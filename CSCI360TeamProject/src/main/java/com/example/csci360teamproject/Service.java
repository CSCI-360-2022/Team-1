package com.example.csci360teamproject;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUser(int userId) {
        return userRepository.findById(userId).orElseThrow();
    }


    public User findUser(String username)
    {
        return userRepository.findByUsername(username);
    }

    public List<User> listUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User updateUser(@NotNull User user, int userId) {
        User oldUser = userRepository.findById(userId).orElseThrow();
        if(user.getUsername() != null && !"".equalsIgnoreCase(user.getUsername())) {
            oldUser.setUsername(user.getUsername());
        }
        if(user.getPassword() != null && !"".equalsIgnoreCase(user.getPassword())) {
            oldUser.setPassword(user.getPassword());
        }
        if(user.getEmail() != null && !"".equalsIgnoreCase(user.getEmail())) {
            oldUser.setUsername(user.getEmail());
        }
        return userRepository.save(oldUser);
    }

    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    public Event findEvent(int eventId) {
        return eventRepository.findById(eventId).orElseThrow();
    }

    public List<Event> findEvents(String searchTerm, String[] tags) {
        List<Event> events = new ArrayList<>();
        int id = -1;
        try {
            id = Integer.parseInt(searchTerm);
            Optional<Event> event = eventRepository.findById(id);
            if(event.isPresent()) {
                events.add(event.get());
                return events;
            }
            else {
                return null;
            }
        }
        catch (NumberFormatException e) {
            String tagsAsString = Arrays.toString(tags);
            java.lang.System.out.println(tagsAsString);
            return eventRepository.findEventsByEventNameOrDescriptionContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrderByEventName(searchTerm,searchTerm,tagsAsString);
        }
    }

    public List<Event> listEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    public Event updateEvent(@NotNull Event event, int eventId) {
        Event oldEvent = eventRepository.findById(eventId).orElseThrow();
        if(event.getEventName() != null && !"".equalsIgnoreCase(event.getEventName())) {
            oldEvent.setEventName(event.getEventName());
        }
        if(event.getDate() != null) {
            oldEvent.setDate(event.getDate());
        }
        if(event.getPrice() > 0) {
            oldEvent.setPrice(event.getPrice());
        }
        if(event.getDescription() != null && !"".equalsIgnoreCase(event.getDescription())) {
            oldEvent.setDescription(event.getDescription());
        }
        if(event.getSeatsLeft() > 0) {
            oldEvent.setSeatsLeft(event.getSeatsLeft());
        }
        if(event.getTags() != null && !"".equalsIgnoreCase(event.getTags())) {
            oldEvent.setTags(event.getTags());
        }
        if(event.getLocation() != null && !"".equalsIgnoreCase(event.getLocation())) {
            oldEvent.setLocation(event.getLocation());
        }
        return eventRepository.save(oldEvent);
    }

    public void deleteEventById(int eventId) {
        eventRepository.deleteById(eventId);
    }

}
