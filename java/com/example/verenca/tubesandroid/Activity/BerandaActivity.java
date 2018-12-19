package com.example.verenca.tubesandroid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.verenca.tubesandroid.R;

public class BerandaActivity extends AppCompatActivity {

    //membuat variabel
    Button mealplan, calculator, about;

    //fungsi yang dijalankan pertama kali pada saat membuat activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        //mengambil komponen dari view berdasarkan id
        mealplan = findViewById(R.id.mealplan);

        //memberikan fungsi click
        mealplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BerandaActivity.this,DietPlanActivity.class);
                startActivity(intent);
            }
        });

        //mengambil komponen dari view berdasarkan id
        calculator = findViewById(R.id.calculator);

        //memberikan fungsi click
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BerandaActivity.this,calculator.class);
                startActivity(intent);
            }
        });

        //mengambil komponen dari view berdasarkan id
        about = findViewById(R.id.about);

        //memberikan fungsi click
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BerandaActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}
