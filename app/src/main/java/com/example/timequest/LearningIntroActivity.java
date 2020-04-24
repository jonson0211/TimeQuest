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

import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.NPC;
import com.example.timequest.Entities.User;
import com.example.timequest.ui.home.HomeFragment;

public class LearningIntroActivity extends AppCompatActivity {

    private NPC mNPC;
    private Era mERA;
    private static final String TAG = "LearningIntroActivity";
    public static final String ARG_ITEM_ID = "LEARNING";

    public static AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_intro);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        db = AppDatabase.getInstance(getApplicationContext());

        try {
            //sample test data
            db.userDAO().insertUser(new User(1, "s", 1, 1, "headdefault", "itemdefault", "bodydefault",1,1));
            db.headItemsDAO().insertHeadItem(new HeadItems("headdefault"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        //Position is going to equal to the value derived from the recyclerview list (integer)
        int position = intent.getIntExtra(String.valueOf(HomeFragment.EXTRA_MESSAGE), 0);

        Log.d(TAG, "on getIntent success:"  +position);
        Button bContinue = findViewById(R.id.bContinue);
        ImageView npcCharacter = findViewById(R.id.npcCharacter);
        ImageView userHead = findViewById(R.id.userHead);
        ImageView userBody = findViewById(R.id.userBody);
        ImageView userHand = findViewById(R.id.userHand);

        TextView tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
        TextView tvYear = findViewById(R.id.tvYear);
        TextView tvLearningTitle = findViewById(R.id.tvLearningTitle);

        userHead.setImageResource(getResources().getIdentifier(db.userDAO().getHeadItem(),"drawable", "com.example.timequest"));
        userBody.setImageResource(getResources().getIdentifier(db.userDAO().getBodyItem(),"drawable","com.example.timequest"));
        userHand.setImageResource(getResources().getIdentifier(db.userDAO().getHandItem(),"drawable", "com.example.timequest"));


        //This grabs the civilisation from RV and retrieves from our NPC class.
        // Change hardcoded "0" to variable position based on recyclerview
        mERA = Era.addEraData().get(position);
        mNPC = NPC.addNPCData().get(position);
        String civilisation = mNPC.getNpcName();
        Integer NPCID = mNPC.getNpcID();
        String eraName = mERA.getEraName();
        String eraYear = mERA.getEraYear();


        //Set all objects based on NPC class and RV intent
        tvWelcomeMessage.setText(mNPC.getWelcomeSpeech());
        tvWelcomeMessage.setMovementMethod(new ScrollingMovementMethod()); //scrolling
        tvLearningTitle.setText(mERA.getEraName());
        tvYear.setText(mERA.getEraYear());


        npcCharacter = findViewById(R.id.npcCharacter);

        int npcCharacterResource = getResources().getIdentifier(mNPC.getNpcAvatar(),"drawable", getPackageName());
        npcCharacter.setImageResource(npcCharacterResource);


        //to do: link user character to the other image view

        bContinue.setOnClickListener(v -> {
            launchLearningReadActivity(NPCID, eraName);
            Log.d(TAG, "on launch activity success:" + NPCID);

        });

    }

    private void launchLearningReadActivity(Integer NPCID, String eraName){
        Intent intent1 = new Intent(this, LearningReadActivity.class);
        intent1.putExtra("LEARNING", NPCID);

        Intent intent2 = new Intent(this, LearningReadActivity.class);
        intent1.putExtra("ERA", eraName);

        Log.d(TAG, "on putExtra Learning success:"  + NPCID);
        startActivity(intent1);
        Log.d(TAG, "on startRead activity success:"  + intent1);



    }
}