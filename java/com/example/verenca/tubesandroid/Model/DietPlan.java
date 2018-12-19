package com.example.verenca.tubesandroid.Model;

import java.io.Serializable;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */

public class DietPlan implements Serializable {


    //variabel
    String judul;
    String deskripsi;
    String pilihan;

    //kontruktor fungsi yang pertama kali dijalankan untuk membuat objek
    public DietPlan(String judul, String deskripsi, String pilihan) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.pilihan = pilihan;
    }

    //kontruktor tetapi tanpa parameter
    public DietPlan() {
    }

    //setter getter
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }
}
