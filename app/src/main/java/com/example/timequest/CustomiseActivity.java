package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CustomiseActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivCharacter;
    private ImageView ivHead;
    private ImageView ivItem1;
    private ImageView ivItem2;

    private Button headNextButton;
    private Button headBackButton;
    private Button item1NextButton;
    private Button item1BackButton;
    private Button item2NextButton;
    private Button item2BackButton;

    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customise);

        ivCharacter = findViewById(R.id.ivCharacter);
        ivHead = findViewById(R.id.ivHead);
        ivItem1 = findViewById(R.id.ivItem1);
        ivItem2 = findViewById(R.id.ivItem2);

        headNextButton = findViewById(R.id.headNextButton);
        headNextButton.setOnClickListener(this);
        headBackButton = findViewById(R.id.headBackButton);
        headBackButton.setOnClickListener(this);
        item1NextButton = findViewById(R.id.item1NextButton);
        item1NextButton.setOnClickListener(this);
        item1BackButton = findViewById(R.id.item1BackButton);
        item1BackButton.setOnClickListener(this);
        item2NextButton = findViewById(R.id.item2NextButton);
        item2NextButton.setOnClickListener(this);
        item2BackButton = findViewById(R.id.item2BackButton);
        item2BackButton.setOnClickListener(this);

        saveButton = findViewById(R.id.saveButton);

        ivCharacter.setImageResource(R.drawable.npcviking);

    }


    //grab current outfit from database (replace the manual counter starting from =1)
    int headCounter = 1;
    int bodyCounter = 1;
    int itemCounter = 1;

    @Override
    public void onClick(View v) {

        int headid = getResources().getIdentifier("head" + headCounter,"drawable", getPackageName());
        int bodyid = getResources().getIdentifier("body" + bodyCounter,"drawable", getPackageName());
        int itemid = getResources().getIdentifier("item" + itemCounter,"drawable", getPackageName());

        switch (v.getId()) {

            case R.id.headNextButton:

                if(headCounter < 6) {
                    headCounter++;
                }else if
               (headCounter == 6){
                    headCounter = 1;
            }
                ivHead.setImageResource(headid);
                break;

            case R.id.headBackButton:

                if(headCounter > 1) {
                    headCounter--;
                }else if(headCounter == 1) {
                    headCounter= 6;
        }
                ivHead.setImageResource(headid);
                break;

            case R.id.item1NextButton:
                if(bodyCounter < 6) {
                    bodyCounter++;
                }else if
                (bodyCounter == 6){
                    bodyCounter = 1;
                }
                ivItem1.setImageResource(bodyid);
                break;

            case R.id.item1BackButton:
                if(bodyCounter > 1) {
                    bodyCounter--;
                }else if(bodyCounter == 1) {
                    bodyCounter= 6;
                }
                ivItem1.setImageResource(bodyid);
                break;

            case R.id.item2NextButton:
                if(itemCounter < 6) {
                    itemCounter++;
                }else if
                (itemCounter == 6){
                    itemCounter = 1;
                }
                ivItem2.setImageResource(itemid);
                break;

            case R.id.item2BackButton:
                if(itemCounter > 1) {
                    itemCounter--;
                }else if(itemCounter == 1) {
                    itemCounter= 6;
                }
                ivItem2.setImageResource(itemid);
                break;

            default:
                break;
        }

    }
}
