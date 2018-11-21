package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "express-table.db";
    private static final int DATABASE_VERSION = 1;

    private static final String BOOKINGS_TABLE = "bookings";
    private static final String CUSTOMERS_TABLE = "customers";
    private static final String FLOOR_PLANS_TABLE = "floor_plans";
    private static final String FOOD_ORDERS_TABLE = "food_orders";
    private static final String MENUS_TABLE = "menus";
    private static final String RESTAURANTS_TABLE = "restaurants";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + BOOKINGS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "customer_id INTEGER," +
                    "restaurant_id INTEGER," +
                    "date TEXT," +
                    "time TEXT," +
                    "table_number INTEGER)");

        db.execSQL("CREATE TABLE " + CUSTOMERS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "username TEXT UNIQUE," +
                    "password_hash TEXT)");

        db.execSQL("CREATE TABLE " + FLOOR_PLANS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "restaurant_id INTEGER," +
                    "image TEXT)");

        db.execSQL("CREATE TABLE " + FOOD_ORDERS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "booking_id INTEGER," +
                    "food_order TEXT)");

        db.execSQL("CREATE TABLE " + MENUS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "restaurant_id INTEGER," +
                    "image TEXT)");

        db.execSQL("CREATE TABLE " + RESTAURANTS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "username TEXT UNIQUE," +
                    "restaurant_name TEXT," +
                    "email_address TEXT UNIQUE," +
                    "password_hash TEXT," +
                    "gps_location TEXT," +
                    "postcode TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + BOOKINGS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CUSTOMERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FLOOR_PLANS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_ORDERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MENUS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RESTAURANTS_TABLE);

        onCreate(db);
    }

    public void write(String tableName, ContentValues values) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(tableName, null, values);

        db.close();
    }

    public ArrayList<Customer> readAllCustomers() {

        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Customer> customers = new ArrayList<>();

        Cursor cursor = db.query("customers",
                                null, // columns - null will give all
                                null, // selection
                                null, // selection arguments
                                null, // groupBy
                                null, // having
                                null); // no need or order by for now;

        if (cursor != null) {
            while (cursor.moveToNext()) {
                // move the cursor to next row if there is any to read it's data
                Customer customer = readCustomer(cursor);
                customers.add(customer);
            }
        }

        return customers;
    }

    private Customer readCustomer(Cursor cursor) {

        Customer customer = new Customer();

        int customerID = cursor.getInt(cursor.getColumnIndex("id"));
        customer.setCustomerID(customerID);

        String customerUsername = cursor.getString(cursor.getColumnIndex("username"));
        customer.setUsername(customerUsername);

        String customerPasswordHash = cursor.getString(cursor.getColumnIndex("password_hash"));
        customer.setPasswordHash(customerPasswordHash);

        return customer;
    }

    public ArrayList<Restaurant> readAllRestaurants() {

        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Restaurant> restaurants = new ArrayList<>();

        Cursor cursor = db.query("restaurants",
                null, // columns - null will give all
                null, // selection
                null, // selection arguments
                null, // groupBy
                null, // having
                null); // no need or order by for now;

        if (cursor != null) {
            while (cursor.moveToNext()) {
                // move the cursor to next row if there is any to read it's data
                Restaurant restaurant = readRestaurant(cursor);
                restaurants.add(restaurant);
            }
        }

        return restaurants;
    }

    private Restaurant readRestaurant(Cursor cursor) {

        Restaurant restaurant = new Restaurant();

        int restaurantID = cursor.getInt(cursor.getColumnIndex("id"));
        restaurant.setRestaurantID(restaurantID);

        String restaurantUsername = cursor.getString(cursor.getColumnIndex("username"));
        restaurant.setUsername(restaurantUsername);

        String restaurantPasswordHash = cursor.getString(cursor.getColumnIndex("password_hash"));
        restaurant.setPasswordHash(restaurantPasswordHash);

        return restaurant;
    }
}