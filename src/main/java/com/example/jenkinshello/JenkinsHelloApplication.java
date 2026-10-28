package com.example.jenkinshello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JenkinsHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsHelloApplication.class, args);
    }
    @GetMapping("/test")
    public String hello(){
        return "Hello World";
    }

}
