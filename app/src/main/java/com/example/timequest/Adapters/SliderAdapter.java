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
            R.drawable.bodyancientegyptian,
            R.drawable.china
    };

    public String [] slide_descs = {
            "Descas1",
            "Desc 2",
            "Desc 3"
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
