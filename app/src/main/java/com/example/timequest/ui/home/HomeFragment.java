package com.example.timequest.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timequest.Adapters.EraAdapter;
import com.example.timequest.Entities.Era;
import com.example.timequest.LearningReadActivity;
import com.example.timequest.MainActivity;
import com.example.timequest.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.example.timequest.Entities.Era.addEraData;
import static com.example.timequest.R.menu.bottom_nav_menu;

public class HomeFragment extends Fragment {
    private RecyclerView mRvList;
    private ArrayList<Era> mEraArrayList;
    private List<Era> mEraList;
    private EraAdapter mEraAdapter;

    /**
     * Connect to the XML layout
     * Call the adapter
     * What happens after the cardview is clicked on?
     */

    public HomeFragment(){

    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        mRvList = v.findViewById(R.id.rvList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext());
        mRvList.setLayoutManager(layoutManager);

        EraAdapter mEraAdapter = new EraAdapter();
        mEraAdapter.setData(Era.addEraData());
        mRvList.setAdapter(mEraAdapter);

        mRvList = v.findViewById(R.id.rvList);
        mRvList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }
}