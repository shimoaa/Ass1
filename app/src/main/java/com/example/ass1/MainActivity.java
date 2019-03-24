package com.example.ass1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText first_name;
    private EditText last_name;
    private EditText date;
    private Button register;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_name = findViewById(R.id.firstName);
        last_name = findViewById(R.id.lastName);
        date = findViewById(R.id.date);
        register = findViewById(R.id.register);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(day+"-"+(month+1)+"-"+year);
                    }
                },year,month,day);
                datePickerDialog.show(); }});

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = first_name.getText().toString();
                String lname = last_name.getText().toString();
                String date_1 = date.getText().toString();


                final Intent welcome = new Intent(MainActivity.this,welcome.class);
                Bundle bundle = new Bundle();
                bundle.putString("first_name",fname);
                bundle.putString("last_name",lname);
                bundle.putString("date",date_1);
                welcome.putExtras(bundle);
                startActivity(welcome);
            }
        });
    }
}
