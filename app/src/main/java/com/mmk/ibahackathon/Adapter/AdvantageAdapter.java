package com.mmk.ibahackathon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mmk.ibahackathon.Model.Advantage;
import com.mmk.ibahackathon.R;

import java.util.List;

public class AdvantageAdapter extends RecyclerView.Adapter<AdvantageAdapter.ViewHolder> {

    private List<Advantage> advantageList;
    private Context context;

    public AdvantageAdapter(List<Advantage> advantageList, Context context) {
        this.advantageList = advantageList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_advantage,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Advantage advantage=advantageList.get(position);
        holder.advantageTitleTxt.setText(advantage.getTitle());
        holder.advantageDescTxt.setText(advantage.getDesc());
        holder.advantageImg.setBackground(advantage.getImg());
    }

    @Override
    public int getItemCount() {
        return advantageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView advantageTitleTxt;
        private TextView advantageDescTxt;
        private ImageView advantageImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            advantageTitleTxt=itemView.findViewById(R.id.row_advantage_title);
            advantageDescTxt=itemView.findViewById(R.id.row_advantage_desc);
            advantageImg=itemView.findViewById(R.id.row_advantage_img);

        }
    }
}
