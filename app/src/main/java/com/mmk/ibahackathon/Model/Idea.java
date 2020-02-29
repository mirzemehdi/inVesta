package com.mmk.ibahackathon.Model;

import android.graphics.drawable.Drawable;

public class Idea {
    private String title;
    private String description;
    private Drawable img;


    public Idea(String title, String description, Drawable img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public Idea() {
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

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
