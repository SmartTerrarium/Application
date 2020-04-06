package com.example.smartterrarium1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Plant_Three extends AppCompatActivity {

    TextView mTempRead3;
    TextView mLightRead3;
    TextView mMoistureRead3;

    DatabaseReference mRefTemp3;
    DatabaseReference mRefLight3;
    DatabaseReference mRefMoisture3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant__three);


        //temperature data readings loaded from the firebase
        mTempRead3 = (TextView) findViewById(R.id.tempRead3);
        mRefTemp3 = FirebaseDatabase.getInstance().getReference().child("temp3");

        mRefTemp3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String temp3 = snapshot.getValue(String.class);
                mTempRead3.setText(temp3);
            }
            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });

        //light data readings from the database
        mLightRead3 = (TextView) findViewById(R.id.lightRead3);
        mRefLight3 = FirebaseDatabase.getInstance().getReference().child("light3");

        mRefLight3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String light3 = snapshot.getValue(String.class);
                mLightRead3.setText(light3);
            }

            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });

        //moisture data readings from the database
        mMoistureRead3 = (TextView) findViewById(R.id.moistureRead3);
        mRefMoisture3 = FirebaseDatabase.getInstance().getReference().child("moisture3");

        mRefMoisture3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String moisture3 = snapshot.getValue(String.class);
                mMoistureRead3.setText(moisture3);
            }

            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });
    }
}
