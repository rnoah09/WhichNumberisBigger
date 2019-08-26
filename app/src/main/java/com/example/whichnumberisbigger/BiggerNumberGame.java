package com.example.whichnumberisbigger;

public class BiggerNumberGame {
    private int number1;
    private int number2;
    private int score;
    private int scoreValue;
    private int upperLimit;
    private int lowerLimit;

    public BiggerNumberGame(int upperLimit, int lowerLimit) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
        scoreValue = 10;
        generateRandomNumbers();
    }

    public void generateRandomNumbers(){
        setNumber1((int)((upperLimit - lowerLimit + 1) * Math.random() + lowerLimit));
        setNumber2((int)((upperLimit - lowerLimit + 1) * Math.random() + lowerLimit));
        while(number1 == number2){
            setNumber2((int)((upperLimit - lowerLimit + 1) * Math.random() + lowerLimit));
        }
    }

    public String checkAnswer(int input){
        if (input == number1 && number1 > number2){
            score += scoreValue;
            return "Well Done!";
        }
        else if (input == number2 && number2 > number1){
            score += scoreValue;
            return "Well Done!";
        }
        else {
            score -= (scoreValue / 2);
            return "Incorrect.";
        }
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
}
