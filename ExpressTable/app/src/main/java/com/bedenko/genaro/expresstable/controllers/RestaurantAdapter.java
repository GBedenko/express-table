package com.bedenko.genaro.expresstable.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
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

    private int resource;
    private ArrayList<Restaurant> restaurants;
    private Context context;

    public RestaurantAdapter(Context context, int resource, ArrayList<Restaurant> restaurants) {
        super(context, resource, restaurants);
        this.resource = resource;
        this.restaurants = restaurants;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
            TextView textViewDetail = (TextView) v.findViewById(R.id.textViewDetail);

            imageView.setImageResource(restaurants.get(position).getRestaurantPhoto());
            textViewName.setText(restaurants.get(position).getRestaurantName());
            textViewDetail.setText(restaurants.get(position).getRestaurantType());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }
}
