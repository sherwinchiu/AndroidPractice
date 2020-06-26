package com.sherwin.listingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

// adaptor is bridge between UI and data source
public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater; // creates XML file in view objects, never directly use
    // used to define the row layout
    // read the XML file that describes layout, and create objects
    String[] items;
    String[] prices;
    String[] descriptions;
    // Context is "Handle to system"?
    /*
    Context is abstract class that provides services like resolves resources, obtaining access to data base
    Adaptor is to bridge the data and UI source
    Inflater is then used to copy the layout of a XML file and continue it
    So what we're doing here is getting a string (Context.LAYOUT_INFLATOR_SERVICE is a constant)
    and then use that string to get the system service (which will be an object of what
    the layout is by giving us the preferences of layout and then we cast it to become another
    layout inflater.*/
    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
        this.items = i;
        this.prices = p;
        this.descriptions = d;
        this.mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

        nameTextView.setText(items[i]);
        descriptionTextView.setText(descriptions[i]);
        priceTextView.setText(prices[i]);

        return v;
    }
}
