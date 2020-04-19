package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.timequest.Entities.User;

public class CustomiseActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivCharacter;
    private ImageView ivHead;
    private ImageView ivBody;
    private ImageView ivHand;
    private ImageView userHead;
    private ImageView userBody;
    private ImageView userHand;
    private Button headNextButton;
    private Button headBackButton;
    private Button bodyNextButton;
    private Button bodyBackButton;
    private Button handNextButton;
    private Button handBackButton;

    private Button saveButton;




    public static AppDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customise);

        mdb = AppDatabase.getInstance(getApplicationContext());
        try{
            mdb.userDAO().insertUser(new User(1,"s", 1, 1, "china", "china", "china"));
        } catch (Exception e){
            System.out.println("!");
        }


        ivCharacter = findViewById(R.id.ivCharacter);
        ivHead = findViewById(R.id.ivHead);
        ivBody = findViewById(R.id.ivBody);
        ivHand = findViewById(R.id.ivHand);

        userHead = findViewById(R.id.userHead);
        userBody = findViewById(R.id.userBody);
        userHand = findViewById(R.id.userHand);

        userHead.setImageResource(getResources().getIdentifier(mdb.userDAO().getHeadItem(),"drawable", getPackageName()));
        userBody.setImageResource(getResources().getIdentifier(mdb.userDAO().getBodyItem(),"drawable", getPackageName()));
        userHand.setImageResource(getResources().getIdentifier(mdb.userDAO().getHandItem(),"drawable", getPackageName()));
        ivHead.setImageResource(getResources().getIdentifier(mdb.userDAO().getHeadItem(),"drawable", getPackageName()));
        ivBody.setImageResource(getResources().getIdentifier(mdb.userDAO().getBodyItem(),"drawable", getPackageName()));
        ivHand.setImageResource(getResources().getIdentifier(mdb.userDAO().getHandItem(),"drawable", getPackageName()));



        headNextButton = findViewById(R.id.headNextButton);
        headNextButton.setOnClickListener(this);
        headBackButton = findViewById(R.id.headBackButton);
        headBackButton.setOnClickListener(this);
        bodyNextButton = findViewById(R.id.bodyNextButton);
        bodyNextButton.setOnClickListener(this);
        bodyBackButton = findViewById(R.id.bodyBackButton);
        bodyBackButton.setOnClickListener(this);
        handNextButton = findViewById(R.id.handNextButton);
        handNextButton.setOnClickListener(this);
        handBackButton = findViewById(R.id.handBackButton);
        handBackButton.setOnClickListener(this);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast toast = Toast.makeText(getApplicationContext(), "Items equipped.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



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
                userHead.setImageResource(headid);
                mdb.userDAO().changeHeadItem(String.valueOf(headid));
                break;

            case R.id.headBackButton:

                if(headCounter > 1) {
                    headCounter--;
                }else if(headCounter == 1) {
                    headCounter= 6;
        }
                ivHead.setImageResource(headid);
                userHead.setImageResource(headid);
                mdb.userDAO().changeHeadItem(String.valueOf(headid));
                break;

            case R.id.bodyNextButton:
                if(bodyCounter < 6) {
                    bodyCounter++;
                }else if
                (bodyCounter == 6){
                    bodyCounter = 1;
                }
                ivBody.setImageResource(bodyid);
                userBody.setImageResource(bodyid);
                mdb.userDAO().changeBodyItem(String.valueOf(bodyid));
                break;

            case R.id.bodyBackButton:
                if(bodyCounter > 1) {
                    bodyCounter--;
                }else if(bodyCounter == 1) {
                    bodyCounter= 6;
                }
                ivBody.setImageResource(bodyid);
                userBody.setImageResource(bodyid);
                mdb.userDAO().changeBodyItem(String.valueOf(bodyid));
                break;

            case R.id.handNextButton:
                if(itemCounter < 6) {
                    itemCounter++;
                }else if
                (itemCounter == 6){
                    itemCounter = 1;
                }
                ivHand.setImageResource(itemid);
                userHand.setImageResource(itemid);
                mdb.userDAO().changeHandItem(String.valueOf(itemid));
                break;

            case R.id.handBackButton:
                if(itemCounter > 1) {
                    itemCounter--;
                }else if(itemCounter == 1) {
                    itemCounter= 6;
                }
                ivHand.setImageResource(itemid);
                userHand.setImageResource(itemid);
                mdb.userDAO().changeHandItem(String.valueOf(itemid));
                break;

            default:
                break;
        }

    }
}
