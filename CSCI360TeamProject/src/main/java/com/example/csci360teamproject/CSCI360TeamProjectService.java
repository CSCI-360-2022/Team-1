package com.example.csci360teamproject;


import java.util.List;

public interface CSCI360TeamProjectService {
    User saveUser(User user);
    User findUser(int userId);
    List<User> listUsers();
    User updateUser(User user, int userId);
    void deleteUserById(int userId);
    Event saveEvent(Event event);
    Event findEvent(int eventId);
    List<Event> listEvents();
    Event updateEvent(Event event, int eventId);
    void deleteEventById(int eventId);
}
