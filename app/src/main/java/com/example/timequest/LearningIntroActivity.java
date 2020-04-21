package com.example.timequest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timequest.Entities.NPC;
import com.example.timequest.ui.home.HomeFragment;

public class LearningIntroActivity extends AppCompatActivity {

    private NPC mNPC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_intro);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        //get Intent from RecyclerView for civilisation


        Intent intent = getIntent();
        //Position is going to equal to the value derived from the recyclerview list
        int position = intent.getIntExtra(HomeFragment.EXTRA_MESSAGE, 0);

        Button bContinue = findViewById(R.id.bContinue);
        ImageView npcCharacter = findViewById(R.id.npcCharacter);
        ImageView userCharacter = findViewById(R.id.userCharacter);

        TextView tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
        TextView tvLearningTitle = findViewById(R.id.tvLearningTitle);


        //This grabs the civilisation from RV and retrieves from our NPC class.
        // Change hardcoded "0" to variable position based on recyclerview
        mNPC = mNPC.addNPCData().get(position);



        //Set all objects based on NPC class and RV intent
        tvWelcomeMessage.setText(mNPC.getWelcomeSpeech());
        tvWelcomeMessage.setMovementMethod(new ScrollingMovementMethod()); //scrolling
        tvLearningTitle.setText(mNPC.getNpcName());


        npcCharacter = findViewById(R.id.npcCharacter);

        int npcCharacterResource = getResources().getIdentifier(mNPC.getNpcAvatar(),"drawable", getPackageName());
        npcCharacter.setImageResource(npcCharacterResource);


        //to do: link user character to the other image view




        bContinue.setOnClickListener(v -> {
            Intent intentRead = new Intent(getApplicationContext(), LearningReadActivity.class);
            intent.putExtra("LEARNING", position); //change from hardcode "Legionary" to variable intent from RecyclerView
            startActivity(intentRead);
        });

    }
}
