package com.bedenko.genaro.expresstable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bedenko.genaro.expresstable.controllers.CustomerController;
import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.persistence.CustomerRepo;
import com.bedenko.genaro.expresstable.persistence.DatabaseHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NewCustomerActivity extends AppCompatActivity {


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
        DatabaseHelper db = new DatabaseHelper(this);

        EditText customerNameField = findViewById(R.id.customerNameField);
        EditText customerUsernameField = findViewById(R.id.customerUsernameField);
        EditText customerEmailField = findViewById(R.id.customerEmailField);
        EditText customerPasswordField = findViewById(R.id.customerPasswordField);

        String customerName = customerNameField.getText().toString();
        String customerUsername = customerUsernameField.getText().toString();
        String customerEmail = customerEmailField.getText().toString();
        String customerPasswordHash = md5HashPassword(customerPasswordField.getText().toString());

        Customer newCustomer = customerController.createCustomer(customerName, customerUsername, customerEmail, customerPasswordHash);

        CustomerRepo customerRepo = new CustomerRepo();

        customerRepo.addCustomerToDB(db, newCustomer);

        startActivity(new Intent(getBaseContext(), CustomerDashboardActivity.class));
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
