// src/main/java/com/eventmanagement/dao/AdminDao.java
package main.java.com.eventmanagement.dao;

import main.java.com.eventmanagement.config.DatabaseConfig;
import main.java.com.eventmanagement.model.Admin;
import main.java.com.eventmanagement.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    public boolean validateAdmin(int id, String password) {
        String sql = "SELECT * FROM Admin WHERE id = ? AND password = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addStudents(List<Student> students) {
        String sql = "INSERT INTO Student (Registration_ID, Name, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (Student student : students) {
                stmt.setString(1, student.getRegistrationId());
                stmt.setString(2, student.getName());
                stmt.setString(3, student.getPassword());
                stmt.addBatch();
            }
            stmt.executeBatch();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean grantOrganizerPermit(String registrationId, String venue) {
        String sql = "INSERT INTO Permits (Registration_ID, venue_permitted) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, registrationId);
            stmt.setString(2, venue);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}