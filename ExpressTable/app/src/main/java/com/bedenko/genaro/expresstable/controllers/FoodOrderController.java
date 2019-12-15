package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import com.bedenko.genaro.expresstable.models.FoodOrder;

public class FoodOrderController {

    // Create a FoodOrder object by providing the required parameters
    public FoodOrder createFoodOrder(int aBookingID, String aFoodOrder) {

        // Create new empty instance of FoodOrder
        FoodOrder foodOrder = new FoodOrder();

        // Populate the instance's attributes with the provided parameters
        foodOrder.setBookingID(aBookingID);
        foodOrder.setFoodOrder(aFoodOrder);

        // Return populated FoodOrder object
        return(foodOrder);
    }
}
