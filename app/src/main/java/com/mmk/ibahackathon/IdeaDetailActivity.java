package com.mmk.ibahackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mmk.ibahackathon.Adapter.InvestorsAdapter;
import com.mmk.ibahackathon.Model.Idea;
import com.mmk.ibahackathon.Model.Investor;

import java.util.ArrayList;
import java.util.List;

public class IdeaDetailActivity extends AppCompatActivity {

    private RecyclerView investorsRecyclerView;
    private InvestorsAdapter investorsAdapter;
    private List<Investor> investorsList;
    private ImageView ideaImageDetail;
    private TextView titleTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_detail);
        initInvestorsList();
        initView();
    }

    private void initInvestorsList() {
        investorsList=new ArrayList<>();
        investorsList.add(new Investor("Ivan Polo",getResources().getDrawable(R.drawable.investor1)));
        investorsList.add(new Investor("Zarela Reed",getResources().getDrawable(R.drawable.investor2)));
        investorsList.add(new Investor("Tua Manue",getResources().getDrawable(R.drawable.investor3)));


    }

    public void back(View view){
        finish();
    }

    private void initView() {

        investorsAdapter=new InvestorsAdapter(investorsList,this);

        investorsRecyclerView =findViewById(R.id.investorSRecyclerViewDetail);
        investorsRecyclerView.setHasFixedSize(true);
        investorsRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        investorsRecyclerView.setAdapter(investorsAdapter);

        ideaImageDetail=findViewById(R.id.ideaImageDetail);
        titleTxt=findViewById(R.id.ideaTitleDetail);

        Bundle bundle=getIntent().getBundleExtra("ideaBundle");
        if (bundle!=null){
            Idea idea=(Idea)bundle.getSerializable("idea");
            ideaImageDetail.setBackgroundResource(idea.getImg());
            titleTxt.setText(idea.getTitle());

        }

    }
}
