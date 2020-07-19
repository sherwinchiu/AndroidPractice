package com.sherwin.basicfunctions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent(); // gets the intend sent to this activity
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); // access property of MainActivity that has EXTRA_MESSAGE contained in it

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

    }
}