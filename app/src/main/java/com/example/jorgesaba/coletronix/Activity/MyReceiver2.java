package com.example.jorgesaba.coletronix.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myintent = new Intent(context, LiderancaService.class);
        context.startService(myintent);
    }
}