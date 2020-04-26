package com.example.smartterrarium1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //these are the initializations for all values names and references used in the
    //MainActivity code

    Button mbtn1;
    Button mbtn2;
    Button mbtn3;

    DatabaseReference mTitle1;
    DatabaseReference mTitle2;
    DatabaseReference mTitle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //part of the connection to Firebase
        FirebaseApp.initializeApp(this);

        //connects the top button to the activity for plant one
        Button plant1_btn = (Button) findViewById(R.id.plant1_btn);
        plant1_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent1 = new Intent(getBaseContext(), Plant_One.class);
                //pass info to second activity
                startActivity(startIntent1);
            }
        });

        //connects the top button to the activity for plant two
        Button plant2_btn = (Button) findViewById(R.id.plant2_btn);
        plant2_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent2 = new Intent(getApplicationContext(), Plant_Two.class);
                //pass info to second activity
                startActivity(startIntent2);
            }
        });

        //connects the top button to the activity for plant three
        Button plant3_btn = (Button) findViewById(R.id.plant3_btn);
        plant3_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent3 = new Intent(getApplicationContext(), Plant_Three.class);
                //pass info to second activity
                startActivity(startIntent3);
            }
        });

        //this section finds the plant titles referenced in the database and changes the
        //corresponding button names to match them, it also recognizes when they change and
        //modifies the button title accordingly

        //BUTTON ONE
        //initialization
        mbtn1 = (Button) findViewById(R.id.plant1_btn);
        //finds the reference in the database
        mTitle1 = FirebaseDatabase.getInstance().getReference().child("title1");

        mTitle1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String titleNew1 = snapshot.getValue(String.class);
                mbtn1.setText(titleNew1);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //add something here for an error message
            }
        });

        //BUTTON TWO
        //initialization
        mbtn2 = (Button) findViewById(R.id.plant2_btn);
        //finds the reference in the database
        mTitle2 = FirebaseDatabase.getInstance().getReference().child("title2");

        mTitle2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String titleNew2 = snapshot.getValue(String.class);
                mbtn2.setText(titleNew2);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //add something here for an error message
            }
        });

        //BUTTON THREE
        //initialization
        mbtn3 = (Button) findViewById(R.id.plant3_btn);
        //finds the reference in the database
        mTitle3 = FirebaseDatabase.getInstance().getReference().child("title3");

        mTitle3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String titleNew3 = snapshot.getValue(String.class);
                mbtn3.setText(titleNew3);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //add something here for an error message
            }
        });

    }

    //these overrides are coded in from the activity selection - not my code
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
