package com.example.verenca.tubesandroid.Helper;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

//konfigurasi ClickListener pada RecyclerView digunakan agar dapat di Click RecyclerView nya
public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    //variabel
    private GestureDetector gestureDetector;
    private ClickListener clickListener;

    //kontruktor yang membutuhkan parameter konteks recyclerview dan clicklistener
    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        //set clicklistener sesuai dengan clicklistener (this.clicklistener pertama yaitu variabel class , clickListener kedua yaitu variabel parameter)
        this.clickListener = clickListener;
        //digunakan untuk membuat objek gestureDetector yang digunakan untuk mendekteksi touch lama / ditahan
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            //touch satu kali
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            //touch long press / ditahan
            @Override
            public void onLongPress(MotionEvent e) {
                //mengambil posisi dari item list
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                //jika child tidak kosong dan clicklistener tidak kosong maka
                if (child != null && clickListener != null) {
                    //memanggil fungsi onLongClick (ditahan)
                    clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        //mengambil posisi dari item list
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        //jika child tidak kosong dan clicklistener tidak kosong maka
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            //memanggil fungsi onClick (satu kali Click)
            clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }


    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}