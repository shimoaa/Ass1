package com.example.ass1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView name = findViewById(R.id.name);
        TextView birth = findViewById(R.id.birth);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String first = bundle.getString("first_name");
        String last = bundle.getString("last_name");
        String date = bundle.getString("date");
        name.setText(first + " " + last);
        birth.setText(date);
    }
}
