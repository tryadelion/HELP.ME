package com.sleepy.helpme.helpme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.btnLogin)
    Button login;
    @Bind(R.id.etUser)
    EditText user;
    @Bind(R.id.etPass)
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ion.with(LoginActivity.this)
                        .load("http://help-mii.esy.es/checkLogin.php?username=joanPlan&pass=grabAtowel42")
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                Toast.makeText(LoginActivity.this,"User logged in",Toast.LENGTH_SHORT).show();
                                Intent i  = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(i);
                            }
                        });
            }
        });
    }
}
