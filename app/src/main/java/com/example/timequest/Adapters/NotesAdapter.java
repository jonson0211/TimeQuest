package com.example.timequest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timequest.Entities.Notes;
import com.example.timequest.MainActivity;
import com.example.timequest.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>{

    public static ArrayList<Notes> mNotesSet;
    private Notes note;
    private RecyclerViewClickListener mListener;




    public NotesAdapter(ArrayList<Notes> notes, RecyclerViewClickListener listener){
        mNotesSet = notes;
        mListener = listener;

    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }



    public static class NotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        public TextView noteTitle;
        public View view;
        private RecyclerViewClickListener mListener;

        public NotesViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            noteTitle = v.findViewById(R.id.noteTitle);
            mListener = listener;
            view = v;
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: done");

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note, parent, false);
        Log.d(TAG, "Inflater: done");


        Log.d(TAG, "ViewHolder: done");
        return new NotesViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        final Notes notesAtPosition = mNotesSet.get(position);
        Log.d(TAG, "eraPosition: done");
        holder.noteTitle.setText(String.valueOf(notesAtPosition.getNoteTitle()));
        Log.d(TAG, "setTitle: done");
    }
    @Override
    public int getItemCount() {
        //count items in array
        return mNotesSet.size();
    }

}
