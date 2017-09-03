package com.google.maps.android.utils.demo;

/**
 * Created by fvgregorio on 8/24/2017.
 */

public class QuestionLibrary2 {

    private String mQuestions [] = {
            "Who is wearing the gold watch?",
            "Which model is wearing pink shoes?",
            "What is brand being advertise?",
            "What is the promo on the billboard?"
    };


    private String mChoices [][] = {
            {"Gerald Anderson", "Felix Gregorio", "Enrique Gil"},
            {"Kim Chui", "Erich Gonzalez", "Marian Rivera"},
            {"Jag", "Vans", "Converse"},
            {"Buy 1 Take 1", "50% Off", "Free trip to Boracay"}
    };



    private String mCorrectAnswers[] = {"Felix Gregorio", "Erich Gonzalez", "Vans", "Free trip to Boracay"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}