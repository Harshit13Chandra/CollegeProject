// src/main/java/com/eventmanagement/service/StudentService.java
package main.java.com.eventmanagement.services;

import main.java.com.eventmanagement.dao.StudentDao;
import main.java.com.eventmanagement.model.Event;
import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public boolean authenticateStudent(String registrationId, String password) {
        return studentDao.validateStudent(registrationId, password);
    }

    public List<Event> getUpcomingEvents() {
        return studentDao.getUpcomingEvents();
    }

    public boolean registerForEvent(String registrationId, int eventId) {
        return studentDao.registerForEvent(registrationId, eventId);
    }

    public boolean rateEvent(int eventId, double rating) {
        return studentDao.rateEvent(eventId, rating);
    }
}