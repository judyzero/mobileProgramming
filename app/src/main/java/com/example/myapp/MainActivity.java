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

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnJoin, btnProduct;
    EditText loginID, loginPassword;
    RadioButton autoLogin;

//    SharedPreferences.Editor editor;
//    SharedPreferences memberPref;

    //기록할 xml 파일 이름, 0:r,w 권한
//    memberPref = getSharedPreferences("setting", 0);

//    editor= memberPref.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnJoin = (Button) findViewById(R.id.btnJoin);
        btnProduct = (Button) findViewById(R.id.btnProduct);

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
                autoLogin = (RadioButton) findViewById(R.id.autoLogin);
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

        //자동로그인 기능
//        if(autoLogin.isChecked()){
//            String id = loginID.getText().toString();
//            String password = loginPassword.getText().toString();
//
//            editor.putString("id", id);
//            editor.putString("password", password);
//            editor.putBoolean("autoLogin_enabled", true);
//            editor.apply();
//        } else{
//            editor.remove("id");
//            editor.remove("pw");
//            editor.remove("autoLogin_enabled");
//            editor.clear();
//            editor.apply();
//        }

        //자동로그인 - 껐다 켜도 값 유지
//        if(setting.getBoolean("autoLogin_enabled", false)){
//            loginID.setText(setting.getString("ID", ""));
//            loginPassword.setText(setting.getString("PW", ""));
//            autoLogin.setChecked(true);
//
//        }

    }
}