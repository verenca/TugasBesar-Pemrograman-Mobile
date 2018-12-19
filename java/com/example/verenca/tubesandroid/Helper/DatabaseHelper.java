package com.example.verenca.tubesandroid.Helper;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    //menyimpan database variabel
    public static String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USER = "user";

    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    /*membuat table users*/

    private static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_EMAIL + " TEXT, "
            + KEY_USERNAME +" TEXT, "
            + KEY_PASSWORD +" TEXT);";

    //konstruktor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //eksekusi table user
        db.execSQL(CREATE_TABLE_USERS);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        onCreate(db);
    }

    //uktuk skrip menambah data user berupa username password email
    public void addUser(String username, String password, String email){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_EMAIL, email);

        long id = db.insertWithOnConflict(TABLE_USER,null,values,SQLiteDatabase.CONFLICT_IGNORE);
    }

    //untuk mengecek username dan password apakah sudah terdaftar atau belum
    public boolean autentikasi(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from "+TABLE_USER+" WHERE "+KEY_USERNAME+"='"+username+"' AND "+KEY_PASSWORD+"='"+password+"'",null);
        cursor.moveToFirst();
        //jika jumlah nya 1 maka return true
        if (cursor.getCount() == 1){
            return true;
        }else{
            return false;
        }
    }
}