package com.example.timequest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timequest.Entities.Era;
import com.example.timequest.Learning1;
import com.example.timequest.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class EraAdapter extends RecyclerView.Adapter<EraAdapter.EraViewHolder>{

    private List<Era> mEra;
    private RecyclerViewClickListener mListener;

   public void setData(ArrayList<Era>mEra){
       Log.d(TAG, "setData: setting data");
       this.mEra = mEra;
       Log.d(TAG, "setData: done");
   }

    public interface RecyclerViewClickListener{
        //Behaviour
        void onClick(View view, int position);
    }

    public static class EraViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titleTv, yearTv;
        public ImageView iconIv;
        public View view;
        private RecyclerViewClickListener mListener;


        public EraViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {


        }
    }

    @NonNull
    @Override
    public EraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Declare view elements
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.era_list_row, parent, false);
        EraViewHolder eraViewHolder = new EraViewHolder(view);

    return eraViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EraViewHolder holder, int position) {
        final Era eraAtPosition = mEra.get(position);


        holder.titleTv.setText(String.valueOf(eraAtPosition.getEraName()));
        holder.yearTv.setText(String.valueOf(eraAtPosition.get));
        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = view.getContext();
                Intent intent = new Intent(context, Learning1.class);
                intent.putExtra("eraName", eraAtPosition.getEraName());
                context.startActivity(intent);
            }

        });
        //populate view elements
    }

    public void getImage(ArrayList<Era>mEra){
        Integer id =



    }
    @Override
    public int getItemCount() {
        //count items in array
        return 0;
    }
}
