package com.example.verenca.tubesandroid.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.verenca.tubesandroid.Activity.LoginActivity;

import java.util.HashMap;

public class SessionManagement {
    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;
    private Context mContext;
    int PRIVATE_MODE;
    private static final String PREF_NAME = "SharedPrefLatihan";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    //konstruktor, konstruktor adalah fungsi yang pertama kali dijalankan saat pembuatan objek
    public SessionManagement(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }
    //fungsi yang digunakan untuk membuat session sesuai email dan password
    public void createLoginSession(String email, String password){
        mEditor.putBoolean(IS_LOGIN, true); //putBoolean digunakan untuk menyimpan variabel boolean kepada mEditor
        mEditor.putString(KEY_USERNAME, email); //putString digunakan untuk menyimpan variabel string kepada mEditor
        mEditor.putString(KEY_PASSWORD, password); //putString digunakan untuk menyimpan variabel string kepada mEditor
        mEditor.commit(); //digunakan untuk save perubahan
    }

    //untuk memberikan key pada suatu nilai
    public HashMap<String, String> getUserInformation(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_USERNAME, mSharedPreference.getString(KEY_USERNAME, null)); //untuk mengisi hashmap dengan data session username
        user.put(KEY_PASSWORD, mSharedPreference.getString(KEY_PASSWORD, null)); //untuk mengisi hashmap dengan data session password
        return user;
    }
    //mengecek sudah login atau belum
    public boolean isLoggedIn(){
        return mSharedPreference.getBoolean(IS_LOGIN, false);
    }

    //mengecek login
    public void checkIsLogin() {
        //jika belum login maka menuju ke LoginActivity
        if (!isLoggedIn()) {
            //membuat objek Intent sesuai Context dan activity tujuan
            Intent i = new Intent(mContext, LoginActivity.class); //intent adalah pintu untuk berpindah
            //untuk menghilangkan bekas activity
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //untuk membuat flag baru
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }

    //untuk logout
    public void logoutUser(){
        mEditor.clear();
        mEditor.commit();
        Intent i = new Intent(mContext, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
