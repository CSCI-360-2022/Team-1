package com.example.csci360teamproject;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    Event event = new Event("newEvent", LocalDate.of(2022, 12, 7), "thisIsADescription", 10.00, 200, "College, Spring", "College of Charleston");
    @Test
    void getEventName() {
        assertEquals(event.getEventName(), "newEvent");
        assertNotEquals(event.getEventName(), null);
        assertNotEquals(event.getEventName(), "oldEvent");
    }

    @Test
    void setEventName() {
        String oldName = event.getEventName();
        event.setEventName("newerEvent");
        assertEquals(event.getEventName(), "newerEvent");
        assertNotEquals(event.getEventName(), null);
        assertNotEquals(event.getEventName(), oldName);
    }

    @Test
    void getDate() {
        assertEquals(event.getDate(), LocalDate.of(2022, 12, 7));
        assertNotEquals(event.getDate(), null);
        assertNotEquals(event.getDate(), LocalDate.of(2022, 12, 6));
    }

    @Test
    void setDate() {
        LocalDate oldDate = event.getDate();
        event.setDate(LocalDate.of(2022, 12, 8));
        assertEquals(event.getDate(), LocalDate.of(2022, 12, 8));
        assertNotEquals(event.getDate(), null);
        assertNotEquals(event.getDate(), oldDate);
    }

    @Test
    void getDescription() {
        assertEquals(event.getDescription(), "thisIsADescription");
        assertNotEquals(event.getDescription(), null);
        assertNotEquals(event.getDescription(), "thisIsNotADescription");
    }

    @Test
    void setDescription() {
        String oldDescription = event.getDescription();
        event.setDescription("coolNewDescription");
        assertEquals(event.getDescription(), "coolNewDescription");
        assertNotEquals(event.getDescription(), null);
        assertNotEquals(event.getDescription(), oldDescription);
    }

    @Test
    void getPrice() {
        assertEquals(event.getPrice(), 10.00);
        assertNotEquals(event.getPrice(), 0);
    }

    @Test
    void setPrice() {
        double oldPrice = event.getPrice();
        event.setPrice(10.50);
        assertEquals(event.getPrice(), 10.5);
        assertNotEquals(event.getPrice(), oldPrice);
    }

    @Test
    void getSeatsLeft() {
        assertEquals(event.getSeatsLeft(), 200);
        assertNotEquals(event.getSeatsLeft(), 0);
    }

    @Test
    void setSeatsLeft() {
        int oldSeatsLeft = event.getSeatsLeft();
        event.setSeatsLeft(100);
        assertEquals(event.getSeatsLeft(), 100);
        assertNotEquals(event.getSeatsLeft(), oldSeatsLeft);
    }

    @Test
    void getTags() {
        assertEquals(event.getTags(), "College, Spring");
        assertNotEquals(event.getTags(), "College");
        assertNotEquals(event.getTags(), null);
    }

    @Test
    void setTags() {
        String oldTags = event.getTags();
        event.setTags("College, Spring, Graduation");
        assertEquals(event.getTags(), "College, Spring, Graduation");
        assertNotEquals(event.getTags(), oldTags);
        assertNotEquals(event.getTags(), null);
    }

    @Test
    void testEquals() {
        Event newEvent = new Event("newEvent", LocalDate.of(2022, 12, 7), "thisIsADescription", 10.00, 200, "College, Spring", "College of Charleston");
        assertEquals(event, newEvent);
        newEvent.setLocation("newLocation");
        assertNotEquals(event, newEvent);
    }

    @Test
    void getLocation() {
        assertEquals(event.getLocation(), "College of Charleston");
        assertNotEquals(event.getLocation(), null);
        assertNotEquals(event.getLocation(), "The Citadel");
    }

    @Test
    void setLocation() {
        String oldLocation = event.getLocation();
        event.setLocation("The Citadel");
        assertEquals(event.getLocation(), "The Citadel");
        assertNotEquals(event.getLocation(), null);
        assertNotEquals(event.getLocation(), oldLocation);
    }
}