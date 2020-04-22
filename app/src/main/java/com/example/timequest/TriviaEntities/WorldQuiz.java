package com.example.timequest.TriviaEntities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.timequest.R;
import com.example.timequest.TriviaService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorldQuiz extends AppCompatActivity {


    private static final String TAG = "WorldQuiz.class";
    TextView modeTv, questionTv;
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
    private Result mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_quiz);


        String mode = super.getIntent().getStringExtra("LEVEL");
        Log.d(TAG, mode);

        modeTv = findViewById(R.id.tvWQMode);
        Log.d(TAG, "WQ 1 onCreate");

        modeTv.setText(mode);
        String level = modeTv.getText().toString();

        topicTv = findViewById(R.id.tvWQTopic);
        questionTV = findViewById(R.id.tvWQQuestion);
        countdownTV = findViewById(R.id.tvWQCounter);
        aButton = findViewById(R.id.buttonWQA);
        bButton = findViewById(R.id.buttonWQB);
        cButton = findViewById(R.id.buttonWQC);
        confirmButton = findViewById(R.id.buttonWQConfirm);
        questionRg = findViewById(R.id.radioWQG);

        //establishing the colours of the button and counter
        defaultColourButton = aButton.getTextColors();
        defaultColourCounter = countdownTV.getTextColors();

        new GetQuizTask().execute();

        /**       //Start quiz, next question
        nextQuestion();

        //When the confirm button is clicked, need to check whether an answer has been selected
        //Mark answer if correct
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (aButton.isChecked() || bButton.isChecked() || cButton.isChecked()) {
                        markAnswer();
                    } else {
                        Toast.makeText(WorldQuiz.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    nextQuestion();
                }

            }
        });

        //handle button colours when selected
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                bButton.setBackgroundResource(R.drawable.buttons);
                cButton.setBackgroundResource(R.drawable.buttons);
            }
        });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                aButton.setBackgroundResource(R.drawable.buttons);
                cButton.setBackgroundResource(R.drawable.buttons);
            }
        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                aButton.setBackgroundResource(R.drawable.buttons);
                bButton.setBackgroundResource(R.drawable.buttons);
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
/**
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

            Intent rsIntent = new Intent(getApplicationContext(), Achievement.class);
            String testContent = getIntent().getStringExtra("LEARNING");
            rsIntent.putExtra("LEARNING", testContent);
            rsIntent.putExtra("EXTRA_SCORE", score);

            setResult(RESULT_OK,rsIntent);
            //finish();
            //finishQuiz();

            startActivity(rsIntent);


        }**/
    }
/**
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

        String time = String.format(Locale.getDefault(), "%02d", seconds);
        countdownTV.setText(time);

        if(countDownTimeLeftMillis<10000){
            countdownTV.setTextColor(Color.RED);
            countdownTV.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake));
        }else{
            countdownTV.setTextColor(defaultColourCounter);
        }

    }
    //To fix once the database is setup
    private void markAnswer(){
        countdownTV.clearAnimation();
        answered = true;
        countDownTimer.cancel();
        RadioButton selectedAnswer = findViewById(questionRg.getCheckedRadioButtonId());

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(questionCount);

        int answer = questionRg.indexOfChild(selectedAnswer) + 1;
        //if(answer == currentQuestion.getAnswerNumber()){
        System.out.println(answer);
        if(answer == currentQuestion.getAnswerNumber()){
            System.out.println(answer + "*");
            score++;
            System.out.println(score);

        }
        //else { - change image to red X for wrong answers
        //Drawable wbThumb = getResources().getDrawable(R.drawable.ic_close);
        //seekBar.setThumb(wbThumb);}
        displaySolution();
        System.out.println("Current score: " + score);
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
    }
**/
    private class GetQuizTask extends AsyncTask<Void, Void, List<Result>> {

        @SuppressLint("WrongThread")
        @Override
        protected List<Result> doInBackground(Void... voids) {
            Log.d(TAG, "GetQuizTask:Step0");
            try {
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://opentdb.com").addConverterFactory(GsonConverterFactory.create()).build();
                Log.d(TAG, "GetQuizTask:Step1");
                TriviaService triviaService = retrofit.create(TriviaService.class);
                Log.d(TAG, "GetQuizTask:Step2");
          /**   if(modeTv.getText().toString() == "easy"){
                    Log.d(TAG, "GetQuizTask:Step3");
                    Call<Trivia> triviaServiceEasyTriviaCall = triviaService.getEasyTrivia();
                    Response<Trivia> triviaResponse = triviaServiceEasyTriviaCall.execute();
                    List<Result> results = triviaResponse.body().getResults();
                    return results;
                }else{**/
                    Call<Trivia> triviaServiceDifficultTriviaCall = triviaService.getDifficultTrivia();
                    Response<Trivia> triviaResponse = triviaServiceDifficultTriviaCall.execute();
                    List<Result> results = triviaResponse.body().getResults();
                Log.d(TAG, "GetQuizTask:Step3");
                return results;
                //     }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        @Override
        protected void onPostExecute(List<Result> results) {
            Log.d(TAG, "GetQuizTask:Step3");
            Log.d(TAG, "GetQuizTask:Step3");

           UpdateUi();
        }
    }

    private void UpdateUi(){
        Log.d(TAG, "GetQuizTask: " + mResult.getQuestion());

     //   ((TextView) findViewById(R.id.tvWQQuestion)).setText(mResult.getQuestion());



    }
}
