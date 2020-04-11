package com.example.timequest.ui.question;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.timequest.R;
import com.kofigyan.stateprogressbar.StateProgressBar;

public class QuestionPage extends AppCompatActivity {

    //Declare string variables
    //Declare XML attributes
    //Declare class instances

    //1. Need to check for category of question
    //2. Display question
    //3. Display answers
    //4. User selects answer
    //5. User confirms answer
    //6. Class checks database to determine right or wrong
    //7. display next question --> condition; if question counter is less than the total amount of questions
    //8. On last question --> take them to quiz page (implicit intent)

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";

    private TextView questionTV, countdownTV;
    private RadioButton aButton, bButton, cButton;
    private Button confirmButton;
    private ColorStateList defaultColourButton, defaultColourCounter;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);

        //Declaring XML variables and connecting to the layout
        questionTV = findViewById(R.id.tvQuestion);
        countdownTV = findViewById(R.id.tvCounter);
        aButton = findViewById(R.id.buttonA);
        bButton = findViewById(R.id.buttonB);
        cButton = findViewById(R.id.buttonC);
        confirmButton = findViewById(R.id.buttonConfirm);

        //establishing the colours of the button and counter
        defaultColourButton = aButton.getTextColors();
        defaultColourCounter = countdownTV.getTextColors();

        //Retrieving the question Topic
        Intent explicitIntent = getIntent();
        String topic = explicitIntent.getStringExtra("topic");
        System.out.println(topic);

        //Need to talk to database to get questions based on the topic

//When the confirm button is clicked, need to check whether an answer has been selected
        //Mark answer if correct
        confirmButton.setOnClickListener(View v){
            if (!answered){
                if (aButton.isChecked() || bButton.isChecked() || cButton.isChecked()){
                    markAnswer();
                }
            }

        }


    }

    private void markAnswer(){
        answered = true;

        RadioButton selectedAnswer =
    }
}

