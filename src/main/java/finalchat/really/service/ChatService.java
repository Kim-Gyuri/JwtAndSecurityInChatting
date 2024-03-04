package finalchat.really.service;

import finalchat.really.entity.Chat;
import finalchat.really.entity.Room;
import finalchat.really.repo.ChatRepository;
import finalchat.really.repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatService {
    private final RoomRepository roomRepository;
    private final ChatRepository chatRepository;

    /**
     * 모든 채팅방 찾기
     */
    @Transactional(readOnly = true)
    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    /**
     * 특정 채팅방 찾기
     * @param id room_id
     */
    @Transactional(readOnly = true)
    public Room findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow();
    }

    /**
     * 채팅방 만들기
     * @param name 방 이름
     */
    public Room createRoom(String name) {
        Room room = Room.createRoom(name);
        return roomRepository.save(room);
    }

    /////////////////

    /**
     * 채팅 생성
     * @param roomId 채팅방 id
     * @param sender 보낸이
     * @param message 내용
     */
    public Chat createChat(Long roomId, String sender, String message) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 방입니다.")); // 방이 존재하지 않을 때 예외 처리

        Chat chat = Chat.createChat(room, sender, message); // 채팅 객체 생성
        return chatRepository.save(chat); // 채팅 저장 후 반환
    }

    /**
     * 채팅방 채팅내용 불러오기
     * @param roomId 채팅방 id
     */
    @Transactional(readOnly = true)
    public List<Chat> findAllChatByRoomId(Long roomId) {
        return chatRepository.findAllByRoomId(roomId);
    }


}
