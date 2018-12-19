package com.example.verenca.tubesandroid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.verenca.tubesandroid.Helper.ClickListener;
import com.example.verenca.tubesandroid.Model.DietPlan;
import com.example.verenca.tubesandroid.Adapter.DietPlanAdapter;
import com.example.verenca.tubesandroid.R;
import com.example.verenca.tubesandroid.Helper.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class DietPlanActivity extends AppCompatActivity {

    //variabel
    RecyclerView rv_dp;

    //fungsi yang dipanggil pada saat activity pertama dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);

        //mengambil komponen recycler view dari layout
        rv_dp = findViewById(R.id.rv_dp);

        //mengganti setLayoutManager menjadi LinearLayoutManager
        rv_dp.setLayoutManager(new LinearLayoutManager(this));

        //membuat variabel dan diberi final agar dapat diakses disemua scope(scope = kurung kurawa)
        final List<DietPlan> listDietPlan;
        //memberikan objek pada listDietPlan berupa ArrayList
        listDietPlan = new ArrayList<>();

        //digunakan untuk mengisi listDietPlan berupa objek dari DietPlan
        listDietPlan.add(new DietPlan("Day 1","Only eat fruits on this day. You can eat any food except banana","Recommended Fruits :"));
        listDietPlan.add(new DietPlan("Day 2","Only eat vegetables on this day. You can eat any vegetables you like","Recommended Vegetables :"));
        listDietPlan.add(new DietPlan("Day 3","You can eat any vegetables and fruits you like on the third day. However do not have banana and potatoes","List :"));
        listDietPlan.add(new DietPlan("Day 4","On day 4 you can eat banana and glasses of milk","List :"));
        listDietPlan.add(new DietPlan("Day 5","You can eat cooked rice and tomato soup","List :"));
        listDietPlan.add(new DietPlan("Day 6","On day 6 you can eat meat and vegetables you wish","List :"));
        listDietPlan.add(new DietPlan("Day 7","On the final day, you can eat cooked rice, fruits, and vegetables as much as you like","List :"));

        //untuk mengeset adapter sesuia dengan DietPlanAdapter yang telah diisi dengan listDietPlan
        rv_dp.setAdapter(new DietPlanAdapter(listDietPlan));
        //untuk memberikan fungsi click pada tiap list yang ada di recycler view
        rv_dp.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rv_dp, new ClickListener() {

            //jika click 1x maka
            @Override
            public void onClick(View view, int position) {
                //membuat intent dari konteks aplikasi ke DetailDietPlanActivity
                Intent i = new Intent(getApplicationContext(),DetailDietPlanActivity.class);

                //untuk mengirimkan data ke activity tujuan DetailDietPlanActivity
                i.putExtra("id_dietplan",+position+1);
                i.putExtra("dietplan",listDietPlan.get(position));
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
