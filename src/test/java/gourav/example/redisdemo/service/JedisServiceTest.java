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
    void testAddKeyValue() {
        final String s = jedisService.addKeyValue("key11", "11");
        System.out.println(s);
    }

    @Test
    void testGetValue() {
        final String value = jedisService.getValue("key11");
        System.out.println(value);
    }
}
