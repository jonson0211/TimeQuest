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
import com.example.timequest.LearningIntroActivity;
import com.example.timequest.LearningReadActivity;
import com.example.timequest.MainActivity;
import com.example.timequest.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.timequest.Entities.Era.addEraData;
import static com.example.timequest.R.menu.bottom_nav_menu;

public class HomeFragment extends Fragment {
    public static final Integer EXTRA_MESSAGE = 0;
    private RecyclerView mRvList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Era> mEraArrayList;
    private List<Era> mEraList;

    /**
     * Connect to the XML layout
     * Call the adapter
     * What happens after the cardview is clicked on.
     * 1. Cardview needs to be inflated into the recyclerview
     * 2. intent to listen to what topic is being clicked on, that will transfer the user to the activity
     * 3. Adapter!
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
//Inflate the fragment, and talk to the Adapter that consists of the cardview to be populated
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        mRvList = v.findViewById(R.id.rvList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext());
        mRvList.setLayoutManager(layoutManager);
        EraAdapter.RecyclerViewClickListener listener = new EraAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchLearningIntroActivity(position);
            }
        };

        EraAdapter mEraAdapter = new EraAdapter(Era.addEraData(), listener);
        mEraAdapter.setData(Era.addEraData());
        mRvList.setAdapter(mEraAdapter);

        mRvList = v.findViewById(R.id.rvList);

        return v;
    }
    //Intent to launch the proceeding screen
    private void launchLearningIntroActivity(int position){
        Intent intent = new Intent(getActivity(), LearningIntroActivity.class);
        intent.putExtra(String.valueOf(EXTRA_MESSAGE), position);
        startActivity(intent);
    }
}