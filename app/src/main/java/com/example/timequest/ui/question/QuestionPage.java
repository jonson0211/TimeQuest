package com.example.timequest.ui.question;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;

import com.example.timequest.AppDatabase;
import com.example.timequest.Entities.HeadItems;
import com.example.timequest.Entities.NPC;
import com.example.timequest.Entities.TrialQuestion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timequest.Entities.User;
import com.example.timequest.R;

import java.util.ArrayList;
import java.util.Locale;

public class QuestionPage extends AppCompatActivity {

    //Declare string variables
    //Declare string variables
    //Declare XML attributes
    //Declare class instances

    //1. Need to check for category of question
    //2. Display question
    //3. Display answers
    //3.1 Start Counter and CountDown
    //3.2 End CountDown and update Counter
    //4. User selects answer
    //5. User confirms answer
    //6. Class checks database to determine right or wrong
    //7. display next question --> condition; if question counter is less than the total amount of questions
    //8. On last question --> take them to quiz page (implicit intent)
    private static final String TAG = "QuestionPage";
    public static final String ARG_ITEM_ID = "LEARNING";

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;
    private long countDownTimeLeftMillis;

    private TextView questionTV, countdownTV, topicTv, tvQuestionNumber,tvScore;
    private RadioButton aButton, bButton, cButton;
    private Button confirmButton;
    private ImageView NPCAvatar;
    private ImageView userHead;
    private ImageView userBody;
    private ImageView userHand;

    private ColorStateList defaultColourButton, defaultColourCounter;
    private boolean answered;
    private RadioGroup questionRg;
    private CountDownTimer countDownTimer;
    //private int questionCount, questionCountTotal, score;

    private int questionCount = 0;
    private int questionCountTotal = 0;
    private int score = 0;
    //private int correctCount = 0;

    private ArrayList<TrialQuestion> questionSet;
    private TrialQuestion currentQuestion;
    private SeekBar seekbar;
    private ProgressBar barQuestionTime;

    private NPC mNPC;
    public static AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);


        db = AppDatabase.getInstance(getApplicationContext());

        try {
            //sample test data
            db.userDAO().insertUser(new User(1, "s", 1, 1, "headdefault", "itemdefault", "bodydefault",1,1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Progress bar set up - assign image icon to thumb, set progress
        SeekBar seekBar = findViewById(R.id.seekBar);
        //Drawable wbThumb = getResources().getDrawable(R.mipmap.logo);
        Drawable wbThumb = getResources().getDrawable(R.drawable.ic_chevron_right_black_24dp);

        //Retrieve user's head from database and manipulate sizing
        Integer drID = getResources().getIdentifier(db.userDAO().getHandItem(),"drawable", "com.example.timequest");
        Drawable dr = getResources().getDrawable(drID);
        Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
        // Scale it to 200 x 200
        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 150, 150, true));
        // Set your new, scaled drawable as "d" and set thumb icon to drawable
        seekBar.setThumb(d);
        seekBar.setProgress(0);
        seekBar.setEnabled(false);



        //Declaring XML variables and connecting to the layout
        topicTv = findViewById(R.id.tvTopic);
        questionTV = findViewById(R.id.tvQuestion);
        countdownTV = findViewById(R.id.tvCounter);
        aButton = findViewById(R.id.buttonA);
        bButton = findViewById(R.id.buttonB);
        cButton = findViewById(R.id.buttonC);
        confirmButton = findViewById(R.id.buttonConfirm);
        questionRg = findViewById(R.id.radioG);
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvScore = findViewById(R.id.tvScore);
        barQuestionTime=(ProgressBar)findViewById(R.id.barQuestionTime);
        NPCAvatar = findViewById(R.id.ivNPC);

        // Get the Drawable custom_progressbar
        Drawable draw=getResources().getDrawable(R.drawable.progressbar_shape);
        // set the drawable as progress drawable
        barQuestionTime.setProgressDrawable(draw);

        //establishing the colours of the button and counter
        defaultColourButton = aButton.getTextColors();
        defaultColourCounter = countdownTV.getTextColors();

        //get topic intent from reading page e.g. "Spartan"
        Integer NPCID = getIntent().getIntExtra("LEARNING",0);

        //Match civilisation from intent to specific NPC array from NPC to get image and item data
        for (int i = 0; i < 10; i++){

            if (NPC.addNPCData().get(i).getNpcID()==(NPCID)){
                mNPC = NPC.addNPCData().get(i);
                System.out.println(mNPC);
                Log.d(TAG, "on match NPC QP: SUCCESS");
                break;
            }
        }
        String testContent = mNPC.getNpcName();

        int npcCharacterResource = getResources().getIdentifier(mNPC.getNpcAvatar(),"drawable", getPackageName());
        NPCAvatar.setImageResource(npcCharacterResource);

        userHead = findViewById(R.id.userHead);
        userBody = findViewById(R.id.userBody);
        userHand = findViewById(R.id.userHand);

        userHead.setImageResource(getResources().getIdentifier(db.userDAO().getHeadItem(),"drawable", "com.example.timequest"));
        userBody.setImageResource(getResources().getIdentifier(db.userDAO().getBodyItem(),"drawable","com.example.timequest"));
        userHand.setImageResource(getResources().getIdentifier(db.userDAO().getHandItem(),"drawable", "com.example.timequest"));

        System.out.println("*" + testContent);
        topicTv.setText(testContent);


        questionSet = TrialQuestion.getTrialQuiz(testContent);
        questionCountTotal = questionSet.size();
        System.out.println(questionSet);

        //Start quiz, next question
        nextQuestion();

        //When the confirm button is clicked, need to check whether an answer has been selected
        //Mark answer if correct
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (aButton.isChecked() || bButton.isChecked() || cButton.isChecked()) {
                        findViewById(R.id.barQuestionTime).clearAnimation();
                        markAnswer();
                    } else {
                        Toast.makeText(QuestionPage.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    nextQuestion();
                }

            }
        });

        //handle button colours when selected
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aButton.setBackgroundResource(R.drawable.quiz_buttons_selected);
                bButton.setBackgroundResource(R.drawable.quiz_buttons);
                cButton.setBackgroundResource(R.drawable.quiz_buttons);
            }
        });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bButton.setBackgroundResource(R.drawable.quiz_buttons_selected);
                aButton.setBackgroundResource(R.drawable.quiz_buttons);
                cButton.setBackgroundResource(R.drawable.quiz_buttons);
            }
        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cButton.setBackgroundResource(R.drawable.quiz_buttons_selected);
                aButton.setBackgroundResource(R.drawable.quiz_buttons);
                bButton.setBackgroundResource(R.drawable.quiz_buttons);
            }
        });

    }
    //1. Set the colors back to default
    //2. Clear the current options
    //3. Reset timer
    //4. Question progress counter
    //5. Finished the quiz - toast message
    //6. Take them to their prize or go back to home page.
    private void nextQuestion(){

        aButton.setClickable(true);
        bButton.setClickable(true);
        cButton.setClickable(true);
        NPCAvatar.clearAnimation();

        //2.
        questionRg.clearCheck();
        aButton.setBackgroundResource(R.drawable.quiz_buttons);
        bButton.setBackgroundResource(R.drawable.quiz_buttons);
        cButton.setBackgroundResource(R.drawable.quiz_buttons);

        if(questionCount < questionCountTotal){
            //questionCounter is the integer
            currentQuestion = questionSet.get(questionCount);
            System.out.println("Current Question: " + currentQuestion);

            //set the textView based on the current question
            questionTV.setText(currentQuestion.getQuestion()); System.out.println(currentQuestion.getQuestion());
            aButton.setText(currentQuestion.getOption1()); System.out.println(currentQuestion.getOption1());
            bButton.setText(currentQuestion.getOption2());
            cButton.setText(currentQuestion.getOption3());

            questionCount++;
            tvQuestionNumber = findViewById(R.id.tvQuestionNumber);

            tvQuestionNumber.setText(String.format(String.valueOf(questionCount)));

            answered = false;
            //3.
            countDownTimeLeftMillis = COUNTDOWN_IN_MILLIS;

            startCountdown();
            //Set progress animation on time countdown bar
            barQuestionTime.setMax(1000);
            ObjectAnimator progressAnimator = ObjectAnimator.ofInt(barQuestionTime, "progress", 1000, 0);
            progressAnimator.setDuration(30000);
            progressAnimator.start();

        } else{

            Intent rsIntent = new Intent(getApplicationContext(),Achievement.class);
            Integer NPCID = getIntent().getIntExtra("LEARNING",0);
            rsIntent.putExtra("LEARNING", NPCID);
            rsIntent.putExtra("EXTRA_SCORE", score);

            setResult(RESULT_OK,rsIntent);
            //finish();
            //finishQuiz();

            startActivity(rsIntent);


        }
    }

    private void finishQuiz() {
        confirmButton.setOnClickListener(v -> {
            confirmButton.setText("Finish");

            Integer NPCID = getIntent().getIntExtra("LEARNING",0);
            Intent intent = new Intent(getApplicationContext(), Achievement.class);
            Intent intent1 = new Intent(getApplicationContext(), Achievement.class);
            intent.putExtra("LEARNING", NPCID);
            intent1.putExtra("EXTRA_SCORE", score);
            startActivity(intent);
        });

        //Start new activity - achievement page
    }

    //Start countdown once activity is alive
    //create countdowntimer using android OS
    private void startCountdown(){
        countDownTimer = new CountDownTimer(countDownTimeLeftMillis, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                countDownTimeLeftMillis = millisUntilFinished;
                changeCountDownText();


            }

            @Override
            public void onFinish() {
                countDownTimeLeftMillis = 0;
                changeCountDownText();
                barQuestionTime.setMax(100);
                barQuestionTime.setProgress(0);
                barQuestionTime.setProgress(100);
                markAnswer();
            }
        }.start();
    }

    private void changeCountDownText(){
        int minutes = (int) (countDownTimeLeftMillis/1000) / 60;
        int seconds = (int) (countDownTimeLeftMillis/1000) % 60;

        String time = String.format(Locale.getDefault(), "%02d", seconds);
        countdownTV.setText(time);


        if(countDownTimeLeftMillis<10000){
            countdownTV.setTextColor(Color.RED);
            countdownTV.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake));
        }else{
            countdownTV.setTextColor(defaultColourCounter);
        }
    }

    private void markAnswer(){
        findViewById(R.id.barQuestionTime).clearAnimation();
        countdownTV.clearAnimation();
        answered = true;

        aButton.setClickable(false);
        bButton.setClickable(false);
        cButton.setClickable(false);

        countDownTimer.cancel();
        RadioButton selectedAnswer = findViewById(questionRg.getCheckedRadioButtonId());

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(questionCount);



        int answer = questionRg.indexOfChild(selectedAnswer) + 1;
        //if(answer == currentQuestion.getAnswerNumber()){
        System.out.println(answer);
        if(answer == currentQuestion.getAnswerNumber()){
            System.out.println(answer + "*");
            score++;

            tvScore.setText(String.format(String.valueOf(score)));
            System.out.println(score);

        }else{NPCAvatar.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake));};
        //else { - change image to red X for wrong answers
        //Drawable wbThumb = getResources().getDrawable(R.drawable.ic_close);
        //seekBar.setThumb(wbThumb);}

        displaySolution();
        System.out.println("Current score: " + score);
    }

    private void displaySolution(){
        aButton.setBackgroundResource(R.drawable.quiz_buttons_incorrect);
        bButton.setBackgroundResource(R.drawable.quiz_buttons_incorrect);
        cButton.setBackgroundResource(R.drawable.quiz_buttons_incorrect);


    if(currentQuestion.getAnswerNumber() == 1){
        aButton.setBackgroundResource(R.drawable.quiz_buttons_correct);
    } else if (currentQuestion.getAnswerNumber() == 2){
        bButton.setBackgroundResource(R.drawable.quiz_buttons_correct);
    } else  cButton.setBackgroundResource(R.drawable.quiz_buttons_correct);;
        if(questionCount < 10){
             confirmButton.setText("Next question");
        }else {
            confirmButton.setText("Finish");
        }

    }

}

