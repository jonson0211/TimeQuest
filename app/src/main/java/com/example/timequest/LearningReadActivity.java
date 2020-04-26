package com.example.timequest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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

import org.w3c.dom.Text;

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

        Integer NPCID = getIntent().getIntExtra("LEARNING",0);
               Log.d(TAG, "on getIntent success:" + NPCID);

        String eraName = getIntent().getStringExtra("ERA");
        Log.d(TAG, "on getIntent success:" + eraName);
        //Match civilisation from intent to specific NPC array from NPC to get image and item data
        for (int i = 0; i < NPC.addNPCData().size(); i++){

            if (NPC.addNPCData().get(i).getNpcID()==(NPCID)){
                mNPC = NPC.addNPCData().get(i);
                System.out.println(mNPC);
                Log.d(TAG, "on match NPC: SUCCESS");
                break;
            }
        }

        for (int x = 0; x < Era.addEraData().size(); x++){

            if (Era.addEraData().get(x).getEraName().equals(eraName)){
                mERA = Era.addEraData().get(x);
                System.out.println(mERA);
                Log.d(TAG, "on match Era Name: SUCCESS");
                break;
            }
        }

      //  learningText = findViewById(R.id.learningText);
        videoView = findViewById(R.id.videoView);
        Button takeTrial = findViewById(R.id.takeTrial);
        notesFloatingButton = findViewById(R.id.notesFloatingButton);
        bannerView = findViewById(R.id.bannerView);

        int bannerResource = getResources().getIdentifier(mNPC.getBannerID(),"drawable", getPackageName());
        bannerView.setBackgroundResource(bannerResource);

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

        new GetWikiTask().execute();
        /**
        final String wikiUrl =
                //"https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Legionary"
               "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + mNPC.getSearchTerm()
                ;
        Context context = getApplicationContext();
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        //Receive string, remove punctuation - wiki-specific newline characters and brackets
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String string = (response.substring(response.lastIndexOf("extract")+10,response.length()-5));
                //string = string.replace("\\n", "\n\n");
                string = string.replace("\\n", "\n\n");
                string = string.replaceAll("\\(.*?\\)", "");
                string = string.replace("\\u","");
                string = string.replace("\\","");
                string = string.replace("alers, German: Neandertaler [ne02c8and0250ta02d0l0250]","");
                string = string.replace("s)","s");
                string = string.replace(":1202013143","\n");
                string = string.replace("2013","-");
                learningText.setText(string);
                System.out.println(string);
                requestQueue.stop();
            }
        };
        //Error handling Volley
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError error) {
                Log.d(TAG, "onErrorResponse Volley error:");
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, wikiUrl, responseListener, errorListener);
        requestQueue.add(stringRequest);
**/

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        String videoID = mNPC.getVideoID();

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                //String videoId = "BIqWKPA83V0";
                youTubePlayer.cueVideo(videoID, 0f);
            }


        });



        takeTrial.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), QuestionPage.class);
            intent.putExtra("LEARNING", NPCID);
            Log.d(TAG, "on putExtra Intent success:" + NPCID);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.release();
        Log.d(TAG, "on YT Player release success:");
    }

    private class GetWikiTask extends AsyncTask<Void, Void, Void> {
/**
        @Override
        protected void onPreExecute() {
            TextView learningTxt = (TextView) findViewById(R.id.learningText);
            learningTxt.setText("Loading...");
            super.onPreExecute();
        }
**/
        @Override
        protected Void doInBackground(Void... voids) {
            final String wikiUrl =
                    //"https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Legionary"
                    "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + mNPC.getSearchTerm();
            Context context = getApplicationContext();
            final RequestQueue requestQueue = Volley.newRequestQueue(context);
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    String string = (response.substring(response.lastIndexOf("extract") + 10, response.length() - 5));
                    //string = string.replace("\\n", "\n\n");
//                    System.out.println(string);
//                    if (string.endsWith("\\n\\n") || string.endsWith("\\n") ){
//                        string.replace("\\n","");
//                    }
                    string = string.replace("\\n", "\n\n");
                    string = string.replaceAll("\\(.*?\\)", "");
                    string = string.replace("\\u", "");
                    string = string.replace("\\", "");
                    string = string.replace("alers, German: Neandertaler [ne02c8and0250ta02d0l0250]", "");
                    string = string.replace("s)", "s");
                    string = string.replace(":1202013143", "\n");
                    string = string.replace("2013", "-");
                    learningText.setText(string);
                    System.out.println(string);
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
            StringRequest stringRequest = new StringRequest(Request.Method.GET, wikiUrl, responseListener, errorListener);
            requestQueue.add(stringRequest);
            UpdateUi();
            return null;
        }
        }


    private void UpdateUi(){
        learningText = findViewById(R.id.learningText);
    }
}

/** VIDEO PLAYING FROM YOUTUBE DOES NOT WORK WELL USING VIDEO VIEW
 //Video Player
 String videoURL ="https://m.www.youtube.com/watch?v=BIqWKPA83V0";
 //videoView.setVideoURI(Uri.parse(videoURL));
 videoView.setVideoPath(videoURL);
 mediaController = new MediaController(this);
 mediaController.setAnchorView(videoView);
 videoView.setMediaController(mediaController);

 //videoView.start();
 //videoView.setOnPreparedListener(mediaPlayer -> videoView.start());

 videoView.setOnTouchListener(
 (v, event) -> {
 videoView.start();
 videoView.requestFocus();
 return false;
 }
 );

 **/