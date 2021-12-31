package com.amigoscode.startspringboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email has already taken.");
        }

        studentRepository.save(student);

    }

    public void deleteStudent(Long id) {
        boolean isExist = studentRepository.existsById(id);

        if (!isExist) {
            throw new IllegalStateException("Student with id " + id + " does not exist.");
        }

        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id,
                              String name,
                              String email) {

        // Check wether student with specified id exist
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + id + " does not exist."
                ));

        // Name validation
        if (name != null
                && name.length() > 0
                && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        // Email validation
        if (email != null
                && email.length() > 0
                && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);

            if (studentByEmail.isPresent()) {
                throw new IllegalStateException(
                        "Email " + email + " has been taken."
                );
            }
            student.setEmail(email);
        }

    }
}
