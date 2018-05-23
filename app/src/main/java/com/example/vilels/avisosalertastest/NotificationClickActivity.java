package com.example.vilels.avisosalertastest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TextView;

public class NotificationClickActivity extends Activity {
    TextView data_title, data_body, data_key_1, data_key_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_click);

        data_title = (TextView) findViewById(R.id.data_title);
        data_body = (TextView) findViewById(R.id.data_body);
        data_key_1 = (TextView) findViewById(R.id.data_key_1);
        data_key_2 = (TextView) findViewById(R.id.data_key_2);

        Intent intent_o = getIntent();
        String title = intent_o.getStringExtra("title");
        String body = intent_o.getStringExtra("body");
        String key_1 = intent_o.getStringExtra("key_1");
        String key_2 = intent_o.getStringExtra("key_2");
        data_title.setText(title);
        data_body.setText(body);
        data_key_1.setText(key_1);
        data_key_2.setText(key_2);

    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
