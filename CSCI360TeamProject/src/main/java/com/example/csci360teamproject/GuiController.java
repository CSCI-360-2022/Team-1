package com.example.csci360teamproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuiController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "HelloWorld";
    }


    @GetMapping("/displayLoginPage")
    public String displayLoginPage() {
        return "LoginPage";
    }
    @PostMapping("/logIn")
    public <model> String logIn(@RequestParam(name="username") String username,
                                @RequestParam(name="password") String password,
                                Model model) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "index";
    }

    @GetMapping("/displayRegisterPage")
    public String displayRegisterPage() {
        return "RegisterPage";
    }

    @PostMapping("/registerAccount")
    public String register(@RequestParam(name = "email") String email,
                           @RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password,
                           Model model) {
        return "index";
    }
}
