package gourav.example.redisdemo.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class JedisService {
    private final Jedis jedis;

    public JedisService() {
        jedis = new Jedis();
    }

    public String addStringKeyValue(String key, String value) {
        return jedis.set(key, value);
    }

    public String getStringValue(String key) {
        return jedis.get(key);
    }
}
