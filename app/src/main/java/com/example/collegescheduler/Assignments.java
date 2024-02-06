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

        Button sortInputOne = rootView.findViewById(R.id.button1);
        Button sortInputTwo = rootView.findViewById(R.id.button2);
        Button sortInputThree = rootView.findViewById(R.id.button3);

        sortInputOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortItemOne();
                AddItem.saveContent(Assignments.adapter.getContext());
                items.clear();
                AddItem.loadContent(Assignments.adapter.getContext());
                Assignments.adapter.notifyDataSetChanged();
            }
        });

        sortInputTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortItemTwo();
                AddItem.saveContent(Assignments.adapter.getContext());
                items.clear();
                AddItem.loadContent(Assignments.adapter.getContext());
                Assignments.adapter.notifyDataSetChanged();
            }
        });

        sortInputThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortItemThree();
                AddItem.saveContent(Assignments.adapter.getContext());
                items.clear();
                AddItem.loadContent(Assignments.adapter.getContext());
                Assignments.adapter.notifyDataSetChanged();
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

    public void sortItemTwo() {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size() - i - 1; j++) {
                if (items.get(j).getInputTwo().compareTo(items.get(j + 1).getInputTwo()) > 0) {
                    swap(j, j + 1, items);
                }
            }
        }
    }

    public void sortItemThree() {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size() - i - 1; j++) {
                if (items.get(j).getInputThree().compareTo(items.get(j + 1).getInputThree()) > 0) {
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
