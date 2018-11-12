package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
//        SQLiteDatabase db = this.getWritableDatabase();
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
                    "name TEXT," +
                    "username TEXT UNIQUE," +
                    "email_address TEXT UNIQUE," +
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

        db.execSQL("DROP TABLE IF EXISTS customers");

        onCreate(db);
    }

    public void write(String tableName, ContentValues values) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(tableName, null, values);

        db.close();
    }

    public String readOne(String selectQuery) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String record = "";
        if (cursor.moveToFirst())
        {
            do {
                String path=cursor.getString(0);
                record = path;
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return record;
    }

    public int count(String countQuery) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        int count = 0;

        if(cursor.moveToFirst()){
            do {
                count++;
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return count;
    }
}