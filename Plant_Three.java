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

public class Plant_Three extends AppCompatActivity {

    //these are the initializations for all the values and references used in Plant_Three activity

    EditText mPlantTitle3;
    TextView mTempRead3;
    TextView mLightRead3;
    TextView mMoistureRead3;
    EditText mMoistureWrite3;
    Button msendBtn3;
    Button mtitleBtn3;

    DatabaseReference mRefTemp3;
    DatabaseReference mRefLight3;
    DatabaseReference mRefMoisture3;
    DatabaseReference mWriteMoisture3;
    DatabaseReference mTitle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant__three);


        //This section finds and prints the temperature data readings from Firebase

        //creates the reference to the TextView in the app
        mTempRead3 = (TextView) findViewById(R.id.tempRead3);
        //finds the reference to the values in Firebase and assigns it to a name to use in the code
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

        //This section finds and prints the light data readings from the database

        //creates the reference to the TextView in the app
        mLightRead3 = (TextView) findViewById(R.id.lightRead3);
        //finds the reference to the values in Firebase and assigns it to a name to use in the code
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
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });

        //This section find and prints the moisture data readings from the database

        //creates the reference to the TextView in the app
        mMoistureRead3 = (TextView) findViewById(R.id.moistureRead3);
        //finds the reference to the values in Firebase and assigns it to a name to use in the code
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

        //This section is the code that makes editing the moisture setting possible. It takes the
        //new value and sends it to the database which then makes the new value the hint in the
        //background of the EditText for the moisture setting

        //creates the reference to both the send button and the moisture setting
        msendBtn3 = (Button) findViewById(R.id.sendBtn3);
        mMoistureWrite3 = (EditText) findViewById(R.id.moistureWrite3);
        //finds corresponding reference in the database
        mWriteMoisture3 = FirebaseDatabase.getInstance().getReference().child("moistureSetting3");

        //This is similar to the code from the other value readings except it is setting the text
        //for the hint and not the main text
        mWriteMoisture3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String moistureSetting3 = snapshot.getValue(String.class);
                mMoistureWrite3.setHint(moistureSetting3);
            }

            @Override
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });
        //this recognizes that when the send button is pressed for a new moisture setting
        //and jumps to the send settings function at the end of the file
        msendBtn3.setOnClickListener(new View.OnClickListener() {
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
        mtitleBtn3 = (Button) findViewById(R.id.titleBtn3);
        mPlantTitle3 = (EditText) findViewById(R.id.plantTitle3);
        //finds corresponding reference in the database
        mTitle3 = FirebaseDatabase.getInstance().getReference().child("title3");

        //This is similar to the code from the other value readings except it is setting the text
        //for the hint in the background
        mTitle3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String titleNew3 = snapshot.getValue(String.class);
                mPlantTitle3.setHint(titleNew3);
            }
            @Override
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });
        //this recognizes that when the send button is pressed for a new title setting
        //and jumps to the title settings function at the end of the file
        mtitleBtn3.setOnClickListener(new View.OnClickListener() {
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
        String newTitle3 = mPlantTitle3.getText().toString();
        mTitle3.setValue(newTitle3);

        Toast.makeText(Plant_Three.this, "New Plant Name Sent", Toast.LENGTH_LONG).show();
    }
    //This is the function that sends the new water settings to the database when the send button
    //is pressed. It also prints a message at the bottom of the screen that confirms the data
    //was sent.
    public void sendSettings() {
        String moistureWrite3 = mMoistureWrite3.getText().toString();
        mWriteMoisture3.setValue(moistureWrite3);

        Toast.makeText(Plant_Three.this, "New Moisture Settings Sent", Toast.LENGTH_LONG).show();
    }
}
