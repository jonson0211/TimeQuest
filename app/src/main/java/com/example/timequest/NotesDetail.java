package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.HandItems;
import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.User;

public class NotesDetail extends AppCompatActivity {



    private Era mEra;
    TextView noteTitle;
    public static AppDatabase db;

    public static EditText editNotes;
    private Button saveNotesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_detail);

        db = AppDatabase.getInstance(getApplicationContext());
        Intent intent = getIntent();
        int position = intent.getIntExtra(NotesActivity.EXTRA_MESSAGE, 0);

        noteTitle = findViewById(R.id.noteTitle2);
        editNotes = findViewById(R.id.editNotes);
        saveNotesButton = findViewById(R.id.saveNotesButton);


        mEra = Era.addEraData().get(position);
        noteTitle.setText(mEra.getEraName());


        //SET EDITtext as "eraNOte"

        //set onclick listener to update eraNote

        try{
            db.eraDAO().insertEra(new Era("Spartan Army", "banner1", "npcathens","Incomplete","sdfsdfsdfsdfsdf ss"));
            db.eraDAO().insertEra(new Era("North Sentinel Islanders", "banner2", "background2","Incomplete", " s"));
            db.eraDAO().insertEra(new Era("Roman Legionnaire", "banner3", "background3","Incomplete", " s"));
            db.eraDAO().insertEra(new Era("Ancient Athenian", "banner4", "background4","Incomplete", " s"));
            db.eraDAO().insertEra(new Era("Normans", "banner5", "background5","Incomplete", " s"));
            db.eraDAO().insertEra(new Era("Cossack Warriors", "banner6", "background6","Incomplete", " s"));
            db.eraDAO().insertEra(new Era("Neanderthals", "banner7", "background7","Incomplete", "s "));
            db.eraDAO().insertEra(new Era("Qing Dynasty", "banner8", "background8","Incomplete", " s"));
            db.eraDAO().insertEra(new Era("Vikings", "banner9", "background9","Incomplete", "s "));

        } catch (Exception e){
            System.out.println("!");
        }

        editNotes.setText(db.eraDAO().getEraNotes(mEra.getEraName()));

        saveNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.eraDAO().updateNotes(editNotes.getText().toString(), mEra.getEraName());
                Toast toast = Toast.makeText(getApplicationContext(), "Notes saved", Toast.LENGTH_SHORT);
                toast.show();
                finish();

            }
        });



    }
}
