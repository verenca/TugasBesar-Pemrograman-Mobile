package com.example.verenca.tubesandroid.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */

//digunakan untuk menserialiskan variabel status, result, message
public class ResultDetailDietPlan {
    @SerializedName("status")
    private String status;
    @SerializedName("result")
    private List<DetailDietPlan> result = new ArrayList<DetailDietPlan>();
    @SerializedName("message")
    private String message;

    //kontruktor
    public ResultDetailDietPlan() {}

    //setter dan getter
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<DetailDietPlan> getResult() {
        return result;
    }
    public void setResult(List<DetailDietPlan> result) {
        this.result = result;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
