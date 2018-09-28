package com.example.jc57931.arithmeticchallenge;

import java.util.Random;

public abstract class ArithmeticChallenge {

    private int[] mChoices = new int[3];

    private String mQuestionText;
    private long mStartTime;

    public ArithmeticChallenge(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        // to be implemented
    }

    /******************************************************
     * Abstract Classes
     ******************************************************/

    // abstract methods declared here;

    /******************************************************
     * Getters and Setters
     ******************************************************/


    private int first,second;

    protected abstract String createQuestion();

    protected abstract int[] createChoices();

    protected void setQuestionText (String Question){
        mQuestionText = Question;
    }

    protected String getQuestionText(){
        return mQuestionText;
    }

    protected String getChoice (int index){
        return Integer.toString(mChoices[index]);
    }

    protected void setChoices(int[] choices) {
        mChoices = choices;
        shuffleChoices(choices);
        mStartTime = System.currentTimeMillis();
    }

    // other getters and setters declared and implemented here

    /******************************************************
     * Concrete Classes
     ******************************************************/

    protected boolean isCorrect(int choice){
        // to be implemented
        return true;
    }


    private void shuffleChoices(int[] choices) {
        int index;
        Random random = new Random();
        for (int i = choices.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                choices[index] ^= choices[i];
                choices[i] ^= choices[index];
                choices[index] ^= choices[i];
            }
        }
    }
}
