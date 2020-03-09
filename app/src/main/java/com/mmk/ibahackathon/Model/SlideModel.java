package com.mmk.ibahackathon.Model;

import android.widget.TextView;

public class SlideModel {
    private String title;
    private String description;
    private int imgResource;

    public SlideModel(String title, String description, int imgResource) {
        this.title = title;
        this.description = description;
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
