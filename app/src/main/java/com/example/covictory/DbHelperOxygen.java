package com.example.covictory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperOxygen extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CovidResources1.db";
    public static final String DATABASE_TABLE = "Oxygen";
    public static final String col_state = "State";
    public static final String col_city = "City";
    public static final String col_name = "Name";
    public static final String contact= "Contact";
    public static final String other = "Other";




    public DbHelperOxygen(Context context) {
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
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Ankit','09113110823','Only Cylinder,no refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Oxygen Bank','09431109590','Both cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Marwari Yuva Manch','09470567187','Both cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Chemi Equip Kamani Centre','09431133341','Can,Cylinder and Concentrator');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Chemi Equip Kamani Centre','09431133341','Can,Cylinder and Concentrator only in Bistupur');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Jamshedpur','Saiful Beg','09155200850','Cylinder and refill services in Golmuri');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Aashutosh Singh','09472715479','Can,Cylinder and refill services ');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Aaskshmik Oxygen Seva','09431105899  ','Cylinder services ');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Abhijeet','08092448086','Can');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','ABVP','09709833671  ,0849577669 ','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Akash','08409973908  ','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Aman','09162402852   ','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Amir Gas Agency','06207148520','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Ranchi','Amit Choudhury','09431105899,07008902193','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Dhanbad','Marwari Youth Brigade','09431122624','Can,Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Dhanbad','Bhagwat Jaiswal','07004181581','Cylinder and refill services in Giridih');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Dhanbad','Jaychand','0629903335','Can,Cylinder,Concentrator & Regulator and refill services in Govindpur');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Dhanbad','JJ Enterprises','09234686100,07808421777','Can,Cylinder and refill services in Joraphatak' );");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Dhanbad','Mohit Gaddyan','07903113388','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Jharkhand','Bokaro','Maa Enterprises','09334744569','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Asansoal','Ayan Ghosh','06297311884','Concentrator and refill services in Hetton Road');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Asansoal','Desai Healthcare','09732004000','Can,Cylinder & Concentrator and refill services in Murgasol');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Baranagar','Argha Das','09836958081  ','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Baranagar','Desbandhu Club','09903670709','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Berhampore','Bapi','09434364512','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Durgapur','Rahul','09748847715','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Durgapur','WBHelpCovid','09832426365','Can,Concentrator Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Durgapur','Indrajit Bose','09564884217','Can and refill services in NB Lane');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Desai Healthcare','09732004000','Can,Concentrator & Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','G. S. Agarwala','09434051222','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Garia- Jadavpur Local Committee','08777480193','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Health and Human Foundation','08240337543','Concentrator & Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Indigenous','03340004704,09874606744','Concentrator services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','Khalid Iqbal','09831272902,09051832211,09002534659,07003734910,09163255142','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Kolkata','KP Gas Trading','06290062623','Can,Concentrator & Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Krishnanagar','Rajib','0943415986','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Krishnanagar','Mou','07797754930','Cylinder and  refill services in Naria');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','North 24 Parganas','Rajkumar Chatterjee','08509737721','Cylinder and refill services in Baranagar');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','North 24 Parganas','Surya Shekhar Chatterjee','09748310901','Cans services in Barrackpore');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','North 24 Parganas','Kunal Chakroborty','09330711109','Cylinder and services in Shyamnagar');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Purulia','Pase Ache Purulia','06289160044','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Purulia','Gaurav Singh','08016894973','Concentrator and Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Siliguri','Jibandeep','09874118925','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Siliguri','Lions Club of Siliguri','09434006923','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Siliguri','Shadab Masoom','07003790794','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('WestBengal','Siliguri','Pintu Acharya','09434075330','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Begusarai','Manik Singh','08447318992','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Begusarai','Sai Oxygen','09798990824','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Bettiah','Shatrugan Agrawal','09308319513,09262985555,07004092184','Cylinder and refill services in Lal Bihar');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Bhagalpur','Abhishek Dalmia','09431090292','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Bhagalpur','Ankit','06206071156','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Bhagalpur','Rahul','07079340001','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Bhagalpur','Sanjay Agarwal','09334009282','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Buxar','Pathak Gas Agency','07301873706','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Champaran','Bablu Dubey','06200408288','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Champaran','Bravo Oxygen Bank','07004493764','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Darbhanga','Kalpana Agency','08797276605','Cylinder and refill services in Bhathiarisarai');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Darbhanga','Megha Traders','09905267363,09470088350','Only refill services in Rahamganj');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Gaya','Faiyaz Khan','09472920500','Cylinder and refill services');");
;       db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Gaya','Faizan','07277838188','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Gaya','M/S Shree Maa Enterprises','09939406815','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Gaya','Santosh','09431272073,09939406815,07870886620','Only refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Gaya','Sawaab Samaj','07250635786','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Gopalganj','MD Azad','07050050060','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Gopalganj','MD Junaid','09576301671','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Gopalganj','MD Kashif','09934325719','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Muzaffarpur','-','09431239264','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Muzaffarpur','Shivan Gas House','09263931569,9835418348,08579923676','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Aman Pacchisia','08877887756','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Amit Kumar','07488029777','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Amresh','08797348700','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Amrit Ji','07484043414,06299643941','Cylinder and refill services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Patna','Ashutosh Pandey','09431254078','Cylinder services');");
        db.execSQL("INSERT INTO "+DATABASE_TABLE+"(State,City,Name,Contact,other)"+"VALUES('Bihar','Siwan','MD Azad','07050050060','Cylinder services');");



        db.close();
        // at last we are closing our
        // database after adding database.



    }
    public Cursor viewData()
    {
        Oxygen oxygen=new Oxygen();

        SQLiteDatabase db=getReadableDatabase();
        String query = "SELECT * FROM "+DATABASE_TABLE ;
        Cursor cursor=db.rawQuery(query,null);
        return cursor;

    }


}
