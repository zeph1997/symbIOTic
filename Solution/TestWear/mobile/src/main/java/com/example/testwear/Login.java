package com.example.testwear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.loginBtn);
        Button register = (Button) findViewById(R.id.registerBtn);
        Button forgot = (Button) findViewById(R.id.forgotBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().equals("danteliew") && password.getText().equals("password")){
                    Intent mainAct = new Intent(getApplicationContext(), Home.class);
                    startActivity(mainAct);
                }
            }
        });

    }
}
