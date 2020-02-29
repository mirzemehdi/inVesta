package com.mmk.ibahackathon.Model;

import android.graphics.drawable.Drawable;

public class Investor {

    private String name;
    private Drawable img;

    public Investor(String name, Drawable img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
