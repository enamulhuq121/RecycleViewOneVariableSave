package com.icddrb.enamappviewdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText participantNameEdit;
    private Button addParticipantBtn ;

    private Button readParticipantBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        participantNameEdit = findViewById(R.id.idParticipantName);

        addParticipantBtn = findViewById(R.id.idBtnAddParticipant);
        readParticipantBtn =findViewById(R.id.idBtnReadParticipant);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add participant button.
        addParticipantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String participantName = participantNameEdit.getText().toString();
                // we can add more variable if we have ... just now one only

                // validating if the text fields are empty or not.
                if (participantName.isEmpty() ) {
                    Toast.makeText(MainActivity.this, "Please enter the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // participant to sqlite data and pass all our values to it.
                dbHandler.addNewParticipant(participantName);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Participant has been added.", Toast.LENGTH_SHORT).show();
                participantNameEdit.setText("");

            }
        });

        readParticipantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewParticipant.class);
                startActivity(i);
            }
        });
    }
}
