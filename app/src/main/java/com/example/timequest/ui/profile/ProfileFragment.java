package com.example.timequest.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.timequest.AppDatabase;
import com.example.timequest.CustomiseActivity;
import com.example.timequest.Entities.User;
import com.example.timequest.R;
import com.example.timequest.NotesActivity;

import org.w3c.dom.Text;

public class ProfileFragment extends Fragment {

    Button notesButton;
    Button customiseButton;
    TextView accuracy;


    public static AppDatabase db;

    private ProfileViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {




        notificationsViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        final TextView textView = root.findViewById(R.id.tvProfileName);
        final Button notesButton = root.findViewById(R.id.notesButton);
         accuracy = root.findViewById(R.id.accuracy);
        customiseButton = root.findViewById(R.id.customiseButton);


        db = AppDatabase.getInstance(getContext());
        accuracy.setText(db.userDAO().getAccuracy()+"%");
//        //to do: get questions correct from DB, get questions total from DB
//        Double accuracy = (questionsCorrect/questionsTotal)*100;
//        Integer questionsCorrect = db.userDAO().changeAccuracy(accuracy);

        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotesActivity.class);
                startActivity(intent);
            }
        });

        customiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomiseActivity.class);
                startActivity(intent);
            }
        });

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;





    }

}