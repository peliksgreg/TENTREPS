package com.google.maps.android.utils.demo;

/**
 * Created by fvgregorio on 8/24/2017.
 */

public class QuestionLibrary1 {

    private String mQuestions [] = {
            "What is the name of the model?",
            "What flavors are available?",
            "How much does it cost?",
            "What is the model wearing?"
    };


    private String mChoices [][] = {
            {"Liza Soberano", "Katherine Bernardo", "Julia Montes"},
            {"Chocolate", "Vanilla", "Strawberry"},
            {"200 pesos", "250 pesos", "149 pesos"},
            {"Denim Jacket", "Red Flannel", "Pink Shirt"}
    };



    private String mCorrectAnswers[] = {"Liza Soberano", "Vanilla", "149 pesos", "Denim Jacket"};




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