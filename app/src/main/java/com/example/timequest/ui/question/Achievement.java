package com.example.timequest.ui.question;

import android.content.Intent;
import android.os.Bundle;

import com.example.timequest.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timequest.R;

import java.util.Random;

public class Achievement extends AppCompatActivity {

    private TextView outcomeTv;
    private Button homeB;
    private ImageView prizeIv;
    private static final Random RANDOM = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        outcomeTv = findViewById(R.id.tvOutcome);
        homeB = findViewById(R.id.bHome);
        prizeIv = findViewById(R.id.ivPrize);

        homeB.setOnClickListener(v -> startActivity(new Intent(Achievement.this, MainActivity.class)));

        int value1 = randomValue();

        if(QuestionPage.EXTRA_SCORE == "5") {
            outcomeTv.setText("Congratulations! You passed the test. Here is your prize.");
            int prize = getResources().getIdentifier("item"+ value1, "drawable", "com.example.timequest");
            prizeIv.setImageResource(prize);

        }else if (QuestionPage.EXTRA_SCORE == "6") {
            outcomeTv.setText("Congratulations! You passed the test. Here is your prize.");
            int prize = getResources().getIdentifier("item"+ value1, "drawable", "com.example.timequest");
            prizeIv.setImageResource(prize);

        }else if (QuestionPage.EXTRA_SCORE == "7") {
            outcomeTv.setText("Congratulations! You passed the test. Here is your prize.");
            int prize = getResources().getIdentifier("item"+ value1, "drawable", "com.example.timequest");
            prizeIv.setImageResource(prize);

        }else if (QuestionPage.EXTRA_SCORE == "8") {
            outcomeTv.setText("Congratulations! You passed the test. Here is your prize.");
            int prize = getResources().getIdentifier("item"+ value1, "drawable", "com.example.timequest");
            prizeIv.setImageResource(prize);

        }else if (QuestionPage.EXTRA_SCORE == "9") {
            outcomeTv.setText("Congratulations! You passed the test. Here is your prize.");
            int prize = getResources().getIdentifier("item"+ value1, "drawable", "com.example.timequest");
            prizeIv.setImageResource(prize);

        }else if (QuestionPage.EXTRA_SCORE == "10") {
            outcomeTv.setText("Congratulations! You passed the test. Here is your prize.");
            int prize = getResources().getIdentifier("item"+ value1, "drawable", "com.example.timequest");
            prizeIv.setImageResource(prize);
        } else{
            outcomeTv.setText("Oh no. You did not pass the quiz. Revise the content and try again to win a prize!");

        }



    }
    public static int randomValue(){
        return RANDOM.nextInt(6)+1;
    }
}
