package gourav.example.redisdemo.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisHashOperationsService {
    private final HashOperations<String, String, String> hashOperations;

    public RedisHashOperationsService(RedisTemplate<String, String> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void saveHashFieldValue(String key, String hashKey, String value) {
        hashOperations.put(key, hashKey, value);
    }

    public String getHashFieldValue(String key, String hashKey) {
        return hashOperations.get(key, hashKey);
    }

    public boolean hasHashKey(String key, String hashKey) {
        return hashOperations.hasKey(key, hashKey);
    }
}
