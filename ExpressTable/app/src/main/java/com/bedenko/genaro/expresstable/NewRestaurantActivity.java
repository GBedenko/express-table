package com.bedenko.genaro.expresstable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.controllers.CustomerController;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.utils.CommonUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NewRestaurantActivity extends AppCompatActivity {

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

    }

    private void submitRestaurantButtonClicked() {

        RestaurantController restaurantController = new RestaurantController();
        DatabaseHandler db = new DatabaseHandler(this);

        EditText restaurantUsernameField = findViewById(R.id.restaurantUsernameField);
        EditText restaurantEmailField = findViewById(R.id.restaurantEmailField);
        EditText restaurantPasswordField = findViewById(R.id.restaurantPasswordField);
        EditText restaurantNameField = findViewById(R.id.restaurantNameField);
        EditText restaurantPostcodeField = findViewById(R.id.restaurantPostcodeField);

        String restaurantUsername = restaurantUsernameField.getText().toString();
        String restaurantEmail = restaurantEmailField.getText().toString();
        String restaurantPasswordHash = commonUtils.md5Hash(restaurantPasswordField.getText().toString());
        String restaurantName = restaurantNameField.getText().toString();
        String restaurantPostcode = restaurantPostcodeField.getText().toString();
        String restaurantGpsLocation = "XXXYYYZZZ";

        Restaurant newRestaurant = restaurantController.createRestaurant(restaurantUsername, restaurantEmail, restaurantPasswordHash,
                                                                         restaurantName, restaurantPostcode, restaurantGpsLocation);

        restaurantController.addRestaurantToDB(db, newRestaurant);
        Toast.makeText(getApplicationContext(),"Restaurant Account Created", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getBaseContext(), RestaurantDashboardActivity.class));
    }
}
