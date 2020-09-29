package com.mohsin.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewContact extends AppCompatActivity {
    ListView lvsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);
        lvsearch=findViewById(R.id.lv);
        Mydatabase md=new Mydatabase(getApplicationContext());
        ArrayList<String> a1=md.showValues();
        ArrayAdapter<String> ad=new ArrayAdapter<>(getApplicationContext(),R.layout.abc,a1);
        lvsearch.setAdapter(ad);
    }
}
