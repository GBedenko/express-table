package com.bedenko.genaro.expresstable.views;

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

    CustomerController customerController = new CustomerController();
    RestaurantController restaurantController = new RestaurantController();
    CommonUtils commonUtils = new CommonUtils();
    DatabaseHandler db = new DatabaseHandler(this);

    private static final String TAG = "LoginActivity";

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
        Log.d(TAG, "Account type: " + accountType);

        String username = usernameField.getText().toString();
        String passwordHash = commonUtils.md5Hash(passwordField.getText().toString());

        if(accountType.equals("Customer")) {

            Log.d(TAG, "Customer type account selected");

            Customer loggingInCustomer = new Customer(username, passwordHash);

            boolean loginCorrect = customerController.isCustomerInDB(db, loggingInCustomer);

            if (loginCorrect) {

                Customer currentCustomer = customerController.getCustomerFromDB(db, loggingInCustomer);

                Intent intent = new Intent(LoginActivity.this, CustomerDashboardActivity.class);
                intent.putExtra("customer_id", currentCustomer.getCustomerID());
                intent.putExtra("customer_username", currentCustomer.getUsername());

                startActivityForResult(intent, 1);

            } else {
                Toast.makeText(getApplicationContext(), "Incorrect login credentials. Please check username and password", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }
        } else if(accountType.equals("Restaurant")) {

            Log.d(TAG, "Restaurant type account selected");

            Restaurant loggingInRestaurant = new Restaurant(username, passwordHash);

            boolean loginCorrect = restaurantController.isRestaurantInDB(db, loggingInRestaurant);

            if (loginCorrect) {

                Restaurant currentRestaurant = restaurantController.getRestaurantFromDB(db, loggingInRestaurant);

                Intent intent = new Intent(LoginActivity.this, RestaurantDashboardActivity.class);
                intent.putExtra("restaurant_id", currentRestaurant.getRestaurantID());
                intent.putExtra("restaurant_username", currentRestaurant.getUsername());

                startActivityForResult(intent, 1);

            } else {
                Toast.makeText(getApplicationContext(), "Incorrect login credentials. Please check username and password", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }
        }
    }
}

