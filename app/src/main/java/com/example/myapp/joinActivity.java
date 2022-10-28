package com.example.myapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class joinActivity extends MainActivity {
    Button btnSave;
    EditText joinId, joinPassword, joinName, joinPhone, joinAddress;
    String id, password, name, phone, address;
    RadioButton agreeRb;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_join);

        btnSave = (Button) findViewById(R.id.btnSave);
        joinId = (EditText) findViewById(R.id.joinID);
        joinPassword = (EditText) findViewById(R.id.joinPassword);
        joinName = (EditText) findViewById(R.id.joinName);
        joinPhone = (EditText) findViewById(R.id.joinPhone);
        joinAddress = (EditText) findViewById(R.id.joinAddress);
        agreeRb = (RadioButton) findViewById(R.id.agreeRb);

        //회원가입하기 버튼을 눌렀을 때
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = joinId.getText().toString(); //아이디
                password = joinPassword.getText().toString(); //비밀번호
                name = joinName.getText().toString();
                phone = joinPhone.getText().toString();
                address = joinAddress.getText().toString();

                //비밀번호 특수문자
                String pattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$";
//                String pattern = "((?=.*[a-z])(?=.*[0-9]))";
                Matcher matcher = Pattern.compile(pattern).matcher(password);

                //약관에 동의 안했다면 실행
                if(!agreeRb.isChecked()){
                    Toast.makeText(getApplicationContext(), "약관을 읽고 동의 해주세요.",
                            Toast.LENGTH_SHORT).show();
                }

                else if(infoSaved(id) != null){
                    Toast.makeText(getApplicationContext(), "존재하는 아이디입니다.", Toast.LENGTH_SHORT).show();
                }

                //빈칸이면 쓰도록
                else if(id.equals("")){
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

                else if(password.equals("")){
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

                else if(name.equals("")){
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

                else if(phone.equals("")){
                    Toast.makeText(getApplicationContext(), "전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

                else if(address.equals("")){
                    Toast.makeText(getApplicationContext(), "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }

                //비밀번호 자릿수
                else if(password.length() < 5) {
                    Toast.makeText(getApplicationContext(), "비밀번호는 5자 이상 입력해야 합니다.", Toast.LENGTH_SHORT).show();
                }

               //특수키 규칙 확인
                else if(!matcher.matches()) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }

                else{
                    //회원가입 정보를 모두 입력했다면 회원가입 정보 쉐어드에 저장
                    signCheck();
                    Toast.makeText(getApplicationContext(), "회원가입을 성공했습니다.", Toast.LENGTH_SHORT).show();

                    //첫번째 화면으로 이동
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    //파일 생성, 정보 저장
    private void  signCheck(){
        String memberInfo = password + "\n" + name + "\n" + phone + "\n" + address;
        try{
            FileOutputStream fs = openFileOutput(id, Context.MODE_PRIVATE);
            PrintWriter writer = new PrintWriter(fs);
            writer.print(memberInfo);
            writer.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
        }
    }

    //아이디로 정보 확인하기
    private String infoSaved(String id){
           String tmp = null;
           try{
               FileInputStream fs = openFileInput(id);
               BufferedReader reader = new BufferedReader(new InputStreamReader(fs));
               tmp = reader.readLine();

           }catch(Exception e){
               e.printStackTrace();
           }
           return tmp;
    }

}

