package com.bedenko.genaro.expresstable.views;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bedenko.genaro.expresstable.R;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve buttons from the interface
        Button createAccountButton = findViewById(R.id.createAccountButton);
        Button loginButton = findViewById(R.id.logInButton);

        // Link create account button to its logic when it is clicked
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccountButtonClicked();
            }
        });

        // Link login button to its logic when it is clicked
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButtonClicked();
            }
        });
    }

    private void createAccountButtonClicked() {

        // Intent to go to choose account activity
        startActivity(new Intent(getBaseContext(), ChooseAccountTypeActivity.class));
    }

    private void loginButtonClicked() {

        // Intent to go to login activity
        startActivity(new Intent(getBaseContext(), LoginActivity.class));
    }
}
