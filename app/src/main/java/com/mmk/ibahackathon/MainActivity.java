package com.mmk.ibahackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mmk.ibahackathon.Adapter.AdvantageAdapter;
import com.mmk.ibahackathon.Adapter.IdeasAdapter;
import com.mmk.ibahackathon.Adapter.InvestorsAdapter;
import com.mmk.ibahackathon.Model.Advantage;
import com.mmk.ibahackathon.Model.Idea;
import com.mmk.ibahackathon.Model.Investor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView popularIdeaRecyclerView,newIdeaRecyclerView,investorsRecyclerView,advantagesRecylerView;
    private IdeasAdapter popularIdeaAdapter,newIdeaAdapter;
    private InvestorsAdapter investorsAdapter;
    private AdvantageAdapter advantagesAdapter;
    private List<Idea> popularIdeaList,newIdeaList;
    private List<Investor> investorsList;
    private List<Advantage> advantageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPopularIdeasList();
        initNewIdeasList();
        initInvestorsList();
        initAdvantagessList();
        initView();
    }

    private void initAdvantagessList() {

        advantageList=new ArrayList<>();
        advantageList.add(new Advantage("Easy to use","Description",getResources().getDrawable(R.drawable.ic_fingerprint)));
        advantageList.add(new Advantage("Compact","Description",getResources().getDrawable(R.drawable.ic_moon)));
    }

    private void initInvestorsList() {
        investorsList=new ArrayList<>();
        investorsList.add(new Investor("Ivan Polo",getResources().getDrawable(R.drawable.investor1)));
        investorsList.add(new Investor("Zarela Reed",getResources().getDrawable(R.drawable.investor2)));
        investorsList.add(new Investor("Tua Manue",getResources().getDrawable(R.drawable.investor3)));
        investorsList.add(new Investor("Gr Karak",getResources().getDrawable(R.drawable.investor1)));
        investorsList.add(new Investor("Zarela Reed",getResources().getDrawable(R.drawable.investor2)));

    }

    private void initNewIdeasList() {
        newIdeaList=new ArrayList<>();
        newIdeaList.add(new Idea("Nextsale","Social Proof, Urgency & Growth"
                ,R.drawable.nextsale));
        newIdeaList.add(new Idea("Product Hunt","Lorem Ipsum"
                ,R.drawable.producthunt));
    }

    private void initPopularIdeasList() {
        popularIdeaList=new ArrayList<>();
        popularIdeaList.add(new Idea("Crunchbase","Investments showing company"
                ,R.drawable.crunchbase));
        popularIdeaList.add(new Idea("Digital Ocean","Lorem Ipsum"
                ,R.drawable.digitalocean));
    }

    private void initView() {
        popularIdeaAdapter =new IdeasAdapter(popularIdeaList,this);
        newIdeaAdapter =new IdeasAdapter(newIdeaList,this);
        investorsAdapter=new InvestorsAdapter(investorsList,this);
        advantagesAdapter=new AdvantageAdapter(advantageList,this);
        popularIdeaRecyclerView =findViewById(R.id.popularIdeasRecyclerView);
        popularIdeaRecyclerView.setHasFixedSize(true);
        popularIdeaRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        popularIdeaRecyclerView.setAdapter(popularIdeaAdapter);

        newIdeaRecyclerView =findViewById(R.id.newIdeasRecyclerView);
        newIdeaRecyclerView.setHasFixedSize(true);
        newIdeaRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        newIdeaRecyclerView.setAdapter(newIdeaAdapter);

        investorsRecyclerView =findViewById(R.id.investorSRecyclerView);
        investorsRecyclerView.setHasFixedSize(true);
        investorsRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        investorsRecyclerView.setAdapter(investorsAdapter);

        advantagesRecylerView =findViewById(R.id.advantagesRecyclerView);
        advantagesRecylerView.setHasFixedSize(true);
        advantagesRecylerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        advantagesRecylerView.setAdapter(advantagesAdapter);
    }
}
