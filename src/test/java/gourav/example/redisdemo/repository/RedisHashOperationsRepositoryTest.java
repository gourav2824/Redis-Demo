package gourav.example.redisdemo.repository;

import gourav.example.redisdemo.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Disabled
@SpringBootTest
class RedisHashOperationsRepositoryTest {

    @Autowired
    private RedisHashOperationsRepository repository;

    @Test
    void testSaveHash() {
        final Student student = new Student(1, "John", "Wick", "johnwick@mail.com", "New City");
        repository.saveHash("Student", student);
    }

    @Test
    void testGetHashFieldValue() {
        final Student student = repository.getHashFieldValue("Student", 1);
        System.out.println(student);
    }

    @Test
    void testDeleteHashField() {
        final Long value = repository.deleteHashField("Student", 2);
        System.out.println(value);
    }

    @Test
    void testGetAllHashEntries() {
        final Map<Integer, Student> entries = repository.getAllHashEntries("Student");
        System.out.println(entries);
    }
}
