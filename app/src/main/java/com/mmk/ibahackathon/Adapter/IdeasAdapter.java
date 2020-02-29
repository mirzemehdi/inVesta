package com.mmk.ibahackathon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mmk.ibahackathon.IdeaDetailActivity;
import com.mmk.ibahackathon.Model.Idea;
import com.mmk.ibahackathon.R;

import java.util.List;

public class IdeasAdapter extends RecyclerView.Adapter<IdeasAdapter.ViewHolder> {

    private List<Idea>ideaList;
    private Context context;

    public IdeasAdapter(List<Idea> ideaList, Context context) {
        this.ideaList = ideaList;
        this.context = context;
    }

    @NonNull
    @Override
    public IdeasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_idea,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull IdeasAdapter.ViewHolder holder, int position) {

        Idea idea=ideaList.get(position);
        holder.ideaTitleTxt.setText(idea.getTitle());
        holder.ideaDescriptionTxt.setText(idea.getDescription());
        holder.ideaImage.setBackgroundResource(idea.getImg());


    }

    @Override
    public int getItemCount() {
        return ideaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ideaTitleTxt;
        private TextView ideaDescriptionTxt;
        private ImageView ideaImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ideaTitleTxt=itemView.findViewById(R.id.row_idea_title);
            ideaDescriptionTxt=itemView.findViewById(R.id.row_idea_description);
            ideaImage=itemView.findViewById(R.id.row_idea_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, IdeaDetailActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("idea",ideaList.get(getAdapterPosition()));
                    intent.putExtra("ideaBundle",bundle);
                    context.startActivity(intent);
                }
            });
        }
    }
}
