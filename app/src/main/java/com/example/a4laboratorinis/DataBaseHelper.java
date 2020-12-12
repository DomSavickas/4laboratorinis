package com.example.a4laboratorinis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(@Nullable Context context) {
        super(context, Constants.NOTE_DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creatTableStatment = "CREATE TABLE " + Constants.NOTE_TABLE + " (" + Constants.COLUMN_ID_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + Constants.COLUMN_NOTE_NAME + " TEXT, " + Constants.COLUMN_NOTE_CONTENT + " TEXT)";
        db.execSQL(creatTableStatment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(NotesModel notesModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Constants.COLUMN_NOTE_NAME, notesModel.getNoteName());
        cv.put(Constants.COLUMN_NOTE_CONTENT, notesModel.getNoteContent());

        long insert = db.insert(Constants.NOTE_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public List<NotesModel> getEveryone(){
        List<NotesModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + Constants.NOTE_TABLE ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do{
                int noteId = cursor.getInt(0);
                String noteName = cursor.getString(1);
                String noteContent = cursor.getString(2);

                NotesModel newNote = new NotesModel(noteId, noteName, noteContent);

                returnList.add(newNote);
            }while(cursor.moveToNext());
        }
        else{
        }

        cursor.close();
        db.close();

        return returnList;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String queryString = "SELECT * FROM " + Constants.NOTE_TABLE ;
        Cursor data = db.rawQuery(queryString, null);

        return data;
    }
    public Integer deletedata(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Constants.NOTE_TABLE, "id=?", new String[]{id.toString()});
    }

}
