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
import com.example.timequest.Entities.NPC;
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

    private int questionCount = 0;
    private int questionCountTotal = 0;
    private int score = 0;
    private Result currentQuestion;
    private List<Result> questionSet;

    ImageView featuredIv, headIv, handIv, bodyIv;
    TextView civilisationTv, featuredNotes;

    private NPC mNPC;

    public static AppDatabase db;
    private List<String> mEra;

    String npcCharacter;
    String iconCharacter;

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



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_featured, container, false);
        //View view = rootView.getView();
        updateUi();

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

            showphotos();

        return view;
    }

    public String shuffleNames(){

        mEra = db.eraDAO().getEraName();
        mEra = db.eraDAO().getEraName();
        Log.d(TAG, "getEraName success:" + db.eraDAO().getEraName().toString());
        //String[] names = new String[]{"spartan", "qing", "athenian","cossack", "roman", "sentinel", "viking", "neanderthal"};
        String[] eraNames = new String[]{"Spartan Army", "Qing Dynasty","Cossack Warriors", "Roman Legionnaire", "North Sentinel Islanders"
                ,"Vikings","Neanderthals","Ancient Athenians","Ancient Egyptians","Normans"};
        List<String> nameList = Arrays.asList(eraNames);
        Collections.shuffle(nameList);
        String name = nameList.get(0);

        //Collections.shuffle(mEra);

        //String name = mEra.get(0);//(String) Array.get(mEra, 0);
        //Log.d(TAG, name);
        //String name = "Spartan Army";

        return name;
        }

        // Too much work on main thread, need Async Task to get the opentrivia api questions.
    private class GetQuestionTask extends AsyncTask<Void, Void, List<Result>> {

        @Override
        protected List<Result> doInBackground(Void... voids) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://opentdb.com")
                    .addConverterFactory(GsonConverterFactory.create()).build();
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
//OnPostExecute, the questions and answers retrieved from the database will be populated into the Ui.
    private void updateUi() {
        View rootview = getView();
        Log.d(TAG, "UPDATE UI: DONE");
        if (mResult != null && rootview != null) {
            questionTV = rootview.findViewById(R.id.tvWQQuestion);

            ((TextView) rootview.findViewById(R.id.tvWQQuestion)).setText(mResult.getQuestion());
            Log.d(TAG, "UPDATE UI: DONE");

            buttonFalse.setBackgroundResource(R.drawable.quiz_buttons);
            buttonTrue.setBackgroundResource(R.drawable.quiz_buttons);
            String answer = mResult.getCorrectAnswer();

            Log.d(TAG, "ANSWER: " + mResult.getCorrectAnswer());


            System.out.print(mResult.getCorrectAnswer());
            buttonTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "TRUE CLICKED");
                    String answer = mResult.getCorrectAnswer();
                    buttonTrue.setBackgroundResource(R.drawable.quiz_buttons_selected);
                    buttonTrue.setClickable(false);
                    buttonFalse.setClickable(false);

                    displaySolution();
                    new GetQuestionTask().execute();
                }

            });
            buttonFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "FALSE CLICKED");
                    String answer = mResult.getCorrectAnswer();
                    buttonFalse.setBackgroundResource(R.drawable.quiz_buttons_selected);
                    buttonTrue.setClickable(false);
                    buttonFalse.setClickable(false);

                    displaySolution();
                    new GetQuestionTask().execute();

                }
            });
        }
    }

    private void nextQuestion() {
        buttonTrue.setBackgroundResource(R.drawable.quiz_buttons);
        buttonFalse.setBackgroundResource(R.drawable.quiz_buttons);
        buttonTrue.setClickable(true);
        buttonFalse.setClickable(true);

        new GetQuestionTask().execute();

    }

    //The changing colours - need to register the users answers, compare with databse. Use if statements.
    private void displaySolution() {
        String answer = mResult.getCorrectAnswer();
        Log.d(TAG, "Gets correct answer string " + answer);

        if(buttonTrue.getText().equals(answer)) {
            buttonTrue.setBackgroundResource(R.drawable.quiz_buttons_correct);
            buttonFalse.setBackgroundResource(R.drawable.quiz_buttons_incorrect);
        }else if(buttonFalse.getText().equals(answer)){
            buttonTrue.setBackgroundResource(R.drawable.quiz_buttons_incorrect);
            buttonFalse.setBackgroundResource(R.drawable.quiz_buttons_correct);
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

//Featured civilisations based on the shuffled names.
      civilisationTv.setText(value);
      featuredNotes.setText(db.eraDAO().getEraNotes(value));

      switch(value){
          case "Spartan Army":
              npcCharacter = "spartan";
              iconCharacter = "spartanwarrior";
              break;
          case "Cossack Warriors":
               npcCharacter = "cossack";
              iconCharacter = "cossackwarrior";
              break;
          case "Qing Dynasty":
               npcCharacter = "qing";
              iconCharacter = "qingeunuch";
              break;
          case "Normans":
               npcCharacter = "norman";
              iconCharacter = "normancrusader";
              break;
          case "Ancient Athenians":
              npcCharacter = "athenian";
              iconCharacter = "athenianman";
              break;
          case "Neanderthals":
              npcCharacter = "neanderthal";
              iconCharacter = "neanderthal";
              break;
          case "Vikings":
              npcCharacter = "viking";
              iconCharacter = "viking";
              break;
          case "North Sentinel Islanders":
              npcCharacter = "sentinel";
              iconCharacter = "northsentinelislander";
              break;
          case "Ancient Egyptians":
              npcCharacter = "egyptian";
              iconCharacter = "ancientegyptian";
              break;
          case "Roman Legionnaire":
              npcCharacter = "roman";
              iconCharacter = "romanlegion";
              break;
      }
        featuredIv.setImageResource(getResources().getIdentifier("npc" + npcCharacter, "drawable", "com.example.timequest"));
//        int headResource = getResources().getIdentifier("iconhead" + value.toLowerCase().replaceAll("\\s",""), "drawable", "com.example.timequest");
//        int bodyResource = getResources().getIdentifier("iconbody" + value.toLowerCase().replaceAll("\\s",""), "drawable", "com.example.timequest");
//        int handResource = getResources().getIdentifier("item" + value.toLowerCase().replaceAll("\\s",""), "drawable", "com.example.timequest");

        headIv.setImageResource(getResources().getIdentifier("iconhead" + npcCharacter, "drawable", "com.example.timequest"));
        bodyIv.setImageResource(getResources().getIdentifier("iconbody" + npcCharacter, "drawable", "com.example.timequest"));
        handIv.setImageResource(getResources().getIdentifier("item" + iconCharacter, "drawable", "com.example.timequest"));
//        bodyIv.setImageResource(bodyResource);
//        headIv.setImageResource(headResource);
//        handIv.setImageResource(handResource);

    }


}




