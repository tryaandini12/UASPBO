/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiService {

    // CREATE
    public void createTransaksi(int konsumenId, int barangId, int jumlah, double totalHarga) {
        String query = "INSERT INTO transaksi (konsumen_id, barang_id, jumlah, total_harga) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, konsumenId);
            stmt.setInt(2, barangId);
            stmt.setInt(3, jumlah);
            stmt.setDouble(4, totalHarga);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Transaksi> readTransaksi() {
        List<Transaksi> transaksiList = new ArrayList<>();
        String query = "SELECT * FROM transaksi";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                transaksiList.add(new Transaksi(
                        rs.getInt("id"),
                        rs.getInt("konsumen_id"),
                        rs.getInt("barang_id"),
                        rs.getInt("jumlah"),
                        rs.getDouble("total_harga")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaksiList;
    }

    // UPDATE
    public void updateTransaksi(int id, int konsumenId, int barangId, int jumlah, double totalHarga) {
        String query = "UPDATE transaksi SET konsumen_id = ?, barang_id = ?, jumlah = ?, total_harga = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, konsumenId);
            stmt.setInt(2, barangId);
            stmt.setInt(3, jumlah);
            stmt.setDouble(4, totalHarga);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteTransaksi(int id) {
        String query = "DELETE FROM transaksi WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

