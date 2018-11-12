package com.bedenko.genaro.expresstable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.controllers.CustomerController;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.CustomerRepo;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.persistence.RestaurantRepo;
import com.bedenko.genaro.expresstable.utils.CommonUtils;

public class LoginActivity extends AppCompatActivity {

    CommonUtils commonUtils = new CommonUtils();
    CustomerRepo customerRepo = new CustomerRepo();
    RestaurantRepo restaurantRepo = new RestaurantRepo();

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
        startActivity(new Intent(getBaseContext(), CustomerDashboardActivity.class));

        CustomerController customerController = new CustomerController();
        RestaurantController restaurantController = new RestaurantController();

        DatabaseHandler db = new DatabaseHandler(this);

        Spinner accountTypeSpinner = findViewById(R.id.accountTypeSpinner);
        EditText usernameField = findViewById(R.id.usernameField);
        EditText passwordField = findViewById(R.id.passwordField);

        String accountType = accountTypeSpinner.getSelectedItem().toString();
        String username = usernameField.getText().toString();
        String passwordHash = commonUtils.md5Hash(passwordField.getText().toString());

        switch (accountType) {
            case "Customer":
                // Query if customer details correct
                Customer potentialExistingCustomer = new Customer(username, passwordHash);
                customerRepo.getOneCustomer(db, potentialExistingCustomer);
                break;
            case "Restaurant":
                // Query if restaurant details correct
                Restaurant potentialExistingRestaurant = new Restaurant(username, passwordHash);
//                restaurantRepo.getOneCustomer(db, potentialExistingRestaurant);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Something went wrong. Please check field inputs.", Toast.LENGTH_SHORT).show();
                break;
        }

        Toast.makeText(getApplicationContext(),"Customer Account Created", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getBaseContext(), CustomerDashboardActivity.class));
    }
}

