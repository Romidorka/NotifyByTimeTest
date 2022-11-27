package com.example.notify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmRecieverNotify extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationMaker.makeNotify(context, "выпей таблетку", "выпей таблетку", "выпей таблетку");
    }
}
