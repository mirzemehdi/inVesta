package com.mmk.ibahackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SmsVerificationActivity extends AppCompatActivity {
    private Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_verification);

        initView();
        setClicks();
    }

    private void setClicks() {
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SmsVerificationActivity.this,VerificationCodeActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initView() {
        continueBtn=findViewById(R.id.continueBtnSmsVerification);
    }
}
