package gourav.example.redisdemo.service;

import gourav.example.redisdemo.entity.KeyValue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest
class KeyValueServiceTest {

    @Autowired
    private KeyValueService keyValueService;

    @Test
    void testKeyValueSave() {
        final String key = "randomKey";
        final String value = "randomValue";

        final KeyValue keyValue = keyValueService.addKeyValue(key, value);

        assertThat(keyValue).isNotNull();
        assertThat(keyValue.getKey()).isEqualTo(key);
        assertThat(keyValue.getValue()).isEqualTo(value);
    }

    @Test
    void testGetValue() {
        final String key = "key1";
        final String expectedValue = "someValue1";

        final String actualValue = keyValueService.getValue(key);

        assertThat(actualValue).isNotNull().isEqualTo(expectedValue);
    }
}
