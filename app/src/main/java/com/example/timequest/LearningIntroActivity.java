package com.example.timequest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timequest.Entities.NPC;
import com.example.timequest.ui.home.HomeFragment;

public class LearningIntroActivity extends AppCompatActivity {

    private NPC mNPC;
    private static final String TAG = "LearningIntroActivity";
    public static final String ARG_ITEM_ID = "LEARNING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_intro);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));


        Intent intent = getIntent();
        //Position is going to equal to the value derived from the recyclerview list (integer)
        int position = intent.getIntExtra(String.valueOf(HomeFragment.EXTRA_MESSAGE), 0);

        Log.d(TAG, "on getIntent success:"  +position);
        Button bContinue = findViewById(R.id.bContinue);
        ImageView npcCharacter = findViewById(R.id.npcCharacter);
        ImageView userCharacter = findViewById(R.id.userCharacter);

        TextView tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
        TextView tvLearningTitle = findViewById(R.id.tvLearningTitle);


        //This grabs the civilisation from RV and retrieves from our NPC class.
        // Change hardcoded "0" to variable position based on recyclerview
        mNPC = NPC.addNPCData().get(position);
        String civilisation = mNPC.getNpcName();
        Integer NPCID = mNPC.getNpcID();


        //Set all objects based on NPC class and RV intent
        tvWelcomeMessage.setText(mNPC.getWelcomeSpeech());
        tvWelcomeMessage.setMovementMethod(new ScrollingMovementMethod()); //scrolling
        tvLearningTitle.setText(mNPC.getNpcName());


        npcCharacter = findViewById(R.id.npcCharacter);

        int npcCharacterResource = getResources().getIdentifier(mNPC.getNpcAvatar(),"drawable", getPackageName());
        npcCharacter.setImageResource(npcCharacterResource);


        //to do: link user character to the other image view




        bContinue.setOnClickListener(v -> {
            launchLearningReadActivity(civilisation);
            Log.d(TAG, "on launch activity success:" + civilisation);

        });

    }

    private void launchLearningReadActivity(String civilisation){
        Intent intent1 = new Intent(this, LearningReadActivity.class);
        intent1.putExtra("LEARNING", civilisation);
        Log.d(TAG, "on putExtra Learning success:"  + civilisation);
        startActivity(intent1);
        Log.d(TAG, "on startRead activity success:"  + intent1);
    }
}