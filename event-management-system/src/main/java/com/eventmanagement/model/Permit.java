// src/main/java/com/eventmanagement/model/Permit.java
package main.java.com.eventmanagement.model;

public class Permit {
    private int permitId;
    private String registrationId;
    private String venuePermitted;
    public Permit(int permitId, String registrationId, String venuePermitted) {
        this.permitId = permitId;
        this.registrationId = registrationId;
        this.venuePermitted = venuePermitted;
    }
    public int getPermitId() {
        return permitId;
    }
    public String getRegistrationId() {
        return registrationId;
    }
    public String getVenuePermitted() {
        return venuePermitted;
    }
    public void setPermitId(int permitId) {
        this.permitId = permitId;
    }
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
    public void setVenuePermitted(String venuePermitted) {
        this.venuePermitted = venuePermitted;
    }
    
    // Constructors, getters, setters
}