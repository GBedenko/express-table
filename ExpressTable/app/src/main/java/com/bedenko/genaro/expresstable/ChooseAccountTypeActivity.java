package com.bedenko.genaro.expresstable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChooseAccountTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account_type);

        final Button nextButton = findViewById(R.id.nextFromChooseAccountTypeButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                // Retrieve the radio group object from the UI
//                RadioGroup accountTypeRadioGroup = findViewById(R.id.chooseAccountRadioGroup);
//
//                // Save the chosen radio button option as a string
//                String accountTypeChosen = findViewById(accountTypeRadioGroup.getCheckedRadioButtonId())
//
//                // Depending on which radio button was chosen, go to the corresponding next screen
//                switch (accountTypeChosen) {
//                    case "I am a Customer":
//                        // TODO
//                    case "I am a Restaurant":
//                        // TODO
//                    default:
//                        // TODO
//                }
                startActivity(new Intent(getBaseContext(), NewRestaurantActivity.class));
            }
        });
    }
}
