package com.example.collegescheduler;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Tasks extends Fragment {
    static ArrayList<ItemView> items;
    @SuppressLint("StaticFieldLeak")
    static com.example.collegescheduler.ListViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tasks, container, false);
        ListView lv = rootView.findViewById(R.id.listviewtasks);
        items = new ArrayList<>();
        adapter = new ListViewAdapter(getActivity(), items);
        lv.setAdapter(adapter);
        AddItem.loadContent(Tasks.adapter.getContext());
        return rootView;
    }
}
