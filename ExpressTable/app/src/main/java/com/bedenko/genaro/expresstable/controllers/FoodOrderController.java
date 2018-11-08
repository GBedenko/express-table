package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.FoodOrder;

public class FoodOrderController {

    public FoodOrder createFoodOrder(int aBookingID, String aFoodOrder) {

        FoodOrder foodOrder = new FoodOrder();

        foodOrder.setBookingID(aBookingID);
        foodOrder.setFoodOrder(aFoodOrder);

        return(foodOrder);
    }
}
