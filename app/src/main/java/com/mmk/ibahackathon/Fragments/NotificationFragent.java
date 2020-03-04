package com.mmk.ibahackathon.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmk.ibahackathon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragent extends Fragment {


    public NotificationFragent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification_fragent, container, false);
    }

}
