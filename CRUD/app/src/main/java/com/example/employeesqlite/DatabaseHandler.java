package com.example.employeesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHandler extends SQLiteOpenHelper {
    public static  final String Database = "employee";
    public static  final String name = "NAME";
    public static  final String surname = "SURNAME";

    public DatabaseHandler(Context context){
        super(context,Database,null,12);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE emp (" + name + " TEXT, " + surname + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS emp");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String n, String sn) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name, n);
        contentValues.put(surname, sn);
        long result = db.insert("emp", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean updateData(String n, String sn) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name, n);
        contentValues.put(surname, sn);
        db.update("emp", contentValues,"NAME=?",new String[]{n});
        return true;
    }
    public Integer deleteData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("emp","NAME=?",new String[]{name});
    }

    public Cursor getListContents(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM emp",null);
        return cursor;
    }
}
