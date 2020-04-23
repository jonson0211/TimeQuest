package com.example.timequest.ui.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.timequest.R;
import com.example.timequest.TriviaEntities.Result;
import com.example.timequest.TriviaEntities.Trivia;
import com.example.timequest.TriviaEntities.WorldQuiz;
import com.example.timequest.TriviaService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.android.volley.VolleyLog.TAG;


public class Featured extends Fragment {

    public static final String EXTRA_MESSAGE = "LEVEL";

    private TextView tvMsg, tvSelectedMode;
    private Button startB;
    private Switch difficultySw;
    private Result mResult;


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
        if (getArguments() != null) {        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_featured, container, false);
        difficultySw = view.findViewById(R.id.switch3);
        startB = view.findViewById(R.id.bStart);
        tvSelectedMode = view.findViewById(R.id.tvSelectedMode);

        difficultySw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Talk to json file to get difficulty
                    String level = "difficult";
                    tvSelectedMode.setText(level);

                }else{
                    //Talk to json file to get easy
                    String level = "easy";
                    tvSelectedMode.setText(level);
                }
            }
        });

        startB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WorldQuiz.class);
                intent.putExtra("LEVEL", tvSelectedMode.getText().toString());
                startActivity(intent);
            }
        });

        return view;
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

            Log.d(EXTRA_MESSAGE, "onresponse: loaded Retrofit");
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


}
