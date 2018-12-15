package com.example.andres.dungeonmasterstoolbox;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "DMToolbox.db";

        //table -encounters
        public static final String TABLE_NAME = "encounters";
        public static final String TABLE1_COL1 = "ID";
        public static final String TABLE1_COL2 = "Name";  // String
        public static final String TABLE1_COL3 = "CR"; // Int
        public static final String TABLE1_COL4 = "EXP"; // Int

        //table - npcs
        public static final String TABLE2_NAME = "saved_npcs";
        public static final String TABLE2_COL1 = "ID";
        public static final String TABLE2_COL2 = "Name";
        public static final String TABLE2_COL3 = "Sex"; // int, 0 is for male, 1 is for Female!
        public static final String TABLE2_COL4 = "Race"; // String
        public static final String TABLE2_COL5 = "Occupation"; // String
        public static final String TABLE2_COL6 = "Alignment"; // String

        //table og factions
        public static final String TABLE3_NAME = "original_factions";
        public static final String TABLE3_COL1 = "ID";
        public static final String TABLE3_COL2 = "Name"; // String
        public static final String TABLE3_COL3 = "Description"; // String

        //table saved factions
        public static final String TABLE4_NAME = "saved_factions";
        public static final String TABLE4_COL1 = "ID";
        public static final String TABLE4_COL2 = "Name"; // String

        //table venue
        public static final String TABLE5_NAME = "saved_venue";
        public static final String TABLE5_COL1 = "ID";
        public static final String TABLE5_COL2 = "Name"; // String
        public static final String TABLE5_COL3 = "Details"; // String

        //table armor &  weapons
        public static final String TABLE6_NAME = "equipment";
        public static final String TABLE6_COL1 = "ID";
        public static final String TABLE6_COL2 = "Name"; // String
        public static final String TABLE6_COL3 = "Type";  //if it is a weapon or armor  "Weapon" / "Armor"
        public static final String TABLE6_COL4 = "Weight"; // Double
        public static final String TABLE6_COL5 = "Description";  //what AC does it give / what is the damage  or etc.
        public static final String TABLE6_COL6 = "Cost"; // Int, not double walang decimall sa cost ng dnd
        public static final String TABLE6_COL7 = "Properties";  //long concatinated string - TLDR just String


        //table classes
        public static final String TABLE7_NAME = "classes";
        public static final String TABLE7_COL1 = "ID";
        public static final String TABLE7_COL2 = "Name"; // String
        public static final String TABLE7_COL3 = "Description"; // String

        //table spells
        public static final String TABLE8_NAME = "spells";
        public static final String TABLE8_COL1 = "ID"; // dont touch this since AI siya
        public static final String TABLE8_COL2 = "Name"; // String
        public static final String TABLE8_COL3 = "Level"; // Int
        public static final String TABLE8_COL4 = "Description"; // String
        public static final String TABLE8_COL5 = "CastingTime"; // String - Instantaneous, 1 minute, 10 minutes, 1 hour, etc.
        public static final String TABLE8_COL6 = "Range"; // String kasi kasama yung ft. sa Range and minsan self siya
        public static final String TABLE8_COL7 = "Components"; // String
        public static final String TABLE8_COL8 = "Duration"; // String
        // if 0, it is not a spell of this class, if 1, then it is.
        public static final String TABLE8_COL9 = "IsBardSpell";
        public static final String TABLE8_COL10 = "IsDruidSpell";
        public static final String TABLE8_COL11 = "IsClericSpell";
        public static final String TABLE8_COL12 = "IsWizardSpell";
        public static final String TABLE8_COL13 = "IsSorcererSpell";
        public static final String TABLE8_COL14 = "IsWarlockSpell";





        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //8 tables in total
            //encounters
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT NOT NULL,CR INTEGER NOT NULL, EXP INTEGER NOT NULL)");
            //NPCs - ID, Name, Sex, Race, Occupation, Alignment
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE2_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Sex INTEGER,Race TEXT, Occupation TEXT, Alignment TEXT)");
            //original factions
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE3_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Description TEXT)");
            //saved factions
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE4_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT)");
            //Venue
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE5_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Details TEXT)");
            //equipment
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE6_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Type TEXT,Weight REAL, Description TEXT, Cost TEXT, Properties TEXT)");
            //classes
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE7_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Description TEXT)");
            //spells
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE8_NAME + " " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Level INTEGER,Description TEXT, CastingTime TEXT, Range TEXT, Components TEXT," +
                    " Duration TEXT, IsBardSpell INTEGER,  IsDruidSpell INTEGER, IsClericSpell INTEGER, " +
                    " IsWizardSpell INTEGER, IsSorcererSpell INTEGER, IsWarlockSpell INTEGER)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE4_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE5_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE6_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE7_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE8_NAME);
            onCreate(db);
        }

        public void dropCurrentTables() {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE4_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE5_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE6_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE7_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE8_NAME);
        }

        public void createTables(){
            SQLiteDatabase db = this.getWritableDatabase();
            //8 tables in total
            //encounters
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT NOT NULL,CR INTEGER NOT NULL, EXP INTEGER NOT NULL)");
            //NPCs - ID, Name, Sex, Race, Occupation, Alignment
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE2_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Sex INTEGER,Race TEXT, Occupation TEXT, Alignment TEXT)");
            //original factions
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE3_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Description TEXT)");
            //saved factions
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE4_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT)");
            //Venue
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE5_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Details TEXT)");
            //equipment
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE6_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Type TEXT,Weight REAL, Description TEXT, Cost TEXT, Properties TEXT)");
            //classes
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE7_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Description TEXT)");
            //spells
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE8_NAME + " " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Level INTEGER,Description TEXT, CastingTime TEXT, Range TEXT, Components TEXT," +
                    " Duration TEXT, IsBardSpell INTEGER,  IsDruidSpell INTEGER, IsClericSpell INTEGER, " +
                    " IsWizardSpell INTEGER, IsSorcererSpell INTEGER, IsWarlockSpell INTEGER)");
        }


        /*
        HERE ARE ALL THE Insert METHODS FOR THE DATABASE
         */
        public boolean insertIntoEncounters(String name, int CR, int EXP) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TABLE1_COL2, name);
            contentValues.put(TABLE1_COL3, CR);
            contentValues.put(TABLE1_COL4, EXP);

            long result = db.insert(TABLE_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }

        public boolean insertIntoNPC(String name, int sex,String race, String Occupation, String Alignment ) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TABLE2_COL2, name);
            contentValues.put(TABLE2_COL3, sex);
            contentValues.put(TABLE2_COL4, race);
            contentValues.put(TABLE2_COL5, Occupation);
            contentValues.put(TABLE2_COL6, Alignment);
            long result = db.insert(TABLE2_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }

        public boolean insertIntoOGFaction(String name, String Description ) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TABLE3_COL2, name);
            contentValues.put(TABLE3_COL3, Description);
            long result = db.insert(TABLE3_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }

        public boolean insertIntoSavedFaction(String name) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TABLE4_COL2, name);
            long result = db.insert(TABLE4_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }

        public boolean insertIntoVenue(String name, String Details) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TABLE5_COL2, name);
            contentValues.put(TABLE5_COL3, Details);
            long result = db.insert(TABLE5_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }

        public boolean insertIntoEquipment(String name, String type, Double Weight, String Description, int cost, String Properties) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TABLE6_COL2, name);
            contentValues.put(TABLE6_COL3, type);
            contentValues.put(TABLE6_COL4, Weight);
            contentValues.put(TABLE6_COL5, Description);
            contentValues.put(TABLE6_COL6, cost);
            contentValues.put(TABLE6_COL7, Properties);
            long result = db.insert(TABLE6_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }

        public boolean insertIntoClasses(String name, String Details) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TABLE7_COL2, name);
            contentValues.put(TABLE7_COL3, Details);
            long result = db.insert(TABLE7_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }


        public boolean insertIntoSpells(String name, int Level, String Description, String CastingTime, String Range, String Components, String Duration,
        boolean isBardSpell, boolean isDruidSpell,  boolean isClericSpell,  boolean isWizardSpell,  boolean isSorcererSpell,  boolean isWarlockSpell) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(TABLE8_COL2, name);
            contentValues.put(TABLE8_COL3, Level);
            contentValues.put(TABLE8_COL4, Description);
            contentValues.put(TABLE8_COL5, CastingTime);
            contentValues.put(TABLE8_COL6, Range);
            contentValues.put(TABLE8_COL7, Components);
            contentValues.put(TABLE8_COL8, Duration);
            contentValues.put(TABLE8_COL9, isBardSpell);
            contentValues.put(TABLE8_COL10, isDruidSpell);
            contentValues.put(TABLE8_COL11, isClericSpell);
            contentValues.put(TABLE8_COL12, isWizardSpell);
            contentValues.put(TABLE8_COL13, isSorcererSpell);
            contentValues.put(TABLE8_COL14, isWarlockSpell);

            long result = db.insert(TABLE8_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }




        /*
        HERE ARE ALL THE GET METHODS FOR THE DATABASE
         */
        public Cursor getAllDataFromEncounters(int cr) {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE_NAME +  " where CR = " + cr ,  null);

            return res;
        }

        public Cursor getAllDataFromNPCs() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE2_NAME, null);
            return res;
        }


        public Cursor getAllFromOGFactions(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE3_NAME , null);
            return res;
        }

        public Cursor getAllFromSavedFactions(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE4_NAME , null);
            return res;
        }

        public Cursor getAllFromVenue(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE5_NAME , null);
            return res;
        }

        public Cursor getAllArmors(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE6_NAME + " where Type = 'Armor'" , null);
            return res;
        }

        public Cursor getAllWeapons(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE6_NAME + " where Type = 'Weapon'", null);
            return res;
        }

        public Cursor getAllFromClasses(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE7_NAME , null);
            return res;
        }

        public Cursor getAllFromSpells(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE8_NAME , null);
            return res;
        }

        /*
        These are the Get spells!
         */
        public Cursor getAllBardSpells(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE8_NAME + " where IsBardSpell = 1", null);
            return res;
        }

        public Cursor getAllDruidSpells(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE8_NAME + " where IsDruidSpell = 1", null);
            return res;
        }

        public Cursor getAllClericSpells(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE8_NAME + " where IsClericSpell = 1", null);
            return res;
        }

        public Cursor getAllWizardSpells(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE8_NAME + " where IsWizardSpell = 1", null);
            return res;
        }

        public Cursor getAllSorcererSpells(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE8_NAME + " where IsSorcererSpell = 1", null);
            return res;
        }

        public Cursor getAllWarlockSpells(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE8_NAME + " where IsWarlockSpell = 1", null);
            return res;
        }

    }


        /* Save cde for later
        public Cursor getAllDataFromOGFactions() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select DISTINCT(CATEGORY) from " + TABLE3_NAME , null);
            return res;
        }

         public Cursor getAllFromOGFactions(String category){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + TABLE3_NAME + " where category = '" + category + "'" , null);
            return res;
        }
        */


