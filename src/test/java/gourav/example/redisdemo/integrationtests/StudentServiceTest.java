package gourav.example.redisdemo.integrationtests;

import gourav.example.redisdemo.entity.Student;
import gourav.example.redisdemo.service.StudentService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class StudentServiceTest {
    private static final String REDIS_IMAGE_NAME = "redis:7.0-alpine";
    private static final int REDIS_PORT = 6379;

    @Autowired
    private StudentService studentService;

    private static GenericContainer<?> redis;

    @BeforeAll
    static void beforeAll() {
        redis = new GenericContainer<>(DockerImageName.parse(REDIS_IMAGE_NAME)).withExposedPorts(REDIS_PORT);
        redis.start();
        setRedisProperties();
    }

    @Test
    void testAddStudent() {
        final Student student = new Student(1, "Oswald", "Octopus", "oswaldtheoctopus@pogo.com", "Big City");
        final Student savedStudent = studentService.addStudent(student);
        assertThat(savedStudent).isNotNull().isEqualTo(student);
    }

    @AfterAll
    static void afterAll() {
        redis.stop();
    }

    private static void setRedisProperties() {
        System.setProperty("spring.data.redis.host", redis.getHost());
        System.setProperty("spring.data.redis.port", redis.getMappedPort(REDIS_PORT).toString());
    }
}
