package gourav.example.redisdemo.service;

import gourav.example.redisdemo.entity.Student;
import gourav.example.redisdemo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final Logger logger;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.logger = LoggerFactory.getLogger(StudentService.class);
    }

    public Student addStudent(Student student) {
        final Student savedStudent = studentRepository.save(student);
        logger.info("Student added successfully : {}", savedStudent);
        return savedStudent;
    }

    public Student getStudent(int studentId) {
        final Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        logger.info("Student found with id {} : {}", studentId, student);
        return student;
    }

    public List<Student> getAllStudents() {
        final List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        logger.info("Students list : {}", students);
        return students;
    }

    public void removeStudent(int studentId) {
        studentRepository.deleteById(studentId);
        logger.info("Student with id {} removed successfully", studentId);
    }
}
