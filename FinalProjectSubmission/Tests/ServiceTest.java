package com.example.csci360teamproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceTest {
    @Autowired
    Service service;
    User user = new User("CoolGuy25", "password", "coolguy25@yahoo.com");
    User badUser = new User("CoolGuy24", "password", "coolguy25@yahoo.com");
    Event event = new Event("newEvent", LocalDate.of(2022, 12, 7), "thisIsADescription", 10.00, 200, "College, Spring", "College of Charleston");
    Event badEvent = new Event("badEvent", LocalDate.of(2022, 12, 7), "thisIsADescription", 10.00, 200, "College, Spring", "College of Charleston");
    @Test
    void userGeneralTests() {
        service.saveUser(user);
        assertEquals(service.findUser(user.getUsername()), user);
        assertNotEquals(service.findUser(user.getUsername()), badUser);
        assertEquals(service.findUser(user.getUserID()), user);
        assertNotEquals(service.findUser(user.getUserID()), badUser);
        service.deleteUserById(service.findUser(user.getUsername()).getUserID());
    }
    @Test
    void eventGeneralTests() {
        service.saveEvent(event);
        assertEquals(service.findEvent(event.getEventID()), event);
        assertNotEquals(service.findEvent(event.getEventID()), badEvent);
        service.deleteEventById(event.getEventID());
    }
}