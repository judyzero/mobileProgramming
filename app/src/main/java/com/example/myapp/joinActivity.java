package com.example.myapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.regex.Pattern;

public class joinActivity extends MainActivity {
    Button btnSave;
    EditText joinId, joinPassword, joinName, joinPhone, joinAddress;
    String id, password, name, phone, address;
    RadioButton agreeRb;

    SharedPreferences memberPref;
    SharedPreferences.Editor editor;

//    String pattern = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
//    boolean digit = false;

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

                //약관에 동의 안했다면 실행
                if(!agreeRb.isChecked()){
                    Toast.makeText(getApplicationContext(), "약관을 읽고 동의 해주세요.",
                            Toast.LENGTH_SHORT).show();
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

//                //특수키 규칙 확인
//                else if(Pattern.matches(pattern, password)) {
//                    Toast.makeText(getApplicationContext(), "특수키를 입력해주세요.", Toast.LENGTH_SHORT).show();
//                }

                else{
                    //회원가입 정보를 모두 입력했다면 회원가입 정보 쉐어드에 저장
                    signCheck();
                   Toast.makeText(getApplicationContext(), "회원가입을 성공했습니다.", Toast.LENGTH_SHORT).show();
                   finish();
                }
            }
        });

    }

    //회원가입정보 프레퍼런스에 저장
    private void  signCheck(){
        String filename = String.format("%s",id);
        memberPref = this.getSharedPreferences(filename, joinActivity.MODE_PRIVATE);
        editor = memberPref.edit();
        editor.putString("id", id);
        editor.putString("password", password);
        editor.putString("name", name);
        editor.putString("phone", phone);
        editor.putString("address", address);
        this.editor.commit();
        Toast.makeText(getApplicationContext(), "프레퍼런스 저장", Toast.LENGTH_SHORT).show();

    }
}

