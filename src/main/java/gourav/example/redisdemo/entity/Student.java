package gourav.example.redisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RedisHash("Student")
public class Student implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
