package com.example.admin.res;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
EditText ee;
    Button okbutton;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ee=(EditText)findViewById(R.id.editText2);
        dbHelper=new DataBaseHelper(Main6Activity.this);
        okbutton=(Button)findViewById(R.id.okbutton);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s;
                s=ee.getText().toString();
                dbHelper.ok(s);
                Toast.makeText(Main6Activity.this,"BOOKED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                Intent notify=new Intent(Main6Activity.this,Notify.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(Main6Activity.this,0,notify,0);
                Notification notification=new Notification.Builder(Main6Activity.this)
                        .setSmallIcon(android.R.drawable.btn_default_small)
                        .setContentInfo("5")
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Message From Listaurants")
                        .setSubText("Your booking of restaurant has been confirmed")
                        .setAutoCancel(true)
                        .build();
                NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(3,notification);
                Intent back=new Intent(Main6Activity.this,Main5Activity.class);
                startActivity(back);
            }
        });
    }

}
