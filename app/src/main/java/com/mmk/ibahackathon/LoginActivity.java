package com.mmk.ibahackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mmk.ibahackathon.Helper.UserSave;

public class LoginActivity extends AppCompatActivity {

    private TextView signupBtn;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setClicks();
    }

    private void setClicks() {
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterTypeActivity.class));
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        //TODO DO AUTHENTICATIONS WITH API
        /**
        * If login is success save user
        * */
        saveUser();
    }

    private void saveUser() {
        UserSave.saveUser(this);
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void initView() {
        signupBtn=findViewById(R.id.signupBtn);
        loginBtn=findViewById(R.id.loginBtn);
    }
}
