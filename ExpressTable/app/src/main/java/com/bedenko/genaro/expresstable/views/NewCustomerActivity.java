package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.CustomerController;
import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.utils.CommonUtils;

public class NewCustomerActivity extends AppCompatActivity {

    // Instances of controller and database interaction used for this activity
    CustomerController customerController = new CustomerController();
    CommonUtils commonUtils = new CommonUtils();
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);

        // Retrieve button and link to its logic when it's clicked
        Button submitCustomerDetailsButton = findViewById(R.id.submitCustomerDetailsButton);
        submitCustomerDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitCustomerDetailsButtonClicked();
            }
        });
    }

    private void submitCustomerDetailsButtonClicked() {

        // Retrieve the text fields from the interface
        EditText customerUsernameField = findViewById(R.id.customerUsernameField);
        EditText customerPasswordField = findViewById(R.id.customerPasswordField);

        // Assign the values the user entered
        String customerUsername = customerUsernameField.getText().toString();
        String customerPasswordHash = commonUtils.md5Hash(customerPasswordField.getText().toString());

        // Create a new Customer object from the values the user entered
        Customer newCustomer = customerController.createCustomer(customerUsername, customerPasswordHash);

        // Add the new Customer object to the local sqlite database
        customerController.addCustomerToDB(db, newCustomer);

        // Create a toast to confirm to the user that their account was created
        Toast.makeText(getApplicationContext(),"Customer Account Created", Toast.LENGTH_LONG).show();

        // Retrieve all the details for the new Customer saved in the database (including the customer id)
        Customer currentCustomer = customerController.getCustomerFromDB(db, newCustomer);

        // Intent to go the the Customer Dashboard now that a new customer account has been created
        Intent intent = new Intent(NewCustomerActivity.this, CustomerDashboardActivity.class);

        // Pass the customer id and username with the intent to the next activity
        intent.putExtra("customer_id", currentCustomer.getCustomerID());
        intent.putExtra("customer_username", currentCustomer.getUsername());

        // Start intent
        startActivityForResult(intent, 1);
    }
}
