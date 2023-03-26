package gourav.example.redisdemo.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Map;

@Service
public class JedisService {
    private final Jedis jedis;

    public JedisService(Jedis jedis) {
        this.jedis = jedis;
    }

    public String saveKeyValue(String key, String value) {
        return jedis.set(key, value);
    }

    public String getValue(String key) {
        return jedis.get(key);
    }

    public long setHashFieldValue(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }

    public String getHashFieldValue(String key, String field) {
        return jedis.hget(key, field);
    }

    public Map<String, String> getAllHashFieldsAndValues(String key) {
        return jedis.hgetAll(key);
    }

    public long addStringInTheList(String key, String value) {
        return jedis.rpush(key, value);
    }
}
