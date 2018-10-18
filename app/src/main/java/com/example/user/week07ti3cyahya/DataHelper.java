package com.example.user.week07ti3cyahya;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 15/10/2018.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tbl_user (id integer primary key, nama text null, " +
                "username text null, password text null);";
        Log.d("Data","onCreate : "+sql);
        db.execSQL(sql);

        sql = "INSERT INTO tbl_user (nama,username,password) " +
                "VALUES ('Yahya Pradika','yahuya','password');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
