package com.example.vilels.avisosalertastest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    public String tokenString;
    protected Button buttonToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonToken = (Button) findViewById(R.id.buttonToken);
        buttonToken.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                tokenString = FirebaseInstanceId.getInstance().getToken();
                Toast.makeText(MainActivity.this, tokenString, Toast.LENGTH_SHORT).show();
                sendRegistrationToServer(tokenString);
            }
        });
    }

    private void sendRegistrationToServer(String newToken){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("messsage");

        myRef.setValue(newToken);
    }

    //@Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Toast.makeText(this, "Recebida mensagem", Toast.LENGTH_SHORT).show();
    }

}
