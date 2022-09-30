package com.example.csci360teamproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "HelloWorld";
    }
}
