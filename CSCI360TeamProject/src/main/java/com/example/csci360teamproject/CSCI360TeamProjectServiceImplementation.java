package com.example.csci360teamproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSCI360TeamProjectServiceImplementation implements CSCI360TeamProjectService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUser(int userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public User findUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> listUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, int userId) {
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

    @Override
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findEvent(int eventId) {
        return eventRepository.findById(eventId).orElseThrow();
    }

    @Override
    public List<Event> listEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public Event updateEvent(Event event, int eventId) {
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

    @Override
    public void deleteEventById(int eventId) {
        eventRepository.deleteById(eventId);
    }

}
