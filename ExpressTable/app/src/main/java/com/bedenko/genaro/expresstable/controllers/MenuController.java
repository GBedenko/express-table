package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko for 300CEM Android Application Development Assignment
  Student ID 7060234
  @author bedenkog
 */

import com.bedenko.genaro.expresstable.models.Menu;

public class MenuController {

    public Menu createMenu(int aRestaurantID, byte[] aMenuImage) {

        Menu menu = new Menu();

        menu.setRestaurantID(aRestaurantID);
        menu.setImage(aMenuImage);

        return(menu);
    }
}
