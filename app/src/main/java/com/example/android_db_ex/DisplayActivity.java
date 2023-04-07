package com.example.android_db_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class DisplayActivity extends AppCompatActivity {

    private ListView listView;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Initialize the views
        listView = findViewById(R.id.listView);

        // Initialize the database
        db = new DatabaseOpenHelper(DisplayActivity.this).getReadableDatabase();

        // Query the database for all records
        String[] projection = {
                DatabaseOpenHelper.ID  + " AS _id",
                DatabaseOpenHelper.TITLE,
        };
        Cursor cursor = db.query(
                DatabaseOpenHelper.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        // Create an ArrayList of HashMaps to hold the data from the cursor
        ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("_id", String.valueOf(cursor.getInt(0)));
                dataMap.put("title", cursor.getString(1));
                dataList.add(dataMap);
            } while (cursor.moveToNext());
        }

        // Create a SimpleAdapter for the data
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dataList,
                android.R.layout.simple_list_item_2,
                new String[] {"_id", "title"},
                new int[] {android.R.id.text1, android.R.id.text2}
        );

        // Set the SimpleAdapter as the adapter for the ListView
        listView.setAdapter(adapter);
        // Populate the ListView with the records
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
//                this,
//                android.R.layout.simple_list_item_2,
//                cursor,
//                new String[] {"_id", DatabaseOpenHelper.TITLE},
//                new int[] {android.R.id.text1, android.R.id.text2},
//                0
//        );
//        listView.setAdapter(adapter);


        // Move the cursor to the first record
//        cursor.moveToFirst();
//
//        // Populate the ListView with the records using a do-while loop
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
//                this,
//                android.R.layout.simple_list_item_2,
//                cursor,
//                new String[] {"_id", DatabaseOpenHelper.TITLE},
//                new int[] {android.R.id.text1, android.R.id.text2},
//                0
//        );
//
//        listView.setAdapter(adapter);
//
//        do {
//            // Access the values from the current record
//            int id = cursor.getInt(0);
//            String title = cursor.getString(1);
//
//
//        } while (cursor.moveToNext());
//
//        // Close the cursor when done
//        cursor.close();

    }


}