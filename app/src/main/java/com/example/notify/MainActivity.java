package com.example.notify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText h_edittext = findViewById(R.id.hour);
        EditText m_edittext = findViewById(R.id.min);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
//                calendar.add(Calendar.SECOND, 10);
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(h_edittext.getText().toString()));
                calendar.set(Calendar.MINUTE, Integer.parseInt(m_edittext.getText().toString()));
                System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println(calendar.get(Calendar.MINUTE));
                setAlarm(calendar.getTimeInMillis());
                System.out.println("onClick");
//                NotificationMaker.makeNotify(getApplicationContext(), "выпей таблетку", "выпей таблетку", "выпей таблетку");
            }
        });
    }

    void setAlarm(long time){
        Intent intent = new Intent(this, AlarmRecieverNotify.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
        System.out.println("setAlarm");
    }
}