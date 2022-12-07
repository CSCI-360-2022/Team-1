package com.example.csci360teamproject;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Class that actually does something to the database
public interface EventRepository  extends CrudRepository<Event, Integer> {
    Event findByEventID(int eventID);
    List<Event> findEventsByEventNameContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrderByEventName(String name, String description, String tags);
}
