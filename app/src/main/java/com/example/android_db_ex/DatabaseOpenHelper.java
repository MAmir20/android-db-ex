package com.example.android_db_ex;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    //columns definition + table name
    public static final String ID = "ID";
    public static final String TITLE = "Title";
    public static final String TABLE_NAME = "Articles";
    //Création d'une table
    private static final String SQLCreateTableArticles =
            "CREATE TABLE " +TABLE_NAME+ " ( "+ ID  + " INTEGER PRIMARY KEY, " + TITLE + " TEXT " + " )";
    public static final int databaseVersion = 4;
    public static final String databaseName = "articlesDB";
    private static final String SQLDeleteTableArticles = "DROP TABLE IF EXISTS Articles" ;
    private final Context context;
    public DatabaseOpenHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQLCreateTableArticles);
    }
    @Override //mise à jour
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLDeleteTableArticles);
        onCreate(db);
    }
    public void ajouter(Integer value1,String value2){
        SQLiteDatabase bd = getWritableDatabase() ;
        ContentValues values = new ContentValues() ;
        values.put("ID", value1) ;
        values.put("Title", value2) ;
        long result = bd.insert("Articles", null, values) ;
        if (result == -1){
            Toast.makeText(context, "Failed !", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "succeeded !", Toast.LENGTH_SHORT).show();
        }
        bd.close() ;
    }

}
