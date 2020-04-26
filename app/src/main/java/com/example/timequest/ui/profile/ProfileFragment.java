package com.example.timequest.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
import com.example.timequest.Instructions;
import com.example.timequest.R;
import com.example.timequest.NotesActivity;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class ProfileFragment extends Fragment {

    Button notesButton;
    private Button customiseButton;
    private TextView accuracy;
    private Button tutorialButton;
    private TextView tvProfileName;
    private User mUser;
    private TextView tvIncomplete, tvComplete, tvPerfect, accuracyComment;
    private ImageView userHead, userBody, userHand;
    private static final String TAG = "ProfileFragment";

    public static AppDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        final Button notesButton = root.findViewById(R.id.notesButton);
        accuracy = root.findViewById(R.id.accuracy);
        customiseButton = root.findViewById(R.id.customiseButton);
        tutorialButton = root.findViewById(R.id.tutorialButton);
        tvProfileName = root.findViewById(R.id.tvProfileName);
        accuracyComment = root.findViewById(R.id.accuracyComment);

        db = AppDatabase.getInstance(getContext());


        userHead = root.findViewById(R.id.userHead);
        userBody = root.findViewById(R.id.userBody);
        userHand = root.findViewById(R.id.userHand);

        userHead.setImageResource(getResources().getIdentifier(db.userDAO().getHeadItem(), "drawable", "com.example.timequest"));
        userBody.setImageResource(getResources().getIdentifier(db.userDAO().getBodyItem(), "drawable", "com.example.timequest"));
        userHand.setImageResource(getResources().getIdentifier(db.userDAO().getHandItem(), "drawable", "com.example.timequest"));

        //Retrieve and display user accuracy
        DecimalFormat df = new DecimalFormat("#.##");
        Double accuracyValue = db.userDAO().getAccuracy();
        accuracy.setText(df.format(db.userDAO().getAccuracy()) + " %");
        if (accuracyValue > 67) {
            accuracy.setTextColor(getResources().getColor(R.color.holo_green_light));
            accuracyComment.setText("Wow you're amazing!");
        } else if (accuracyValue < 67 && accuracyValue > 34) {
            accuracy.setTextColor(getResources().getColor(R.color.colorPrimary));
            accuracyComment.setText("Not bad...");
        } else if (accuracyValue < 34) {
            accuracy.setTextColor(getResources().getColor(R.color.colorAltAccentRed));
            accuracyComment.setText("Really??");
        }

        String username = db.userDAO().getUserName();
        tvProfileName.setText(username);

        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotesActivity.class);
                startActivity(intent);
                Log.d(TAG, "on startActivity(): SUCCESS");
            }
        });

        customiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomiseActivity.class);
                startActivity(intent);
                Log.d(TAG, "on start Customise Activity(): SUCCESS");
            }
        });

        tutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Instructions.class);
                startActivity(intent);
                Log.d(TAG, "on start Tutorial: SUCCESS");
            }
        });

        return root;

    }

}