package com.example.timequest.ui.question;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.example.timequest.Entities.TrialQuestion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timequest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

public class QuestionPage extends AppCompatActivity {

    //Declare string variables
    //Declare XML attributes
    //Declare class instances

    //1. Need to check for category of question
    //2. Display question
    //3. Display answers
    //3.1 Start Counter and CountDown
    //3.2 End CountDown and update Counter
    //4. User selects answer
    //5. User confirms answer
    //6. Class checks database to determine right or wrong
    //7. display next question --> condition; if question counter is less than the total amount of questions
    //8. On last question --> take them to quiz page (implicit intent)

    public static final String ARG_ITEM_ID = "LEARNING";

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private long countDownTimeLeftMillis;

    private TextView questionTV, countdownTV, topicTv;
    private RadioButton aButton, bButton, cButton;
    private Button confirmButton;

    private ColorStateList defaultColourButton, defaultColourCounter;
    private boolean answered;
    private RadioGroup questionRg;
    private CountDownTimer countDownTimer;
    //private int questionCount, questionCountTotal, score;

    private int questionCount = 0;
    private int questionCountTotal = 0;
    private int score = 0;
    //private int correctCount = 0;

    private ArrayList<TrialQuestion> questionSet;
    private TrialQuestion currentQuestion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);



        //Declaring XML variables and connecting to the layout
        topicTv = findViewById(R.id.tvTopic);
        questionTV = findViewById(R.id.tvQuestion);
        countdownTV = findViewById(R.id.tvCounter);
        aButton = findViewById(R.id.buttonA);
        bButton = findViewById(R.id.buttonB);
        cButton = findViewById(R.id.buttonC);
        confirmButton = findViewById(R.id.buttonConfirm);
        questionRg = findViewById(R.id.radioG);

        //establishing the colours of the button and counter
        defaultColourButton = aButton.getTextColors();
        defaultColourCounter = countdownTV.getTextColors();

        //get topic intent from reading page e.g. "Spartan"
        String testContent = getIntent().getStringExtra("LEARNING");

        System.out.println(testContent);
        topicTv.setText(testContent);

        questionSet = TrialQuestion.getTrialQuiz(testContent);
        questionCountTotal = questionSet.size();
        System.out.println(questionSet);

        //Start quiz, next question
        nextQuestion();
//test
        /**
        Integer answer = questionSet.get(0).getAnswerNumber();
        Integer answer1 = questionSet.get(1).getAnswerNumber();
        System.out.println(answer);
        System.out.println(answer1); **/

        //When the confirm button is clicked, need to check whether an answer has been selected
        //Mark answer if correct
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (aButton.isChecked() || bButton.isChecked() || cButton.isChecked()) {
                        markAnswer();
                    } else {
                        Toast.makeText(QuestionPage.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    nextQuestion();
                }

            }
        });


    }
    //1. Set the colors back to default
    //2. Clear the current options
    //3. Reset timer
    //4. Question progress counter
    //5. Finished the quiz - toast message
    //6. Take them to their prize or go back to home page.
    private void nextQuestion(){
        aButton.setTextColor(defaultColourButton);
        bButton.setTextColor(defaultColourButton);
        cButton.setTextColor(defaultColourButton);


        //2.
        questionRg.clearCheck();
        aButton.setBackgroundResource(R.drawable.buttons);
        bButton.setBackgroundResource(R.drawable.buttons);
        cButton.setBackgroundResource(R.drawable.buttons);

        if(questionCount < questionCountTotal){
            //questionCounter is the integer
            currentQuestion = questionSet.get(questionCount);
            System.out.println("Current Question: " + currentQuestion);

            //set the textView based on the current question
            questionTV.setText(currentQuestion.getQuestion()); System.out.println(currentQuestion.getQuestion());
            aButton.setText(currentQuestion.getOption1()); System.out.println(currentQuestion.getOption1());
            bButton.setText(currentQuestion.getOption2());
            cButton.setText(currentQuestion.getOption3());

            questionCount++;

            answered = false;
            //3.
            countDownTimeLeftMillis = COUNTDOWN_IN_MILLIS;

            startCountdown();
        } else{

            Intent rsIntent = new Intent(getApplicationContext(),Achievement.class);
            String testContent = getIntent().getStringExtra("LEARNING");
            rsIntent.putExtra("LEARNING", testContent);
            rsIntent.putExtra("EXTRA_SCORE", score);

            setResult(RESULT_OK,rsIntent);
            //finish();
            //finishQuiz();

            startActivity(rsIntent);


        }
    }

    private void finishQuiz() {
        confirmButton.setOnClickListener(v -> {
            confirmButton.setText("Finish");

            String testContent = getIntent().getStringExtra("LEARNING");
            Intent intent = new Intent(getApplicationContext(), Achievement.class);
            Intent intent1 = new Intent(getApplicationContext(), Achievement.class);
            intent.putExtra("LEARNING", testContent);
            intent1.putExtra("EXTRA_SCORE", score);
            startActivity(intent);
        });

        //Start new activity - achievement page
    }

    //Start countdown once activity is alive
    //create countdowntimer using android OS
    private void startCountdown(){
        countDownTimer = new CountDownTimer(countDownTimeLeftMillis, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                countDownTimeLeftMillis = millisUntilFinished;

                changeCountDownText();

            }

            @Override
            public void onFinish() {
                countDownTimeLeftMillis = 0;
                changeCountDownText();

                markAnswer();

            }
        }.start();
    }

    private void changeCountDownText(){
        int minutes = (int) (countDownTimeLeftMillis/1000) / 60;
        int seconds = (int) (countDownTimeLeftMillis/1000) % 60;

        String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        countdownTV.setText(time);

        if(countDownTimeLeftMillis<10000){
            countdownTV.setTextColor(Color.RED);
        }else{
            countdownTV.setTextColor(defaultColourCounter);
        }

    }
    //To fix once the database is setup
    private void markAnswer(){

        answered = true;
        countDownTimer.cancel();
        RadioButton selectedAnswer = findViewById(questionRg.getCheckedRadioButtonId());

        int answer = questionRg.indexOfChild(selectedAnswer) + 1;
        //if(answer == currentQuestion.getAnswerNumber()){
        System.out.println(answer);
        if(answer == currentQuestion.getAnswerNumber()){
            System.out.println(answer + "*");
            score++;
            System.out.println(score);

        }
        displaySolution();
    }

    private void displaySolution(){
        aButton.setBackgroundColor(Color.RED);
        bButton.setBackgroundColor(Color.RED);
        cButton.setBackgroundColor(Color.RED);

    if(currentQuestion.getAnswerNumber() == 1){
        aButton.setBackgroundColor(Color.GREEN);
    } else if (currentQuestion.getAnswerNumber() == 2){
        bButton.setBackgroundColor(Color.GREEN);

    } else cButton.setBackgroundColor(Color.GREEN);
        if(questionCount < 10){
             confirmButton.setText("Next question");
        }else {
            confirmButton.setText("Finish");
        }

    }

}

