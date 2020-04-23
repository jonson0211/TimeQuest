package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.timequest.Entities.Era;

public class NotesDetail extends AppCompatActivity {



    private Era mEra;
    TextView noteTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra(NotesActivity.EXTRA_MESSAGE, 0);

        noteTitle = findViewById(R.id.noteTitle2);

        mEra = Era.addEraData().get(position);
        noteTitle.setText(mEra.getEraName());

    }
}
