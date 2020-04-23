package com.example.timequest.TriviaEntities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Update;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timequest.R;
import com.example.timequest.TriviaService;
import com.example.timequest.ui.question.Achievement;
import com.example.timequest.ui.question.QuestionPage;

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
    private RadioButton aButton, bButton, cButton, dButton;
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
    private Result currentQuestion;
    private List<Result> questionSet;


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
        aButton = findViewById(R.id.buttonWQA);
        bButton = findViewById(R.id.buttonWQB);
        cButton = findViewById(R.id.buttonWQC);
        dButton = findViewById(R.id.buttonWQD);
        questionRg = findViewById(R.id.radioWQG);

        //establishing the colours of the button and counter
        defaultColourButton = aButton.getTextColors();
        defaultColourCounter = countdownTV.getTextColors();


        new GetQuestionTask().execute();
        Log.d(TAG, "onresponse: loaded XML");

        //handle button colours when selected
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                bButton.setBackgroundResource(R.drawable.buttons);
                cButton.setBackgroundResource(R.drawable.buttons);
                dButton.setBackgroundResource(R.drawable.buttons);
            }
        });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                aButton.setBackgroundResource(R.drawable.buttons);
                cButton.setBackgroundResource(R.drawable.buttons);
                dButton.setBackgroundResource(R.drawable.buttons);
            }
        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                aButton.setBackgroundResource(R.drawable.buttons);
                bButton.setBackgroundResource(R.drawable.buttons);
                dButton.setBackgroundResource(R.drawable.buttons);
            }
        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                aButton.setBackgroundResource(R.drawable.buttons);
                bButton.setBackgroundResource(R.drawable.buttons);
                cButton.setBackgroundResource(R.drawable.buttons);
            }
        });
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (aButton.isChecked() || bButton.isChecked() || cButton.isChecked()) {
                       // markAnswer();
                    } else {
                        Toast.makeText(WorldQuiz.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    nextQuestion();
                }

            }
        });


    }
    private class GetQuestionTask extends AsyncTask<Void, Void, List<Result>> {

        @Override
        protected List<Result> doInBackground(Void... voids) {


            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://opentdb.com").addConverterFactory(GsonConverterFactory.create()).build();
            TriviaService triviaService = retrofit.create(TriviaService.class);
            Call<Trivia> triviasCall = triviaService.getEasyTrivia();
            try {
                Response<Trivia> triviasResponse = triviasCall.execute();
                List<Result> results = triviasResponse.body().getResults();
                return results;
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.d(TAG, "onresponse: loaded Retrofit");
            return null;
        }

        @Override
        protected void onPostExecute(List<Result> results){
            for(Result result : results){
                mResult = result;
                updateUi();
            }
        }
    }
    private void updateUi(){
        if(mResult != null){
            ((TextView) findViewById(R.id.tvWQQuestion)).setText(mResult.getQuestion());
            ((TextView) findViewById(R.id.buttonWQA)).setText(mResult.getIncorrectAnswers().get(0));
            ((TextView) findViewById(R.id.buttonWQB)).setText(mResult.getIncorrectAnswers().get(1));
            ((TextView) findViewById(R.id.buttonWQC)).setText(mResult.getIncorrectAnswers().get(2));
            ((TextView) findViewById(R.id.buttonWQD)).setText(mResult.getCorrectAnswer());
        }
    }

    private void nextQuestion(){
        aButton.setTextColor(defaultColourButton);
        bButton.setTextColor(defaultColourButton);
        cButton.setTextColor(defaultColourButton);
        dButton.setTextColor(defaultColourButton);


        //2.
        questionRg.clearCheck();
        aButton.setBackgroundResource(R.drawable.buttons);
        bButton.setBackgroundResource(R.drawable.buttons);
        cButton.setBackgroundResource(R.drawable.buttons);
        dButton.setBackgroundResource(R.drawable.buttons);
        if(questionCount < 10){
            //questionCounter is the integer
            currentQuestion = questionSet.get(questionCount);
            System.out.println("Current Question: " + currentQuestion);

            //set the textView based on the current question
            ((TextView) findViewById(R.id.tvWQQuestion)).setText(currentQuestion.getQuestion());
            ((TextView) findViewById(R.id.buttonWQA)).setText(currentQuestion.getIncorrectAnswers().get(0));
            ((TextView) findViewById(R.id.buttonWQB)).setText(currentQuestion.getIncorrectAnswers().get(1));
            ((TextView) findViewById(R.id.buttonWQC)).setText(currentQuestion.getIncorrectAnswers().get(2));
            ((TextView) findViewById(R.id.buttonWQD)).setText(currentQuestion.getCorrectAnswer());

            questionCount++;

            answered = false;
            //3.
            countDownTimeLeftMillis = COUNTDOWN_IN_MILLIS;


        } else{

            Intent rsIntent = new Intent(getApplicationContext(), Achievement.class);
            String testContent = getIntent().getStringExtra("LEARNING");
            rsIntent.putExtra("LEARNING", testContent);
            rsIntent.putExtra("EXTRA_SCORE", score);

            setResult(RESULT_OK,rsIntent);
            //finish();
            //finishQuiz();

            startActivity(rsIntent);


        }
    }
}
