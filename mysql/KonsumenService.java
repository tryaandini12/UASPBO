/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KonsumenService {

    // CREATE
    public void createKonsumen(String namaKonsumen, String alamat, String telepon) {
        String query = "INSERT INTO konsumen (nama_konsumen, alamat, telepon) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaKonsumen);
            stmt.setString(2, alamat);
            stmt.setString(3, telepon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Konsumen> readKonsumen() {
        List<Konsumen> konsumenList = new ArrayList<>();
        String query = "SELECT * FROM konsumen";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                konsumenList.add(new Konsumen(
                        rs.getInt("id"),
                        rs.getString("nama_konsumen"),
                        rs.getString("alamat"),
                        rs.getString("telepon")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return konsumenList;
    }

    // UPDATE
    public void updateKonsumen(int id, String namaKonsumen, String alamat, String telepon) {
        String query = "UPDATE konsumen SET nama_konsumen = ?, alamat = ?, telepon = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaKonsumen);
            stmt.setString(2, alamat);
            stmt.setString(3, telepon);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteKonsumen(int id) {
        String query = "DELETE FROM konsumen WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

