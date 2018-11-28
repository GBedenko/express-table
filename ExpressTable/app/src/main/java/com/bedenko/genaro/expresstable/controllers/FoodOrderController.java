package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.FoodOrder;

public class FoodOrderController {

    public FoodOrder createFoodOrder(int aBookingID, String aFoodOrder) {

        FoodOrder foodOrder = new FoodOrder();

        foodOrder.setBookingID(aBookingID);
        foodOrder.setFoodOrder(aFoodOrder);

        return(foodOrder);
    }
}
