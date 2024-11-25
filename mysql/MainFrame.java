/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainFrame extends JFrame {
    private JTextField namaBarangField, hargaField, stokField;
    private JTable table;
    private DefaultTableModel tableModel;
    private BarangService barangService;

    public MainFrame() {
        barangService = new BarangService();

        setTitle("CRUD Data Barang");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nama Barang:"));
        namaBarangField = new JTextField();
        inputPanel.add(namaBarangField);

        inputPanel.add(new JLabel("Harga:"));
        hargaField = new JTextField();
        inputPanel.add(hargaField);

        inputPanel.add(new JLabel("Stok:"));
        stokField = new JTextField();
        inputPanel.add(stokField);

        JButton createButton = new JButton("Create");
        createButton.addActionListener(this::handleCreate);
        inputPanel.add(createButton);

        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"ID", "Nama Barang", "Harga", "Stok"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        refreshTable();
    }

    private void handleCreate(ActionEvent e) {
        barangService.createBarang(namaBarangField.getText(), Double.parseDouble(hargaField.getText()), Integer.parseInt(stokField.getText()));
        refreshTable();
        clearFields();
    }

    private void refreshTable() {
        List<Barang> barangList = barangService.readBarang();
        tableModel.setRowCount(0);
        for (Barang barang : barangList) {
            tableModel.addRow(new Object[]{barang.getId(), barang.getNamaBarang(), barang.getHarga(), barang.getStok()});
        }
    }

    private void clearFields() {
        namaBarangField.setText("");
        hargaField.setText("");
        stokField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}

