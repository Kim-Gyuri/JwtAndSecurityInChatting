package finalchat.really.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="chat_id")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    private String sender;

    @Column(columnDefinition = "TEXT")
    private String message;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime sendDate;

    @Builder
    public Chat(Room room, String sender, String message) {
        this.room = room;
        this.sender = sender;
        this.message = message;
        this.sendDate = LocalDateTime.now();
    }

    public static Chat createChat(Room room, String sender, String message) {
        return Chat.builder()
                .room(room)
                .sender(sender)
                .message(message)
                .build();
    }
}
