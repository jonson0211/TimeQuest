package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.timequest.Adapters.NotesAdapter;
import com.example.timequest.Entities.Era;

import java.util.List;

public class NotesActivity extends AppCompatActivity {


    private boolean mTwoPane;
    public static AppDatabase db;
    private RecyclerView notesList;
    public static List notes;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notesList = findViewById(R.id.rvListNotes);
        notesList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        notesList.setLayoutManager(mLayoutManager);
        NotesAdapter.RecyclerViewClickListener listener = new NotesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

            }
        };
        mAdapter = new NotesAdapter(Era.addEraData(), listener);
        notesList.setAdapter(mAdapter);

/**
        NotesAdapter mNotesAdapter = new NotesAdapter(Era.addEraData(), listener);


        notes = db.notesDAO().getNotes();


        db = AppDatabase.getInstance(getApplicationContext());
 **/
    }

}