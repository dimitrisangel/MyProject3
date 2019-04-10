package com.example.myproject;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataSource {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    private String[] listsAllColums = {SQLiteHelper.LIST_COLUMN_ID, SQLiteHelper.LIST_COLUMN_NAME};


    public DataSource(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<List> selectAllLists() {
        ArrayList<List> lists = new ArrayList<>();
        Cursor cursor = database.query(SQLiteHelper.LIST_TABLE, listsAllColums, null, null, null, null, null);

        return lists;
    }


}
