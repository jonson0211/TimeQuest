package com.example.timequest.TriviaEntities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Update;

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
import retrofit2.Callback;
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

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://opentdb.com").addConverterFactory(GsonConverterFactory.create()).build();
        Log.d(TAG, "GetQuizTask:Step1");
        TriviaService triviaService = retrofit.create(TriviaService.class);
        Log.d(TAG, "GetQuizTask:Step2");
        Call<Trivia> triviaServiceEasyTriviaCall = triviaService.getEasyTrivia();
        Log.d(TAG, "GetQuizTask:Step3");

        triviaServiceEasyTriviaCall.enqueue(new Callback<Trivia>() {
            @Override
            public void onResponse(Call<Trivia> call, Response<Trivia> response) {
                List<Result> results = response.body().getResults();
                Log.d(TAG, "GetQuizTask:Step4");

                for (Result result : results) {
                    Log.d(TAG, "GetQuizTask:Step5");

                    mResult = result;
                }

            }

            @Override
            public void onFailure(Call<Trivia> call, Throwable t) {

            }
        });

        UpdateUi();
    }


    private void UpdateUi(){
     ((TextView) findViewById(R.id.tvWQQuestion)).setText(mResult.getQuestion());

        Log.d(TAG, "GetQuizTask:Step6");


    }
}
