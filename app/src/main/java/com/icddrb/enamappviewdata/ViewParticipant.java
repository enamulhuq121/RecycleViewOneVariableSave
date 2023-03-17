package com.icddrb.enamappviewdata;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewParticipant extends AppCompatActivity {

    // creating variables for our array list, dbhandler, adapter and recycler view.

    private ArrayList<ParticipantModal> participantModalArrayList;
    private DBHandler dbHandler;
    private ParticipantRVAdapter participantRVAdapter;
    private RecyclerView participantRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_participant);

        // initializing our all variables.
        participantModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewParticipant.this);

        // getting our Participant array
        // list from db handler class.
        participantModalArrayList = dbHandler.readParticipant();

        // on below line passing our array list to our adapter class.
        participantRVAdapter = new ParticipantRVAdapter(participantModalArrayList, ViewParticipant.this);
        participantRV = findViewById(R.id.idRVParticipant);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewParticipant.this, RecyclerView.VERTICAL, false);
        participantRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        participantRV.setAdapter(participantRVAdapter);
    }
}

