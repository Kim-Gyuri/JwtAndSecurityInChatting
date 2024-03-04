package finalchat.really.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="room_id")
    private Long id;

    private String name;

    @Builder
    public Room(String name) {
        this.name = name;
    }

    public static Room createRoom(String name) {
        return Room.builder()
                .name(name)
                .build();
    }

}
