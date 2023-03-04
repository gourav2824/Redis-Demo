package gourav.example.redisdemo.entity;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
public class Student implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
