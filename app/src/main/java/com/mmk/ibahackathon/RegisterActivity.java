package com.mmk.ibahackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;

public class RegisterActivity extends AppCompatActivity {

    private TextView signInBtn;
    private Button createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setClicks();

    }

    private void setClicks() {
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,SmsVerificationActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initView() {
        signInBtn=findViewById(R.id.signInBtn);
        createAccountBtn=findViewById(R.id.createAccountBtn);
    }
}
