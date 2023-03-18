package com.icddrb.enamappviewdata.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icddrb.enamappviewdata.DBHandler;
import com.icddrb.enamappviewdata.ParticipantModal;
import com.icddrb.enamappviewdata.ParticipantRVAdapter;
import com.icddrb.enamappviewdata.R;

import java.util.ArrayList;

public class ViewParticipantActivity extends AppCompatActivity {

    // creating variables for our array list, dbhandler, adapter and recycler view.

    private ArrayList<ParticipantModal> participantModalArrayList;
    private DBHandler dbHandler;
    private ParticipantRVAdapter participantRVAdapter;
    private RecyclerView participantRV;
    private Button goToAddParticipant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_participant);

        goToAddParticipant = findViewById(R.id.button);

        // initializing our all variables.
        participantModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewParticipantActivity.this);

        // getting our Participant array
        // list from db handler class.
        participantModalArrayList = dbHandler.readParticipant();

        // on below line passing our array list to our adapter class.
        participantRVAdapter = new ParticipantRVAdapter(participantModalArrayList, ViewParticipantActivity.this);
        participantRV = findViewById(R.id.idRVParticipant);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewParticipantActivity.this, RecyclerView.VERTICAL, false);
        participantRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        participantRV.setAdapter(participantRVAdapter);

        goToAddParticipant.setOnClickListener(view -> {
            startActivity(new Intent(this,MainActivity.class));
        });
    }
}

