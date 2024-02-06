package com.example.collegescheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FloatingActionButton addButton;

    public static Classes classFragment = new Classes();
    static Assignments assignmentsFragment = new Assignments();
    static Tasks tasksFragment = new Tasks();
    static Tests testsFragment = new Tests();

    static String selectedFrag = "classes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, classFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.classesMenu) {
                    selectedFrag = "classes";
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, classFragment).commit();
                    return true;
                }
                else if (item.getItemId() == R.id.assignmentsMenu) {
                    selectedFrag = "assignments";
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, assignmentsFragment).commit();
                    return true;
                }
                else if (item.getItemId() == R.id.todoMenu) {
                    selectedFrag = "todo";
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, tasksFragment).commit();
                    return true;
                }
                else if (item.getItemId() == R.id.testsMenu) {
                    selectedFrag = "tests";
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, testsFragment).commit();
                    return true;
                }
                return false;
            }
        });

        addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
            }
        });

    }

}