package com.example.verenca.tubesandroid.Helper;

import android.view.View;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */
//digunakan untuk recycler touch listener agar bisa di click
public interface ClickListener {
    void onClick(View view, int position);
    void onLongClick(View view, int position);
}