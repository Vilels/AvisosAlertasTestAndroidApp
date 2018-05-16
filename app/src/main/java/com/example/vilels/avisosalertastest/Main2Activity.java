package com.example.vilels.avisosalertastest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {
    protected Button buttonRegisto, buttonLogin;

    public void changeActivity (Class<?> subActivity){
        Intent x = new Intent(this, subActivity);
        startActivity(x);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonRegisto = (Button) findViewById(R.id.button2_1);
        buttonLogin = (Button) findViewById(R.id.button2_2) ;

        buttonRegisto.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeActivity(Main3Activity.class);
            }
        });

        buttonLogin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeActivity(Main6Activity.class);
            }
        });
    }
}
