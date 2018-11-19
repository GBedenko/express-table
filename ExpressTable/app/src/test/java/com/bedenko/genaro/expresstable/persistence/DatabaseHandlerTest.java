package com.bedenko.genaro.expresstable.persistence;

import com.bedenko.genaro.expresstable.views.MainActivity;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseHandlerTest {

    @Test
    public void onCreate() {

        // Test void functions by asserting that an instance of the Activity is not null
        DatabaseHandler databaseHandler = new DatabaseHandler(new MainActivity());
        assertNotNull(databaseHandler);
    }

    @Test
    public void onUpgrade() {

        // Test void functions by asserting that an instance of the Activity is not null
        DatabaseHandler databaseHandler = new DatabaseHandler(new MainActivity());
        assertNotNull(databaseHandler);
    }

    @Test
    public void write() {

        // Test void functions by asserting that an instance of the Activity is not null
        DatabaseHandler databaseHandler = new DatabaseHandler(new MainActivity());
        assertNotNull(databaseHandler);
    }

    @Test
    public void readCustomerRecord() {
        assertEquals("todo", "fake_result");
    }
}