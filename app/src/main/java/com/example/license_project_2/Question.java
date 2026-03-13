package com.example.license_project_2;

public class Question {
    private String questionRequirement;
    private int answerID;
    private boolean isAnswerCorrect;

    public Question(int id, boolean correct, String requirement){
        this.questionRequirement = requirement;
        this.answerID = id;
        this.isAnswerCorrect = correct;
    }

    public String getQuestionRequirement(){
        return this.questionRequirement;
    }

    public void setQuestionRequirement(String otherQuestion){
        this.questionRequirement = otherQuestion;
    }
    public int getAnswerID(){
        return this.answerID;
    }

    public void setAnswerID(int otherAnswerID){
        this.answerID = otherAnswerID;
    }

    public boolean getCorrectAnswer(){
        return this.isAnswerCorrect;
    }

    public void setCorrectAnswer(boolean otherCorrectAnswer){
        this.isAnswerCorrect = otherCorrectAnswer;
    }
}

