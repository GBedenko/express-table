package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.FoodOrder;

import java.util.ArrayList;

public class FoodOrderRepo {

    public void addFoodOrderToDB(DatabaseHelper db, FoodOrder foodOrder) {

        ContentValues foodOrderValues = new ContentValues();
        foodOrderValues.put("booking_id", foodOrder.getBookingID());
        foodOrderValues.put("food_order", foodOrder.getFoodOrder());

        db.write("foodOrders", foodOrderValues);
    }

    public ArrayList<FoodOrder> getAllFoodOrders() {

        ArrayList<FoodOrder> retrievedFoodOrders = new ArrayList<>();

        return retrievedFoodOrders;
    }

    public FoodOrder getFoodOrder(FoodOrder foodOrder) {

        FoodOrder retrievedFoodOrder = new FoodOrder();

        return retrievedFoodOrder;
    }

    public void updateFoodOrder(FoodOrder foodOrder) {

    }

    public void deleteFoodOrder(FoodOrder foodOrder) {

    }
}
