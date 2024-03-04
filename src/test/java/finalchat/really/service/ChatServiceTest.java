package finalchat.really.service;

import finalchat.really.entity.Chat;
import finalchat.really.entity.Room;
import finalchat.really.repo.ChatRepository;
import finalchat.really.repo.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
@Slf4j
@SpringBootTest
class ChatServiceTest {
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    RoomRepository roomRepository;

    @Test
    void redisTest() {
        Room room = Room.createRoom("room1");
        Room savedRoom = roomRepository.save(room);
        Chat chat = Chat.createChat(savedRoom, "범준", "안녕하세요");
        chatRepository.save(chat);

        Chat findChat = chatRepository.findById(chat.getId()).orElseThrow();

        log.info("findChat={}", findChat.getMessage());
        log.info("findChat.getRoom={}", findChat.getRoom().getName());

      //  List<Chat> chats = chatRepository.findAllByRoomId(savedRoom.getId());

    }


}