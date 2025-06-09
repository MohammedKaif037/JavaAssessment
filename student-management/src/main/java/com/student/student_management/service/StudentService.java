package com.student.student_management.service;

import com.student.student_management.model.Student;
import com.student.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student) {
        student.setAge(calculateAge(student.getBirthDay(), student.getBirthMonth(), student.getBirthYear()));
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public int calculateAge(int day, int month, int year) {
        LocalDate dob = LocalDate.of(year, month, day);
        return LocalDate.now().getYear() - dob.getYear();
    }

    public Student updateAge(Long id) {
        Student student = studentRepo.findById(id).orElse(null);
        if (student != null) {
            int age = calculateAge(student.getBirthDay(), student.getBirthMonth(), student.getBirthYear());
            student.setAge(age);
            return studentRepo.save(student);
        }
        return null;
    }

    public List<Student> getStudentsBetween18And25() {
        return studentRepo.findByAgeBetween(18, 25);
    }
}
