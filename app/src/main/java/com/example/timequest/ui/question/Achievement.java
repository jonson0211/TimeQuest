package com.example.timequest.ui.question;

import android.content.Intent;
import android.os.Bundle;

import com.example.timequest.Entities.NPC;
import com.example.timequest.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timequest.R;

import java.util.ArrayList;

public class Achievement extends AppCompatActivity {

    public static final String ARG_ITEM_ID = "EXTRA_SCORE";
    public static final String ARG_NPC_ID = "LEARNING";
    private static final String TAG = "Message";


    private TextView outcomeTv;
    private Button homeB;
    private ImageView npcCharacter;
    private ImageView prizeIv;
    //private static final Random RANDOM = new Random();
    private NPC mNPC;
    private ArrayList<NPC> npcs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        String civilisation = getIntent().getStringExtra("LEARNING");
        System.out.println(civilisation);
        Log.d(TAG, "on getIntent(): SUCCESS");

        /**
        for(NPC npc : npcs){
            if(npc.getNpcName().equals(civilisation)){
                mNPC = npc;
                System.out.println(mNPC);
            }}**/
        //mNPC.getEndingSpeech();
        //return mNPC

        Integer score = getIntent().getIntExtra("EXTRA_SCORE",0);
        System.out.println(score);
        //Integer scoreValue = Integer.valueOf(score);
        outcomeTv = findViewById(R.id.tvOutcome);
        homeB = findViewById(R.id.bHome);
        prizeIv = findViewById(R.id.ivPrize);

        //civilisation.toLowerCase()
        int npcCharacterid = getResources().getIdentifier("npc" + civilisation.toLowerCase(),"drawable","com.example.timequest");

        npcCharacter = findViewById(R.id.npcCharacter);
        npcCharacter.setImageResource(npcCharacterid);


        homeB.setOnClickListener(v -> startActivity(new Intent(Achievement.this, MainActivity.class)));
        int value1 = 1;

        /** can use if else statements to manually assign the integer in get(0).getEnding speech
        int npcValue = 0;

            if (civilisation.equals("Spartan")) {
            }else if {civilisation.equals()
        }       ;


        {
        }
         **/;
        //for (Integer i = 1; i < npcs.size(); i++){
        for (int i = 0; i < 8; i++){

            if (NPC.addNPCData().get(i).getNpcName().equals(civilisation)){
                mNPC = NPC.addNPCData().get(i);
                System.out.println(mNPC);
                Log.d(TAG, "on match NPC: SUCCESS");
                break;
            }

        }


        if(score > 7) {
            outcomeTv.setText("Congratulations Adventurer!\n You passed the test. Here is something for your troubles.");
            //outcomeTv.setText(mNPC.addNPCData().get(5).getEndingSpeech()); //change "5" to be the variable NPC civilisation
            outcomeTv.setText(mNPC.getEndingSpeech());
            Log.d(TAG, "on setText(): SUCCESS");

            //outcomeTv.setText(mNPC.getEndingSpeech()); //doesn't work, use the above if can't figure out^
            //Log.d(TAG, "on setText(): SUCCESS");

            int prize = getResources().getIdentifier("item"+ value1, "drawable", "com.example.timequest");
            Log.d(TAG, "on getResourceID(): SUCCESS");
            prizeIv.setImageResource(prize);
            //to do: immediately add item to user's collection in database

        } else{
            outcomeTv.setText("Oh no. You did not pass the quiz. Revise the content and try again to win a prize!");

        }

    }

}

