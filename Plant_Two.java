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

public class Plant_Two extends AppCompatActivity {

    //these are the initializations for all the values and references used in Plant_Two activity

    EditText mPlantTitle2;
    TextView mTempRead2;
    TextView mLightRead2;
    TextView mMoistureRead2;
    EditText mMoistureWrite2;
    Button msendBtn2;
    Button mtitleBtn2;

    DatabaseReference mRefTemp2;
    DatabaseReference mRefLight2;
    DatabaseReference mRefMoisture2;
    DatabaseReference mWriteMoisture2;
    DatabaseReference mTitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant__two);


        //This section finds and prints the temperature data readings from Firebase

        //creates the reference to the TextView in the app
        mTempRead2 = (TextView) findViewById(R.id.tempRead2);
        //finds the reference to the values in Firebase and assigns it to a name to use in the code
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

        //This section finds and prints the light data readings from the database

        //creates the reference to the TextView in the app
        mLightRead2 = (TextView) findViewById(R.id.lightRead2);
        //finds the reference to the values in Firebase and assigns it to a name to use in the code
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
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });

        //This section find and prints the moisture data readings from the database

        //creates the reference to the TextView in the app
        mMoistureRead2 = (TextView) findViewById(R.id.moistureRead2);
        //finds the reference to the values in Firebase and assigns it to a name to use in the code
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

        //This section is the code that makes editing the moisture setting possible. It takes the
        //new value and sends it to the database which then makes the new value the hint in the
        //background of the EditText for the moisture setting

        //creates the reference to both the send button and the moisture setting
        msendBtn2 = (Button) findViewById(R.id.sendBtn2);
        mMoistureWrite2 = (EditText) findViewById(R.id.moistureWrite2);
        //finds corresponding reference in the database
        mWriteMoisture2 = FirebaseDatabase.getInstance().getReference().child("moistureSetting2");

        //This is similar to the code from the other value readings except it is setting the text
        //for the hint and not the main text
        mWriteMoisture2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String moistureSetting2 = snapshot.getValue(String.class);
                mMoistureWrite2.setHint(moistureSetting2);
            }

            @Override
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });
        //this recognizes that when the send button is pressed for a new moisture setting
        //and jumps to the send settings function at the end of the file
        msendBtn2.setOnClickListener(new View.OnClickListener() {
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
        mtitleBtn2 = (Button) findViewById(R.id.titleBtn2);
        mPlantTitle2 = (EditText) findViewById(R.id.plantTitle2);
        //finds corresponding reference in the database
        mTitle2 = FirebaseDatabase.getInstance().getReference().child("title2");

        //This is similar to the code from the other value readings except it is setting the text
        //for the hint in the background
        mTitle2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot snapshot){
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String titleNew2 = snapshot.getValue(String.class);
                mPlantTitle2.setHint(titleNew2);
            }
            @Override
            public void onCancelled (DatabaseError error) {
                //add something here for an error message
            }
        });
        //this recognizes that when the send button is pressed for a new title setting
        //and jumps to the title settings function at the end of the file
        mtitleBtn2.setOnClickListener(new View.OnClickListener() {
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
        String newTitle2 = mPlantTitle2.getText().toString();
        mTitle2.setValue(newTitle2);

        Toast.makeText(Plant_Two.this, "New Plant Name Sent", Toast.LENGTH_LONG).show();
    }
    //This is the function that sends the new water settings to the database when the send button
    //is pressed. It also prints a message at the bottom of the screen that confirms the data
    //was sent.
    public void sendSettings() {
        String moistureWrite2 = mMoistureWrite2.getText().toString();
        mWriteMoisture2.setValue(moistureWrite2);

        Toast.makeText(Plant_Two.this, "New Moisture Settings Sent", Toast.LENGTH_LONG).show();
    }
}
