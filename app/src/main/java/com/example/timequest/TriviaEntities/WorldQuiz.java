package com.example.timequest.TriviaEntities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.timequest.R;
import com.example.timequest.ui.Fragments.Featured;

public class WorldQuiz extends AppCompatActivity {

    Intent intent = getIntent();
    int level = intent.getIntExtra(Featured.EXTRA_MESSAGE,0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_quiz);


    }
}
