package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.models.Restaurant;

import java.util.ArrayList;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    // Define TAG used for debugging purposes
    private static final String TAG = "RestaurantAdapter";

    private int resource;
    private ArrayList<Restaurant> restaurants;
    private Context context;

    // Constructor to assign values the adaptor requires
    // Used for creating the list view items based on a list of Restaurant objects
    public RestaurantAdapter(Context context, int resource, ArrayList<Restaurant> restaurants) {
        super(context, resource, restaurants);
        this.resource = resource;
        this.restaurants = restaurants;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Creates the list view based on input list of restaurants

        View v = convertView;

        try {
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            // Interface elements which will be populated in each list item
            ImageView imageView = v.findViewById(R.id.listItemImageView);
            TextView textViewName = v.findViewById(R.id.listItemNameTextView);
            TextView textViewDetail = v.findViewById(R.id.listItemDetailsTextView);

            // Set the values to be the image and text from the restaurants list
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(restaurants.get(position).getLogoImage(), 0, restaurants.get(position).getLogoImage().length));
            textViewName.setText(restaurants.get(position).getRestaurantName());
            textViewDetail.setText(restaurants.get(position).getRestaurantAddress());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return v;
    }
}