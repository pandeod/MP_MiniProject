package com.example.onkarpande.mp_project.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "login.db";
    private static final String TABLE_NAME="userlogin";
    private static final String COL_1="id";
    private static final String COL_2="email";
    private static final String COL_3="password";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable="create table "+TABLE_NAME+"("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_2+" TEXT UNIQUE NOT NULL,"+COL_3+" TEXT NOT NULL )";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTable="drop table if exists "+TABLE_NAME;
        sqLiteDatabase.execSQL(dropTable);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String email,String password)
    {
        if(email!=""&&password!=""&&email!=null&&password!=null) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, email);
            contentValues.put(COL_3, password);
            long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            if (result != -1) {
                return true;
            } else {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean isPresent(String email,String password)
    {
        if(email!=""&&password!=""&&email!=null&&password!=null) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            String[] args = {email, password};
            Cursor res = sqLiteDatabase.query(TABLE_NAME, null, COL_2 + "=? AND " + COL_3 + "=?", args, null, null, null);
            if (res.getCount() != 0) {
                return true;
            } else {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
