package com.example.timequest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.Image;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timequest.Entities.Era;
import com.example.timequest.LearningReadActivity;
import com.example.timequest.R;
import com.example.timequest.ui.home.HomeFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class EraAdapter extends RecyclerView.Adapter<EraAdapter.EraViewHolder>{

    private List<Era> mEraSet;
    private Era mEra;


    private int[] images;

    public EraAdapter(){

    }

   public void setData(ArrayList<Era> eraToAdapt) {
       Log.d(TAG, "setData: setting data");
       this.mEraSet = eraToAdapt;
       Log.d(TAG, "setData: done");
   }
    @NonNull
    @Override
    public EraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: done");
        //Declare view elements
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.era_list_row, parent, false);
        Log.d(TAG, "Inflater: done");

        EraViewHolder eraViewHolder = new EraViewHolder(view);
        Log.d(TAG, "ViewHolder: done");
        return eraViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EraViewHolder holder, int position) {
        final Era eraAtPosition = mEraSet.get(position);
        Log.d(TAG, "eraPosition: done");
        holder.titleTv.setText(String.valueOf(eraAtPosition.getEraName()));
        Log.d(TAG, "setTitle: done");
/**
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, LearningReadActivity.class);
                intent.putExtra("LEARNING", eraAtPosition.getEraName());
                context.startActivity(intent);
            }
        });**/

        if(eraAtPosition.getEraName().contentEquals("Ancient Athenian")){
            holder.iconIv.setImageResource(R.drawable.npcathens);
        } else if (eraAtPosition.getEraName().contentEquals("Ancient Athenian")) {
            holder.iconIv.setImageResource(R.drawable.npcathens);
        } else if (eraAtPosition.getEraName().contentEquals("Roman Legionnaire")) {
            holder.iconIv.setImageResource(R.drawable.npcroman);
        } else if (eraAtPosition.getEraName().contentEquals("Qing Dynasty")) {
            holder.iconIv.setImageResource(R.drawable.npcqing);
        } else if (eraAtPosition.getEraName().contentEquals("North Sentinel Islanders")) {
            holder.iconIv.setImageResource(R.drawable.npcsentinel);
        } else if (eraAtPosition.getEraName().contentEquals("Spartan Army")) {
            holder.iconIv.setImageResource(R.drawable.npcspartan);
        } else if (eraAtPosition.getEraName().contentEquals("Vikings")){
        holder.iconIv.setImageResource(R.drawable.npcviking);
        } else{
            holder.iconIv.setImageResource(R.drawable.npcneanderthal);
        }


        //populate view elements
    }
    @Override
    public int getItemCount() {
        //count items in array
        return mEraSet.size();
    }
    public static class EraViewHolder extends RecyclerView.ViewHolder{

        public TextView titleTv;
        public ImageView iconIv;
        public View view;


        public EraViewHolder(View v){
            super(v);
            Log.d(TAG, "EraViewHolderr: done");
            titleTv = v.findViewById(R.id.tvTitle);
            iconIv = v.findViewById(R.id.ivIcon);
        }
    }
}
