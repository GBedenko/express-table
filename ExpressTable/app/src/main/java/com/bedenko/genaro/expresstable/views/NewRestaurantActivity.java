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

    }

    private void submitRestaurantButtonClicked() {

        EditText restaurantUsernameField = findViewById(R.id.restaurantUsernameField);
        EditText restaurantPasswordField = findViewById(R.id.restaurantPasswordField);
        EditText restaurantNameField = findViewById(R.id.restaurantNameField);

        String restaurantUsername = restaurantUsernameField.getText().toString();
        String restaurantName = restaurantNameField.getText().toString();
        String restaurantPasswordHash = commonUtils.md5Hash(restaurantPasswordField.getText().toString());
        String restaurantGpsLocation = "XXXYYYZZZ";

        Restaurant newRestaurant = restaurantController.createRestaurant(restaurantUsername, restaurantName, restaurantPasswordHash, restaurantGpsLocation);

        restaurantController.addRestaurantToDB(db, newRestaurant);
        Toast.makeText(getApplicationContext(),"Restaurant Account Created", Toast.LENGTH_LONG).show();

        Restaurant currentRestaurant = restaurantController.getRestaurantFromDB(db, newRestaurant);

        Intent intent = new Intent(NewRestaurantActivity.this, RestaurantDashboardActivity.class);
        intent.putExtra("restaurant_id", currentRestaurant.getRestaurantID());
        intent.putExtra("restaurant_username", currentRestaurant.getUsername());

        startActivityForResult(intent, 1);

        startActivity(new Intent(getBaseContext(), RestaurantDashboardActivity.class));
    }
}
