package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.FoodOrder;

import org.junit.Test;

import static org.junit.Assert.*;

public class FoodOrderControllerTest {

    @Test
    public void createFoodOrder() {

        FoodOrderController foodOrderController = new FoodOrderController();

        FoodOrder testFoodOrder = foodOrderController.createFoodOrder(1234, "test_food_order");
        assertEquals(testFoodOrder.getBookingID(), 1234);
        assertEquals(testFoodOrder.getFoodOrder(), "test_food_order");
    }
}