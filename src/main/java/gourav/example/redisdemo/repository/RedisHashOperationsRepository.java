package gourav.example.redisdemo.repository;

import gourav.example.redisdemo.entity.Student;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RedisHashOperationsRepository {
    private final HashOperations<String, Integer, Student> hashOperations;

    public RedisHashOperationsRepository(RedisTemplate<String, Student> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void saveHash(String key, Student student) {
        hashOperations.put(key, student.getId(), student);
    }

    public Student getHashFieldValue(String key, int hashKey) {
        return hashOperations.get(key, hashKey);
    }

    public Long deleteHashField(String key, int hashKey) {
        return hashOperations.delete(key, hashKey);
    }

    public Map<Integer, Student> getAllHashEntries(String key) {
        return hashOperations.entries(key);
    }
}
