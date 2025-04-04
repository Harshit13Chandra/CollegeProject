// src/main/java/com/eventmanagement/service/OrganizerService.java
package main.java.com.eventmanagement.services;

import main.java.com.eventmanagement.dao.OrganizerDao;
import main.java.com.eventmanagement.model.Event;

public class OrganizerService {
    private OrganizerDao organizerDao = new OrganizerDao();

    public boolean authenticateOrganizer(String registrationId, String password) {
        return organizerDao.validateOrganizer(registrationId, password);
    }

    public String getPermittedVenue(String registrationId) {
        return organizerDao.getPermittedVenue(registrationId);
    }

    public boolean createEvent(Event event) {
        return organizerDao.createEvent(event);
    }

    public boolean addCoOrganizer(String registrationId, int eventId) {
        return organizerDao.addOrganizer(registrationId, eventId);
    }
}