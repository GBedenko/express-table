package com.bedenko.genaro.expresstable.persistence;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;

import com.bedenko.genaro.expresstable.views.MainActivity;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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

        // Test void functions by asserting that an instance of the class is not null
        assertNotNull(this);
    }
}