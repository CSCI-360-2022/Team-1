package com.example.csci360teamproject;

import org.springframework.data.repository.CrudRepository;

//Class that actually does something to the database
public interface EventRepository  extends CrudRepository<Event, Integer> {
    Event findByEventID(int eventID);
}
