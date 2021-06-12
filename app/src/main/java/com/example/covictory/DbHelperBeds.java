package com.example.covictory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelperBeds extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CovidResources4.db";
    public static final String DATABASE_TABLE = "Beds";
    public static final String col_state = "State";
    public static final String col_city = "City";
    public static final String col_name = "Name";
    public static final String contact = "Contact";
    public static final String other = "Other";

    public DbHelperBeds(Context context) {
        super(context, DATABASE_NAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE " + DATABASE_TABLE + "( " + col_state + " TEXT NOT NULL , " + col_city + " TEXT NOT NULL ," + col_name + " TEXT NOT NULL ," + contact + " TEXT," + other + " TEXT)";

        db.execSQL(qry);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS " + DATABASE_TABLE;
        db.execSQL(qry);
        onCreate(db);
    }


    public void addNewData() {

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + DATABASE_TABLE);
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Kantilal Hospital','06576622000,09031050802','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Meditrina Hospital','09534343434, 06576688888','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Sadar Hospital','07004387010','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Shive Nursing Home','07947104434','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Tata Mains Hospital','06576641122, 06576641012, 06576641233','All Types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Tinplate Hospital','06572342266','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Uma Hospital','08677017777','All Types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Saket Hospital','07209565321','ICU in Dimna Road');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Tata Motors Hospital','0657669560','All Types of Bed in Kharanga Jhar');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Central Gurudwara Prabandhak Committee','09431740444','Oxygen in Sakchi');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Jamshedpur','Mercy Hospital','06572210018, 09067634691','All Types of Bed in Tube Colony');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Bokaro','Shivam Hospital','07488090631','All Types of Bed in Sector 4');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Bokaro','KM Memorial Hospital','06542236188, 06542236189, 08405900724, 09835769110 ','All Types of Bed in Chas');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Dhanbad','Asian Jalan Hospital','08250297212, 09051462585, 07070038888   ','All Types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Dhanbad','Eatern Railway Bhuli','09835097012','Normal');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Dhanbad','JIMS Hospital','09334262431, 07061316226','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Dhanbad','Nirsa Polytechnic','08102032987','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Dhanbad','Pragati Nursing Home','09431122513, 07278817641','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Dhanbad','Sunrise Hospital','07003876466','All Types of Bed in Barwadda');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Dhanbad','Healthy Life Care Hospital','0878917435','All Types of Bed in Nagri Kala');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','111 SaveLife Hospital ','09801536617','All Types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Bramahanad Hospital','06576600550','ICU ');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Jai Ram Hospital','09771430421','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Ranchi Sadar Hospital','09708572899','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Raj Hospital','09771488888','All Types Of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','RIMS Hospital','08757504254','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Life Care Hospital','09031652986','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','MDLM Hospital & Research','09905692426','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Berlin Diagnostics and Daycare','08340430095','All types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Praveen Brothers','08102644455','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Rims Bariyatu','08986684439','All types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Ram Pyari Super Speciality Hospital','09264443201','All types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Kailash Surgicals','09709117172','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Sadar Hospitals','08750602550','Oxygen');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Rani Hospital','07677111010, 09471568618','All types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Jharkhand','Ranchi','Sankalp Diagnostic Centre','09771466650','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Howrah','-','09830143748','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Kothari Medical Centre','03340127000, 09152154575','All types of Bed in alipore');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Woodlands Multispeciality Hospital','03340337032, 03340337033, 03324567075,','All types of Bed in alipore');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Fortis Hospital','03366284444, 08585030355','All types of Bed in Anadapur');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Apex Behandala Hospital','09874910027, 06290619696 ','All types of Bed in Behala');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Beleghata I.D. and B.G. Hospital','03323633373','All types of Bed in Beleghata');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Calcutta Heart Clinic, Salt Lake','03323585735, 03323588876','All types of Bed in Bidhannagar');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Columbia Asia Hospital Salt Lake','03366003300, 03339898969, 09874851514, 09836017501','All types of Bed in Bidhannagar');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Jagannath Gupta Medical College & Hospital','03324823500','All types of Bed in Budge Budge');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','JIMS','09123781550','All types of Bed in Budge Budge');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Kolkata','Calcutta Medical College','03322551621','All types of Bed in College Square');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','North 24 Paraganas','Megacity Nursing Home','06290337393, 03325526319, 03325525069, 03325627701','Oxygen in Barasat');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('WestBengal','Purulia','Hatuara COVID Hospital','07583988101','All Types of Bed in Hatuara');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Darbhanga','Shadab Bhai','08360032289','All Types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Gaya','Buddha Hospital','09470800656','All Types of Bed');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Kishanganj','ZA Nursing Home','09470800656','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Kishanganj','MI Jain Hospital','09431232005','All Types of Bed in kaltax Chowk');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Kishanganj','Radiant Hospital','08340217575','All Types of Bed in Paschimpali Chowk');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Muzzafarpur','Maa Jannki Hospital','09431238116','All Types of Bed in Bairai Golumbar');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Muzzafarpur','Galaxy Hospital','09801110547','ICU in Zero Mine');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Big Apollo Spectra Hospital','09771499926, 07360027999','All Types of Bed in Agam Kaun');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Budha Hospital','07762919191, 06122350116','All Types of Bed ');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Mediversal Hospital','09679885104','All Types of Bed ');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','MR Hospital','09934490027','ICU');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Netaji Subhash Medical College Hospital','09470092410','Oxygen in Amhara');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','R&N Superspeciality Hospital And Research Centre ','09835491081','All Types of Bed in Anandpura');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','S.S Hospital','09308437254','ICU in Anisabad');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Shri Murlidhar Memorial Nursing Home Patna','09955706874','Oxygen in Barh');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Shyam Multispeciality Hospital','07991172895','Oxygen in Bawanpura Bazaar');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Sparsh Heritage Hospital','09334111117','ICU in Bus Stand Road');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Hi-Tech Emergency Hospital','08709547571','All Types of Bed in Danapur');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Samay Hospital','09297911121','All Types of Bed in Danapur');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Nestiva Jay Arogya Hospital','07360011952','All Types of Bed in Gardanibagh');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Artis Multispeciality','09576711111','All Types of Bed in Hanuman Nagar');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Samarpan Trauma And Research Hospital','09304111833','All Types of Bed in Jakariyapur');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Asia Hospital','09128000666, 07677889922','ICU in Kankarbagh');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Ayushman Care Hospital','09135582078','ICU in Kankarbagh');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Jagdish Memorial Hospital','09263631220','Oxygen in Kankarbagh');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','Green City Hospital','08709253652','All Types of Bed in Meethapur');");
        db.execSQL("INSERT INTO " + DATABASE_TABLE + "(State,City,Name,Contact,other)" + "VALUES('Bihar','Patna','JDM Hospital','08102473340','ICU in Meethapur');");
        db.close();
    }


        public Cursor viewData() {
        Beds beds=new Beds();

        SQLiteDatabase db=getReadableDatabase();
        String query = "SELECT * FROM "+DATABASE_TABLE ;
        Cursor cursor=db.rawQuery(query,null);
        return cursor;

    }

}




