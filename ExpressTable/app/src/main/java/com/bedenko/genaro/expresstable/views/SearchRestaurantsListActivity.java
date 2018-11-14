package com.bedenko.genaro.expresstable.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.RestaurantAdapter;
import com.bedenko.genaro.expresstable.models.Restaurant;

import java.util.ArrayList;

public class SearchRestaurantsListActivity extends AppCompatActivity {

    private ListView listView;
    private String[] restaurantNames;
    private String[] restaurantDetails;

    public static int[] restaurantPhotos = {
            R.drawable.nandos,
            R.drawable.pizza_hut,
            R.drawable.zizzi,
            R.drawable.harvester,
            R.drawable.wagamamas,
            R.drawable.cosy_club,
            R.drawable.cosmo,
            R.drawable.yakki_sushi
    };

    private ArrayList<Restaurant> restaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        restaurantNames = getResources().getStringArray(R.array.restaurantNames);
        restaurantDetails = getResources().getStringArray(R.array.restaurantDetails);
        generateRestaurants();

        listView = findViewById(R.id.listViewComplex);
        listView.setAdapter(new RestaurantAdapter(this, R.layout.list_item, restaurants));
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(SearchRestaurantsListActivity.this, ViewRestaurantActivity.class);
                        intent.putExtra("restaurant_name", restaurants.get(position).getRestaurantName());
                        intent.putExtra("restaurant_id", restaurants.get(position).getRestaurantID());
                        startActivityForResult(intent, 1);

//                        Toast.makeText(getBaseContext(), "You clicked " + restaurants.get(position).getRestaurantName(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void generateRestaurants() {

        for (int i = 0; i < restaurantPhotos.length; i++) {
            restaurants.add(new Restaurant(restaurantNames[i], restaurantDetails[i], restaurantPhotos[i]));
        }
    }

}
