package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.Menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuControllerTest {

    @Test
    public void createMenu() {

        MenuController menuController = new MenuController();

        Menu testMenu = menuController.createMenu(1234, new byte[]{});
        assertEquals(testMenu.getRestaurantID(), 1234);
    }
}