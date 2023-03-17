package com.icddrb.enamappviewdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateParticipantActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private EditText participantNameEdit;
    private Button updateParticipantBtn, deleteParticipantBtn;
    private DBHandler dbHandler;
    String participantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_participant);

        // initializing all our variables.
        participantNameEdit = findViewById(R.id.idParticipantName);
        updateParticipantBtn = findViewById(R.id.idBtnUpdateParticipant);
        deleteParticipantBtn= findViewById(R.id.idBtnDelete);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateParticipantActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        participantName = getIntent().getStringExtra("name");


        // setting data to edit text
        // of our update activity.
        participantNameEdit.setText(participantName);


        // adding on click listener to our update Participant button.
        updateParticipantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   String participantName = participantNameEdit.getText().toString();*/

                // inside this method we are calling an update Participant
                // method and passing all our edit text values.
          //      dbHandler.updateParticipant();  String participantName = participantNameEdit.getText().toString();
                dbHandler.updateParticipant(participantName,participantNameEdit.getText().toString());

                // displaying a toast message that our Participant has been updated.
                Toast.makeText(UpdateParticipantActivity.this, "Participant Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateParticipantActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        // adding on click listener for delete button to delete our course.
        deleteParticipantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteParticipant(participantName);
                Toast.makeText(UpdateParticipantActivity.this, "Deleted the course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateParticipantActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}



