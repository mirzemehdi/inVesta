package com.mmk.ibahackathon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mmk.ibahackathon.Helper.UserSave;

public class SettingsActivity extends AppCompatActivity {

    private ImageView closeBtn;
    private Button logOutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initView();
        setClicks();
    }

    private void setClicks() {
        closeBtn.setOnClickListener(v -> {
            Intent intent=new Intent(SettingsActivity.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(SettingsActivity.this);
                builder.setTitle("Log Out");
                builder.setMessage("Do you want to log out?");
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    UserSave.removeUser(SettingsActivity.this);
                    finish();
                });
                builder.setNeutralButton("Cancel", (dialog, which) -> {
                    dialog.dismiss();
                });
                builder.show();
            }
        });
    }

    private void initView() {
        closeBtn=findViewById(R.id.closeBtnSettings);
        logOutBtn=findViewById(R.id.logOutBtnSettings);

        if (UserSave.isLogedIn(SettingsActivity.this)){
            logOutBtn.setVisibility(View.VISIBLE);
        }
        else
            logOutBtn.setVisibility(View.INVISIBLE);
    }
}
