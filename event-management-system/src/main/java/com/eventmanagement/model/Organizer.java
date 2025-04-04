// src/main/java/com/eventmanagement/model/Organizer.java
package main.java.com.eventmanagement.model;

public class Organizer {
    private String registrationId;
    private int eventId;
    public Organizer(String registrationId, int eventId) {
        this.registrationId = registrationId;
        this.eventId = eventId;
    }
    public String getRegistrationId() {
        return registrationId;
    }
    public int getEventId() {
        return eventId;
    }
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    
    // Constructors, getters, setters
}