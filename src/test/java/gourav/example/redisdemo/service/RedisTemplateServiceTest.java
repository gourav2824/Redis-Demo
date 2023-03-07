package gourav.example.redisdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisTemplateServiceTest {

    @Autowired
    private RedisTemplateService redisTemplateService;

    @Test
    void testAddKeyValue() {
        final String key = "key001";
        final String value = "value01";
        redisTemplateService.addKeyValue(key, value);
    }

    @Test
    void testGetValue() {
        final String key = "key001";
        final String value = redisTemplateService.getValue(key);
        System.out.println(value);
    }
}
