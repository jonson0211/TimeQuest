package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.HandItems;
import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.User;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> headItems;
    public List<String> bodyItems;
    public List<String> handItems;


    int headCounter = 0;
    int bodyCounter = 0;
    int handCounter = 0;
    List<Integer> headIDList = new ArrayList<Integer>();
    List<Integer> bodyIDList = new ArrayList<Integer>();
    List<Integer> handIDList = new ArrayList<Integer>();




    public static AppDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customise);

        mdb = AppDatabase.getInstance(getApplicationContext());
        try{
            //sample test data
            mdb.userDAO().insertUser(new User(1,"s", 1, 1, "china", "china", "china"));
            mdb.headItemsDAO().insertHeadItem(new HeadItems("head1"));
            mdb.headItemsDAO().insertHeadItem(new HeadItems("head2"));
            mdb.headItemsDAO().insertHeadItem(new HeadItems("head3"));
            mdb.headItemsDAO().insertHeadItem(new HeadItems("head4"));
            mdb.bodyItemsDAO().insertBodyItem(new BodyItems("body1"));
            mdb.bodyItemsDAO().insertBodyItem(new BodyItems("body2"));
            mdb.bodyItemsDAO().insertBodyItem(new BodyItems("body5"));
            mdb.handItemsDAO().insertHandItem(new HandItems("item1"));
            mdb.handItemsDAO().insertHandItem(new HandItems("item2"));
            mdb.handItemsDAO().insertHandItem(new HandItems("item3"));


        } catch (Exception e){
            System.out.println("!");
        }

        //fill arraylists with database items
        headItems = mdb.headItemsDAO().getHeadItems();
        bodyItems = mdb.bodyItemsDAO().getBodyItems();
        handItems = mdb.handItemsDAO().getHandItems();


        ivCharacter = findViewById(R.id.ivCharacter);
        ivHead = findViewById(R.id.ivHead);
        ivBody = findViewById(R.id.ivBody);
        ivHand = findViewById(R.id.ivHand);

        userHead = findViewById(R.id.userHead);
        userBody = findViewById(R.id.userBody);
        userHand = findViewById(R.id.userHand);

        //set images based on what user is currently wearing
        userHead.setImageResource(getResources().getIdentifier(mdb.userDAO().getHeadItem(),"drawable", "com.example.timequest"));
        userBody.setImageResource(getResources().getIdentifier(mdb.userDAO().getBodyItem(),"drawable","com.example.timequest"));
        userHand.setImageResource(getResources().getIdentifier(mdb.userDAO().getHandItem(),"drawable", "com.example.timequest"));
        ivHead.setImageResource(getResources().getIdentifier(mdb.userDAO().getHeadItem(),"drawable", "com.example.timequest"));
        ivBody.setImageResource(getResources().getIdentifier(mdb.userDAO().getBodyItem(),"drawable","com.example.timequest"));
        ivHand.setImageResource(getResources().getIdentifier(mdb.userDAO().getHandItem(),"drawable", "com.example.timequest"));



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


        //fill arraylists of identifiers
        for(int i = 0; i < headItems.size(); i++)
        {
            int headID = getResources().getIdentifier(String.valueOf(headItems.get(i)), "drawable", getPackageName());
            headIDList.add(headID);
        }

        for(int i = 0; i < bodyItems.size(); i++)
        {
            int bodyID = getResources().getIdentifier(String.valueOf(bodyItems.get(i)), "drawable", getPackageName());
            bodyIDList.add(bodyID);
        }

        for(int i = 0; i < handItems.size(); i++)
        {
            int handID = getResources().getIdentifier(String.valueOf(handItems.get(i)), "drawable", getPackageName());
            handIDList.add(handID);
        }



    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.headNextButton:

                if(headCounter < headItems.size()-1) {
                    headCounter++;
                }else if
               (headCounter == headItems.size()-1){
                    headCounter = 0;
            }

                //set images
                ivHead.setImageResource(headIDList.get(headCounter));
                userHead.setImageResource(headIDList.get(headCounter));

                //update user entity
                mdb.userDAO().changeHeadItem(String.valueOf(headIDList.get(headCounter)));
                break;

            case R.id.headBackButton:

                if(headCounter > 0) {
                    headCounter--;
                }else if(headCounter == 0) {
                    headCounter = headIDList.size()-1;
        }
                ivHead.setImageResource(headIDList.get(headCounter));
                userHead.setImageResource(headIDList.get(headCounter));
                mdb.userDAO().changeHeadItem(String.valueOf(headIDList.get(headCounter)));
                break;

            case R.id.bodyNextButton:
                if(bodyCounter < bodyIDList.size()-1) {
                    bodyCounter++;
                }else if
                (bodyCounter == bodyIDList.size()-1){
                    bodyCounter = 0;
                }
                ivBody.setImageResource(bodyIDList.get(bodyCounter));
                userBody.setImageResource(bodyIDList.get(bodyCounter));
                mdb.userDAO().changeBodyItem(String.valueOf(bodyIDList.get(bodyCounter)));
                break;

            case R.id.bodyBackButton:
                if(bodyCounter > 0) {
                    bodyCounter--;
                }else if(bodyCounter == 0) {
                    bodyCounter= bodyIDList.size()-1;
                }
                ivBody.setImageResource(bodyIDList.get(bodyCounter));
                userBody.setImageResource(bodyIDList.get(bodyCounter));
                mdb.userDAO().changeBodyItem(String.valueOf(bodyIDList.get(bodyCounter)));
                break;

            case R.id.handNextButton:
                if(handCounter < handIDList.size()-1) {
                    handCounter++;
                }else if
                (handCounter == handIDList.size()-1){
                    handCounter = 0;
                }
                ivHand.setImageResource(handIDList.get(handCounter));
                userHand.setImageResource(handIDList.get(handCounter));
                mdb.userDAO().changeHandItem(String.valueOf(handIDList.get(handCounter)));
                break;

            case R.id.handBackButton:
                if(handCounter > 0) {
                    handCounter--;
                }else if(handCounter == 0) {
                    handCounter = handIDList.size()-1;
                }
                ivHand.setImageResource(handIDList.get(handCounter));
                userHand.setImageResource(handIDList.get(handCounter));
                mdb.userDAO().changeHandItem(String.valueOf(handIDList.get(handCounter)));
                break;

            default:
                break;
        }

    }
}
