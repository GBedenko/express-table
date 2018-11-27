package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.utils.CommonUtils;

public class NewRestaurantActivity extends AppCompatActivity {

    RestaurantController restaurantController = new RestaurantController();
    DatabaseHandler db = new DatabaseHandler(this);
    CommonUtils commonUtils = new CommonUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_restaurant);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        Button submitRestaurantButton = findViewById(R.id.submitRestaurantButton);

        submitRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRestaurantButtonClicked();
            }
        });

        Button setRestaurantLocationButton = findViewById(R.id.enterGpsLocation);

        setRestaurantLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRestaurantLocationButtonClicked();
            }
        });

    }

    private void setRestaurantLocationButtonClicked() {

        startActivity(new Intent(getBaseContext(), SetRestaurantLocationActivity.class));
    }

    private void submitRestaurantButtonClicked() {

        EditText restaurantUsernameField = findViewById(R.id.restaurantUsernameField);
        EditText restaurantPasswordField = findViewById(R.id.restaurantPasswordField);
        EditText restaurantNameField = findViewById(R.id.restaurantNameField);

        String restaurantUsername = restaurantUsernameField.getText().toString();
        String restaurantName = restaurantNameField.getText().toString();
        String restaurantPasswordHash = commonUtils.md5Hash(restaurantPasswordField.getText().toString());
        double restaurantLatitude = 52.4082385;
        double restaurantLongitude = -1.5155974;

        Restaurant newRestaurant = restaurantController.createRestaurant(restaurantUsername, restaurantName, restaurantPasswordHash, restaurantLatitude, restaurantLongitude);

        restaurantController.addRestaurantToDB(db, newRestaurant);
        Toast.makeText(getApplicationContext(),"Restaurant Account Created", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getBaseContext(), RestaurantDashboardActivity.class));
    }
}
