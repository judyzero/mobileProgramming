package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnJoin, btnProduct;
    EditText loginID, loginPassword;
    RadioButton autoLogin;

    SharedPreferences memberPref;
    SharedPreferences.Editor editor;
    String id, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnJoin = (Button) findViewById(R.id.btnJoin);
        btnProduct = (Button) findViewById(R.id.btnProduct);

        //id, password 값 받기
        loginID = (EditText) findViewById(R.id.loginID);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        autoLogin = (RadioButton) findViewById(R.id.autoLogin);

        //로그인 눌렀을 경우
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = loginID.getText().toString();
                password = loginPassword.getText().toString();

                //파일을 읽는다.
                String filename = String.format("%s", id);
                try{
                    memberPref = getSharedPreferences(filename, joinActivity.MODE_PRIVATE);
                    passwordCheck();
                }
                //아이디(파일)이 존재하지 않을 경우
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "존재하지 않는 아이디입니다.",
                            Toast.LENGTH_SHORT).show();
                }
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

        btnProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        ProductActivity.class);
                startActivity(intent);
            }
        });
    }
    public void passwordCheck(){
        // id, pw 값 가져옴
        String prefId = memberPref.getString("id", "");
        String prefPassword = memberPref.getString("password", "");
        //아이디 맞음
        if(id.equals(prefId)){
            //아이디, 비밀번호 맞음
            if (password.equals((prefPassword))) {
                Intent intent = new Intent(getApplicationContext(),
                        ProductActivity.class);
                startActivity(intent);
            }
            //아이디 맞지만 비밀번호 틀림
            else{
                Toast.makeText(getApplicationContext(), "비밀번호를 다시 입력하세요.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        //아이디 틀림
        else{
            Toast.makeText(getApplicationContext(), "아이디를 다시 입력하세요.",
                    Toast.LENGTH_SHORT).show();
        }

    }
 }
