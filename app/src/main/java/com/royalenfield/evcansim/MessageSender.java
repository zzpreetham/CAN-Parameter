package com.royalenfield.evcansim;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageSender {

    public static final String CUSTOM_ACTION = "com.royalenfield.digital.telemetry.info.ACTION_SEND";

    public static void sendBroadcast(Context context, String message,String type) {
        Intent intent = new Intent(CUSTOM_ACTION);
        intent.putExtra(type, message);
        context.sendBroadcast(intent);
    }
}