package com.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirlineDAO {

    public void addAirline(Airlines airline) {
        String sql = "INSERT INTO airlines (name, source, destination, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, airline.getName());
            ps.setString(2, airline.getSource());
            ps.setString(3, airline.getDestination());
            ps.setDouble(4, airline.getPrice());
            ps.executeUpdate();

            System.out.println("✅ Airline added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Airlines> getAllAirlines() {
        List<Airlines> list = new ArrayList<>();
        String sql = "SELECT * FROM airlines";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Airlines airline = new Airlines(
                        rs.getString("name"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getDouble("price")
                );
                airline.setId(rs.getInt("id"));
                list.add(airline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
