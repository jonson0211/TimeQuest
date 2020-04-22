package com.example.timequest.ui.question;

import android.content.Intent;
import android.os.Bundle;

import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.HandItems;
import com.example.timequest.Entities.HeadItems;
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

        Integer NPCID = getIntent().getIntExtra("LEARNING",0);
        System.out.println("*"+ NPCID);
        Log.d(TAG, "on getIntent(): SUCCESS");

        //Match civilisation from intent to specific NPC array from NPC to get image and item data
        for (int i = 0; i < 8; i++){

            if (NPC.addNPCData().get(i).getNpcID()==(NPCID)){
                mNPC = NPC.addNPCData().get(i);
                System.out.println(mNPC);
                Log.d(TAG, "on match NPC: SUCCESS");
                break;
            }
        }

        String civilisation = mNPC.getNpcName();

        Integer score = getIntent().getIntExtra("EXTRA_SCORE",0);
        System.out.println(score);
        //Integer scoreValue = Integer.valueOf(score);
        outcomeTv = findViewById(R.id.tvOutcome);
        homeB = findViewById(R.id.bHome);
        prizeIv = findViewById(R.id.ivPrize);

        int npcCharacterid = getResources().getIdentifier("npc" + civilisation.toLowerCase(),"drawable","com.example.timequest");

        npcCharacter = findViewById(R.id.npcCharacter);
        npcCharacter.setImageResource(npcCharacterid);


        homeB.setOnClickListener(v -> startActivity(new Intent(Achievement.this, MainActivity.class)));
        int value1 = 1;


        //Determine if user gets prize or fails
        if(score > 7) {
            //outcomeTv.setText("Congratulations Adventurer!\n You passed the test. Here is something for your troubles.");
            //outcomeTv.setText(mNPC.addNPCData().get(5).getEndingSpeech()); //change "5" to be the variable NPC civilisation
            outcomeTv.setText(mNPC.getEndingSpeech());
            Log.d(TAG, "on setText(): SUCCESS");
                    switch(mNPC.getNpcName()){
                        case "Spartan":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                        case "North Sentinel Islander":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                        case "Roman Legion":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                        case "Athenian Man":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                        case "Norman Crusader":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                        case "Cossack Warrior":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                        case "Neanderthal":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                        case "Qing Eunuch":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                        case "Viking":
                            MainActivity.db.headItemsDAO().insertHeadItem(new HeadItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.bodyItemsDAO().insertBodyItem(new BodyItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));
                            MainActivity.db.handItemsDAO().insertHandItem(new HandItems(mNPC.getNpcName().replaceAll("\\s+","")+"item"));

                    }

                    if(score > 7 && score < 10){
                        MainActivity.db.eraDAO().updateToCompleted();
                    } else if(score == 10){
                        MainActivity.db.eraDAO().updateToPerfect();
                    }

            int prize = getResources().getIdentifier(mNPC.getNpcName().replaceAll("\\s+","")+"item", "drawable", "com.example.timequest");
            Log.d(TAG, "on getResourceID(): SUCCESS");
            prizeIv.setImageResource(prize);
            //to do: immediately add item to user's collection in database
        }
        else{
            //outcomeTv.setText("Oh no. You did not pass the quiz. Revise the content and try again to win a prize!");
            outcomeTv.setText(mNPC.getFailSpeech());
        }

    }

}

