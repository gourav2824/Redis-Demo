package gourav.example.redisdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@RedisHash("Key-Value")
public class KeyValue {
    @Id
    private String key;
    private String value;
}
