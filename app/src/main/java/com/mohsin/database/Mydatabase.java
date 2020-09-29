package com.mohsin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class Mydatabase extends SQLiteOpenHelper {


    private static final int dbv=1;
    private static final String dbname="mydb";
    Context ct;

            Mydatabase(Context c)
            {
                super(c,dbname,null,dbv);
                ct=c;
            }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Toast.makeText(ct,"in oncreate",Toast.LENGTH_LONG).show();
        String s="create table info (name text,mob integer,email text)";
        db.execSQL(s);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertValues(String toString, long mohsin, String toString1) {
                SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",toString);
        cv.put("mob",mohsin);
        cv.put("email",toString1);
        db.insert("info",null,cv);
        Toast.makeText(ct,"insert complete",Toast.LENGTH_LONG).show();
    }

    public ArrayList<String> showValues() {
                Toast.makeText(ct,"Inside Show values",Toast.LENGTH_LONG).show();
                SQLiteDatabase db=getReadableDatabase();
                String s="select * from info";
        Cursor cr=db.rawQuery(s,null);
        ArrayList<String> a1=new ArrayList<>();
        while (cr.moveToNext())
        {
            String s1=cr.getString(0);
            long l=cr.getLong(1);
            String s2=cr.getString(2);
            String s3="name is :"+s1+"\nMobile no is : "+l+"\n EMail is :"+s2;
            a1.add(s3);
            Log.d("DATABASE", s1+" "+l+""+s2);
        }
      return a1;
    }
}
