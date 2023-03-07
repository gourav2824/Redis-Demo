package gourav.example.redisdemo.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Student")
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
