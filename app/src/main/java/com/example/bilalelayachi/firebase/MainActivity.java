package com.example.bilalelayachi.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


public class MainActivity extends AppCompatActivity {



    Button verzenden;
    EditText naam;
    EditText hobby;
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    DatabaseReference gebruiker = database.getReference("gegevens");







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }





    public void verzenden(View view) {



                verzenden = (Button) findViewById(R.id.verzenden);
                naam = (EditText) findViewById(R.id.naam);
                hobby = (EditText) findViewById(R.id.hobby);


                String a_naam = naam.getText().toString();
                String a_hobby = hobby.getText().toString();


                DatabaseReference hey = gebruiker.push().child("naam");

                hey.child("naam").setValue(a_naam);
                hey.child("hobby").setValue(a_hobby);


                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);



    }



}
