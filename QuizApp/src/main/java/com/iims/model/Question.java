package com.iims.model;

public class Question {
    int id;
    String question;
    String ansOne, ansTwo, ansThree;
    String correctAns;

    public Question() {
    }

    public Question(int id, String question, String ansOne, String ansTwo, String ansThree, String correctAns) {
        this.id = id;
        this.question = question;
        this.ansOne = ansOne;
        this.ansTwo = ansTwo;
        this.ansThree = ansThree;
        this.correctAns = correctAns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnsOne() {
        return ansOne;
    }

    public void setAnsOne(String ansOne) {
        this.ansOne = ansOne;
    }

    public String getAnsTwo() {
        return ansTwo;
    }

    public void setAnsTwo(String ansTwo) {
        this.ansTwo = ansTwo;
    }

    public String getAnsThree() {
        return ansThree;
    }

    public void setAnsThree(String ansThree) {
        this.ansThree = ansThree;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", ansOne='" + ansOne + '\'' +
                ", ansTwo='" + ansTwo + '\'' +
                ", ansThree='" + ansThree + '\'' +
                ", correctAns='" + correctAns + '\'' +
                '}';
    }
}
