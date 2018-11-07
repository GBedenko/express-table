package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bedenko.genaro.expresstable.models.Customer;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "express-table-db.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CUSTOMERS_TABLE = "customers";

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
        db.execSQL("CREATE TABLE " + CUSTOMERS_TABLE + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE," +
                    "name TEXT," +
                    "username TEXT," +
                    "email_address TEXT UNIQUE," +
                    "password_hash TEXT)");
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
}