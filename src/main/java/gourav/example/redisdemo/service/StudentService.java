package gourav.example.redisdemo.service;

import gourav.example.redisdemo.entity.Student;
import gourav.example.redisdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public List<Student> getAllStudents() {
        final List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public void removeStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
