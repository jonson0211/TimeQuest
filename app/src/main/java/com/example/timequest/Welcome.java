package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.timequest.Entities.BodyItems;
import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.HandItems;
import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.User;

public class Welcome extends AppCompatActivity {

    /**
     * 1. First screen that the user sees
     * 2. User needs to enter name
     * 3. User clicks start, name is saved to db
     * 4. User is taken to the adventure page
     */

     private EditText nameEt;
     private Button startB;
     private boolean answered;
     private String username;

      AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        nameEt = findViewById(R.id.etName);
        startB = findViewById(R.id.bStart);


        db = AppDatabase.getInstance(getApplicationContext());

        startB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if (validateFields() == true) {
                    try{
                        //sample test data
                        db.userDAO().insertUser(new User(1, nameEt.getText().toString(), 0, 0, "headdefault", "itemdefault", "bodydefault",0,0));
                        db.headItemsDAO().insertHeadItem(new HeadItems("headdefault"));
                        db.bodyItemsDAO().insertBodyItem(new BodyItems("bodydefault"));
                        db.handItemsDAO().insertHandItem(new HandItems("itemdefault"));



                        db.eraDAO().insertEra(new Era("Spartan Army", "banner1", "npcathens","Incomplete"," ", "750 BC - 146 BC"));
                        db.eraDAO().insertEra(new Era("Vikings", "banner9", "background9","Incomplete", " ","793 AD - 1066 AD"));
                        db.eraDAO().insertEra(new Era("Roman Legionnaire", "banner3", "background3","Incomplete", " ", "150 BC - 120 BC "));
                        db.eraDAO().insertEra(new Era("Ancient Athenians", "banner4", "background4","Incomplete", " ","508 BC - 322 BC "));
                        db.eraDAO().insertEra(new Era("Normans", "banner5", "background5","Incomplete", " ","911 AD - 1167 AD"));
                        db.eraDAO().insertEra(new Era( "Cossack Warriors", "banner6", "background6","Incomplete", " ","1676 AD - Present"));
                        db.eraDAO().insertEra(new Era("Neanderthals", "banner7", "background7","Incomplete", " ","400 000 BC - 40 000 BC"));
                        db.eraDAO().insertEra(new Era("Qing Dynasty", "banner8", "background8","Incomplete", " ","1636 AD- 1912 AD"));
                        db.eraDAO().insertEra(new Era("North Sentinel Islanders", "banner2", "background2","Incomplete", " ", "60 000 BC - Present"));
                        db.eraDAO().insertEra(new Era("Ancient Egyptians", "banner10", "background10","Incomplete", " ","3100 BC - 30 BC"));


                    } catch (Exception e){
                        System.out.println("!");
                    }

                    Toast toast = Toast.makeText(getApplicationContext(), "Name saved.", Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(new Intent(Welcome.this, Instructions.class));
                    finish();

                }
                }



        });



    }

    private boolean validateFields() {
        int yourDesiredLength = 1;
        if (nameEt.getText().length() < yourDesiredLength) {
            nameEt.setError("Please enter a valid name.");
            return false;
        }
            return true;
        }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Welcome.this, Welcome.class);
        startActivity(intent);

        finish();
    }


}
