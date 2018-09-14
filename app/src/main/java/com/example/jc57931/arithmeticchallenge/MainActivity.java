package com.example.jc57931.arithmeticchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.content.Intent;

/***********************************************************************
 * Description: This is the controller of the main activity to react
 *              user activities.
 *
 * @author Bruce Gustin
 * @version September 8, 2018 5:30 pm
 ***********************************************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listenForUserInput();
    }

    private void listenForUserInput(){
        // sets asset ids for use in setOnClickListener
        final ImageButton[] operation = {
                findViewById(R.id.imageButton_addition),
                findViewById(R.id.imageButton_subtraction),
                findViewById(R.id.imageButton_multiplication),
                findViewById(R.id.imageButton_division)};
        final Button instructionButton = findViewById(R.id.button_HTP2);
        final Button exitButton = findViewById(R.id.Button_Quit);

        // sets operation strings for use in intent put
        final String operationName[] = {"addition", "subtraction", "multiplication", "division"};


        // listens for clicks to pass intent
        for(int i = 0; i < operation.length; i++) {
            final int operationNum = i; //declared final to pass into inner class
            operation[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), GameActivity.class);
                    intent.putExtra("Operation", operationName[operationNum]);
                    startActivity(intent);
                }
            });
        }

        // listens for button and instruction view clicks
        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instructionButton.setVisibility(View.VISIBLE);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instructionButton.setVisibility(View.INVISIBLE);
            }
        });
    }
}

