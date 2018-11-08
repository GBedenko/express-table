package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.Menu;

import java.util.ArrayList;

public class MenuRepo {

    public void addMenuToDB(DatabaseHelper db, Menu menu) {

        ContentValues menuValues = new ContentValues();
        menuValues.put("restaurant_id", menu.getRestaurantID());
        menuValues.put("image", menu.getImage());

        db.write("menus", menuValues);
    }

    public ArrayList<Menu> getAllMenus() {

        ArrayList<Menu> retrievedMenus = new ArrayList<Menu>();

        return retrievedMenus;
    }

    public Menu getMenu(Menu menu) {

        Menu retrievedMenu = new Menu();

        return menu;
    }

    public void updateMenu(Menu menu) {

    }

    public void deleteMenu(Menu menu) {

    }
}
