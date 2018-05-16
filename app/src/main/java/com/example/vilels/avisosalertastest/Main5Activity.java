package com.example.vilels.avisosalertastest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends Activity {

    protected Button buttonFinalizar;

    public void changeActivity (Class<?> subActivity){
        Intent x = new Intent(this, subActivity);
        startActivity(x);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        buttonFinalizar = (Button) findViewById(R.id.button5_Finalizar);

        buttonFinalizar.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeActivity(Main6Activity.class);
            }
        });
    }
}
