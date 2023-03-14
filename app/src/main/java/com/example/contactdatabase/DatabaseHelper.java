package com.example.contactdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "details";

    public static final String ID_COLUMN = "person_id";
    public static final String AVATAR_COLUMN = "avatar";
    public static final String NAME_COLUMN = "name";
    public static final String EMAIL_COLUMN = "email";
    public static final String DOB_COLUMN = "dob";
    public static final String PHONE_COLUMN = "phone";

    private final SQLiteDatabase database;

    private static final String DATABASE_CREATE = String.format(
            "CREATE TABLE %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT, " +
                    "%s TEXT, " +
                    "%s TEXT, " +
                    "%s TEXT, " +
                    "%s TEXT) ",

            DATABASE_NAME, ID_COLUMN, AVATAR_COLUMN, NAME_COLUMN, EMAIL_COLUMN, DOB_COLUMN, PHONE_COLUMN);

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);

        Log.v(this.getClass().getName(), DATABASE_NAME +
                " database upgrade to version " + newVersion + " - old data lost");
        onCreate(db);
    }

    public long insertDetails(Person p){
        ContentValues rowValues = new ContentValues();

        rowValues.put(NAME_COLUMN, p.getName());
        rowValues.put(EMAIL_COLUMN, p.getEmail());
        rowValues.put(DOB_COLUMN, p.getDob());
        rowValues.put(PHONE_COLUMN, p.getPhone());
        rowValues.put(AVATAR_COLUMN, p.getAvatar());

        return database.insertOrThrow(DATABASE_NAME, null, rowValues);
    }

    public ArrayList<Person> getDetails(){
        Cursor results = database.query("details", new String[] {"person_id", "avatar", "name", "email", "dob", "phone"},
                null, null, null, null, "name");

        ArrayList<Person> listPeople = new ArrayList<>();

        results.moveToFirst();
        while (!results.isAfterLast()) {
            int id = results.getInt(1);
            String name = results.getString(2);
            String email = results.getString(3);
            String dob = results.getString(4);
            String phone = results.getString(5);
            String avatar = results.getString(6);

            listPeople.add(new Person(id, avatar, name, email, dob, phone));
            results.moveToNext();
        }

        results.close();
        database.close();
        return listPeople;
    }
}