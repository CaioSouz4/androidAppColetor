package com.example.jorgesaba.coletronix.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myintent = new Intent(context, LiderancaService.class);
        context.startService(myintent);
    }
}
