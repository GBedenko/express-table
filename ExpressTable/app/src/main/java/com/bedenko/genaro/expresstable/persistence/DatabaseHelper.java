package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bedenko.genaro.expresstable.models.Customer;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "express-table-db.db";
    private static final int DATABASE_VERSION = 1;

    public static final String BOOKINGS_TABLE = "bookings";
    public static final String CUSTOMERS_TABLE = "customers";

    public static final String FLOOR_PLANS_TABLE = "floor_plans";
    public static final String FOOD_ORDERS_TABLE = "food_orders";
    public static final String MENUS_TABLE = "menus";
    public static final String RESTAURANTS_TABLE = "restaurants";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CUSTOMERS_TABLE +" (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                "FIRST_NAME TEXT," +
                "LAST_NAME TEXT," +
                "EMAIL TEXT UNIQUE," +
                "PHONE_NO TEXT," +
                "PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS customers");

        onCreate(db);
    }

    public void addCustomer(Customer customer){

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("name", customer.getName());
        values.put("username", customer.getUsername());
        values.put("email_address", customer.getEmailAddress());
        values.put("password_hash", customer.getPasswordHash());

        // 3. insert
        db.insert(CUSTOMERS_TABLE, null, values);

        db.close();
    }
}