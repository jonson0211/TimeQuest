package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;


public class TrialQuestion {


    private Integer questionNumber;

    private String question;

    private String option1;

    private String option2;

    private String option3;

    private Integer answerNumber;

    private String quizBackground;

    public TrialQuestion(Integer questionNumber, String question, String option1, String option2, String option3, Integer answerNumber, String quizBackground) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNumber = answerNumber;
        this.quizBackground = quizBackground;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String getQuizBackground() {
        return quizBackground;
    }

    public void setQuizBackground(String quizBackground) {
        this.quizBackground = quizBackground;
    }

    public static ArrayList<TrialQuestion> spartanTrial(){
        ArrayList<TrialQuestion> spartanQuestions = new ArrayList<>();
        spartanQuestions.add(new TrialQuestion(1, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(2, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(3, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(4, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(5, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(6, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(7, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(8, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(9, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        spartanQuestions.add(new TrialQuestion(10, "Spartan Army", "banner1", "background1","Incomplete",1,"d"));
        return spartanQuestions;
    }

    public static ArrayList<TrialQuestion> nslTrial(){
        ArrayList<TrialQuestion> nslQuestions = new ArrayList<>();
        nslQuestions.add(new TrialQuestion(1, "NSL", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(2, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(3, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(4, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(5, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(6, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(7, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(8, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(9, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        nslQuestions.add(new TrialQuestion(10, "NSL Army", "banner1", "background1","Incomplete",1,"d"));
        return nslQuestions;
    }

    public static ArrayList<TrialQuestion> romanTrial(){
        ArrayList<TrialQuestion> romanQuestions = new ArrayList<>();
        romanQuestions.add(new TrialQuestion(1, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(2, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(3, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(4, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(5, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(6, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(7, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(8, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(9, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        romanQuestions.add(new TrialQuestion(10, "Roman Army", "banner1", "background1","Incomplete",1,"d"));
        return romanQuestions;
    }

    public static ArrayList<TrialQuestion> athenianTrial(){
        ArrayList<TrialQuestion> athenianQuestions = new ArrayList<>();
        athenianQuestions.add(new TrialQuestion(1, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(2, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(3, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(4, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(5, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(6, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(7, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(8, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(9, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        athenianQuestions.add(new TrialQuestion(10, "Athenian Army", "banner1", "background1","Incomplete",1,"d"));
        return athenianQuestions;
    }

    public static ArrayList<TrialQuestion> normanTrial(){
        ArrayList<TrialQuestion> normanQuestions = new ArrayList<>();
        normanQuestions.add(new TrialQuestion(1, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(2, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(3, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(4, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(5, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(6, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(7, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(8, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(9, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        normanQuestions.add(new TrialQuestion(10, "Norman Army", "banner1", "background1","Incomplete",1,"d"));
        return normanQuestions;
    }

    public static ArrayList<TrialQuestion> cossackTrial(){
        ArrayList<TrialQuestion> cossackQuestions = new ArrayList<>();
        cossackQuestions.add(new TrialQuestion(1, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(2, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(3, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(4, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(5, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(6, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(7, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(8, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(9, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        cossackQuestions.add(new TrialQuestion(10, "Cossack Army", "banner1", "background1","Incomplete",1,"d"));
        return cossackQuestions;
    }

    public static ArrayList<TrialQuestion> neanderthalTrial(){
        ArrayList<TrialQuestion> neanderthalQuestions = new ArrayList<>();
        neanderthalQuestions.add(new TrialQuestion(1, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(2, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(3, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(4, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(5, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(6, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(7, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(8, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(9, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        neanderthalQuestions.add(new TrialQuestion(10, "neanderthal Army", "banner1", "background1","Incomplete",1,"d"));
        return neanderthalQuestions;
    }

    public static ArrayList<TrialQuestion> qingTrial(){
        ArrayList<TrialQuestion> qingQuestions = new ArrayList<>();
        qingQuestions.add(new TrialQuestion(1, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(2, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(3, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(4, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(5, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(6, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(7, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(8, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(9, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        qingQuestions.add(new TrialQuestion(10, "Qing Army", "banner1", "background1","Incomplete",1,"d"));
        return qingQuestions;
    }

    public static ArrayList<TrialQuestion> vikingTrial(){
        ArrayList<TrialQuestion> vikingQuestions = new ArrayList<>();
        vikingQuestions.add(new TrialQuestion(1, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(2, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(3, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(4, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(5, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(6, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(7, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(8, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(9, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        vikingQuestions.add(new TrialQuestion(10, "Viking Army", "banner1", "background1","Incomplete",1,"d"));
        return vikingQuestions;
    }




}