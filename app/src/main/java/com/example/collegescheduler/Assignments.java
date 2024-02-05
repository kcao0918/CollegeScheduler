package com.example.collegescheduler;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class Assignments extends Fragment{
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

        // Find view within fragment and set click listener
        Button sortInputOne = rootView.findViewById(R.id.button1);
        sortInputOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortItemOne();
                AddItem.saveContent(Assignments.adapter.getContext());
                items = new ArrayList<>();
                AddItem.loadContent(Assignments.adapter.getContext());
            }
        });

        return rootView;
    }

    public void sortItemOne() {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size() - i - 1; j++) {
                if (items.get(j).getInputOne().compareTo(items.get(j + 1).getInputOne()) > 0) {
                    swap(j, j + 1, items);
                }
            }
        }
    }

    private void swap(int a, int b, ArrayList<ItemView> arr) {
        ItemView temp = arr.get(b);
        arr.set(b, arr.get(a));
        arr.set(a, temp);
    }
}
