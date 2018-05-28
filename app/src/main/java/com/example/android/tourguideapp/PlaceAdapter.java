package com.example.android.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PlaceAdapter extends ArrayAdapter<Place>{

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context,0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view

        final Place currentPlace = getItem(position);

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TextView nameLocationTextView = (TextView) listItemView.findViewById(R.id.nameTextView);
        nameLocationTextView.setText(currentPlace.getName());

        TextView scheduleLocationTextView = (TextView) listItemView.findViewById(R.id.webTextView);
        scheduleLocationTextView.setText(currentPlace.getWebsite());

        TextView addressLocationTextView = (TextView) listItemView.findViewById(R.id.addressTextView);
        addressLocationTextView.setText(currentPlace.getAddress());

        TextView phoneLocationTextView = (TextView) listItemView.findViewById(R.id.phoneTextView);
        phoneLocationTextView.setText(currentPlace.getPhone());

        ImageView photoLocationImageView = (ImageView) listItemView.findViewById(R.id.photoImageView);
        photoLocationImageView.setImageResource(currentPlace.getImageResourceId());

        return listItemView;
    }
}
