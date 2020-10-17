package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class callChinh extends AppCompatActivity {
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh);


        BottomNavigationView navigationView =findViewById(R.id.btn_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id =menuItem.getItemId();
                if(id==R.id.Login){
                    loginFragment fragment = new loginFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fram_layout,fragment);
                    fragmentTransaction.commit();
                }
                if(id==R.id.signup){
                    signFragment fragment = new signFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fram_layout,fragment);
                    fragmentTransaction.commit();
                }
                if(id==R.id.listview){
                    listviewFragment fragment = new listviewFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fram_layout,fragment);
                    fragmentTransaction.commit();
                }
                if(id==R.id.profile){
                    ProfileFragment fragment = new ProfileFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fram_layout,fragment);
                    fragmentTransaction.commit();
                }
                return true;
            }
        });

        navigationView.setSelectedItemId(R.id.Login);
    }
}