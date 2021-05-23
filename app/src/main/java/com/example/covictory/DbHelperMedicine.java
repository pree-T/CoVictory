package com.example.covictory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperMedicine extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CovidResources.db";
    public static final String DATABASE_TABLE = "Medicine";
    public static final String col_state = "State";
    public static final String col_city = "City";
    public static final String col_name = "Name";
    public static final String contact= "Contact";
    public static final String other = "Other";




    public DbHelperMedicine(Context context) {
        super(context,DATABASE_NAME,null,5);

    }





    @SuppressLint("SQLiteString")
    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry="CREATE TABLE " + DATABASE_TABLE + "( " + col_state + " TEXT NOT NULL , " + col_city + " TEXT NOT NULL ," + col_name + " TEXT NOT NULL ," + contact + " TEXT," + other + " TEXT)";

        db.execSQL(qry);


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry="DROP TABLE IF EXISTS "+DATABASE_TABLE;
        db.execSQL(qry);
        onCreate(db);




    }





    public void addNewData() {

        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("delete from "+ DATABASE_TABLE);
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Ankit','JHJXXN','nOTH');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jammu','Srinagar','Anamika','JHJXXN','nOTH');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Asmita','JHJXXN','nOTH');");
        db.close();
        // at last we are closing our
        // database after adding database.



    }
    public Cursor viewData()
    {
        Food food=new Food();

        SQLiteDatabase db=getReadableDatabase();
        String query = "SELECT * FROM "+DATABASE_TABLE ;
        Cursor cursor=db.rawQuery(query,null);
        return cursor;

    }

}
