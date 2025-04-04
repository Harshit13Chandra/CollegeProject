// src/main/java/com/eventmanagement/dao/OrganizerDao.java
package main.java.com.eventmanagement.dao;

import main.java.com.eventmanagement.config.DatabaseConfig;
import main.java.com.eventmanagement.model.Event;
import main.java.com.eventmanagement.model.Organizer;
import main.java.com.eventmanagement.model.Permit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganizerDao {
    public boolean validateOrganizer(String registrationId, String password) {
        String sql = "SELECT s.* FROM Student s JOIN Permits p ON s.Registration_ID = p.Registration_ID " +
                     "WHERE s.Registration_ID = ? AND s.password = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, registrationId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPermittedVenue(String registrationId) {
        String sql = "SELECT venue_permitted FROM Permits WHERE Registration_ID = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, registrationId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("venue_permitted");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean createEvent(Event event) {
        String sql = "INSERT INTO Events (Organizer_ID, Name, venue, date, start_time, category) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, event.getOrganizerId());
            stmt.setString(2, event.getName());
            stmt.setString(3, event.getVenue());
            stmt.setString(4, event.getDate());
            stmt.setString(5, event.getStartTime());
            stmt.setString(6, event.getCategory());
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                return false;
            }
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    event.setEventId(generatedKeys.getInt(1));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addOrganizer(String registrationId, int eventId) {
        String sql = "INSERT INTO Organizers (Registration_ID, Event_ID) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, registrationId);
            stmt.setInt(2, eventId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}