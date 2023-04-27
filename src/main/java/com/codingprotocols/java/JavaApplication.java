package com.codingprotocols.java;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JavaApplication {

    @GetMapping(value = "/")
    public String helloWorld() {
        return "<H1> Hello from Maven Test - April 28 - Final Test </H1> \n <h3> Date :- " + new Date() + "</h3>";
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

}
