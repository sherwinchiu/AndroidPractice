package com.sherwin.basicfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainGameActivity extends AppCompatActivity {
    final private char LENGTH = 3;
    private char pieces[][] = new char[LENGTH][LENGTH];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
    }
}