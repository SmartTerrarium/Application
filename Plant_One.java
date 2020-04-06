package com.example.smartterrarium1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Plant_One extends AppCompatActivity {

    TextView mTempRead1;
    TextView mLightRead1;
    TextView mMoistureRead1;

    DatabaseReference mRefTemp1;
    DatabaseReference mRefLight1;
    DatabaseReference mRefMoisture1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant__one);


        //temperature data readings loaded from the firebase
        mTempRead1 = (TextView) findViewById(R.id.tempRead1);
        mRefTemp1 = FirebaseDatabase.getInstance().getReference().child("temp1");

        mRefTemp1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String temp1 = snapshot.getValue(String.class);
                mTempRead1.setText(temp1);
            }
            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });

        //light data readings from the database
        mLightRead1 = (TextView) findViewById(R.id.lightRead1);
        mRefLight1 = FirebaseDatabase.getInstance().getReference().child("light1");

        mRefLight1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String light1 = snapshot.getValue(String.class);
                mLightRead1.setText(light1);
            }

            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });

        //moisture data readings from the database
        mMoistureRead1 = (TextView) findViewById(R.id.moistureRead1);
        mRefMoisture1 = FirebaseDatabase.getInstance().getReference().child("moisture1");

        mRefMoisture1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String moisture1 = snapshot.getValue(String.class);
                mMoistureRead1.setText(moisture1);
            }

            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });
    }
}
