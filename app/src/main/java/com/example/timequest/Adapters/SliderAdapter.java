package com.example.timequest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.timequest.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;

    }

    public int[] slide_images = {
            R.drawable.amazonian,
            R.drawable.amazonian,
            R.drawable.bodyancientegyptian,
            R.drawable.china
    };

    public String [] slide_descs = {
            "Welcome to TimeQuest! TimeQuest is a RPG-style history learning game. You play as a time traveller, who has the ability to travel to different points in time to learn about a variety of ancient civilisations, and undertake their trial to prove your worth.",
            "In the Adventure screen, you can select from a list of civilisations to learn about. There will be written and video material - you will also be able to write notes. Afterwards, you will be able to undertake a trial. The trial would consist of 10 questions, and if you get 8+ correct, you will win an item drop or several.",
            "In the Featured screen, you will be able to answer True/False questions on general history. A random civilisation will also be displayed below, along with it's associated item drops and the notes you have written for it for this specific civilisation.",
            "In your Profile page, you will be able to customise your character and equip items that you have collected through you journey. Statistics such as your accuracy and progress are also displayed. You will also be able to access this tutorial through this screen. Best of luck in your adventures, traveller! "
    };




    @Override
    public int getCount() {
        return slide_descs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView screenshot = view.findViewById(R.id.screenshot);
        TextView instructionText = view.findViewById(R.id.instructionText);

        screenshot.setImageResource(slide_images[position]);
        instructionText.setText(slide_descs[position]);

        container.addView(view);

        return view;



    }

    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((ConstraintLayout)object);
    }



}
