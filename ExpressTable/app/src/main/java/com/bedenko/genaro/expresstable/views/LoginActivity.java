package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.CustomerController;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.utils.CommonUtils;

public class LoginActivity extends AppCompatActivity {

    CustomerController customerController = new CustomerController();
    RestaurantController restaurantController = new RestaurantController();
    CommonUtils commonUtils = new CommonUtils();
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button submitLoginButton = findViewById(R.id.submitLoginButton);

        submitLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitLoginButtonClicked();
            }
        });
    }


    private void submitLoginButtonClicked() {

        Spinner accountTypeSpinner = findViewById(R.id.accountTypeSpinner);
        EditText usernameField = findViewById(R.id.usernameField);
        EditText passwordField = findViewById(R.id.passwordField);

        String accountType = accountTypeSpinner.getSelectedItem().toString();
        String username = usernameField.getText().toString();
        String passwordHash = commonUtils.md5Hash(passwordField.getText().toString());

        switch (accountType) {

            case "Customer":

                Customer loggingInCustomer = new Customer(username, passwordHash);

                boolean loginCorrect = customerController.isCustomerInDB(db, loggingInCustomer);

                if(loginCorrect) {
                    startActivity(new Intent(getBaseContext(), CustomerDashboardActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect login credentials. Please check username and password", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBaseContext(), LoginActivity.class));
                }

            case "Restaurant":
//
//                // Query if restaurant details correct
//                Restaurant potentialExistingRestaurant = new Restaurant(username, passwordHash);
//
//                String existingRestaurantUsername = restaurantController.getRestaurantFromDB(db, potentialExistingRestaurant);
//
//                startActivity(new Intent(getBaseContext(), RestaurantDashboardActivity.class));
//
//                if(existingRestaurantUsername.equals(username)) {
//                    Toast.makeText(getApplicationContext(), "Restaurant username already exists.", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getBaseContext(), LoginActivity.class));
//                } else {
//                    startActivity(new Intent(getBaseContext(), RestaurantDashboardActivity.class));
//                }
//                break;
            startActivity(new Intent(getBaseContext(), RestaurantDashboardActivity.class));

            default:
                Toast.makeText(getApplicationContext(), "Something went wrong. Please check field inputs.", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}

