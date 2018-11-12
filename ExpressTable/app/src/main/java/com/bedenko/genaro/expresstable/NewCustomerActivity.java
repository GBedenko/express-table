package com.bedenko.genaro.expresstable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.controllers.CustomerController;
import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.utils.CommonUtils;

public class NewCustomerActivity extends AppCompatActivity {

    CommonUtils commonUtils = new CommonUtils();

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

        CustomerController customerController = new CustomerController();
        DatabaseHandler db = new DatabaseHandler(this);

        EditText customerNameField = findViewById(R.id.customerNameField);
        EditText customerUsernameField = findViewById(R.id.customerUsernameField);
        EditText customerEmailField = findViewById(R.id.customerEmailField);
        EditText customerPasswordField = findViewById(R.id.customerPasswordField);

        String customerName = customerNameField.getText().toString();
        String customerUsername = customerUsernameField.getText().toString();
        String customerEmail = customerEmailField.getText().toString();
        String customerPasswordHash = commonUtils.md5Hash(customerPasswordField.getText().toString());

        Customer newCustomer = customerController.createCustomer(customerName, customerUsername, customerEmail, customerPasswordHash);

        customerController.addCustomerToDB(db, newCustomer);
        Toast.makeText(getApplicationContext(),"Customer Account Created", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getBaseContext(), CustomerDashboardActivity.class));
    }
}
