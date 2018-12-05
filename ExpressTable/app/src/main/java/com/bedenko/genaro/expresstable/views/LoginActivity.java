package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.CustomerController;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.utils.CommonUtils;

public class LoginActivity extends AppCompatActivity {

    // Instances of controllers to be used by this activity
    CustomerController customerController = new CustomerController();
    RestaurantController restaurantController = new RestaurantController();
    CommonUtils commonUtils = new CommonUtils();
    DatabaseHandler db = new DatabaseHandler(this);

    // Define TAG used for debugging purpose
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Retrieve button and link to the logic when it is clicked
        Button submitLoginButton = findViewById(R.id.submitLoginButton);
        submitLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitLoginButtonClicked();
            }
        });
    }


    private void submitLoginButtonClicked() {

        // Retrieve the interface elements
        Spinner accountTypeSpinner = findViewById(R.id.accountTypeSpinner);
        EditText usernameField = findViewById(R.id.usernameField);
        EditText passwordField = findViewById(R.id.passwordField);

        // Assign the user type depending on the spinner value selected
        String accountType = accountTypeSpinner.getSelectedItem().toString();

        // Log account type to verify which option was selected (and which logic it will proceed with)
        Log.d(TAG, "Account type: " + accountType);

        // Retrieve the user credentials the user entered
        String username = usernameField.getText().toString();
        String passwordHash = commonUtils.md5Hash(passwordField.getText().toString());

        // If the spinner value is customer, proceed to logic to validate their details as a customer
        if(accountType.equals("Customer")) {

            // Log to verify entered this branch of the if statement
            Log.d(TAG, "Customer type account selected");

            // Create a Customer object based on the credentials entered
            Customer loggingInCustomer = new Customer(username, passwordHash);

            // Using the new Customer object, call the controller to verify if these details are in the database
            boolean loginCorrect = customerController.isCustomerInDB(db, loggingInCustomer);

            if (loginCorrect) {
                // If the username and passwordHash are stored in database

                // Retrieve all of this customer's details from the database, including their customer id
                Customer currentCustomer = customerController.getCustomerFromDB(db, loggingInCustomer);

                // Intent to go to Customer Dashboard Activity, because the customer credentials are correct
                Intent intent = new Intent(LoginActivity.this, CustomerDashboardActivity.class);

                // Log to verify the customer id was retrieved from the database
                Log.d(TAG, "intent at login " + currentCustomer.getCustomerID());

                // Pass the customer id and username with the intent to the next activity
                intent.putExtra("customer_id", currentCustomer.getCustomerID());
                intent.putExtra("customer_username", currentCustomer.getUsername());

                // Start intent
                startActivityForResult(intent, 1);

            } else {
                // If username and passwordHash are not in the database, notify the user the credentials are incorrect

                // Create a toast with a useful message stating the username or password was incorrect
                Toast.makeText(getApplicationContext(), "Incorrect login credentials. Please check username and password", Toast.LENGTH_LONG).show();

                // Refresh this activity's interface so they can try their login details again
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }

        } else if(accountType.equals("Restaurant")) {
            // If the spinner value is restaurant, proceed to logic to validate their details as a restaurant

            // Log to verify entered this branch of the if statement
            Log.d(TAG, "Restaurant type account selected");

            // Create a Restaurant object based on the credentials entered
            Restaurant loggingInRestaurant = new Restaurant(username, passwordHash);

            // Using the new Restaurant object, call the controller to verify if these details are in the database
            boolean loginCorrect = restaurantController.isRestaurantInDB(db, loggingInRestaurant);

            if (loginCorrect) {
                // If the username and passwordHash are stored in database

                // Retrieve all of this restaurant's details from the database, including their restaurant id
                Restaurant currentRestaurant = restaurantController.getRestaurantFromDB(db, loggingInRestaurant);

                // Intent to go to Restaurant Dashboard Activity, because the credentials are correct
                Intent intent = new Intent(LoginActivity.this, RestaurantDashboardActivity.class);

                // Pass the restaurant id and username with the intent to the next activity
                intent.putExtra("restaurant_id", currentRestaurant.getRestaurantID());
                intent.putExtra("restaurant_username", currentRestaurant.getUsername());

                // Start intent
                startActivityForResult(intent, 1);

            } else {
                // If username and passwordHash are not in the database, notify the user the credentials are incorrect

                // Create a toast with a useful message stating the username or password was incorrect
                Toast.makeText(getApplicationContext(), "Incorrect login credentials. Please check username and password", Toast.LENGTH_LONG).show();

                // Refresh this activity's interface so they can try their login details again
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }
        }
    }
}

