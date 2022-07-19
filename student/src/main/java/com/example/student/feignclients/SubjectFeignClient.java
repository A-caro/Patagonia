package com.example.student.feignclients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name ="subject-service")
@RequestMapping("/subject")

public class SubjectFeignClient {



}
