package com.example.jc57931.arithmeticchallenge;

import java.util.Random;

//Jane Casto
//24 September 2018
//6th Period

// Bounds 1-14 because it is the basis of the 5th grade multiplication table (12) plus two extras,
// which I liked using purely because it will be more challenging for the intended age range.
// Choices were based on things that would confuse children, like switching up the operator, but
// also that look similar in size etc. Quite often in this code, there is one that can be eliminated
// easily, but there are others that are more difficult to spot to those who don't know the answer.
//-----------------------------------------------------------------------------------

public class Multiplication extends ArithmeticChallenge {

    private int first,second;
    private int choices[] = new int[2];


    public Multiplication (int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        super(TOTAL_LEVELS, TURNS_PER_LEVEL);
    }

    protected String createQuestion(){
        Random rand = new Random();
        first = rand.nextInt(13)+1;
        second = rand.nextInt(13)+1;


        String question = Integer.toString(first) + " * " + Integer.toString(second);
        return question;
    }

    protected int[] createChoices(){
        Random rand = new Random();
        int[] choices = new int[3];

        if (first>second && second>1) {
            choices[0] = first / second;

        }else if (first == 1 || second == 1) {
            choices[0] = first * second * 5;
        }else if (first == 11 && second ==1){
            choices [0] = first + second + 6;
        }else{
            choices[0] = first*second*2;
        }

        choices[1] = first+second;
        choices[2] = first*second;
        return choices;
    }
}













