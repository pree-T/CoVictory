package com.example.covictory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperMedicine extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CovidResources2.db";
    public static final String DATABASE_TABLE = "Medicine";
    public static final String col_state = "State";
    public static final String col_city = "City";
    public static final String col_name = "Name";
    public static final String contact= "Contact";
    public static final String other = "Other";




    public DbHelperMedicine(Context context) {
        super(context,DATABASE_NAME,null,6);

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
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Healthmate Pharma','09835163314','Fabi Flu in Sakchi');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Apex Enterprises','08699450001,08969450001','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','New Patodi Marketing','06512229929','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Shambhu Medical','0887705955','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Sushruta Hospital Solutions','09040772232','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Easy Medik','07004997026','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Bokaro','KM Memorial Hospital','09835769110','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Bokaro','Wellmark Hospital','07488155036','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Bokaro','Bharat Medical Hall','06542231005','Fabi Flu');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Bokaro','Amit Singh','09204703703','Remdicivir in Cooperative and Colony ');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Bokaro','Sai Kripa Medical','07004373706','Sector 4');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Shipra Sinha','09155144344','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Shree Salasar Balaji Agency','09709300131','Remdicivir in Ashok Rajput');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','K.V.D Agencies','06122301980','Remdicivir Govind Mitra Road');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Kesar Vaccine Distributors','06122301463','Remdicivir Govind Mitra Road ');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Hrsh Raj','07783059638','in Kankarbag');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Gomes Adeline','09831041904','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Harsh','8084440834','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Manjit Singh','9804455124','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Niraj Thakur','9830328500','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Prateek','6289252238','');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Bankura','Jayanto Chowdhary','9434101421','');");
        db.close();


        // at last we are closing our
        // database after adding database.



    }
    public Cursor viewData()
    {
        Medicine medicine=new Medicine();

        SQLiteDatabase db=getReadableDatabase();
        String query = "SELECT * FROM "+DATABASE_TABLE ;
        Cursor cursor=db.rawQuery(query,null);
        return cursor;

    }

}
