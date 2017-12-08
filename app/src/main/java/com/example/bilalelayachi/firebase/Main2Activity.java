package com.example.bilalelayachi.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {




    TextView txt;
    TextView txt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = (TextView) findViewById(R.id.txt);
        txt2 = (TextView) findViewById(R.id.txt2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference degebruiker = database.getReferenceFromUrl("https://fir-testbilal.firebaseio.com/gegevens/");


        //Naam
        DatabaseReference naam = degebruiker.child("-L-pZlfgavpsrgCEwsHM").child("naam").child("naam");
        //Hobby
        DatabaseReference hobby = degebruiker.child("-L-pZlfgavpsrgCEwsHM").child("naam").child("hobby");

        naam.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String gegevens_naam = dataSnapshot.getValue(String.class);
                txt.setText(gegevens_naam);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        hobby.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String gegevens_hobby = dataSnapshot.getValue(String.class);
                txt2.setText(gegevens_hobby);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });








    }



}
