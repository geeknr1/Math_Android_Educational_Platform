package com.example.license_project_2;

public class Section {
    private String sectionContent;
    private int answerID;
    public Section(String section, int id){
        this.sectionContent = section;
        this.answerID = id;
    }

    public String getQuestionRequirement(){
        return this.sectionContent;
    }

    public void setQuestionRequirement(String otherSection){
        this.sectionContent = otherSection;
    }
    public int getAnswerID(){
        return this.answerID;
    }

    public void setAnswerID(int otherAnswerID){
        this.answerID = otherAnswerID;
    }
}

