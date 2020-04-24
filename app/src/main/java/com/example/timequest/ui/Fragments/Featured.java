package com.example.timequest.ui.Fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.timequest.AppDatabase;
import com.example.timequest.Entities.Era;
import com.example.timequest.R;
import com.example.timequest.TriviaEntities.Result;
import com.example.timequest.TriviaEntities.Trivia;
import com.example.timequest.TriviaService;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.android.volley.VolleyLog.TAG;


public class Featured extends Fragment {

    public static final String EXTRA_MESSAGE = "LEVEL";

    private TextView tvMsg, tvSelectedMode;

    private Switch difficultySw;
    private Result mResult;
    TextView modeTv, questionTv;
    public static final String ARG_ITEM_ID = "LEARNING";
    private ScrollView scrollView1;

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private long countDownTimeLeftMillis;

    private TextView questionTV, countdownTV, topicTv;
    private RadioButton aButton, bButton, cButton, dButton;
    private Button confirmButton;
    private String mAnswer;

    private Button buttonTrue;
    private Button buttonFalse;

    private ColorStateList defaultColourButton, defaultColourCounter;
    private boolean answered;
    private RadioGroup questionRg;
    private CountDownTimer countDownTimer;
    //private int questionCount, questionCountTotal, score;

    private int questionCount = 0;
    private int questionCountTotal = 0;
    private int score = 0;
    private Result currentQuestion;
    private List<Result> questionSet;

    ImageView featuredIv, headIv, handIv, bodyIv;
    TextView civilisationTv, featuredNotes;


    public static AppDatabase db;
    private List<String> mEra;


    public Featured() {
        // Required empty public constructor
    }


    public static Featured newInstance(String param1, String param2) {
        Featured fragment = new Featured();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GetQuestionTask().execute();

        db = AppDatabase.getInstance(getContext());
        try{
            db.eraDAO().insertEra(new Era("Spartan Army", "banner1", "npcathens","Incomplete","Spartan Notes","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("North Sentinel Islanders", "banner2", "background2","Incomplete", "NSL Notes","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("Roman Legionnaire", "banner3", "background3","Incomplete", "Roman Notes","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("Ancient Athenian", "banner4", "background4","Incomplete", "Athens Notes","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("Normans", "banner5", "background5","Incomplete", "Norman","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("Cossack Warriors", "banner6", "background6","Incomplete", "Cossack Notes","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("Neanderthals", "banner7", "background7","Incomplete", "Neanderthal Notes","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("Qing Dynasty", "banner8", "background8","Incomplete", "Qing Notes","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("Vikings", "banner9", "background9","Incomplete", "Viking Notes","431 - 371 BC"));
            db.eraDAO().insertEra(new Era("Ancient Egyptians", "banner9", "background9","Incomplete", "Egypt Notes","431 - 371 BC"));

        } catch (Exception e){
            System.out.println("!");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_featured, container, false);
        //View view = rootView.getView();
        updateUi();

       // difficultySw = view.findViewById(R.id.switch3);
        buttonTrue = view.findViewById(R.id.buttonTrue);
        buttonFalse = view.findViewById(R.id.buttonFalse);
      //  tvSelectedMode = view.findViewById(R.id.tvSelectedMode);
        questionTV = view.findViewById(R.id.tvWQQuestion);
        buttonFalse.setBackgroundResource(R.drawable.buttons);
        buttonTrue.setBackgroundResource(R.drawable.buttons);
        featuredIv = view.findViewById(R.id.ivNPCFeatured);
        handIv = view.findViewById(R.id.ivHand);
        headIv = view.findViewById(R.id.ivHead);
        bodyIv = view.findViewById(R.id.ivBody);
        civilisationTv = view.findViewById(R.id.tvCivilisation);
        featuredNotes = view.findViewById(R.id.featuredNotes);
/**
 difficultySw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
@Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
if (isChecked) {
//Talk to json file to get difficulty
String level = "difficult";
tvSelectedMode.setText(level);

} else {
//Talk to json file to get easy
String level = "easy";
tvSelectedMode.setText(level);
}
}
});**/
            showphotos();

        return view;
    }

    public String shuffleNames(){

        mEra = db.eraDAO().getEraName();

        //String[] names = new String[]{"spartan", "qing", "athenian","cossack", "roman", "sentinel", "viking", "neanderthal"};

        Collections.shuffle(mEra);

        String name = mEra.get(0);//(String) Array.get(mEra, 0);
        Log.d(TAG, name);
        return name;
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
                return null;

            }

        }

        @Override
        protected void onPostExecute(List<Result> results) {
            for (Result result : results) {
                mResult = result;
                updateUi();
            }
        }
    }

    private void updateUi() {
        View rootview = getView();
        Log.d(TAG, "UPDATE UI: DONE");
        if (mResult != null && rootview != null) {
            questionTV = rootview.findViewById(R.id.tvWQQuestion);

            ((TextView) rootview.findViewById(R.id.tvWQQuestion)).setText(mResult.getQuestion());
            Log.d(TAG, "UPDATE UI: DONE");

            buttonFalse.setBackgroundResource(R.drawable.buttons);
            buttonTrue.setBackgroundResource(R.drawable.buttons);
            String answer = mResult.getCorrectAnswer();

            Log.d(TAG, "ANSWER: " + mResult.getCorrectAnswer());


            System.out.print(mResult.getCorrectAnswer());
            buttonTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "TRUE CLICKED");
                    String answer = mResult.getCorrectAnswer();
                    buttonTrue.setBackgroundResource(R.drawable.buttons);
                    buttonTrue.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    buttonFalse.setBackgroundResource(R.drawable.buttons);

                    displaySolution();
                    new GetQuestionTask().execute();
                }

            });
            buttonFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "FALSE CLICKED");
                    String answer = mResult.getCorrectAnswer();
                    buttonFalse.setBackgroundResource(R.drawable.buttons);
                    buttonFalse.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    buttonFalse.setBackgroundResource(R.drawable.buttons);

                    displaySolution();
                    new GetQuestionTask().execute();

                }
            });
        }
    }

    private void nextQuestion() {
        buttonTrue.setBackgroundColor(R.drawable.quiz_button);
        buttonFalse.setBackgroundColor(R.drawable.quiz_button);

        new GetQuestionTask().execute();

    }

    private void displaySolution() {
        String answer = mResult.getCorrectAnswer();
        Log.d(TAG, "Gets correct answer string " + answer);

        if(buttonTrue.getText().equals(answer)) {
            buttonTrue.setBackgroundColor(Color.GREEN);
            buttonFalse.setBackgroundColor(Color.RED);
        }else if(buttonFalse.getText().equals(answer)){
            buttonTrue.setBackgroundColor(Color.RED);
            buttonFalse.setBackgroundColor(Color.GREEN);
        }
    }

    private void showphotos(){
        String value = shuffleNames();
      /*  int res1 = getResources().getIdentifier("head" + value, "drawable", "com.example.timequest");
        Log.d(TAG, value);
        int res2 = getResources().getIdentifier("body" + value, "drawable", "com.example.timequest");
        Log.d(TAG, "body" +value);

        int res3 = getResources().getIdentifier("item" + value, "drawable", "com.example.timequest");
        Log.d(TAG, "item" +value);
        int res4 = getResources().getIdentifier("npc" + value, "drawable", "com.example.timequest");


        headIv.setImageResource(res1);
        bodyIv.setImageResource(res2);
        handIv.setImageResource(res3);
        featuredIv.setImageResource(res4);*/


      civilisationTv.setText(value);
      featuredNotes.setText(db.eraDAO().getEraNotes(value));



       /* if(value.equals("roman")){
            civilisationTv.setText("Roman");
        } else if(value.equals("qing")){
            civilisationTv.setText("Qing Dynasty");
        }else if(value.equals("cossack")){
            civilisationTv.setText("Cossack Warriors");
        }else if(value.equals("neanderthal")){
            civilisationTv.setText("Neanderthals");
        }else if(value.equals("spartan")){
            civilisationTv.setText("Spartan Warriors");
        }else if(value.equals("viking")){
            civilisationTv.setText("Viking");
        }*/

    }


}




