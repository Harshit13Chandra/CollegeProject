// src/main/java/com/eventmanagement/model/Event.java
package main.java.com.eventmanagement.model;

import java.sql.Timestamp;

public class Event {
    private int eventId;
    private String organizerId;
    private String name;
    private String venue;
    private String date;
    private String startTime;
    private String category;
    private double rating;
    
    public int getEventId() {
        return eventId;
    }
    public String getOrganizerId() {
        return organizerId;
    }
    public String getName() {
        return name;
    }
    public String getVenue() {
        return venue;
    }
    public String getDate() {
        return date;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getCategory() {
        return category;
    }
    public double getRating() {
        return rating;
    }
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    // Constructors, getters, setters
}