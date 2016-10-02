package com.example.admin.res;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main4Activity extends AppCompatActivity {
ListView listView;
    String[] contents;
    ArrayAdapter<String> arrayAdapter;
    DatePickerDialog date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
listView=(ListView)findViewById(R.id.listView);
        contents=new String[]{"Haven","Mithsya","Loiee","Winter palace","pind","Kumarakonam"};
         arrayAdapter=new ArrayAdapter<String>(Main4Activity.this,android.R.layout.simple_list_item_1,contents);
        listView.setAdapter(arrayAdapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String next = String.valueOf(parent.getItemAtPosition(position));
        if (position == 0) {
            Toast.makeText(Main4Activity.this, next, Toast.LENGTH_LONG).show();
            Intent one = new Intent(Main4Activity.this, Main5Activity.class);
            startActivity(one);
        }
        if (position == 1) {
            Toast.makeText(Main4Activity.this, next, Toast.LENGTH_LONG).show();
            Intent two = new Intent(Main4Activity.this, Main5Activity.class);
            startActivity(two);
        }
            if (position == 2) {
                Toast.makeText(Main4Activity.this, next, Toast.LENGTH_LONG).show();
                Intent three = new Intent(Main4Activity.this, Main5Activity.class);
                startActivity(three);
            }
                if (position == 3) {
                    Toast.makeText(Main4Activity.this, next, Toast.LENGTH_LONG).show();
                    Intent four = new Intent(Main4Activity.this, Main5Activity.class);
                    startActivity(four);
                }
                    if (position == 4) {
                        Toast.makeText(Main4Activity.this, next, Toast.LENGTH_LONG).show();
                        Intent five = new Intent(Main4Activity.this, Main5Activity.class);
                        startActivity(five);
                    }
                        if (position == 5) {
                            Toast.makeText(Main4Activity.this, next, Toast.LENGTH_LONG).show();
                            Intent six = new Intent(Main4Activity.this, Main5Activity.class);
                            startActivity(six);
                        }
        }
    });

    }
}
