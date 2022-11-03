package com.example.csci360teamproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class GuiController {

    @Autowired
    private CSCI360TeamProjectService csci360TeamProjectService;
//    @PostMapping("/addUser")
//    public @ResponseBody String addNewUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
//        User user = new User(username, password, email);
//        userRepository.save(user);
//        return "Saved";
//    }

    @GetMapping("/listUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return csci360TeamProjectService.listUsers();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "HelloWorld";
    }


    @GetMapping("/displayLoginPage")
    public String displayLoginPage() {
        return "LoginPage";
    }
    @PostMapping("/logIn")
    public String logIn(@RequestParam(name="username") String username,
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
        User user = new User(username, password, email);
        csci360TeamProjectService.saveUser(user);
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "index";
    }
    //Used to show AddEvent.html
    @GetMapping("/displayAddEventPage")
    public String displayAddEventPage() {
        return "AddEvent";
    }
    //Used to add an event to the database
    //@PostMapping indicates what request we want to map to this addEvent method
    @PostMapping("/addEvent")
    //@RequestParam is used to get information from the form and map them to parameter variables
    public String addEvent(@RequestParam(name = "eventName") String eventName,
                           @RequestParam(name = "description") String description, @RequestParam(name = "price") double price,
                           @RequestParam(name = "seatsLeft") int seatsLeft, @RequestParam(name = "tags") String tags, @RequestParam(name = "location") String location, @RequestParam(name = "date") String date) {
        LocalDate dateObj = LocalDate.parse(date);
        //Standard construction of a java object
        Event event = new Event(eventName, dateObj, description, price, seatsLeft, tags, location);
        //Save the new event to the database
        csci360TeamProjectService.saveEvent(event);
        //Go back to index.html
        return "index";
    }

    public boolean confirmLogin(String username, String password) {
        User usr = csci360TeamProjectService.findUserByUsername(username);
        if (password.equals(usr.getPassword()))
        {
            return true;
        }


        return false;
    }

    public String passwordHash(String password) {
        return "";
    }
}
