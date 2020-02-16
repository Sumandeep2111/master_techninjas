package com.example.project_techninjas_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseNotes extends SQLiteOpenHelper {

    private  static  final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "noteDB";
    private static final String DATABASE_TABLE = "tablenotes";

    //column name for database table
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";

    DatabaseNotes(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table
        String query = "CREATE TABLE "+ DATABASE_TABLE + "("+ KEY_ID+" INT PRIMARY KEY,"+
                KEY_TITLE + " TEXT,"+
                KEY_CONTENT + " TEXT,"+
                KEY_DATE + " TEXT,"+
                KEY_TIME + " TEXT "+")";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);

    }

    public long addNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TITLE,note.getTitle());
        contentValues.put(KEY_CONTENT,note.getContent());
        contentValues.put(KEY_DATE,note.getDate());
        contentValues.put(KEY_TIME,note.getTime());

        long ID = db.insert(DATABASE_TABLE,null,contentValues);
        Log.d("Insert data","ID -> "+ ID);
        return ID;

    }
}
