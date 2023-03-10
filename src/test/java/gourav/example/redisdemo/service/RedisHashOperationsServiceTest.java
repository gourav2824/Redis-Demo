package gourav.example.redisdemo.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
class RedisHashOperationsServiceTest {
    public static final String HASH = "MyHash";

    @Autowired
    private RedisHashOperationsService redisHashOperationsService;

    @Test
    void testSaveHashFieldValue() {
        redisHashOperationsService.saveHashFieldValue(HASH, "111", "abc");
    }

    @Test
    void testGetHashFieldValue() {
        final String value = redisHashOperationsService.getHashFieldValue(HASH, "111");
        System.out.println(value);
    }

    @Test
    void testHasHashKey() {
        final boolean hasHashKey = redisHashOperationsService.hasHashKey(HASH, "111");
        System.out.println(hasHashKey);
    }
}
