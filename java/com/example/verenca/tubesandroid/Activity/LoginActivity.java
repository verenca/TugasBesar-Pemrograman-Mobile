package com.example.verenca.tubesandroid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.verenca.tubesandroid.Helper.DatabaseHelper;
import com.example.verenca.tubesandroid.Helper.SessionManagement;
import com.example.verenca.tubesandroid.R;

public class LoginActivity extends AppCompatActivity {

    //variabel

    TextView l_username,l_password;
    Button buttonLogin;
    SessionManagement sessionManagement;
    DatabaseHelper databaseHelper;

    //fungsi yang dipanggil pada saat activity pertama dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //untuk mengambil objek dari layout berdasarkan id
        l_username = findViewById(R.id.l_username);
        l_password = findViewById(R.id.l_password);

        //memberikan objek pada variabel session dan database helper
        sessionManagement = new SessionManagement(this);
        databaseHelper = new DatabaseHelper(this);

        //mengambil objek dari layout berdasarkan id
        buttonLogin = findViewById(R.id.buttonLogin);

        //memberikan fungsi click pada button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //membuat variabel username dan password
                String username,password;
                //mendapatkan nilai pada inputan
                username = l_username.getText().toString();
                password = l_password.getText().toString();

                //validasi jika kosong maka
                if(username.matches("") || username.trim().isEmpty() || password.matches("") || password.trim().isEmpty()){
                    //tampil pesan error
                    Toast.makeText(LoginActivity.this,"Email dan Passsword Tidak Boleh Kosong / Space"
                            , Toast.LENGTH_LONG).show();
                    return;
                }
                //jika validasi benar maka
                else {
                    //mengecek apakah username dan password sudah terdaftar di database
                    if (databaseHelper.autentikasi(username,password)){
                        //membuat login
                        sessionManagement.createLoginSession(username, password);

                        //berpindah halaman ke BerandaActivity
                        Intent i = new Intent(LoginActivity.this,BerandaActivity.class);
                        startActivity(i);
                    }
                    //jika tidak terdaftar maka tampil pesan error
                    else{
                        Toast.makeText(LoginActivity.this,"Username belum terdaftar",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
