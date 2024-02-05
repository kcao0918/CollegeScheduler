package com.example.collegescheduler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EditItem extends AppCompatActivity {
    static int editItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item_page);
        EditText input1 = findViewById(R.id.editinput1);
        EditText input2 = findViewById(R.id.editinput2);
        EditText input3 = findViewById(R.id.editinput3);
        ImageView backImageButtonEdit = findViewById(R.id.backImageEdit);
        Button changeButton = findViewById(R.id.changeItemButton);
        String text1 = input1.getText().toString();
        String text2 = input2.getText().toString();
        String text3 = input3.getText().toString();
        ItemView tempView = new ItemView(text1, text2, text3);
        switch (MainActivity.selectedFrag) {
            case "classes":
                Classes.items.set(editItemPosition, tempView);
                break;
            case "assignments":
                Assignments.items.set(editItemPosition, tempView);
                break;
            case "todo":
                Tasks.items.set(editItemPosition, tempView);
                break;
            case "tests":
                Tests.items.set(editItemPosition, tempView);
                break;
            default:
                break;
        }
        finish();

        backImageButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
