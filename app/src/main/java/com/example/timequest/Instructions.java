package com.example.timequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.timequest.Adapters.SliderAdapter;
import com.example.timequest.ui.question.Achievement;

import org.w3c.dom.Text;

public class Instructions extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private Button finishInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);


        Intent intent = getIntent();

        viewPager = findViewById(R.id.viewPager);
        mDotLayout = findViewById(R.id.dotLayout);
        finishInstructions = findViewById(R.id.finishInstructions);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);


        finishInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(Instructions.this, MainActivity.class));
                    finish();

            }
        });

    }

    public void addDotsIndicator(int position){
        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextColor(getResources().getColor(R.color.colorAltAccentLightOrange));
            mDots[i].setTextSize(35);

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorAltAccentYellowOrange));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
