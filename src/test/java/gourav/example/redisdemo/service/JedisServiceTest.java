package gourav.example.redisdemo.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Disabled
@SpringBootTest
class JedisServiceTest {

    @Autowired
    private JedisService jedisService;

    @Test
    void testAddStringKeyValue() {
        final String result = jedisService.addStringKeyValue("key11", "11");
        System.out.println(result);
    }

    @Test
    void testGetStringValue() {
        final String value = jedisService.getStringValue("key11");
        System.out.println(value);
    }

    @Test
    void testSetHashFieldValue() {
        final long result = jedisService.setHashFieldValue("myHashKey1", "field1", "value1");
        System.out.println(result);
    }

    @Test
    void testGetHashFieldValue() {
        final String value = jedisService.getHashFieldValue("myHashKey1", "field1");
        System.out.println(value);
    }

    @Test
    void testGetAllHashFieldsAndValues() {
        final Map<String, String> hashFieldsAndValues = jedisService.getAllHashFieldsAndValues("myHashKey1");
        System.out.println(hashFieldsAndValues);
    }

    @Test
    void testAddStringInTheList() {
        final long result = jedisService.addStringInTheList("myList1", "value1");
        System.out.println(result);
    }
}
