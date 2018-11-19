package com.bedenko.genaro.expresstable.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void getMenuID() {
        Menu menu = new Menu(1234, 1111 , new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        assertEquals(menu.getMenuID(), 1234);
    }

    @Test
    public void setMenuID() {
        Menu menu = new Menu(1234, 1111 , new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        menu.setMenuID(2222);
        assertEquals(menu.getMenuID(), 2222);
    }

    @Test
    public void getRestaurantID() {
        Menu menu = new Menu(1234, 1111 , new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        assertEquals(menu.getRestaurantID(), 1111);
    }

    @Test
    public void setRestaurantID() {
        Menu menu = new Menu(1234, 1111 , new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        menu.setRestaurantID(3333);
        assertEquals(menu.getRestaurantID(), 3333);
    }

    @Test
    public void getImage() {
        Menu menu = new Menu(1234, 1111 , new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        assertEquals(menu.getImage(), new byte[]{});
    }

    @Test
    public void setImage() {
        Menu menu = new Menu(1234, 1111 , new byte[]{(byte) 204, 29, (byte) 207, (byte) 217});
        menu.setImage(new byte[]{});
        assertEquals(menu.getImage(), new byte[]{});
    }
}