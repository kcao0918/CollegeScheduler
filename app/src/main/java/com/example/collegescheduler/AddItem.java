package com.example.collegescheduler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import kotlinx.coroutines.scheduling.Task;

public class AddItem extends AppCompatActivity {
    private EditText input1;
    private EditText input2;
    private EditText input3;
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additempage);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        Button enterButton = findViewById(R.id.addItemButton);
        ImageView backImageButton = findViewById(R.id.backImage);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = input1.getText().toString();
                String text2 = input2.getText().toString();
                String text3 = input3.getText().toString();
                if (!(text1.equals("") | text2.equals("") | text3.equals(""))) {
                    ItemView newItem = new ItemView(text1, text2, text3);
                    addItem(newItem);
                }
                input1.setText("");
                input2.setText("");
                input3.setText("");
            }
        });
        backImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static void loadContent(Context context) {
        try {
            File path = context.getFilesDir();
            File readFrom = null;
            switch (MainActivity.selectedFrag) {
                case "classes":
                    readFrom = new File(path, "classesList.txt");
                    break;
                case "assignments":
                    readFrom = new File(path, "assignmentsList.txt");
                    break;
                case "todo":
                    readFrom = new File(path, "tasksList.txt");
                    break;
                case "tests":
                    readFrom = new File(path, "testsList.txt");
                    break;
                default:
                    break;
            }

            // Check if the file exists, if not, create it
            if (!readFrom.exists()) {
                readFrom.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(readFrom));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] viewData = line.split(";");
                if (viewData.length == 3) {
                    switch (MainActivity.selectedFrag) {
                        case "classes":
                            Classes.items.add(new ItemView(viewData[0], viewData[1], viewData[2]));
                            break;
                        case "assignments":
                            Assignments.items.add(new ItemView(viewData[0], viewData[1], viewData[2]));
                            break;
                        case "todo":
                            Tasks.items.add(new ItemView(viewData[0], viewData[1], viewData[2]));
                            break;
                        case "tests":
                            Tests.items.add(new ItemView(viewData[0], viewData[1], viewData[2]));
                            break;
                        default:
                            break;
                    }
                }
            }
            reader.close();

            // Notify adapters after reading all data
            switch (MainActivity.selectedFrag) {
                case "classes":
                    Classes.adapter.notifyDataSetChanged();
                    break;
                case "assignments":
                    Assignments.adapter.notifyDataSetChanged();
                    break;
                case "todo":
                    Tasks.adapter.notifyDataSetChanged();
                    break;
                case "tests":
                    Tests.adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveContent(Context context) {
        try {
            File path = context.getFilesDir();
            File writeTo = null;
            switch (MainActivity.selectedFrag) {
                case "classes":
                    writeTo = new File(path, "classesList.txt");
                    break;
                case "assignments":
                    writeTo = new File(path, "assignmentsList.txt");
                    break;
                case "todo":
                    writeTo = new File(path, "tasksList.txt");
                    break;
                case "tests":
                    writeTo = new File(path, "testsList.txt");
                    break;
                default:
                    break;
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(writeTo));
            switch (MainActivity.selectedFrag) {
                case "classes":
                    for (ItemView item : Classes.items) {
                        writer.write(item.getInputOne() + ";" + item.getInputTwo() + ";" + item.getInputThree());
                        writer.newLine();
                    }
                    break;
                case "assignments":
                    for (ItemView item : Assignments.items) {
                        writer.write(item.getInputOne() + ";" + item.getInputTwo() + ";" + item.getInputThree());
                        writer.newLine();
                    }
                    break;
                case "todo":
                    for (ItemView item : Tasks.items) {
                        writer.write(item.getInputOne() + ";" + item.getInputTwo() + ";" + item.getInputThree());
                        writer.newLine();
                    }
                    break;
                case "tests":
                    for (ItemView item : Tests.items) {
                        writer.write(item.getInputOne() + ";" + item.getInputTwo() + ";" + item.getInputThree());
                        writer.newLine();
                    }
                    break;
                default:
                    break;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void removeItem(int position) {
        switch (MainActivity.selectedFrag) {
            case "classes":
                Classes.items.remove(position);
                Classes.adapter.notifyDataSetChanged();
                saveContent(Classes.adapter.getContext());
                break;
            case "assignments":
                Assignments.items.remove(position);
                Assignments.adapter.notifyDataSetChanged();
                saveContent(Assignments.adapter.getContext());
                break;
            case "todo":
                Tasks.items.remove(position);
                Tasks.adapter.notifyDataSetChanged();
                saveContent(Tasks.adapter.getContext());
                break;
            case "tests":
                Tests.items.remove(position);
                Tests.adapter.notifyDataSetChanged();
                saveContent(Tests.adapter.getContext());
                break;
            default:
                break;
        }
    }
    public static void addItem(ItemView item) {
        switch (MainActivity.selectedFrag) {
            case "classes":
                Classes.items.add(item);
                Classes.adapter.notifyDataSetChanged();
                saveContent(Classes.adapter.getContext());
                break;
            case "assignments":
                Assignments.items.add(item);
                Assignments.adapter.notifyDataSetChanged();
                saveContent(Assignments.adapter.getContext());
                break;
            case "todo":
                Tasks.items.add(item);
                Tasks.adapter.notifyDataSetChanged();
                saveContent(Tasks.adapter.getContext());
                break;
            case "tests":
                Tests.items.add(item);
                Tests.adapter.notifyDataSetChanged();
                saveContent(Tests.adapter.getContext());
                break;
            default:
                break;
        }
    }

}
