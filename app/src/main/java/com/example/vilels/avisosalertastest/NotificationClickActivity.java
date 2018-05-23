package com.example.vilels.avisosalertastest;

import android.app.Activity;
import android.os.Bundle;
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

        if (getIntent().getExtras()!=null){
            for (String key : getIntent().getExtras().keySet()){
                if (key.equals("title"))
                    data_title.setText(getIntent().getExtras().getString(key));
                else if (key.equals("body"))
                    data_body.setText(getIntent().getExtras().getString(key));
                else if (key.equals("key_1"))
                    data_key_1.setText(getIntent().getExtras().getString(key));
                else if (key.equals("key_2"))
                    data_key_2.setText(getIntent().getExtras().getString(key));
            }
        }
    }
}
