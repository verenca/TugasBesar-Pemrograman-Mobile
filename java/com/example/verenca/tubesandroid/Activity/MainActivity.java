package com.example.verenca.tubesandroid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.verenca.tubesandroid.Helper.PrefManager;
import com.example.verenca.tubesandroid.R;

public class MainActivity extends AppCompatActivity {

    //variabel
    Button buttonLogin;
    Button buttonRegister;

    //fungsi yang dipanggil pada saat activity pertama dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mengambil objek di layout sesuai id
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        //memberikan fungsi click pada login
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //menuju ke halaman LoginActivity
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        //memberikan fungsu click pada register
        buttonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //menuju ke halaman RegisterActivity
                Intent i = new Intent(MainActivity.this,RegistserActivity.class);
                startActivity(i);
            }
        });

        //memberikan fungsi click
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PrefManager prefManager = new PrefManager(getApplicationContext());
                prefManager.setFirstTimeLaunch(true);
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                finish();
            }
        });

    }
}