package com.example.collegescheduler;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class Assignments extends Fragment {
    static ArrayList<ItemView> items;
    @SuppressLint("StaticFieldLeak")
    static com.example.collegescheduler.ListViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_assignments, container, false);
        ListView lv = rootView.findViewById(R.id.listview);
        items = new ArrayList<>();
        adapter = new ListViewAdapter(getActivity(), items);
        lv.setAdapter(adapter);
        AddItem.loadContent(Assignments.adapter.getContext());
        return rootView;
    }
}
