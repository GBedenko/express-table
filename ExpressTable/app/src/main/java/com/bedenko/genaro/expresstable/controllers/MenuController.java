package com.bedenko.genaro.expresstable.controllers;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import com.bedenko.genaro.expresstable.models.Menu;

public class MenuController {

    // Create a Menu object by providing the required parameters
    public Menu createMenu(int aRestaurantID, byte[] aMenuImage) {

        // Create new empty instance of Menu
        Menu menu = new Menu();

        // Populate the instance's attributes with the provided parameters
        menu.setRestaurantID(aRestaurantID);
        menu.setImage(aMenuImage);

        // Return populated Menu object
        return(menu);
    }
}
