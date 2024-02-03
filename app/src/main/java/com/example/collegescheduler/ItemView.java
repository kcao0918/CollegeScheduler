package com.example.collegescheduler;

public class ItemView {

    private String inputOne;
    private String inputTwo;
    private String inputThree;

    public ItemView(String inputOne, String inputTwo, String inputThree) {
        this.inputOne = inputOne;
        this.inputTwo = inputTwo;
        this.inputThree = inputThree;
    }

    public String getInputOne() {
        return inputOne;
    }

    public String getInputTwo() {
        return inputTwo;
    }

    public String getInputThree() {
        return inputThree;
    }

    // used for edit button
    public void setInputOne(String inputOne) {
        this.inputOne = inputOne;
    }

    public void setInputTwo(String inputTwo) {
        this.inputTwo = inputTwo;
    }

    public void setInputThree(String inputThree) {
        this.inputThree = inputThree;
    }
}