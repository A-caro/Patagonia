package com.example.student.service;


import com.example.student.entity.Student;
import com.example.student.feignclients.SubjectFeignClient;
import com.example.student.model.Subject;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

/*
    @Autowired
    RestTemplate restTemplate;*/

    @Autowired
    SubjectFeignClient subjectFeignClient;

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

      public Subject saveSubject(Long studentId, Subject subject){
        subject.setStudentId(studentId);
        Subject subjectNew = subjectFeignClient.saveSubject(subject);
        return subjectNew;
    }

//    public List<Subject> getSubject(Long studentId) {
//        List<Subject> subjects = restTemplate.getForObject("http://subject-service/subject/byStudent/" + studentId, List.class);
//        return subjects;
//    }

    public Map<String, Object> getSubject(Long studentId){
        Map<String, Object> datos = new HashMap<>();
        Student student = studentRepository.findById(studentId).orElse(null);
        datos.put("Student", student);
        List<Subject> subjects = subjectFeignClient.getSubject(studentId);
        datos.put("Subjects", subjects);
        return datos;
    }

}
