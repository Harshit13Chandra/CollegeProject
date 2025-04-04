// src/main/java/com/eventmanagement/dao/StudentDao.java
package main.java.com.eventmanagement.dao;

import main.java.com.eventmanagement.model.Student;
import main.java.com.eventmanagement.config.DatabaseConfig;
import main.java.com.eventmanagement.model.Event;
import main.java.com.eventmanagement.model.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public boolean validateStudent(String registrationId, String password) {
        String sql = "SELECT * FROM Student WHERE Registration_ID = ? AND password = ?";
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

    public List<Event> getUpcomingEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM Events WHERE date >= CURDATE()";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Event event = new Event();
                event.setEventId(rs.getInt("Event_ID"));
                event.setName(rs.getString("Name"));
                event.setVenue(rs.getString("venue"));
                event.setDate(rs.getString("date"));
                event.setStartTime(rs.getString("start_time"));
                event.setCategory(rs.getString("category"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public boolean registerForEvent(String registrationId, int eventId) {
        String sql = "INSERT INTO Tickets (Registration_ID, Event_ID) VALUES (?, ?)";
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

    public boolean rateEvent(int eventId, double rating) {
        String sql = "UPDATE Events SET rating = ? WHERE Event_ID = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, rating);
            stmt.setInt(2, eventId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}