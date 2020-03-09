package com.mmk.ibahackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;
import com.mmk.ibahackathon.Helper.UserSave;

public class VerificationCodeActivity extends AppCompatActivity {
    private Pinview pinview;
    private Button finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        initView();
        setClicks();



    }

    private void setClicks() {
        finishBtn.setOnClickListener(v -> {
            //TODO CHECK VERIFICation CODE
            UserSave.saveUser(this);
            Intent intent=new Intent(VerificationCodeActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }

    private void initView() {
        pinview=findViewById(R.id.pinview);
        //For changing font of pinview
        overrideFonts(pinview);
        finishBtn=findViewById(R.id.finishBtnVerification);

    }

    private void overrideFonts( final View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    overrideFonts(child);
                }
            } else if (v instanceof EditText) {
                ((TextView) v).setTypeface(ResourcesCompat.getFont(this,R.font.tthoves_regular));
                ((TextView) v).setTextSize(14);

            }
        } catch (Exception e) {
        }
    }
}
