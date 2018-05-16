package com.example.vilels.avisosalertastest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends Activity {

    protected Button buttonNext;

    public void changeActivity (Class<?> subActivity){
        Intent x = new Intent(this, subActivity);
        startActivity(x);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buttonNext = (Button) findViewById(R.id.button3_Proximo);

        buttonNext.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeActivity(Main4Activity.class);
            }
        });
    }
}
