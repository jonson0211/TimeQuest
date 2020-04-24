package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class Instructions extends AppCompatActivity {

    ScrollView instructionSv;
    Button homeB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);


        Intent intent = getIntent();
        instructionSv = (ScrollView) findViewById(R.id.svInstructions);
        homeB = (Button) findViewById(R.id.bReturn);

        homeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Instructions.this, Welcome.class));

            }
        });

    }
}
