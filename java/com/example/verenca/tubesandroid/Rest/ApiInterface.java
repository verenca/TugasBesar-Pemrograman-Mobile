package com.example.verenca.tubesandroid.Rest;

import com.example.verenca.tubesandroid.Model.ResultDetailDietPlan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */

public interface ApiInterface {

    //mengambil data detail diet plan
    @GET("DietPlan/detail/{id_dietplan}")
    Call<ResultDetailDietPlan> getDetailDietPlan(@Path("id_dietplan") int id_dietplan);

}