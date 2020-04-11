package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Trial {


    @PrimaryKey(autoGenerate = true)
    private int questionNumber;

    @ColumnInfo(name = "question")
    private String question;

    @ColumnInfo(name = "option1")
    private String option1;
    @ColumnInfo(name = "option2")
    private String option2;
    @ColumnInfo(name = "option3")
    private String option3;
    @ColumnInfo(name = "option4")
    private String option4;

    @ColumnInfo(name = "answer_number")
    private int answerNumber;

    @ColumnInfo(name = "quiz_background")
    private String quizBackground;

    public Trial(int questionNumber, String question, String option1, String option2, String option3, String option4, int answerNumber, String quizBackground) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
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

    public String getQuizBackground() {
        return quizBackground;
    }

    public void setQuizBackground(String quizBackground) {
        this.quizBackground = quizBackground;
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

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }
}
