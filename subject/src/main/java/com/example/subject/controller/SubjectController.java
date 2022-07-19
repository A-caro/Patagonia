package com.example.subject.controller;

import com.example.subject.entity.Subject;
import com.example.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll(){
        return subjectService.getAll();
    }

    @GetMapping("/byStudent/{studentId}")
    public ResponseEntity<List<Subject>> getAll(@PathVariable("studentId") Long studentId){
        List<Subject> subject = subjectService.byStudentId(studentId);
        return ResponseEntity.ok(subject);

    }

    @PostMapping
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        Subject subjectNew = subjectService.saveSubject(subject);
        return ResponseEntity.ok(subjectNew);
    }




}
