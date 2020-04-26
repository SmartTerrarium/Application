package com.example.smartterrarium1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Plant_One extends AppCompatActivity {

    //these are the initializations for all the values and references used in Plant_One activity

    EditText mPlantTitle1;
    TextView mTempRead1;
    TextView mLightRead1;
    TextView mMoistureRead1;
    EditText mMoistureWrite1;
    Button msendBtn1;
    Button mtitleBtn1;

    DatabaseReference mRefTemp1;
    DatabaseReference mRefLight1;
    DatabaseReference mRefMoisture1;
    DatabaseReference mWriteMoisture1;
    DatabaseReference mTitle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant__one);


        //This section finds and prints the temperature data readings from Firebase

        //creates the reference to the TextView in the app
        mTempRead1 = (TextView) findViewById(R.id.tempRead1);
        //finds the reference to the values in Firebase and assigns it to a name to use in the code
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

        //This section finds and prints the light data readings from the database

        //creates the reference to the TextView in the app
        mLightRead1 = (TextView) findViewById(R.id.lightRead1);
        //finds the reference to the values in Firebase and assigns it to a name to use in the code
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
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });

        //This section find and prints the moisture data readings from the database

        //creates the reference to the TextView in the app
        mMoistureRead1 = (TextView) findViewById(R.id.moistureRead1);
        //finds the reference to teh values in Firebase and assigns it to a name to use in the code
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

        //This section is the code that makes editing the moisture setting possible. It takes the
        //new value and sends it to the database which then makes the new value the hint in the
        //background of the EditText for the moisture setting

        //creates the reference to both the send button and the moisture setting
        msendBtn1 = (Button) findViewById(R.id.sendBtn1);
        mMoistureWrite1 = (EditText) findViewById(R.id.moistureWrite1);
        //finds corresponding reference in the database
        mWriteMoisture1 = FirebaseDatabase.getInstance().getReference().child("moistureSetting1");

        //This is similar to the code from the other value readings except it is setting the text
        //for the hint and not the main text
        mWriteMoisture1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String moistureSetting1 = snapshot.getValue(String.class);
                mMoistureWrite1.setHint(moistureSetting1);
            }

            @Override
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });
        //this recognizes that when the send button is pressed for a new moisture setting
        //and jumps to the send settings function at the end of the file
        msendBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                sendSettings();
            }
        });

        //This section is the code that makes editing the plant title possible. It takes the
        //new name and sends it to the database which then makes the new name the hint in the
        //background of the EditText for the title. This is sending the information to the same
        //spot where the buttons on the main menu get their names.

        //creates the reference to both the send button and the moisture setting
        mtitleBtn1 = (Button) findViewById(R.id.titleBtn1);
        mPlantTitle1 = (EditText) findViewById(R.id.plantTitle1);
        //finds corresponding reference in the database
        mTitle1 = FirebaseDatabase.getInstance().getReference().child("title1");

        //This is similar to the code from the other value readings except it is setting the text
        //for the hint in the background
        mTitle1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String titleNew1 = snapshot.getValue(String.class);
                mPlantTitle1.setHint(titleNew1);
            }
            @Override
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });
        //this recognizes that when the send button is pressed for a new title setting
        //and jumps to the title settings function at the end of the file
        mtitleBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                sendTitle();
            }
        });

    }
    //This is the function that sends the new title setting to the database when the send button
    //is pressed. It also prints a message at the bottom of the screen that confirms the data
    //was sent.
    public void sendTitle() {
        String newTitle1 = mPlantTitle1.getText().toString();
        mTitle1.setValue(newTitle1);

        Toast.makeText(Plant_One.this, "New Plant Name Sent", Toast.LENGTH_LONG).show();
    }

    //This is the function that sends the new water settings to the database when the send button
    //is pressed. It also prints a message at the bottom of the screen that confirms the data
    //was sent.
    public void sendSettings() {
        String moistureWrite1 = mMoistureWrite1.getText().toString();
        mWriteMoisture1.setValue(moistureWrite1);

        Toast.makeText(Plant_One.this, "New Moisture Settings Sent", Toast.LENGTH_LONG).show();
    }
}
