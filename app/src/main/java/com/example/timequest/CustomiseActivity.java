package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class CustomiseActivity extends AppCompatActivity {

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
        headBackButton = findViewById(R.id.headBackButton);
        item1NextButton = findViewById(R.id.item1NextButton);
        item1BackButton = findViewById(R.id.item1BackButton);
        item2NextButton = findViewById(R.id.item2NextButton);
        item2BackButton = findViewById(R.id.item2BackButton);
        saveButton = findViewById(R.id.saveButton);


    }
}
