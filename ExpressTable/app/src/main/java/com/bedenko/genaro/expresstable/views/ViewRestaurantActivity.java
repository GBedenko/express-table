package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

public class ViewRestaurantActivity extends AppCompatActivity {

    String restaurantIDBeingViewed;
    String restaurantNameBeingViewed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);

        Intent intent = getIntent();
        setRestaurantNameBeingViewed(intent.getStringExtra("restaurant_name"));
        setRestaurantIDBeingViewed(intent.getStringExtra("restaurant_id"));
        TextView textView = findViewById(R.id.viewingRestaurantName);
        textView.setText(getRestaurantNameBeingViewed());

        Button bookThisRestaurantButton = findViewById(R.id.bookThisRestaurantButton);

        bookThisRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookThisRestaurantButtonClicked();
            }
        });
    }

    private void bookThisRestaurantButtonClicked() {
        TextView restaurantTheyClicked = findViewById(R.id.viewingRestaurantName);

        Intent intent = new Intent(ViewRestaurantActivity.this, BookRestaurantActivity.class);
        intent.putExtra("restaurant_name", getRestaurantNameBeingViewed());
        intent.putExtra("restaurant_id", getRestaurantIDBeingViewed());

        startActivityForResult(intent, 1);
    }

    public String getRestaurantIDBeingViewed() {
        return restaurantIDBeingViewed;
    }

    public void setRestaurantIDBeingViewed(String restaurantIDBeingViewed) {
        this.restaurantIDBeingViewed = restaurantIDBeingViewed;
    }

    public String getRestaurantNameBeingViewed() {
        return restaurantNameBeingViewed;
    }

    public void setRestaurantNameBeingViewed(String restaurantNameBeingViewed) {
        this.restaurantNameBeingViewed = restaurantNameBeingViewed;
    }
}
