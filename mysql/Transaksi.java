/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.mysql;

public class Transaksi {
    private int id;
    private int konsumenId;
    private int barangId;
    private int jumlah;
    private double totalHarga;

    public Transaksi(int id, int konsumenId, int barangId, int jumlah, double totalHarga) {
        this.id = id;
        this.konsumenId = konsumenId;
        this.barangId = barangId;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    public int getId() {
        return id;
    }

    public int getKonsumenId() {
        return konsumenId;
    }

    public int getBarangId() {
        return barangId;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }
}

