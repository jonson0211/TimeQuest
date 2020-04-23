package com.example.timequest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.timequest.Adapters.EraAdapter;
import com.example.timequest.Entities.Era;
import com.example.timequest.ui.Fragments.Test1;
import com.example.timequest.ui.Fragments.Featured;
import com.example.timequest.ui.home.HomeFragment;
import com.example.timequest.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity.class";

    public static AppDatabase db;

    //link to recyclerview and cardviews
    private EraAdapter mEra;
    private FragmentManager FragmentManager;
    private androidx.fragment.app.FragmentTransaction FragmentTransaction;
    private FrameLayout containerfragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fragment_container, homeFragment, "FragmentName");
                    fragmentTransaction1.commit();
                    return true;
                case R.id.navigation_dashboard:
                    Featured featured = new Featured();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fragment_container, featured, "FragmentName");
                    fragmentTransaction2.commit();
                    return true;
                case R.id.navigation_notifications:
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fragment_container, profileFragment, "FragmentName");
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(R.layout.abs_layout);
        //getSupportActionBar().setDisplayOptions(
                //ActionBar.DISPLAY_SHOW_HOME |
               // ActionBar.DISPLAY_SHOW_TITLE |
                       // ActionBar.DISPLAY_HOME_AS_UP |
                       // ActionBar.DISPLAY_USE_LOGO);
       // actionbar.setIcon(R.drawable.logotqicon);

        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fragment_container, homeFragment, "FragmentName");
        fragmentTransaction1.commit();
    }
}