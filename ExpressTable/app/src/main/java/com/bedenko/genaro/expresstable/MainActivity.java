package com.bedenko.genaro.expresstable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCreateAccountButtonClick(View view) {
        startActivity(new Intent(getBaseContext(), ChooseAccountTypeActivity.class));
    }

    public void onLogInButtonClick(View view) {
    }
}
