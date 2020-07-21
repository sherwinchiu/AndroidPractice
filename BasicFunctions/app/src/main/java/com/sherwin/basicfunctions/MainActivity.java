package com.sherwin.basicfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.sherwin.basicfunctions.MESSAGE";
    public static final String PLAYER_1 = "com.sherwin.chiu.basicfunctions.P1";
    public static final String PLAYER_2 = "com.sherwin.chiu.basicfunctions.P2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message); // Intent carries on data types called "extra", in this case message and original message
        startActivity(intent);
    }
    public void startGame(View view){
        Intent intent = new Intent(this, MainGameActivity.class);
        EditText player1EditText = (EditText) findViewById(R.id.player1EditText);
        EditText player2EditText = (EditText) findViewById(R.id.player2EditText);
        String player1 = player1EditText.getText().toString();
        String player2 = player2EditText.getText().toString();
        intent.putExtra(PLAYER_1, player1);
        intent.putExtra(PLAYER_2, player2);
        startActivity(intent);
    }
}