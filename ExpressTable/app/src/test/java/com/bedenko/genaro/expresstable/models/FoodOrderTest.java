package com.bedenko.genaro.expresstable.models;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class FoodOrderTest {

    @Test
    public void getFoodOrderID() {
        FoodOrder foodOrder = new FoodOrder(1234, 1111, "test food order");
        assertEquals(foodOrder.getFoodOrderID(), 1234);
    }

    @Test
    public void setFoodOrderID() {
        FoodOrder foodOrder = new FoodOrder(1234, 1111, "test food order");
        foodOrder.setFoodOrderID(2222);
        assertEquals(foodOrder.getFoodOrderID(), 2222);
    }

    @Test
    public void getBookingID() {
        FoodOrder foodOrder = new FoodOrder(1234, 1111, "test food order");
        assertEquals(foodOrder.getBookingID(), 1111);
    }

    @Test
    public void setBookingID() {
        FoodOrder foodOrder = new FoodOrder(1234, 1111, "test food order");
        foodOrder.setBookingID(3333);
        assertEquals(foodOrder.getBookingID(), 3333);
    }

    @Test
    public void getFoodOrder() {
        FoodOrder foodOrder = new FoodOrder(1234, 1111, "test food order");
        assertEquals(foodOrder.getFoodOrder(), "test food order");
    }

    @Test
    public void setFoodOrder() {
        FoodOrder foodOrder = new FoodOrder(1234, 1111, "test food order");
        foodOrder.setFoodOrder("new test food order");
        assertEquals(foodOrder.getFoodOrder(), "new test food order");
    }
}