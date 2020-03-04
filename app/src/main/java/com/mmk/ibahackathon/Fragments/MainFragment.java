package com.mmk.ibahackathon.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mmk.ibahackathon.Adapter.AdvantageAdapter;
import com.mmk.ibahackathon.Adapter.IdeasAdapter;
import com.mmk.ibahackathon.Adapter.InvestorsAdapter;
import com.mmk.ibahackathon.MainActivity;
import com.mmk.ibahackathon.Model.Advantage;
import com.mmk.ibahackathon.Model.Idea;
import com.mmk.ibahackathon.Model.Investor;
import com.mmk.ibahackathon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private RecyclerView popularIdeaRecyclerView,newIdeaRecyclerView,investorsRecyclerView,advantagesRecylerView;
    private IdeasAdapter popularIdeaAdapter,newIdeaAdapter;
    private InvestorsAdapter investorsAdapter;
    private AdvantageAdapter advantagesAdapter;
    private List<Idea> popularIdeaList,newIdeaList;
    private List<Investor> investorsList;
    private List<Advantage> advantageList;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        initPopularIdeasList();
        initNewIdeasList();
        initInvestorsList();
        initAdvantagessList();
        initView(view);
        return view;
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

    private void initView(View v) {

        ( (MainActivity)getActivity()).setToolbarTxt("InVESTA");

        popularIdeaAdapter =new IdeasAdapter(popularIdeaList,getActivity());
        newIdeaAdapter =new IdeasAdapter(newIdeaList,getActivity());
        investorsAdapter=new InvestorsAdapter(investorsList,getActivity());
        advantagesAdapter=new AdvantageAdapter(advantageList,getActivity());
        popularIdeaRecyclerView =v.findViewById(R.id.popularIdeasRecyclerView);
        popularIdeaRecyclerView.setHasFixedSize(true);
        popularIdeaRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        popularIdeaRecyclerView.setAdapter(popularIdeaAdapter);

        newIdeaRecyclerView =v.findViewById(R.id.newIdeasRecyclerView);
        newIdeaRecyclerView.setHasFixedSize(true);
        newIdeaRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        newIdeaRecyclerView.setAdapter(newIdeaAdapter);

        investorsRecyclerView =v.findViewById(R.id.investorSRecyclerView);
        investorsRecyclerView.setHasFixedSize(true);
        investorsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        investorsRecyclerView.setAdapter(investorsAdapter);

        advantagesRecylerView =v.findViewById(R.id.advantagesRecyclerView);
        advantagesRecylerView.setHasFixedSize(true);
        advantagesRecylerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        advantagesRecylerView.setAdapter(advantagesAdapter);


    }

}
