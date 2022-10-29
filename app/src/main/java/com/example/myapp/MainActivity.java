package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    String id, password, autoID, autoPassword;
    boolean autoCheck;

    SharedPreferences memberPref;
    SharedPreferences.Editor editor;


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

        //자동로그인
        try{
            memberPref = getSharedPreferences("memberPref", joinActivity.MODE_PRIVATE);
            loginID.setText(memberPref.getString("autoID", ""));
            loginPassword.setText(memberPref.getString("autoPassword", ""));
            autoLogin.setChecked(true);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "자동로그인 실패",
                    Toast.LENGTH_SHORT).show();
        }

        //로그인 눌렀을 경우
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = loginID.getText().toString();
                password = loginPassword.getText().toString();
                autoCheck = autoLogin.isChecked();
                Toast.makeText(getApplicationContext(), "autologin: " + autoCheck,
                        Toast.LENGTH_SHORT).show();

                //아이디, 비밀번호 맞음
                if (password.equals(passwordCheck(id))) {
                    if (autoCheck) {
                        editor = memberPref.edit();
                        editor.putString("autoID", id);
                        editor.putString("autoPassword", password);
                        editor.putBoolean("autoCheck", true);
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "프레퍼런스 저장", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(), "자동로그인 화면전환",
                            Toast.LENGTH_SHORT).show();
                    //product 화면으로 이동
                    Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                    intent.putExtra("intentId", id);
                    startActivity(intent);
                    finish();

                }
                //에러 처리
                else {
                    //아이디 틀림
                    if (passwordCheck(id) == null) {
                        Toast.makeText(getApplicationContext(), "아이디를 다시 입력하세요.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "비밀번호를 다시 입력하세요.",
                                Toast.LENGTH_SHORT).show();
                    }
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

            //메인으로 이동 눌렀을 경우
            btnProduct.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),
                            ProductActivity.class);
                    intent.putExtra("intentId", id);
                    startActivity(intent);
                }
            });

    }

    //로그인 기능 - 회원가입 정보랑 맞는지 확인
    public String passwordCheck(String id) {
        //회원가입 정보 가져오기
        String tmp = null;
        try {
            FileInputStream fs = openFileInput(id);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fs));
            reader.readLine();
            tmp = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }

 }

