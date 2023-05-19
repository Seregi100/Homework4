package com.mirea.kt.homework4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class MyAppSQLiteHelper extends SQLiteOpenHelper{

    public MyAppSQLiteHelper(@Nullable Context c, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory f, int version) {
        super(c, name, f, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + "TABLE_CARS" + " (" + "_id integer primary key autoincrement," + "model text," + "number text," + "age integer" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}