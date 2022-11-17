package com.example.csci360teamproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

@Controller
public class System {

    @Autowired
    private Service csci360TeamProjectService;
    private boolean loggedIn = false;


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

//    @GetMapping("/hello")
//    public String helloWorld() {
//        return "HelloWorld";
//    }


    @GetMapping("/displayLoginPage")
    public String displayLoginPage() {
        return "loginPage";
    }
    @PostMapping("/logIn")
    public String login(@RequestParam(name="username") String username,
                        @RequestParam(name="password") String password, Model model) {
        if(confirmLogin(username, password, csci360TeamProjectService)) {
//            model.addAttribute("username", username);
//            model.addAttribute("password", password);
            loggedIn = true;
            model.addAttribute("loggedIn", loggedIn);
            return "index";
        }
        else {
            return "error";
        }
    }

    @GetMapping("/displayRegisterPage")
    public String displayRegisterPage() {
        return "registerPage";
    }

    @PostMapping("/registerAccount")
    public String createUser(@RequestParam(name = "email") String email,
                           @RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password) throws NoSuchAlgorithmException {
        User user = new User(username, passwordHash(password), email);
        csci360TeamProjectService.saveUser(user);
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
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
    public boolean confirmLogin(String username, String password, Service service) {
        User usr = service.findUser(username);
        if(usr == null) {
            return false;
        }
        if (password.equals(usr.getPassword()))
        {
            return true;
        }


        //csci360TeamProjectService.findUser(21);
        return false;
    }

    public String passwordHash(String password) throws NoSuchAlgorithmException {
        byte[] byteArr;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byteArr = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder outString = new StringBuilder();
        for(byte b : byteArr){
            String st = String.format("%02X", b).toLowerCase();
            outString.append(st);
        }
        return outString.toString();
    }

    public String search(String searchTerm, String[] tags) {
        return null;
    }

    public String selectEvent(int eventId) {
        return null;
    }

    public String startPurchase(int eventId) {
        return null;
    }

    public String confirmPurchase() {
        return null;
    }

    public String purchase(int cardNumber, LocalDate expDate, int cvv, String name, String address, String city, String state, String country, int zipCode) {
        return null;
    }

    public void emailReceipt(String receipt, String email) {

    }

    public String cancelPurchase() {
        return null;
    }
}
