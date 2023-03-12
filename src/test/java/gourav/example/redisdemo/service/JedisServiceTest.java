package gourav.example.redisdemo.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled
@SpringBootTest
class JedisServiceTest {

    @Autowired
    private JedisService jedisService;

    @Test
    void testAddStringKeyValue() {
        final String s = jedisService.addStringKeyValue("key11", "11");
        System.out.println(s);
    }

    @Test
    void testGetStringValue() {
        final String value = jedisService.getStringValue("key11");
        System.out.println(value);
    }
}
