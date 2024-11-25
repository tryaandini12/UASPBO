/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangService {

    // CREATE
    public void createBarang(String namaBarang, double harga, int stok) {
        String query = "INSERT INTO barang (nama_barang, harga, stok) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaBarang);
            stmt.setDouble(2, harga);
            stmt.setInt(3, stok);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Barang> readBarang() {
        List<Barang> barangList = new ArrayList<>();
        String query = "SELECT * FROM barang";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                barangList.add(new Barang(
                        rs.getInt("id"),
                        rs.getString("nama_barang"),
                        rs.getDouble("harga"),
                        rs.getInt("stok")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barangList;
    }

    // UPDATE
    public void updateBarang(int id, String namaBarang, double harga, int stok) {
        String query = "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaBarang);
            stmt.setDouble(2, harga);
            stmt.setInt(3, stok);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteBarang(int id) {
        String query = "DELETE FROM barang WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

