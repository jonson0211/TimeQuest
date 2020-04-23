package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    /**
     * 1. First screen that the user sees
     * 2. User needs to enter name
     * 3. User clicks start, name is saved to db
     * 4. User is taken to the adventure page
     */

     private EditText nameEt;
     private Button startB;
     private boolean answered;
     private String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        nameEt = findViewById(R.id.etName);
        startB = findViewById(R.id.bStart);

        startB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!answered){
                    username = nameEt.getText().toString();
                    if(username.matches(" ")){
                        Toast.makeText(Welcome.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                        return;
                    }else
                        saveName();

                } else {
                    startActivity(new Intent(Welcome.this, MainActivity.class));
                }
            }
        });

    }

    public void saveName(){
        //Talk to database to save name
    }

    public static class NotesAdapter {
    }
}
