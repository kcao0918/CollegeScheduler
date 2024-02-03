package com.example.collegescheduler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.collegescheduler.AddItem;
import com.example.collegescheduler.ItemView;
import com.example.collegescheduler.MainActivity;
import com.example.collegescheduler.R;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<ItemView> {
    private final Context context;

    public ListViewAdapter(@NonNull Context context, ArrayList<ItemView> arrayList) {
        super(context, 0, arrayList);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
        }

        ItemView currentNumberPosition = getItem(position);
        ImageView remove = currentItemView.findViewById(R.id.remove);
        TextView textView1 = currentItemView.findViewById(R.id.name1);
        assert currentNumberPosition != null;
        textView1.setText(currentNumberPosition.getInputOne());
        TextView textView2 = currentItemView.findViewById(R.id.name2);
        textView2.setText(currentNumberPosition.getInputTwo());
        TextView textView3 = currentItemView.findViewById(R.id.name3);
        textView3.setText(currentNumberPosition.getInputThree());

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItem.removeItem(position);
                Toast.makeText(context, "Item removed at position: " + (position+1), Toast.LENGTH_SHORT).show();
            }
        });
        return currentItemView;
    }
}