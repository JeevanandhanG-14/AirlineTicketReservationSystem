package com.project;

import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/airline_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // change to your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ✅ saveBooking method with correct parameters
    public static void saveBooking(String airline, String name, int age, String gender, String email, long mobile, long aadhar, String departure, String destination, String date) {
        String sql = "INSERT INTO tickets (airline_name, passenger_name, age, gender, email_id, mobile_no, aadhar_no, departure, destination, journey_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, airline);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setString(5, email);
            ps.setLong(6, mobile);
            ps.setLong(7, aadhar);
            ps.setString(8, departure);
            ps.setString(9, destination);
            ps.setString(10, date);

            ps.executeUpdate();
            System.out.println("✅ Booking saved to database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ displayBooking (fixed column names)
    public static void displayBooking(long mobile) {
        String sql = "SELECT * FROM tickets WHERE mobile_no=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, mobile);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Airline: " + rs.getString("airline_name"));
                System.out.println("Passenger: " + rs.getString("passenger_name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Email: " + rs.getString("email_id"));
                System.out.println("Mobile: " + rs.getLong("mobile_no"));
                System.out.println("Aadhar: " + rs.getLong("aadhar_no"));
                System.out.println("Departure: " + rs.getString("departure"));
                System.out.println("Destination: " + rs.getString("destination"));
                System.out.println("Date: " + rs.getString("journey_date"));
            } else {
                System.out.println("No booking found with this mobile number.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ cancelBooking fixed (use tickets table)
    public static void cancelBooking(long mobile) {
        String sql = "DELETE FROM tickets WHERE mobile_no=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, mobile);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("❌ Booking cancelled.");
            } else {
                System.out.println("No booking found with this mobile number.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ changeDate fixed (use tickets table + correct column names)
    public static void changeDate(long mobile, String newDate) {
        String sql = "UPDATE tickets SET journey_date=? WHERE mobile_no=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newDate);
            ps.setLong(2, mobile);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("📅 Date updated successfully.");
            } else {
                System.out.println("No booking found with this mobile number.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
