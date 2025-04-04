// src/main/java/com/eventmanagement/model/Venue.java
package main.java.com.eventmanagement.model;

public class Venue {
    private String name;
    private int capacity;
    private boolean available;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Venue(String name, int capacity, boolean available) {
        this.name = name;
        this.capacity = capacity;
        this.available = available;
    }
    
    // Constructors, getters, setters
}