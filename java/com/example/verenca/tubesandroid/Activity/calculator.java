package com.example.verenca.tubesandroid.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.verenca.tubesandroid.R;


public class calculator extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculator);

            //mengambil dari layout
            final EditText e1 = (EditText) findViewById(R.id.et1);
            final EditText e2 = (EditText) findViewById(R.id.et2);
            final TextView tv4 = (TextView) findViewById(R.id.tv4);

            //button jika di click
            findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

                // Logic for validation, input can't be empty
                @Override
                public void onClick(View v) {

                    //untuk menyimpan tulisan yang telah diinputkan di edit text 1 dan edit text 2 (berat & tinggi)
                    String str1 = e1.getText().toString();
                    String str2 = e2.getText().toString();

                    //jika kosong maka tampil pesan error weight
                    if(TextUtils.isEmpty(str1)){
                        e1.setError("Please enter your weight");
                        //untuk memfokuskan pada bagian error / yang harus diisi
                        e1.requestFocus();
                        return;
                    }

                    //jika kosong maka tampil pesan error height
                    if(TextUtils.isEmpty(str2)){
                        e2.setError("Please enter your height");
                        e2.requestFocus();
                        return;
                    }


                    //digunakan untuk mendapatkan data dan dicasting (merubah tipedata) ke float
                    float weight = Float.parseFloat(str1);
                    float height = Float.parseFloat(str2)/100;

                    //menghitung bmivalue sesuai data yang telah diinputkan
                    float bmiValue = calculateBMI(weight, height);

                    //digunakan untuk memuculkan keterangan sesuai dengan value diatas (kurus - normal - over)
                    String bmiInterpretation = interpretBMI(bmiValue);

                    //mengganti tulisan keterangan
                    tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

                }
            });

        }

        //Perhitungan bmi sesuai dengan weight dan heigt
        private float calculateBMI (float weight, float height) {
            return (float) (weight / (height * height));
        }

        //digunakan untuk mengambil keterangan hasil
        private String interpretBMI(float bmiValue) {

            //jika bmi < 16 maka underweight
            if (bmiValue < 16) {
                return "Severely underweight";
            } else if (bmiValue < 18.5) {

                return "Underweight";
            } else if (bmiValue < 25) {

                return "Normal";
            } else if (bmiValue < 30) {

                return "Overweight";
            } else {
                return "Obese";
            }
        }
    }



