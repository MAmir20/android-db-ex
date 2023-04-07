package com.example.android_db_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText t1 = findViewById(R.id.identifiant);
        EditText t2 = findViewById(R.id.titre);
        Button b1 = findViewById(R.id.btn);
        Button b2 = findViewById(R.id.afficherButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(t1.getText().toString());
                String title = t2.getText().toString();
                DatabaseOpenHelper db = new DatabaseOpenHelper(MainActivity.this);
                db.ajouter(id,title);
            }
        });

    }
}