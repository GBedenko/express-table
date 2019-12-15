package com.bedenko.genaro.expresstable.persistence;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.models.Customer;
import com.bedenko.genaro.expresstable.models.Restaurant;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Define TAG used for debugging purposes
    private static final String TAG = "DatabaseHandler";

    // Define SQLite database name and schema version number
    private static final String DATABASE_NAME = "express-table.db";
    private static final int DATABASE_VERSION = 2;

    // Define table names for the database
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

        // If the app newly installed, create the blank database with the following tables
        db.execSQL("CREATE TABLE " + BOOKINGS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "customer_id INTEGER," +
                    "restaurant_id INTEGER," +
                    "date TEXT," +
                    "time TEXT," +
                    "table_number INTEGER)");

        db.execSQL("CREATE TABLE " + CUSTOMERS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "username TEXT," +
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
                    "username TEXT," +
                    "restaurant_name TEXT," +
                    "password_hash TEXT," +
                    "logo TEXT," +
                    "menu_image TEXT," +
                    "floorplan_image TEXT," +
                    "latitude REAL," +
                    "longitude REAL," +
                    "address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // If the device recognises the schema as different version, delete current one and create new one
        db.execSQL("DROP TABLE IF EXISTS " + BOOKINGS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CUSTOMERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FLOOR_PLANS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_ORDERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MENUS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RESTAURANTS_TABLE);

        onCreate(db);
    }

    // Uses the given table name and values to write a record to SQLite
    public void write(String tableName, ContentValues values) {

        // Get the instance of the database
        SQLiteDatabase db = this.getWritableDatabase();

        // Run an insert statement using the provided values
        db.insert(tableName, null, values);

        // Close db connection
        db.close();
    }

    // Returns an ArrayList of all customers in the customer table
    public ArrayList<Customer> readAllCustomers() {

        // Get the instance of the database
        SQLiteDatabase db = this.getReadableDatabase();

        // Array list which will be populated from the database query
        ArrayList<Customer> customers = new ArrayList<>();

        // Create an SQL query to only select all from the customers table
        Cursor cursor = db.query("customers",
                                null, // columns - null will give all
                                null, // selection
                                null, // selection arguments
                                null, // groupBy
                                null, // having
                                null); // no need or order by for now;

        // While there is a next record in the customers table, read the record
        if (cursor != null) {
            while (cursor.moveToNext()) {
                // Use readCustomer to save the record as a Customer object
                Customer customer = readCustomer(cursor);

                // Append the retrieved Customer object to the array list
                customers.add(customer);
            }
        }

        // Return the populated customers array list
        return customers;
    }

    // Function which takes the current record the cursor is pointed at
    // Returns the field mapped to a Customer object
    private Customer readCustomer(Cursor cursor) {

        // Blank Customer object the record will populate
        Customer customer = new Customer();

        // Assign the id sqlite table column to the customerID attribute
        String customerID = cursor.getString(cursor.getColumnIndex("id"));
        customer.setCustomerID(customerID);

        // Assign the username sqlite table column to the customerUsername attribute
        String customerUsername = cursor.getString(cursor.getColumnIndex("username"));
        customer.setUsername(customerUsername);

        // Assign the password_hash sqlite table column to the customerPasswordHash attribute
        String customerPasswordHash = cursor.getString(cursor.getColumnIndex("password_hash"));
        customer.setPasswordHash(customerPasswordHash);

        // Return the retrieved Customer object
        return customer;
    }

    // Returns an ArrayList of all restaurants in the customer table
    public ArrayList<Restaurant> readAllRestaurants() {

        // Get the instance of the database
        SQLiteDatabase db = this.getReadableDatabase();

        // Array list which will be populated from the database query
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        // Create an SQL query to only select all from the restaurants table
        Cursor cursor = db.query("restaurants",
                null, // columns - null will give all
                null, // selection
                null, // selection arguments
                null, // groupBy
                null, // having
                null); // no need or order by for now;

        // While there is a next record in the restaurants table, read the record
        if (cursor != null) {
            while (cursor.moveToNext()) {
                // Use readRestaurant to save the record as a Customer object
                Restaurant restaurant = readRestaurant(cursor);

                // Append the retrieved Restaurant object to the array list
                restaurants.add(restaurant);
            }
        }

        // Return the populated restaurants array list
        return restaurants;
    }

    // Function which takes the current record the cursor is pointed at
    // Returns the field mapped to a Restaurant object
    private Restaurant readRestaurant(Cursor cursor) {

        // Blank Restaurant object the record will populate
        Restaurant restaurant = new Restaurant();

        // Assign the id sqlite table column to the customerID attribute
        String restaurantID = cursor.getString(cursor.getColumnIndex("id"));
        restaurant.setRestaurantID(restaurantID);

        // Assign the username sqlite table column to the restaurantUsername attribute
        String restaurantUsername = cursor.getString(cursor.getColumnIndex("username"));
        restaurant.setUsername(restaurantUsername);

        // Assign the restaurant_name sqlite table column to the restaurantName attribute
        String restaurantName = cursor.getString(cursor.getColumnIndex("restaurant_name"));
        restaurant.setRestaurantName(restaurantName);

        // Assign the password_hash sqlite table column to the passwordHash attribute
        String restaurantPasswordHash = cursor.getString(cursor.getColumnIndex("password_hash"));
        restaurant.setPasswordHash(restaurantPasswordHash);

        // Assign the logo sqlite table column to the logoImage attribute
        byte[] logoImage = cursor.getBlob(cursor.getColumnIndex("logo"));
        restaurant.setLogoImage(logoImage);

        // Assign the menu_image sqlite table column to the menuImage attribute
        byte[] menuImage = cursor.getBlob(cursor.getColumnIndex("menu_image"));
        restaurant.setMenuImage(menuImage);

        // Assign the floorplan_image sqlite table column to the floorPlanImage attribute
        byte[] floorPlanImage = cursor.getBlob(cursor.getColumnIndex("floorplan_image"));
        restaurant.setFloorPlanImage(floorPlanImage);

        // Assign the latitude sqlite table column to the restaurantLatitude attribute
        double latitude = cursor.getDouble(cursor.getColumnIndex("latitude"));
        restaurant.setRestaurantLatitude(latitude);

        // Assign the longitude sqlite table column to the restaurantLongitude attribute
        double longitude = cursor.getDouble(cursor.getColumnIndex("longitude"));
        restaurant.setRestaurantLongitude(longitude);

        // Assign the address sqlite table column to the restaurantAddress attribute
        String address = cursor.getString(cursor.getColumnIndex("address"));
        restaurant.setRestaurantAddress(address);

        // Return the retrieved Restaurant object
        return restaurant;
    }
}