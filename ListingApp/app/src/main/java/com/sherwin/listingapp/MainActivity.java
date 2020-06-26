package com.sherwin.listingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources(); // get resource pact from res, values
        myListView = (ListView) findViewById(R.id.myListView); // init list view from activity_main.xml
        items = res.getStringArray(R.array.items); // get the string array of items from strings.xml and put it into our items array
        prices = res.getStringArray(R.array.prices); // get the string array of prices from strings.xml and put it into our prices array
        descriptions = res.getStringArray(R.array.descriptions); // get the string array of descriptions from strings.xml and put it into our descriptions array

        myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, items)); // set the adapter for list view


    }
}