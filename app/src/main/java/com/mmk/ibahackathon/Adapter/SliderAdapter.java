package com.mmk.ibahackathon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.mmk.ibahackathon.Model.SlideModel;
import com.mmk.ibahackathon.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private List<SlideModel> slideModelList;

    public SliderAdapter(Context context, List<SlideModel> slideModelList) {
        this.context = context;
        this.slideModelList = slideModelList;
    }

    @Override
    public int getCount() {
        return slideModelList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view=LayoutInflater.from(context).inflate(R.layout.slide_view,container,false);
        ImageView slideImage=view.findViewById(R.id.slide_view_img);
        TextView slideTitle=view.findViewById(R.id.slide_view_title);
        TextView slideDescription=view.findViewById(R.id.slide_view_description);

        SlideModel slideModel=slideModelList.get(position);
        slideImage.setBackgroundResource(slideModel.getImgResource());
        slideTitle.setText(slideModel.getTitle());
        slideDescription.setText(slideModel.getDescription());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
