package com.example.timequest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.timequest.Entities.Era;
import com.example.timequest.Entities.NPC;
import com.example.timequest.ui.question.QuestionPage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class LearningReadActivity extends AppCompatActivity {

    public static final String ARG_ITEM_ID = "LEARNING";
    private static final String TAG = "LearningReadActivity";

    private NPC mNPC;
    private ImageView eraBanner;
    private TextView learningText;
    private Button takeTrial;
    private VideoView videoView;
    private MediaController mediaController;
    private FloatingActionButton notesFloatingButton;
    private Era mERA;
    private View bannerView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_read);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(R.layout.abs_layout);

        Integer NPCID = getIntent().getIntExtra("LEARNING", 0);
        Log.d(TAG, "on getIntent success - NPCID:" + NPCID);

        String eraName = getIntent().getStringExtra("ERA");
        Log.d(TAG, "on getIntent success - ERANAME:" + eraName);

        //Match civilisation from the intent to the specific NPC array from NPC.class to get image and item data
        for (int i = 0; i < NPC.addNPCData().size(); i++) {
            if (NPC.addNPCData().get(i).getNpcID() == (NPCID)) {
                mNPC = NPC.addNPCData().get(i);
                System.out.println(mNPC);
                Log.d(TAG, "on match NPC: SUCCESS");
                break;
            }
        }

        for (int x = 0; x < Era.addEraData().size(); x++) {

            if (Era.addEraData().get(x).getEraName().equals(eraName)) {
                mERA = Era.addEraData().get(x);
                System.out.println(mERA);
                Log.d(TAG, "on match Era Name: SUCCESS");
                break;
            }
        }

        videoView = findViewById(R.id.videoView);
        Button takeTrial = findViewById(R.id.takeTrial);
        notesFloatingButton = findViewById(R.id.notesFloatingButton);
        bannerView = findViewById(R.id.bannerView);

        int bannerResource = getResources().getIdentifier(mNPC.getBannerID(), "drawable", getPackageName());
        bannerView.setBackgroundResource(bannerResource);

        //Set behaviour for note taking feature
        notesFloatingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intentEra = new Intent(getApplicationContext(), NotesDetail.class);
                intentEra.putExtra("ERA", mERA.getEraName().toString());
                Log.d(TAG, "on match Era Name: SUCCESS" + mERA.getEraName());
                context.startActivity(intentEra);

            }
        });
        //Execute wikipedia API using Async Tasks
        new GetWikiTask().execute();

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        String videoID = mNPC.getVideoID();

        //The following YouTuber player has made use of an open-source YouTube player. The native methods to display video in-app are:
        // 1) Obsolete and buggy due to lack of support from Android developers
        // 2) Difficult to achieve using webview elements alone and makes for poor UI/UX design due to the inherent design of the element
        //The YouTube player and supporting documention can be found here: https://github.com/PierfrancescoSoffritti/android-youtube-player
        //Pierfrancesco Soffritti (2019), android-youtube-player (2019) [Source Code]. https://github.com/PierfrancescoSoffritti/android-youtube-player.
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.cueVideo(videoID, 0f);
            }


        });

        takeTrial.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), QuestionPage.class);
            intent.putExtra("LEARNING", NPCID);
            Log.d(TAG, "on put ExtraIntent success:" + NPCID);
            startActivity(intent);
        });
    }

    //Video players take a lot of memory so the method below has been used to release the videoplayer when the activity is destroyed.
    @Override
    public void onDestroy() {
        super.onDestroy();
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.release();
        Log.d(TAG, "on YT Player release success:");
    }

    private class GetWikiTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            final String wikiLink = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + mNPC.getSearchTerm();
            Context context = getApplicationContext();
            final RequestQueue requestQueue = Volley.newRequestQueue(context);
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //The retrieved wikipedia string is illegible in its raw state due to the specific HTML code used and the links. Below, the string is cleaned.
                    String string = (response.substring(response.lastIndexOf("extract") + 10, response.length() - 5));
                    string = string.replace("\\n", "\n\n");
                    string = string.replaceAll("\\(.*?\\)", "");
                    string = string.replace("\\u", "");
                    string = string.replace("\\", "");
                    string = string.replace("alers, German: Neandertaler [ne02c8and0250ta02d0l0250]", "");
                    string = string.replace("s)", "s");
                    string = string.replace(":1202013143", "\n");
                    string = string.replace("2013", "-");
                    learningText.setText(string);
                    requestQueue.stop();
                }
            };
            //Error handling Volley
            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG, "onErrorResponse Volley Error:");
                }
            };
            StringRequest stringRequest = new StringRequest(Request.Method.GET, wikiLink, responseListener, errorListener);
            requestQueue.add(stringRequest);
            UpdateUi();
            return null;
        }
    }


    private void UpdateUi() {
        learningText = findViewById(R.id.learningText);
    }
}
