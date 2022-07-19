package com.example.student.feignclients;


import com.example.student.model.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name ="subject-service")
@RequestMapping("/subject")

public interface SubjectFeignClient {

    @PostMapping
    Subject saveSubject(@RequestBody Subject subject);


}
