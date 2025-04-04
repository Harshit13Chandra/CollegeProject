// src/main/java/com/eventmanagement/model/Student.java
package main.java.com.eventmanagement.model;

public class Student {
    private String registrationId;
    private String name;
    private String password;
    public Student(String registrationId, String name, String password) {
        this.registrationId = registrationId;
        this.name = name;
        this.password = password;
    }
    public String getRegistrationId() {
        return registrationId;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Constructors, getters, setters
    
}