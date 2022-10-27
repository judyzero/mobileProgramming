package com.example.myapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class joinActivity extends MainActivity {
    Button btnSave;
    EditText joinId, joinPassword, joinName, joinPhone, joinAddress;
    String id, password, name, phone, address;
    RadioButton agreeRb;

    SharedPreferences memberPref, profilePref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_join);

        btnSave = (Button) findViewById(R.id.btnSave);

        //회원가입하기 버튼을 눌렀을 때
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinId = (EditText) findViewById(R.id.joinID);
                joinPassword = (EditText) findViewById(R.id.joinPassword);
                joinName = (EditText) findViewById(R.id.joinName);
                joinPhone = (EditText) findViewById(R.id.joinPhone);
                joinAddress = (EditText) findViewById(R.id.joinAddress);

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
                else if(id.equals("") || password.equals("") || name.equals("")
                        || phone.equals("") || address.equals("")){
                    Toast.makeText(getApplicationContext(), "빈칸을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }
                else{
                    //회원가입 정보를 모두 입력했다면 회원가입 정보 쉐어드에 저장
                    signCheck();
                }
                //다시 mainActivity로 돌아감
                finish();
            }
        });

    }

    //회원가입정보 프레퍼런스에 저장
    private void  signCheck(){
        memberPref = this.getSharedPreferences("memberPref", MainActivity.MODE_PRIVATE);
        editor = memberPref.edit();
        editor.putString(id, password);
        editor.putString(name, phone);
        this.editor.apply();
    }

}

