package com.bedenko.genaro.expresstable.controllers;

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