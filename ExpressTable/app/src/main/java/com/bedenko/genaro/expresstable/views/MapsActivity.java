package com.bedenko.genaro.expresstable.views;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.bedenko.genaro.expresstable.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        // Add markers from stored restaurants
        LatLng pizza_hut = new LatLng(52.4082385,-1.5155974);
        mMap.addMarker(new MarkerOptions().position(pizza_hut).title("Pizza Hut"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pizza_hut));
    }
}
