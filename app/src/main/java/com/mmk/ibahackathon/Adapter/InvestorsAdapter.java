package com.mmk.ibahackathon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mmk.ibahackathon.Model.Investor;
import com.mmk.ibahackathon.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InvestorsAdapter extends RecyclerView.Adapter<InvestorsAdapter.ViewHolder> {

    private List<Investor> investors;
    private Context context;

    public InvestorsAdapter(List<Investor> investors, Context context) {
        this.investors = investors;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_investor,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Investor investor=investors.get(position);
        holder.investorNameTxt.setText(investor.getName());
        holder.investorImage.setImageDrawable(investor.getImg());


    }

    @Override
    public int getItemCount() {
        return investors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView investorNameTxt;
        private CircleImageView investorImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            investorImage=itemView.findViewById(R.id.row_investor_img);
            investorNameTxt=itemView.findViewById(R.id.row_investor_name);
        }
    }
}
