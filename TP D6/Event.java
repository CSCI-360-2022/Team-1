package com.example.csci360teamproject;


import javax.persistence.*;
import java.util.Date;

//Indicates that this Class is a JPA Entity (A plain old java object that can be persisted to a database.
@Entity
//Specifies the table in the database to connect to
@Table(name = "events")
public class Event {
    //Specifies that eventID is an id
    @Id
    //Specifies that eventID is auto generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventID;
    private String eventName;
    private Date date;
    private String description;
    private double price;
    private int seatsLeft;
    private String tags;

    public Event() {

    }
    //Fully loaded constructor. Note that eventID is not present since it is auto generated
    public Event(String eventName, Date date, String description, double price, int seatsLeft, String tags) {
        this.eventName = eventName;
        this.date = date;
        this.description = description;
        this.price = price;
        this.seatsLeft = seatsLeft;
        this.tags = tags;
    }
    //Getters and Setters
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    //toString
    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", eventName='" + eventName + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", seatsLeft=" + seatsLeft +
                ", tags='" + tags + '\'' +
                '}';
    }
}
