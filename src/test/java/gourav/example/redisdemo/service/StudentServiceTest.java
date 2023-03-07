package gourav.example.redisdemo.service;

import gourav.example.redisdemo.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void testAddStudent() {
        final Student student = new Student(6, "Abc", "Def", "abc@mail.com", "XYZ");
        final Student actual = studentService.addStudent(student);
        System.out.println(actual);
        assertThat(actual).isNotNull();
    }

    @Test
    void testGetStudent() {
        final Student student = studentService.getStudent(3);
        System.out.println(student);
        assertThat(student).isNotNull();
    }

    @Test
    void testGetAllStudents() {
        final List<Student> students = studentService.getAllStudents();
        System.out.println(students);
        assertThat(students).isNotEmpty();
    }

    @Test
    void testDeleteStudent() {
        studentService.removeStudent(5);
    }
}
