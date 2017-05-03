package com.edwayzapp.models;

/**
 * Created by HP on 4/30/2017.
 */

public class QuestionsPojo {

    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String right;

    public QuestionsPojo(String question, String answer1, String answer2, String answer3, String answer4, String right) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.right = right;
    }

    public String getAnswer4() {
        return answer4;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

}
