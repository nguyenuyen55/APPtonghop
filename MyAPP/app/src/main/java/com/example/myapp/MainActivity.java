package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button btn1,BT3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_main);

        // so item click is done now check list view
        setContentView(R.layout.activity_main);

BT3=(Button) findViewById(R.id.dangnhap) ;
        btn1= (Button) findViewById(R.id.dki);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listviewFragment fragment = new listviewFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fram_layout,fragment);
                fragmentTransaction.commit();
            }
        });



    }}