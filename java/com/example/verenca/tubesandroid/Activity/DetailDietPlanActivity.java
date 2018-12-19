package com.example.verenca.tubesandroid.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.verenca.tubesandroid.Model.DetailDietPlan;
import com.example.verenca.tubesandroid.Adapter.DetailDietPlanAdapter;
import com.example.verenca.tubesandroid.Model.DietPlan;
import com.example.verenca.tubesandroid.R;
import com.example.verenca.tubesandroid.Rest.ApiClient;
import com.example.verenca.tubesandroid.Rest.ApiInterface;
import com.example.verenca.tubesandroid.Model.ResultDetailDietPlan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDietPlanActivity extends AppCompatActivity {

    //variabel
    TextView ddp_judul;
    TextView ddp_deskripsi;
    TextView ddp_pilihan;
    RecyclerView rv_ddp;

    //fungsi yang dipanggil pada saat activity pertama dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_diet_plan);

        //mengambil komponen berdasarkan id
        ddp_judul = findViewById(R.id.ddp_judul);
        ddp_deskripsi = findViewById(R.id.ddp_deskripsi);
        ddp_pilihan = findViewById(R.id.ddp_pilihan);
        rv_ddp = findViewById(R.id.rv_ddp);

        //untuk mengeset ryclcler view LayoutManager menjadi LinearLayoutManager
        rv_ddp.setLayoutManager(new LinearLayoutManager(this));

        //digunakan untuk mendapatkan data DietPlan dari DietPlanActivity
        DietPlan dp = (DietPlan) getIntent().getSerializableExtra("dietplan");
        //mengambil id_dietplan digunakan untuk menampilkan detail DietPlan sesuai dengan id
        int id_dietplan = getIntent().getIntExtra("id_dietplan",0);

        //merubah judul, deskripsi, pilihan sesuai dengan data DietPlan
        ddp_judul.setText(dp.getJudul());
        ddp_deskripsi.setText(dp.getDeskripsi());
        ddp_pilihan.setText(dp.getPilihan());

        //mendapatkan interface dari ApiClient
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        //memanggil fungsi getDetailDietPlan sesuai dengan id DietPlan dari interface
        Call<ResultDetailDietPlan> mPembeliCall = mApiInterface.getDetailDietPlan(id_dietplan);
        //mendapatkan hasil yang telah dipanggil
        mPembeliCall.enqueue(new Callback<ResultDetailDietPlan>() {
            //jika merespon maka
            @Override
            public void onResponse(Call<ResultDetailDietPlan> call,
                                   Response<ResultDetailDietPlan> response) {
                //menampilkan log (logcat bawah)
                Log.d("Get DietPlan",response.body().getStatus());
                //mendapatkan result dan dimasukkan ke dalam dataset
                List<DetailDietPlan> dataset = response.body().getResult();

                //digunakan untuk mengeset adapter pada recycler view
                rv_ddp.setAdapter(new DetailDietPlanAdapter(dataset,getApplicationContext()));
                //menampilkan pesan Berhasil
                Toast.makeText(getApplicationContext(),"Berhasil", Toast.LENGTH_LONG).show();
            }
            //jika tidak maka
            @Override
            public void onFailure(Call<ResultDetailDietPlan> call, Throwable t) {
                //menampilkan log (logcat dibawah)
                Log.d("Get DietPlan",t.getMessage());
                //menampilkan pesan gagal
                Toast.makeText(getApplicationContext(),"Gagal"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
