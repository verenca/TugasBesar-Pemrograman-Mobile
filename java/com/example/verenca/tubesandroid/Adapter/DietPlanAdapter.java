package com.example.verenca.tubesandroid.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.verenca.tubesandroid.Model.DietPlan;
import com.example.verenca.tubesandroid.R;

import java.util.List;

/**
 * Created by WINDOWS 10 on 09/12/2018.
 */

public class DietPlanAdapter extends RecyclerView.Adapter<DietPlanAdapter.DietPlanHolder> {

    //variabel
    List<DietPlan> listDietPlan;

    //konstruktor
    public DietPlanAdapter(List<DietPlan> listDietPlan) {
        this.listDietPlan = listDietPlan;
    }

    @NonNull
    @Override
    public DietPlanHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_dietplan,viewGroup,false);
        DietPlanHolder viewHolder = new DietPlanHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DietPlanHolder dietPlanHolder, int i) {
        dietPlanHolder.judul.setText(listDietPlan.get(i).getJudul() + " DIET MEAL");
    }

    @Override
    public int getItemCount() {
        return listDietPlan.size();
    }

    public class DietPlanHolder extends RecyclerView.ViewHolder {
        TextView judul;
        public DietPlanHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.dp_judul);
        }
    }
}
