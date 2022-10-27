package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnJoin;
    EditText loginID, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnJoin = (Button) findViewById(R.id.btnJoin);

        //로그인 눌렀을 경우
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast 알람 띄우기
                Toast.makeText(getApplicationContext(), "Click btnLogin",
                        Toast.LENGTH_SHORT).show();

                //id, password값 받기
                loginID = (EditText) findViewById(R.id.loginID);
                loginPassword = (EditText) findViewById(R.id.loginPassword);
            }
        });

        //회원가입 눌렀을 경우
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        joinActivity.class);
                startActivity(intent);
            }
        });


    }
}