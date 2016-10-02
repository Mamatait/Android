package com.example.admin.res;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by admin on 25-09-2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;

    public DataBaseHelper(Context context)
    {
        super(context,"login.db",null,1);
        sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase=getReadableDatabase();
    }
    // Called when no database exists in disk and the helper class needs
    // to create a new one.

    public void onCreate(SQLiteDatabase _db)
    {
        _db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);

    }
    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.

    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        // Log the version upgrade.
        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");


        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.
        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        // Create a new one.
        onCreate(_db);
    }

public void ok(String s)
{
    ContentValues cv=new ContentValues();
    cv.put("CustomerCount",s);
    sqLiteDatabase.insert("DATABASE_CREATE",null,cv);
}

}
