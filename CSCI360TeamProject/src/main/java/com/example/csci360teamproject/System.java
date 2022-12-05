package com.example.csci360teamproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class System {

    @Autowired
    private Service csci360TeamProjectService;
    private boolean loggedIn = false;
    private int demand = 0;
    private double lastTimeStamp = 0;


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
        if(confirmLogin(username, passwordHash(password), csci360TeamProjectService)) {
//            model.addAttribute("username", username);
//            model.addAttribute("password", password);
            loggedIn = true;
            model.addAttribute("loggedIn", loggedIn);
            return "index";
        }
        else {
            model.addAttribute("error", "Login Information Incorrect");
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
                           @RequestParam(name = "password") String password, Model model) {
        User duplicate = csci360TeamProjectService.findUser(username);
        if(duplicate == null && password.length() >= 15 && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?~]).+$")) {
            User user = new User(username, passwordHash(password), email);
            csci360TeamProjectService.saveUser(user);
            //        model.addAttribute("username", username);
            //        model.addAttribute("password", password);
            loggedIn = true;
            return "index";
        }
        else {
            String errorMessage = "";
            if(duplicate != null) {
                errorMessage += "User already exists with specified username. ";
            }
            if(password.length() < 15) {
                errorMessage += "Password is not 15 characters long.";
            }
            if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?~]).+$")) {
                errorMessage += "Password does not match character requirements.";
            }
            model.addAttribute("error", errorMessage);
            return "error";
        }
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
        return password.equals(usr.getPassword());


        //csci360TeamProjectService.findUser(21);
    }

    public String passwordHash(String password) {
        byte[] byteArr;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byteArr = md.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder outString = new StringBuilder();
            for (byte b : byteArr) {
                String st = String.format("%02X", b).toLowerCase();
                outString.append(st);
            }
            return outString.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam (name = "searchTerm") String searchTerm, String[] tags, Model model) {
        List<Event> eventList = csci360TeamProjectService.findEvents(searchTerm, tags);
        model.addAttribute("eventList", eventList);
        return "searchResults";
    }

    @GetMapping("/events/{eventId}")
    public String selectEvent(@PathVariable int eventId, Model model) {
        Event event = csci360TeamProjectService.findEvent(eventId);
        model.addAttribute("eventName", event.getEventName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("eeee MMMM d yyyy");
        model.addAttribute("date", event.getDate().format(formatter));
        model.addAttribute("seatsLeft", event.getSeatsLeft());
        model.addAttribute("location", event.getLocation());
        model.addAttribute("description", event.getDescription());
        model.addAttribute("price", String.format("%.2f", event.getPrice()));
        model.addAttribute("tags", event.getTags());
        model.addAttribute("eventID", eventId);
        return "productDetails";
    }

    @GetMapping("/events/purchase/{eventId}")
    public String startPurchase(@PathVariable int eventId, Model model) {
        double currentTime = java.lang.System.currentTimeMillis();
        int demandMax = 5;
        int demandPentalty = 5;
        if (currentTime - lastTimeStamp > demandPentalty * 1000) {
            demand = 0;
            lastTimeStamp = currentTime;
        }
        else {
            demand++;
            lastTimeStamp = currentTime;
        }
        if(loggedIn) {
            if(demand < demandMax) {
                double taxRate = .07;
                Event event = csci360TeamProjectService.findEvent(eventId);
                model.addAttribute("price", String.format("%.2f", event.getPrice()));
                model.addAttribute("tax", String.format("%.2f", event.getPrice() * taxRate));
                model.addAttribute("total", String.format("%.2f", event.getPrice() + (event.getPrice() * taxRate)));
                model.addAttribute("eventName", event.getEventName());
                model.addAttribute("date", event.getDate());
                model.addAttribute("location", event.getLocation());
                model.addAttribute("description", event.getDescription());
                model.addAttribute("eventID", eventId);
                return "purchaseScreen";
            }
            else {
                model.addAttribute("error", "This ticket is in hot demand currently. Please try again in another " + demandPentalty  + " seconds");
                return "error";
            }
        }
        else {
            return displayLoginPage();
        }
    }

    public String confirmPurchase() {
        return null;
    }

    public String purchase(int cardNumber, LocalDate expDate, int cvv, String name, String address, String city, String state, String country, int zipCode) {
        return null;
    }

    public String cancelPurchase() {
        return null;
    }

}
