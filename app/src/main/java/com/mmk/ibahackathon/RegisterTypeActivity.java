package com.mmk.ibahackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterTypeActivity extends AppCompatActivity {

    private Button investorBtn,smeBtn;
    private TextView signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_type);
        initView();
        setClicks();
    }

    private void setClicks() {
        investorBtn.setOnClickListener(v -> {
            Intent intent=new Intent(RegisterTypeActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
        smeBtn.setOnClickListener(v -> {
            Intent intent=new Intent(RegisterTypeActivity.this,RegisterActivity.class);
            startActivity(intent);
        });

        signInBtn.setOnClickListener(v -> {
            Intent intent=new Intent(RegisterTypeActivity.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }

    private void initView() {
        investorBtn=findViewById(R.id.investorBtn);
        smeBtn=findViewById(R.id.smeBtn);
        signInBtn=findViewById(R.id.signInBtnRegisterType);
    }


}
