package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timequest.Adapters.EraAdapter;
import com.example.timequest.Adapters.NotesAdapter;
import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.Notes;

import java.util.List;

public class NotesActivity extends AppCompatActivity {


    private boolean mTwoPane;
    public static AppDatabase db;
    private RecyclerView notesList;
    public static List notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        db = AppDatabase.getInstance(getApplicationContext());

        NotesAdapter mNotesAdapter = new NotesAdapter();

        notesList = findViewById(R.id.notesList);
        notesList.setHasFixedSize(true);
        notes = db.notesDAO().getNotes();



        EraAdapter mEraAdapter = new EraAdapter(Era.addEraData(), listener);
        mEraAdapter.setData(Era.addEraData());
        mRvList.setAdapter(mEraAdapter);

        mRvList = v.findViewById(R.id.rvList);
    }

}