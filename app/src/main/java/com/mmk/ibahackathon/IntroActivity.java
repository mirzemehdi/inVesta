package com.mmk.ibahackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mmk.ibahackathon.Adapter.SliderAdapter;
import com.mmk.ibahackathon.Model.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;
    private List<SlideModel> slideModelList;
    private LinearLayout dotsView;
    private TextView[] mDots;
    private TextView skipBtn,signInBtn;
    private Button createAccountBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        initView();
        setClicks();

    }

    private void setClicks() {
        skipBtn.setOnClickListener(v -> changeActivity(MainActivity.class));
        createAccountBtn.setOnClickListener(v -> changeActivity(RegisterActivity.class));
        signInBtn.setOnClickListener(v -> changeActivity(LoginActivity.class));

    }

    public void changeActivity(Class<?>toActivity){
        Intent intent=new Intent(IntroActivity.this,toActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void initView() {
        skipBtn=findViewById(R.id.skipTourBtn);
        createAccountBtn=findViewById(R.id.createAccountBtnIntro);
        signInBtn=findViewById(R.id.signInBtnIntro);
        viewPager=findViewById(R.id.viewPagerIntro);
        initSlideList();
        sliderAdapter=new SliderAdapter(this,slideModelList);
        viewPager.setAdapter(sliderAdapter);

        dotsView=findViewById(R.id.dotsView);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDotsIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addDotsIndicator(int position) {
        mDots=new TextView[slideModelList.size()];
        dotsView.removeAllViews();
        for (int i=0;i<mDots.length;i++){
            TextView textView=new TextView(this);
            textView.setText(Html.fromHtml("&#8226;"));
            textView.setTextSize(35);
            textView.setTextColor(getResources().getColor(R.color.colorDotDisable));
            mDots[i]=textView;
            dotsView.addView(textView);
        }
        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorDotEnable));
        }

    }

    private void initSlideList() {
        slideModelList=new ArrayList<>();
        slideModelList.add(new SlideModel("Easy to use","Description",R.drawable.ic_fingerprint));
        slideModelList.add(new SlideModel("Worldwide Connection","Description",R.drawable.ic_connection));
        slideModelList.add(new SlideModel("Compact","Description",R.drawable.ic_moon));
    }
}
