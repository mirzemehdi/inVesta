package com.mmk.ibahackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mmk.ibahackathon.Adapter.AdvantageAdapter;
import com.mmk.ibahackathon.Adapter.IdeasAdapter;
import com.mmk.ibahackathon.Adapter.InvestorsAdapter;
import com.mmk.ibahackathon.Fragments.FavoritesFragment;
import com.mmk.ibahackathon.Fragments.MainFragment;
import com.mmk.ibahackathon.Fragments.NotificationFragent;
import com.mmk.ibahackathon.Fragments.ProfileFragment;
import com.mmk.ibahackathon.Model.Advantage;
import com.mmk.ibahackathon.Model.Idea;
import com.mmk.ibahackathon.Model.Investor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView toolbarTxtView;

    private BottomNavigationView bottomNavigationView;
    final Fragment fragment1 = new MainFragment();
    final Fragment fragment2 = new ProfileFragment();
    final Fragment fragment3 = new FavoritesFragment();
    final Fragment fragment4 = new NotificationFragent();

    final FragmentManager fm = getSupportFragmentManager();
    private Fragment active = fragment1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }



    public void setToolbarTxt(String toolbarTxt) {
        toolbarTxtView.setText(toolbarTxt);
    }

    private void initView() {
        toolbarTxtView=findViewById(R.id.toolbarText);
        fm.beginTransaction().replace(R.id.frameLayout, active).commit();
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()){

                    case R.id.home_menu:
                        active = fragment1;
                        break;
                    case R.id.profile_menu:
                        active = fragment2;
                        break;
                    case R.id.favorites_menu:
                        active = fragment3;
                        break;
                    case R.id.notification_menu:
                        active = fragment4;
                        break;


                }
                fm.beginTransaction().replace(R.id.frameLayout, active).commit();
                return true;
            }
        });
    }
}
