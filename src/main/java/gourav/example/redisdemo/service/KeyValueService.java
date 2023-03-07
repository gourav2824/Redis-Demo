package gourav.example.redisdemo.service;

import gourav.example.redisdemo.entity.KeyValue;
import gourav.example.redisdemo.repository.KeyValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KeyValueService {
    private final KeyValueRepository keyValueRepository;
    private final Logger logger;

    public KeyValueService(KeyValueRepository keyValueRepository) {
        this.keyValueRepository = keyValueRepository;
        logger = LoggerFactory.getLogger(KeyValueService.class);
    }

    public KeyValue addKeyValue(String key, String value) {
        final KeyValue keyValue = new KeyValue(key, value);
        final KeyValue save = keyValueRepository.save(keyValue);
        logger.info("Key-Value saved successfully : {}", save);
        return save;
    }

    public String getValue(String key) {
        final KeyValue keyValue = keyValueRepository.findById(key).orElse(null);

        if (keyValue == null) {
            logger.info("Key {} not found", key);
            return null;
        }

        final String value = keyValue.getValue();
        logger.info("Key {} found : {}", key, value);
        return value;
    }
}
