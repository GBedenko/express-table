package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    RestaurantController restaurantController = new RestaurantController();
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Retrieve all restaurants from the database
        ArrayList<Restaurant> restaurants = restaurantController.getAllRestaurantsFromDB(db);

        // For each restaurant, add a marker on the map for its location
        for(int i=0; i <= restaurants.size()-1; i++) {

            // Create a LatLng object based on the restaurant's coordinates
            LatLng restaurantLocation = new LatLng(restaurants.get(i).getRestaurantLatitude(), restaurants.get(i).getRestaurantLongitude());

            // Add a marker with the coordinates and the restaurant's name
            mMap.addMarker(new MarkerOptions().position(restaurantLocation).title(restaurants.get(i).getRestaurantName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurantLocation));
        }
    }
}
