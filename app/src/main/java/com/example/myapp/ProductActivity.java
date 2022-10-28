package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProductActivity extends MainActivity {

    Button btnInfo;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        btnInfo = (Button) findViewById(R.id.btnInfo);

        //로그인 정보 받기
        Intent intent = getIntent();
        id = intent.getExtras().getString("id");

        //회원정보 버튼 눌렀을 경우
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //info activity로 넘어감
                Intent intent = new Intent(getApplicationContext(),
                        InfoActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
}