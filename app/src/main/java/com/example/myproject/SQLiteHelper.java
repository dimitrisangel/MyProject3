package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database_db";
    private static final int DATABASE_VERSION = 1;

    public static final String LIST_TABLE = "lists";
    public static final String LIST_COLUMN_ID = "id";
    public static final String LIST_COLUMN_NAME = "name";

    public static final String ITEMS_TABLE = "items";
    public static final String ITEMS_COLUMN_ID = "id";
    public static final String ITEMS_COLUMN_NAME = "name";
    public static final String ITEMS_LIST_ID = "id";
    public static final String ITEMS_QUANTITY = "quantity";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+LIST_TABLE+" (" +
                LIST_COLUMN_ID+" integer primary key autoincrement, " +
                LIST_COLUMN_NAME+" text not null)" );

        db.execSQL("CREATE TABLE "+ITEMS_TABLE+" (" +
                ITEMS_COLUMN_ID+" integer primary key autoincrement, " +
                ITEMS_COLUMN_NAME+" text not null, "+
                ITEMS_LIST_ID+" integer not null, "+
                ITEMS_QUANTITY+" text not null)");

        ContentValues values = new ContentValues();

        values.put(LIST_COLUMN_NAME, "masoutis" );
        db.insert(LIST_TABLE, null, values);






    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
