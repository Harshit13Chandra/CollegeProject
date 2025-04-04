// src/main/java/com/eventmanagement/model/Ticket.java
package main.java.com.eventmanagement.model;

public class Ticket {
    private int ticketId;
    private String registrationId;
    private int eventId;
    public Ticket(int ticketId, String registrationId, int eventId) {
        this.ticketId = ticketId;
        this.registrationId = registrationId;
        this.eventId = eventId;
    }
    public int getTicketId() {
        return ticketId;
    }
    public String getRegistrationId() {
        return registrationId;
    }
    public int getEventId() {
        return eventId;
    }
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    
    // Constructors, getters, setters
}