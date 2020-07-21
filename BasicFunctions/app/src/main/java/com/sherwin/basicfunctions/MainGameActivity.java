package com.sherwin.basicfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainGameActivity extends AppCompatActivity implements View.OnClickListener{
    private final char LENGTH = 3;
    private char moves[][] = new char[LENGTH][LENGTH];
    private static int scores[] = new int[2];
    private static boolean inPlay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        Intent intent = getIntent(); // gets the intend sent to this activity
        String player1Name = intent.getStringExtra(MainActivity.PLAYER_1); // access property of MainActivity that has EXTRA_MESSAGE contained in it
        String player2Name = intent.getStringExtra(MainActivity.PLAYER_2);

        TextView player1TextView = (TextView) findViewById(R.id.player1TextView);
        TextView player2TextView = (TextView) findViewById(R.id.player2TextView);
        player1TextView.setText(player1Name);
        player2TextView.setText(player2Name);
        TextView score1TextView = (TextView) findViewById(R.id.score1TextView);
        TextView score2TextView = (TextView) findViewById(R.id.score2TextView);
        initializeButtons();


        while(inPlay){
            score1TextView.setText(scores[0]);
            score2TextView.setText(scores[1]);

        }
    }
    public void pressButton(View view){

    }
    public void initializeButtons(){
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view.getId() == R.id.button1){
            z
        } else if (view.getId() == R.id.button2){

        } else if (view.getId() == R.id.button3){

        } else if (view.getId() == R.id.button4){

        } else if (view.getId() == R.id.button5){

        } else if (view.getId() == R.id.button6){

        } else if (view.getId() == R.id.button7){

        } else if (view.getId() == R.id.button8){

        } else if (view.getId() == R.id.button9) {

        }
    }
}