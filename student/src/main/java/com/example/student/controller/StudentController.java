package com.example.student.controller;


import com.example.student.entity.Student;
import com.example.student.model.Subject;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

      @PostMapping("/saveSubject/{studentId}")
    public ResponseEntity<Subject> saveSubject(@PathVariable("studentId") Long studentId, @RequestBody Subject subject) {
        Subject subjectNew = studentService.saveSubject(studentId, subject);
        return ResponseEntity.ok(subject);
    }

}
