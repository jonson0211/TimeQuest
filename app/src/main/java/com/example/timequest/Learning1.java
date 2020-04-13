package com.example.timequest;

//Welcome screen for the learning topic

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.TrialQuestion;

import java.util.List;

public class Learning1 extends AppCompatActivity {

    private TextView topic2Tv, welcomeTv;
    private Button continueB;
    private List<Era> era;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_intro);

        topic2Tv = findViewById(R.id.tvTopic2);
        continueB = findViewById(R.id.bContinue);
        welcomeTv = findViewById(R.id.tvWelcomeMessage);



    }
}

