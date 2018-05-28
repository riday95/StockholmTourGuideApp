package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {

    private int placeName;
    private int placeDescription;
    private int placeAddress;
    private int placePhone;
    private int placeWebsite;
    private int placeImageResourceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        final android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent current = getIntent();
        Place places = current.getParcelableExtra("PLACES");

        /*Gets the song info and store in a variable*/
        placeName = places.getName();
        placeAddress = places.getAddress();
        placeDescription = places.getDescription();
        placePhone = places.getPhone();
        placeWebsite = places.getWebsite();
        placeImageResourceID = places.getImageResourceId();

        ImageView imageView = findViewById(R.id.toolbarImage);
        imageView.setImageResource(placeImageResourceID);

        getSupportActionBar().setTitle(placeName);

        TextView textViewDes = findViewById(R.id.placeDes);
        textViewDes.setText(placeDescription);

        TextView textViewPhone = findViewById(R.id.phoneText);
        textViewPhone.setText(placePhone);

        TextView textViewWeb = findViewById(R.id.websiteText);
        textViewWeb.setText(placeWebsite);

        TextView textViewLocation = findViewById(R.id.locationText);

        textViewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + placeAddress);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
