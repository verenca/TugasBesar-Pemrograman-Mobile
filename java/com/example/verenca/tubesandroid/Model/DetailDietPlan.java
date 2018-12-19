package com.example.verenca.tubesandroid.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */
//memiliki data berupa id, id_diet_plan, judul, gambar_url
public class DetailDietPlan {
    @SerializedName("id") //digunakan untuk menserialiskan variabel
    public int id;

    @SerializedName("id_diet_plan")
    public int id_diet_plan;

    @SerializedName("judul")
    public String judul;

    @SerializedName("gambar_url")
    public String gambar_url;

    //konstruktor adalah funsi yang pertama kali dijalankan saat pembuatan objek
    public DetailDietPlan(int id, int id_diet_plan, String judul, String gambar_url) {
        this.id = id;
        this.id_diet_plan = id_diet_plan;
        this.judul = judul;
        this.gambar_url = gambar_url;
    }

    public DetailDietPlan() {
    }

    //setter dan getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_diet_plan() {
        return id_diet_plan;
    }

    public void setId_diet_plan(int id_diet_plan) {
        this.id_diet_plan = id_diet_plan;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar_url() {
        return gambar_url;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }
}
