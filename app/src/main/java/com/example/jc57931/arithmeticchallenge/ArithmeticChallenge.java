package com.example.jc57931.arithmeticchallenge;

import java.util.Random;

public abstract class ArithmeticChallenge {

    private int[] mChoices = new int[3];

    private String mQuestionText;
    private long mStartTime;
    private long mEndTime;
    private int cCorrect;
    private int mHighScore;
    private int mProgress;
    private int mCorrectAnswer;

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
    protected void setQuestionText (String Question)
    {
        mQuestionText = Question;
    }
    protected String getQuestionText()
    {
        return mQuestionText;
    }
    protected String getChoice (int index)
    {
        return Integer.toString(mChoices[index]);
    }
    protected void setChoices(int[] choices)
    {
        mChoices = choices;
        mCorrectAnswer = choices[2];
        mStartTime = System.currentTimeMillis();
        shuffleChoices(choices);
    }

    protected void setHighScore(int HighScore)
    {
        mHighScore = HighScore;
    }

    protected int getHighScore()
    {
        return mHighScore;
    }

    protected void setScore (boolean isCorrect)
    {
        if(isCorrect)
        {
            mEndTime = System.currentTimeMillis();
            cCorrect += 100-(int)mEndTime%(int)mStartTime/1000;
        }
        else
            {
                cCorrect--;
            }
    }

    protected int getScore()
    {
        return cCorrect;
    }


    protected void setProgress(boolean isCorrect)
    {
       if(isCorrect)
       {
           mProgress ++;
       }
       else
       {
           mProgress--;
       }
    }

    protected int getProgress()
    {
        return mProgress;
    }

    // other getters and setters declared and implemented here

    /******************************************************
     * Concrete Classes
     ******************************************************/

    protected boolean isCorrect(int choice){
        return (mCorrectAnswer == mChoices[choice]);
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
