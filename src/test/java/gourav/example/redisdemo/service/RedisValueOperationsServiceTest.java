package gourav.example.redisdemo.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
class RedisValueOperationsServiceTest {

    @Autowired
    private RedisValueOperationsService redisValueOperationsService;

    @Test
    void testAddKeyValue() {
        final String key = "key001";
        final String value = "value01";
        redisValueOperationsService.addKeyValue(key, value);
    }

    @Test
    void testGetValue() {
        final String key = "key001";
        final String value = redisValueOperationsService.getValue(key);
        System.out.println(value);
    }
}
