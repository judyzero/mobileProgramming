package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfoActivity extends ProductActivity {

    TextView infoName, infoPhone, infoAddress;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        infoName = (TextView) findViewById(R.id.infoName);
        infoPhone = (TextView) findViewById(R.id.infoPhone);
        infoAddress = (TextView) findViewById(R.id.infoAddress);

        Intent intent = getIntent();
        userName = intent.getExtras().getString("intentId");
        infoName.setText(getName(userName));
        infoPhone.setText(getPhone(userName));
        infoAddress.setText(getAddress(userName));
    }

    public String getName(String name){
        String tmp = null;
        try{
            FileInputStream fs = openFileInput(name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fs));
            reader.readLine();
            reader.readLine();
            tmp = reader.readLine();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tmp;
    }

    public String getPhone(String name){
        String tmp = null;
        try{
            FileInputStream fs = openFileInput(name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fs));
            reader.readLine();
            reader.readLine();
            reader.readLine();
            tmp = reader.readLine();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tmp;
    }

    public String getAddress(String name){
        String tmp = null;
        try{
            FileInputStream fs = openFileInput(name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fs));
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            tmp = reader.readLine();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tmp;
    }

}