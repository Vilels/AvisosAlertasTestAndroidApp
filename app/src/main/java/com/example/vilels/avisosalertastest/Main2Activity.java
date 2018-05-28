package com.example.vilels.avisosalertastest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends Activity {
    protected Button buttonRegisto, buttonLogin;
    protected EditText inputEmail, inputPassword;
    private FirebaseAuth auth;

    public void changeActivity (Class<?> subActivity){
        Intent x = new Intent(this, subActivity);
        startActivity(x);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        
        setContentView(R.layout.activity_main2);

        buttonRegisto = (Button) findViewById(R.id.button2_1);
        buttonLogin = (Button) findViewById(R.id.button2_2) ;
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);

        buttonRegisto.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                changeActivity(Main3Activity.class);
            }
        });

        buttonLogin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "Email em falta", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "Password em falta", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                  if (password.length() < 6){
                                      inputPassword.setError("Confirme a palavra-passe");
                                  } else {
                                      Toast.makeText(getApplicationContext(), "Erro ao realizar login, porfavor confirme os seus dados", Toast.LENGTH_SHORT).show();
                                  }

                                } else {
                                    Toast.makeText(getApplicationContext(), "Login com sucesso", Toast.LENGTH_SHORT).show();
                                    changeActivity(Main6Activity.class);
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}


