package com.example.timequest.ui.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.timequest.R;
import com.example.timequest.TriviaEntities.WorldQuiz;


public class Featured extends Fragment {

    public static final String EXTRA_MESSAGE = "LEVEL";

    private TextView tvMsg;
    private Button continueB;
    private Switch difficultySw;



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
        tvMsg = view.findViewById(R.id.msgTv);
        difficultySw = view.findViewById(R.id.switch3);
        continueB = view.findViewById(R.id.msgTv);


        difficultySw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Talk to json file to get difficulty
                    int level = 1;

                    continueB.setOnClickListener(v -> {
                        Intent intent = new Intent(getActivity(), WorldQuiz.class);
                        intent.putExtra(EXTRA_MESSAGE, level);
                        startActivity(intent);
                    });
                }else{
                    //Talk to json file to get easy
                    int level = 0;
                    continueB.setOnClickListener(v -> {
                        Intent intent = new Intent(getActivity(), WorldQuiz.class);
                        intent.putExtra(EXTRA_MESSAGE, level);
                        startActivity(intent);
                    });
                }
            }
        });




        return view;
    }

}
