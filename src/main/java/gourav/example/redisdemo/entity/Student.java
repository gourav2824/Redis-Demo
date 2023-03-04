package gourav.example.redisdemo.entity;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
