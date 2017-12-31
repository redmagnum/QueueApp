package com.example.user.queueapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by USER on 12/27/2017.
 */

public class MyCoreDatabase extends SQLiteOpenHelper {

    static final private String DB_NAME = "jantung";
    static final private String DB_TABLE = "dr01";
    static final private int DB_VER = 1;

    Context ctx;
    SQLiteDatabase myDb;

    public MyCoreDatabase (Context ct){
        super(ct,DB_NAME,null,DB_VER);
        ctx=ct;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+DB_TABLE+" (nomor integer primary key autoincrement, nama text, pesan text);");
        Log.i("Database","Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+DB_TABLE);
        onCreate(db);
    }

    public void insertData(String s1, String s2){
        myDb = getWritableDatabase();

        myDb.execSQL("insert into "+DB_TABLE+" (nama,pesan) values('"+s1+"','"+s2+"');");
        Toast.makeText(ctx, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void getAll(){
        myDb = getReadableDatabase();
        Cursor cr = myDb.rawQuery("Select * from "+DB_TABLE,null);
        StringBuilder str = new StringBuilder();

        while(cr.moveToNext()){
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);

            str.append("Nama : "+s1+"\nPesan : "+s2+" \n ----------------- \n");
        }

        Toast.makeText(ctx, str.toString(), Toast.LENGTH_LONG).show();
    }
}
