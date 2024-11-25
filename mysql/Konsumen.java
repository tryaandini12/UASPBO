/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tugas.mysql;

public class Konsumen {
    private int id;
    private String namaKonsumen;
    private String alamat;
    private String telepon;

    public Konsumen(int id, String namaKonsumen, String alamat, String telepon) {
        this.id = id;
        this.namaKonsumen = namaKonsumen;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public int getId() {
        return id;
    }

    public String getNamaKonsumen() {
        return namaKonsumen;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }
}
