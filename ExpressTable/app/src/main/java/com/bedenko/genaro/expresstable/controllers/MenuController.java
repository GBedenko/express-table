package com.bedenko.genaro.expresstable.controllers;

import com.bedenko.genaro.expresstable.models.Menu;

public class MenuController {

    public Menu createMenu(int aRestaurantID, byte[] aMenuImage) {

        Menu menu = new Menu();

        menu.setRestaurantID(aRestaurantID);
        menu.setImage(aMenuImage);

        return(menu);
    }
}
