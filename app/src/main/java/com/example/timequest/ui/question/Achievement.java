package com.example.timequest.ui.question;

import android.content.Intent;
import android.os.Bundle;

import com.example.timequest.AppDatabase;
import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.HandItems;
import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.NPC;
import com.example.timequest.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timequest.R;

import java.util.ArrayList;

public class Achievement extends AppCompatActivity {

    public static final String ARG_ITEM_ID = "EXTRA_SCORE";
    public static final String ARG_NPC_ID = "LEARNING";
    private static final String TAG = "Message";

    private ImageView userHead, userBody, userHand;
    private View constraintComplete;
    private View constraintPerfectComplete;
    private TextView outcomeTv;
    private Button homeB;
    private ImageView npcCharacter;
    private ImageView prizeIv, prizeIv2, prizeIv3;
    //private static final Random RANDOM = new Random();
    private NPC mNPC;
    private ArrayList<NPC> npcs = new ArrayList<>();

    public static AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        db = AppDatabase.getInstance(getApplicationContext());

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
        String NPCAvatar = mNPC.getNpcAvatar();

        Integer score = getIntent().getIntExtra("EXTRA_SCORE",0);
        System.out.println("Score intent from quiz is: " + score);
        //Integer scoreValue = Integer.valueOf(score);
        outcomeTv = findViewById(R.id.tvOutcome);
        homeB = findViewById(R.id.bHome);
        constraintComplete = findViewById(R.id.constraintComplete);
        constraintPerfectComplete = findViewById(R.id.constraintCompletePerfect);

        prizeIv = findViewById(R.id.ivPrize);
        prizeIv2 = findViewById(R.id.ivPrize2);
        prizeIv3 = findViewById(R.id.ivPrize3);

        prizeIv.setVisibility(View.VISIBLE);
        prizeIv2.setVisibility(View.INVISIBLE);
        prizeIv3.setVisibility(View.INVISIBLE);
        constraintPerfectComplete.setVisibility(View.INVISIBLE);

        int npcCharacterid = getResources().getIdentifier(NPCAvatar,"drawable","com.example.timequest");

        npcCharacter = findViewById(R.id.npcCharacter);
        npcCharacter.setImageResource(npcCharacterid);

        userHead = findViewById(R.id.userHead);
        userBody = findViewById(R.id.userBody);
        userHand = findViewById(R.id.userHand);

        userHead.setImageResource(getResources().getIdentifier(db.userDAO().getHeadItem(),"drawable", "com.example.timequest"));
        userBody.setImageResource(getResources().getIdentifier(db.userDAO().getBodyItem(),"drawable","com.example.timequest"));
        userHand.setImageResource(getResources().getIdentifier(db.userDAO().getHandItem(),"drawable", "com.example.timequest"));




        int value1 = 1;

        int prize;
        String itemID;
        String prizeID = " ";

        db.userDAO().updateAnswered(10);
        db.userDAO().updateCorrect(score);
        db.userDAO().changeAccuracy();
        //Determine if user gets prize or fails
        if(score > 7 && score < 10) {
            //outcomeTv.setText("Congratulations Adventurer!\n You passed the test. Here is something for your troubles.");
            //outcomeTv.setText(mNPC.addNPCData().get(5).getEndingSpeech()); //change "5" to be the variable NPC civilisation
            outcomeTv.setText(mNPC.getEndingSpeech());


            Log.d(TAG, "on setText(): SUCCESS");
            System.out.println(mNPC.getNpcName());
            switch(mNPC.getNpcName().toString()){
                case "Spartan Warrior":
                    itemID = "bodyspartanwarrior";
                    prizeID = "iconbodyspartan";
                    db.bodyItemsDAO().insertBodyItem(new BodyItems(itemID));
                    break;
                case "North Sentinel Islander":
                    itemID = "headnorthsentinelislander";
                    prizeID = "iconheadsentinel";
                    db.headItemsDAO().insertHeadItem(new HeadItems(itemID));
                    break;
                case "Roman Legion":
                    itemID = "itemromanlegion";
                    prizeID = "itemromanlegion";
                    db.handItemsDAO().insertHandItem(new HandItems(itemID));
                    break;
                case "Athenian Man":
                    itemID = "bodyathenianman";
                    prizeID = "iconbodyathenian";
                    db.bodyItemsDAO().insertBodyItem(new BodyItems(itemID));
                    break;
                case "Norman Crusader":
                    itemID = "headnormancrusader";
                    prizeID = "iconheadnorman";
                    db.headItemsDAO().insertHeadItem(new HeadItems(itemID));
                    break;
                case "Cossack Warrior":
                    itemID = "itemcossackwarrior";
                    prizeID = "itemcossackwarrior";
                    db.handItemsDAO().insertHandItem(new HandItems(itemID));
                    break;
                case "Neanderthal":
                    itemID = "itemneanderthal";
                    prizeID = "itemneanderthal";
                    db.handItemsDAO().insertHandItem(new HandItems(itemID));
                    break;
                case "Qing Eunuch":
                    itemID = "bodyqingeunuch";
                    prizeID = "iconbodyqing";
                    db.bodyItemsDAO().insertBodyItem(new BodyItems(itemID));
                    break;
                case "Viking":
                    itemID = "headviking";
                    prizeID = "iconheadviking";
                    db.headItemsDAO().insertHeadItem(new HeadItems(itemID));
                    break;
                case "Egyptian Man":
                    itemID = "itemancientegyptian";
                    prizeID = "itemancientegyptian";
                    db.handItemsDAO().insertHandItem(new HandItems(itemID));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + mNPC.getNpcName().toString());
            }

            prize = getResources().getIdentifier(prizeID, "drawable", "com.example.timequest");
            prizeIv.setImageResource(prize);
            db.eraDAO().updateToCompleted();
            //to do: immediately add item to user's collection in database
        } else if(score == 10){

            outcomeTv.setText(mNPC.getPerfectSpeech());

            int prize2, prize3;
            String prize2ID;
            String prize3ID;
            String itemHead, itemBody, itemHand;

            switch(mNPC.getNpcName().toString()){
                case "Spartan Warrior":
                    itemBody = "bodyspartanwarrior";
                    itemHead = "headspartanwarrior";
                    itemHand = "itemspartanwarrior";
                    prizeID = "iconbodyspartan";
                    prize2ID = "iconheadspartan";
                    prize3ID = "itemspartanwarrior";
                    break;
                case "North Sentinel Islander":
                    itemBody = "bodynorthsentinelislander";
                    itemHead = "headnorthsentinelislander";
                    itemHand = "itemnorthsentinelislander";
                    prizeID = "iconheadsentinel";
                    prize2ID = "iconbodysentinel";
                    prize3ID = "itemnorthsentinelislander";
                    break;
                case "Roman Legion":
                    itemBody = "bodyromanlegion";
                    itemHead = "headromanlegion";
                    itemHand = "itemromanlegion";
                    prizeID = "itemromanlegion";
                    prize2ID = "iconheadroman";
                    prize3ID = "iconbodyroman";

                    break;
                case "Athenian Man":
                    itemBody = "bodyathenianman";
                    itemHead = "headathenianman";
                    itemHand = "itemathenianman";
                    prizeID = "iconbodyathenian";
                    prize2ID = "iconheadathenian";
                    prize3ID = "itemathenianman";
                    break;
                case "Norman Crusader":
                    itemBody = "bodynormancrusader";
                    itemHead = "headnormancrusader";
                    itemHand = "itemnormancrusader";
                    prizeID = "iconheadnorman";
                    prize2ID = "iconbodyheadnorman";
                    prize3ID = "itemnormancrusader";

                    break;
                case "Cossack Warrior":
                    itemBody = "bodyncossackwarrior";
                    itemHead = "headncossackwarrior";
                    itemHand = "itemcossackwarrior";
                    prizeID = "itemcossackwarrior";
                    prize2ID = "iconbodycossack";
                    prize3ID = "iconheadcossack";
                    break;
                case "Neanderthal":
                    itemBody = "bodynneanderthal";
                    itemHead = "headneanderthal";
                    itemHand = "itemneanderthal";
                    prizeID = "itemneanderthal";
                    prize2ID = "iconbodyneanderthal";
                    prize3ID = "iconheadneanderthal";

                    break;
                case "Qing Eunuch":
                    itemBody = "bodyqingeunuch";
                    itemHead = "headqingeunuch";
                    itemHand = "itemnqingeunuch";
                    prizeID = "itemnqingeunuch";
                    prize2ID = "iconbodyqing";
                    prize3ID = "iconheadqing";

                    break;
                case "Viking":
                    itemBody = "bodyviking";
                    itemHead = "headviking";
                    itemHand = "itemviking";
                    prizeID = "iconheadviking";
                    prize2ID = "iconbodyviking";
                    prize3ID = "itemviking";

                    break;
                case "Egyptian Man":
                    itemBody = "bodyancientegyptian";
                    itemHead = "headancientegyptian";
                    itemHand = "itemancientegyptian";
                    prizeID = "itemancientegyptian";
                    prize2ID = "bodyancientegyptian";
                    prize3ID = "headancientegyptian";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + mNPC.getNpcName().toString());
            }

            db.handItemsDAO().insertHandItem(new HandItems(itemHand));
            db.headItemsDAO().insertHeadItem(new HeadItems(itemHead));
            db.bodyItemsDAO().insertBodyItem(new BodyItems(itemBody));

            db.eraDAO().updateToPerfect();

            prize = getResources().getIdentifier(prizeID, "drawable", "com.example.timequest");
            prize2 = getResources().getIdentifier(prize2ID, "drawable", "com.example.timequest");
            prize3 = getResources().getIdentifier(prize3ID, "drawable", "com.example.timequest");
            prizeIv.setImageResource(prize);
            prizeIv2.setVisibility(View.VISIBLE);
            prizeIv3.setVisibility(View.VISIBLE);
            constraintComplete.setVisibility(View.INVISIBLE);
            constraintPerfectComplete.setVisibility(View.VISIBLE);

            prizeIv.setImageResource(prize);
            prizeIv2.setImageResource(prize2);
            prizeIv3.setImageResource(prize3);
        } else{
            //outcomeTv.setText("Oh no. You did not pass the quiz. Revise the content and try again to win a prize!");
            prizeIv.setVisibility(View.INVISIBLE);
            outcomeTv.setText(mNPC.getFailSpeech());
        }

        homeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Achievement.this, MainActivity.class));
                finish();

            }
        });

    }



}

