// src/main/java/com/eventmanagement/service/AdminService.java
package main.java.com.eventmanagement.services;

import main.java.com.eventmanagement.dao.AdminDao;
import main.java.com.eventmanagement.model.Student;
import java.util.List;

public class AdminService {
    private AdminDao adminDao = new AdminDao();

    public boolean authenticateAdmin(int id, String password) {
        return adminDao.validateAdmin(id, password);
    }

    public boolean addStudentsInBulk(List<Student> students) {
        return adminDao.addStudents(students);
    }

    public boolean grantOrganizerPermission(String registrationId, String venue) {
        return adminDao.grantOrganizerPermit(registrationId, venue);
    }
}