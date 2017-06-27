package me.andrewhanselee.stayproductive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Andrew on 2017-06-23.
 */

public class dataOperations extends SQLiteOpenHelper{
    public static final int database_ver = 1;
    public String createQuery = "CREATE TABLE " + dataTable.tableInfo.Table + "("
            + dataTable.tableInfo.USER_ID + " TEXT," + dataTable.tableInfo.USER_FAIL + " TEXT," + dataTable.tableInfo.USER_SUC + " TEXT);";

    public dataOperations(Context context){

        super(context, dataTable.tableInfo.Database, null, database_ver);
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(createQuery);
        Log.d("Database operations", "Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int agr1, int arg2){

    }

    public void addData(dataOperations DO, String name, String succ, String fail){

        SQLiteDatabase dbase = DO.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(dataTable.tableInfo.USER_ID, name);
        cv.put(dataTable.tableInfo.USER_SUC, succ);
        cv.put(dataTable.tableInfo.USER_FAIL, fail);

        long val = dbase.insert(dataTable.tableInfo.Table, null, cv);
        Log.d("Database operations", " Inserted");

    }

    public static Cursor getInfo(dataOperations DO){

        SQLiteDatabase sqDB = DO.getReadableDatabase();
        String[] columns = {dataTable.tableInfo.USER_ID, dataTable.tableInfo.USER_SUC, dataTable.tableInfo.USER_FAIL};
        Cursor cr = sqDB.query(dataTable.tableInfo.Table, columns, null, null, null, null, null);
        return cr;
    }

    public void updateInfo(dataOperations DO, String username, String complete, String fail){
        SQLiteDatabase dbase = DO.getWritableDatabase();
        String[] args = {username};
        ContentValues cv = new ContentValues();
        Log.d("Database operations", "Updated values");
        cv.put(dataTable.tableInfo.USER_ID, "bob");
        cv.put(dataTable.tableInfo.USER_SUC, complete);
        cv.put(dataTable.tableInfo.USER_FAIL, fail);
        dbase.update(dataTable.tableInfo.Table, cv, "USER_ID = ?" , args);
    }

}
