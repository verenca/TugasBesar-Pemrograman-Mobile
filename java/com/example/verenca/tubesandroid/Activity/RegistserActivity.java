package com.example.verenca.tubesandroid.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.verenca.tubesandroid.Helper.DatabaseHelper;
import com.example.verenca.tubesandroid.Helper.SessionManagement;
import com.example.verenca.tubesandroid.R;

public class RegistserActivity extends AppCompatActivity {

    //variabel
    TextView r_username,r_password,r_email;
    Button buttonRegister;
    SessionManagement sessionManagement;
    DatabaseHelper databaseHelper;

    //fungsi yang dipanggil pada saat activity pertama dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registser);

        //mengambil objek username, password, email di layout sesuai id
        r_username = findViewById(R.id.r_username);
        r_password = findViewById(R.id.r_password);
        r_email = findViewById(R.id.r_email);
        buttonRegister = findViewById(R.id.buttonRegister);

        //membuat objek baru sessionManagement dan databaseHelper
        sessionManagement = new SessionManagement(this);
        databaseHelper = new DatabaseHelper(this);

        //memberi fungsi click pada buttonRegister
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //membuat variabel
                String email,username,password;
                email = r_email.getText().toString();
                username = r_username.getText().toString();
                password = r_password.getText().toString();


                //jika username kosong maka
                if (username.trim().isEmpty()){
                    //tampil pesan error
                    Toast.makeText(RegistserActivity.this,"Username Harus Diisi",Toast.LENGTH_LONG).show();
                    return;
                }
                //jika email kosong maka
                if (email.trim().isEmpty()){
                    //tampil pesan error
                    Toast.makeText(RegistserActivity.this,"Email Harus Diisi",Toast.LENGTH_LONG).show();
                    return;
                }
                //jika email tidak menggunakan @ maka
                if (!email.contains("@")){
                    //tampil pesan error
                    Toast.makeText(RegistserActivity.this,"Email Harus berisikan @",Toast.LENGTH_LONG).show();
                    return;
                }
                //jika password kosong
                if (password.trim().isEmpty()){
                    //maka tampil pesan error
                    Toast.makeText(RegistserActivity.this,"Password Harus Diisi",Toast.LENGTH_LONG).show();
                    return;
                }


                //untuk menambahkan ke database
                databaseHelper.addUser(username,password,email);
                //untuk mengeclose activity
                finish();
            }
        });
    }
}
