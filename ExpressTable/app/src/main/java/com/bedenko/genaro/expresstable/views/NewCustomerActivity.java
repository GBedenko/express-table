package com.bedenko.genaro.expresstable.views;

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

    CustomerController customerController = new CustomerController();
    CommonUtils commonUtils = new CommonUtils();
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);

        Button submitCustomerDetailsButton = findViewById(R.id.submitCustomerDetailsButton);

        submitCustomerDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitCustomerDetailsButtonClicked();
            }
        });
    }

    private void submitCustomerDetailsButtonClicked() {

        EditText customerUsernameField = findViewById(R.id.customerUsernameField);
        EditText customerPasswordField = findViewById(R.id.customerPasswordField);

        String customerUsername = customerUsernameField.getText().toString();
        String customerPasswordHash = commonUtils.md5Hash(customerPasswordField.getText().toString());

        Customer newCustomer = customerController.createCustomer(customerUsername, customerPasswordHash);

        customerController.addCustomerToDB(db, newCustomer);
//
//        if(existingCustomerUsername.equals(customerUsername)) {
//            Toast.makeText(getApplicationContext(), "Customer username already exists.", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(getBaseContext(), NewCustomerActivity.class));
//        } else {
//            customerController.addCustomerToDB(db, newCustomer);
//            Toast.makeText(getApplicationContext(),"Customer Account Created", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(getBaseContext(), CustomerDashboardActivity.class));
//        }
        startActivity(new Intent(getBaseContext(), CustomerDashboardActivity.class));
    }
}
