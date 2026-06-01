package com.example.license_project_2.MathComplete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Math_Complete_DB";
    private static final int DB_VERSION = 4;
    private static final String TABLE_NAME = "Solved_Exercises";
    private static final String columnID = "id";
    private static final String columnLevel = "Current_Level";
    private static final String columnIndexOne = "Word_Problem_Index_One";
    private static final String columnIndexTwo = "Word_Problem_Index_Two";
    private static final String columnProgressValue = "Progress_Value";
    private static final int saveSlotID = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + columnID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + columnLevel + " INTEGER NOT NULL DEFAULT 0,"
                + columnIndexOne + " INTEGER NOT NULL DEFAULT 0,"
                + columnIndexTwo + " INTEGER NOT NULL DEFAULT 1,"
                + columnProgressValue + " INTEGER NOT NULL DEFAULT 0"
                + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }

    public void saveProgress(int level, int indexOne, int indexTwo, int progressValue){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(columnID, saveSlotID);
        values.put(columnLevel, level);
        values.put(columnIndexOne, indexOne);
        values.put(columnIndexTwo, indexTwo);
        values.put(columnProgressValue, progressValue);
        database.insertWithOnConflict(TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        database.close();
    }

    public int[] loadProgress() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME,
                new String[]{columnLevel, columnIndexOne, columnIndexTwo, columnProgressValue},
                columnID + " = ?",
                new String[]{String.valueOf(saveSlotID)},
                null, null, null);
        int[] result = null;
        if(cursor != null && cursor.moveToFirst()){
            result = new int[]{
                    cursor.getInt(cursor.getColumnIndexOrThrow(columnLevel)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(columnIndexOne)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(columnIndexTwo)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(columnProgressValue))};
            cursor.close();
        }
        database.close();
        return result;
    }

    public void clearProgress(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, columnID + " = ?", new String[]{String.valueOf(saveSlotID)});
        database.close();
    }
}
