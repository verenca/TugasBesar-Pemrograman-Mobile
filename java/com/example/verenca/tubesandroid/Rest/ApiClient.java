package com.example.verenca.tubesandroid.Rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */

//class untuk menyimpan retrofit yang digunakan untuk  menyambungkan ke server
public class ApiClient {
    //menyimpan alamat server
    public static final String BASE_URL = "http://192.168.100.165:8080/diet_server/index.php/";
    //menyimpan retrofit
    private static Retrofit retrofit = null;
    //memanggil retrofit dari server
    public static Retrofit getClient() {
        //jika retrofit kosong maka mengambil retrofit
        if (retrofit==null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}