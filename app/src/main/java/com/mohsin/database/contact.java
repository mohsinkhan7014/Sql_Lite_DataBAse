package com.mohsin.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class contact extends AppCompatActivity {

    EditText name, contact,email;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        name=findViewById(R.id.name);
        contact=findViewById(R.id.contact);
        email=findViewById(R.id.email);
        submit=findViewById(R.id.btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mydatabase md=new Mydatabase(getApplicationContext());
                md.insertValues(name.getText().toString(),Long.parseLong(contact.getText().toString()),email.getText().toString());
                finish();
            }
        });
    }
}
