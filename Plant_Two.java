package com.example.smartterrarium1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Plant_Two extends AppCompatActivity {

    TextView mTempRead2;
    TextView mLightRead2;
    TextView mMoistureRead2;

    DatabaseReference mRefTemp2;
    DatabaseReference mRefLight2;
    DatabaseReference mRefMoisture2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant__two);

        //temperature data readings loaded from the firebase
        mTempRead2 = (TextView) findViewById(R.id.tempRead2);
        mRefTemp2 = FirebaseDatabase.getInstance().getReference().child("temp2");

        mRefTemp2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String temp2 = snapshot.getValue(String.class);
                mTempRead2.setText(temp2);
            }
            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });

        //light data readings from the database
        mLightRead2 = (TextView) findViewById(R.id.lightRead2);
        mRefLight2 = FirebaseDatabase.getInstance().getReference().child("light2");

        mRefLight2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String light2 = snapshot.getValue(String.class);
                mLightRead2.setText(light2);
            }

            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });

        //moisture data readings from the database
        mMoistureRead2 = (TextView) findViewById(R.id.moistureRead2);
        mRefMoisture2 = FirebaseDatabase.getInstance().getReference().child("moisture2");

        mRefMoisture2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String moisture2 = snapshot.getValue(String.class);
                mMoistureRead2.setText(moisture2);
            }

            @Override
            public void onCancelled (DatabaseError error){
                //add something here for an error message
            }
        });
    }
}