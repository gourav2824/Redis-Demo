package gourav.example.redisdemo.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisValueOperationsService {
    private final ValueOperations<String, String> valueOperations;

    public RedisValueOperationsService(RedisTemplate<String, String> redisTemplate) {
        valueOperations = redisTemplate.opsForValue();
    }

    public void addKeyValue(String key, String value) {
        valueOperations.set(key, value);
    }

    public String getValue(String key) {
        return valueOperations.get(key);
    }
}
