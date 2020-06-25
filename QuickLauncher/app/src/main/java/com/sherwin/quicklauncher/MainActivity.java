package com.sherwin.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Launch activity inside of app
        Button secondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("com.sherwin.quicklauncher.SOMETHING", "HELLO WORLD!");
                startActivity(startIntent);
            }
        });
        // Launch activity outside of app
        Button googleButton = (Button) findViewById(R.id.googleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "http://www.google.ca";
                Uri googleAddress = Uri.parse(google);

                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, googleAddress);
                if(goToGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(goToGoogle);
                }
            }
        });
    }
}