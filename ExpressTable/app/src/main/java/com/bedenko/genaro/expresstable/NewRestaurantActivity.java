package com.bedenko.genaro.expresstable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.persistence.RestaurantRepo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NewRestaurantActivity extends AppCompatActivity {

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
        String restaurantPasswordHash = md5HashPassword(restaurantPasswordField.getText().toString());
        String restaurantName = restaurantNameField.getText().toString();
        String restaurantPostcode = restaurantPostcodeField.getText().toString();
        String restaurantGpsLocation = "XXXYYYZZZ";

        Restaurant newRestaurant = restaurantController.createRestaurant(restaurantUsername, restaurantEmail, restaurantPasswordHash,
                                                                         restaurantName, restaurantPostcode, restaurantGpsLocation);

        RestaurantRepo restaurantRepo = new RestaurantRepo();

        restaurantRepo.addRestaurantToDB(db, newRestaurant);

        startActivity(new Intent(getBaseContext(), RestaurantDashboardActivity.class));
    }

    private String md5HashPassword(String password) {

        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();

            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
