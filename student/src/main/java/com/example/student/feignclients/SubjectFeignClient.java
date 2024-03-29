package com.example.student.feignclients;


import com.example.student.model.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="subject-service")
@RequestMapping("/subject")

public interface SubjectFeignClient {

    @PostMapping
    Subject saveSubject(@RequestBody Subject subject);

    @GetMapping("/byStudent/{studentId}")
    List<Subject> getSubject(@PathVariable("studentId") Long studentId);


}
