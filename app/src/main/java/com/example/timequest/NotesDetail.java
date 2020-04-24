package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    private static final String TAG = "NotesDetail Activity";

    private Era mEra;
    TextView noteTitle;
    public static AppDatabase db;

    public static EditText editNotes;
    private Button saveNotesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_detail);

        //Set up page elements
        noteTitle = findViewById(R.id.noteTitle2);
        editNotes = findViewById(R.id.editNotes);
        saveNotesButton = findViewById(R.id.saveNotesButton);

        db = AppDatabase.getInstance(getApplicationContext());


        //This if block checks and handles whether the intent is coming from recyclerview in Profile fragment (which would send an integer position)
        // OR if it is coming from Learning Read Activity, which will send a String EraName intent
        Intent intent = getIntent();

        if(intent.hasExtra("ERA")){
            intent.getStringExtra("ERA");
            String eraName = intent.getStringExtra("ERA");

            for (int x = 0; x < Era.addEraData().size(); x++){
                if (Era.addEraData().get(x).getEraName().equals(eraName)){
                    mEra = Era.addEraData().get(x);
                    System.out.println(mEra);
                    Log.d(TAG, "on match Era Name from LearningReadActivity: SUCCESS");
                    break;
                }
            }
        }else if(intent.hasExtra(NotesActivity.EXTRA_MESSAGE)) {
            int position = intent.getIntExtra(NotesActivity.EXTRA_MESSAGE, 0);
            Log.d(TAG, "on match Era Name from Recyclerview: SUCCESS");
            mEra = Era.addEraData().get(position);
        }

        //Intent from learning read activity (from adventures), make sure it can still handle instances where it may be null
        //e.g. if you only access it from the profile link/recyclerview
        //Intent readIntent = getIntent();



        noteTitle.setText(mEra.getEraName());


        //SET EDITtext as "eraNOte"

        //set onclick listener to update eraNote

        try{
            db.eraDAO().insertEra(new Era("Spartan Army", "banner1", "npcathens","Incomplete","sdfsdfsdfsdfsdf ss", ""));
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
