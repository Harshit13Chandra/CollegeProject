// src/main/java/com/eventmanagement/MainApplication.java
package com.eventmanagement;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class MainApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(main.java.com.eventmanagement.controller.AdminController.class);
        classes.add(main.java.com.eventmanagement.controller.StudentController.class);
        classes.add(main.java.com.eventmanagement.controller.OrganizerController.class);
        return classes;
    }
}