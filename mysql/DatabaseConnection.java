/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/toko";  // Gunakan nama database yang telah dibuat
            String user = "root";  // Ganti dengan username MySQL Anda
            String password = "";  // Ganti dengan password MySQL Anda
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
