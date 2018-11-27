package com.bedenko.genaro.expresstable.views;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.List;

public class SetRestaurantLocationActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public static int REQUEST_LOCATION = 1;

    protected TextView latitudeTextView;
    protected TextView longitudeTextView;
    protected TextView locationDescription;
    protected Button refreshLocationButton;

    // member variables that hold location info
    protected GoogleApiClient mGoogleApiClient;
    protected Location mLastLocation;
    protected LocationRequest mLocationRequest;
    protected Geocoder mGeocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_restaurant_location);

        latitudeTextView = findViewById((R.id.latitudeText));
        longitudeTextView = findViewById((R.id.longitudeText));
        locationDescription = findViewById(R.id.locationDescription);
        refreshLocationButton = findViewById(R.id.refreshLocationButton);

        latitudeTextView.setText("Latitude not available yet");
        longitudeTextView.setText("Longitude not available yet");
        locationDescription.setText("");

        // GoogleApiClient allows to connect to remote services, the two listeners are the first
        // two interfaces the current class implements
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        refreshLocationButton.setEnabled(mGoogleApiClient.isConnected());

        // LocationReques sets how often etc the app receives location updates
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onConnected(@Nullable Bundle connectionHint) {
        // check if the current app has permission to access location of the device
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            // This ACCESS_COARSE_LOCATION corresponds to permission defined in manifest
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);
        } else {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (mLastLocation != null) {
                latitudeTextView.setText(String.valueOf(mLastLocation.getLatitude()));
                longitudeTextView.setText(String.valueOf(mLastLocation.getLongitude()));
            }

            // the last parameter specify the onLocationChanged listener
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    /*
     * This overriding method overrides ActivityCompat.OnRequestPermissionsResultCallback,
     * basically that is a method inherited.
     * */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_LOCATION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onConnected(null);
            }
        }
    }

    /*
     * Update UI on location change detected.
     * */
    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        latitudeTextView.setText(String.valueOf(mLastLocation.getLatitude()));
        longitudeTextView.setText(String.valueOf(mLastLocation.getLongitude()));
    }

    /*
     * Manually start/stop GoogleApiClient connection. This is for demo purposes only. In real
     * world case you'll want to start/stop in Activity life cyle callbacks. Take a look in here
     * https://developer.android.com/training/location/retrieve-current.html
     * */
    public void onStartClicked(View v) {
        if (!mGoogleApiClient.isConnected()) {
            mGoogleApiClient.connect();
            refreshLocationButton.setEnabled(true);
            locationDescription.setText("GoogleApiClient has started. You can see the location icon in status bar");
        } else {
            mGoogleApiClient.disconnect();
            refreshLocationButton.setEnabled(false);
            locationDescription.setText("GoogleApiClient has stopped. Location icon in status has gone.");
        }
    }

    /*
     * Get the address from the current location, and display back in the app.
     * This is for demo purposes only. In real world case you'll want to implement this in a
     * separate thread so that it won't block your main UI thread.
     * */
    public void onLocateClicked(View v) {
        mGeocoder = new Geocoder(this);
        try {
            // Only 1 address is needed here.
            List<Address> addresses = mGeocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);

            if (addresses.size() == 1) {
                Address address = addresses.get(0);
                StringBuilder addressLines = new StringBuilder();
                //see herehttps://stackoverflow
                // .com/questions/44983507/android-getmaxaddresslineindex-returns-0-for-line-1
                if (address.getMaxAddressLineIndex() > 0) {
                    for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                        addressLines.append(address.getAddressLine(i) + "\n");
                    }
                } else {
                    addressLines.append(address.getAddressLine(0));
                }
                locationDescription.setText(addressLines);
            } else {
                locationDescription.setText("WARNING! Geocoder returned more than 1 addresses!");
            }
        } catch (Exception e) {
            locationDescription.setText("WARNING! Geocoder.getFromLocation() didn't work!");
        }
    }
}
