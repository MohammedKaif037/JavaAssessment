package com.student.student_management.controller;

import com.student.student_management.model.Student;
import com.student.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update-age/{id}")
    public Student updateAge(@PathVariable Long id) {
        return studentService.updateAge(id);
    }

    @GetMapping("/age-between")
    public List<Student> getStudentsBetween18And25() {
        return studentService.getStudentsBetween18And25();
    }
}
