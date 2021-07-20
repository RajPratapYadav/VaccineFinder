package com.example.vaccinefinder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recylerAdapter extends RecyclerView.Adapter<recylerAdapter.ViewClass>{
     ArrayList<modal> ar;
    Context c;
    public recylerAdapter(Context homePage, ArrayList<modal> ar) {
        this.ar=ar;
        c=homePage;
    }



    @NonNull
    @Override
    public ViewClass onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View v= LayoutInflater.from(c).inflate(R.layout.adapter_recyler,null,false);
        return new ViewClass(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull recylerAdapter.ViewClass holder, int position) {
        holder.centerName.setText(ar.get(position).centerName+"");
      holder.centerAddress.setText(ar.get(position).centerAddress+","+ar.get(position).centerBlockName+","+ar.get(position).centerDistrictName+","+ar.get(position).centerStateName);
      holder.centerTimings.setText("From : "+ar.get(position).centerFrom+" To : "+ar.get(position).centerTo+"");
      holder.vaccineName.setText(ar.get(position).vaccine+"");
      holder.feeType.setText("Fee Type : "+ar.get(position).centerFeetype);
      holder.ageLimit.setText("Age Limit : "+ar.get(position).min_age_limit);
      holder.avaliablity.setText("Availibility : "+ar.get(position).available_capacity);
      holder.dose1.setText("Dose 1 : "+ar.get(position).available_capacity_dose1);
      holder.dose2.setText("Dose 2 : "+ar.get(position).available_capacity_dose2);

    }
    @Override
    public int getItemCount() {

        return ar.size();
    }

    public static class ViewClass extends RecyclerView.ViewHolder {
        TextView centerName,centerAddress,centerTimings,vaccineName,feeType,ageLimit,avaliablity,dose1,dose2;
         ConstraintLayout cll;

        public ViewClass(@NonNull  View itemView) {

            super(itemView);
            cll=(itemView).findViewById(R.id.cll);
            avaliablity = (itemView).findViewById(R.id.avaliablity);
            dose1=(itemView).findViewById(R.id.dose1);
            dose2=(itemView).findViewById(R.id.dose2);
            ageLimit = (itemView).findViewById(R.id.ageLimit);
            feeType = (itemView).findViewById(R.id.feeType);
            vaccineName = (itemView).findViewById(R.id.vaccineName);
            centerTimings = (itemView).findViewById(R.id.centerTimings);
            centerAddress = (itemView).findViewById(R.id.centerAddress);
            centerName = (itemView).findViewById(R.id.centerName);

        }
    }
}

