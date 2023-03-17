package com.icddrb.enamappviewdata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParticipantRVAdapter extends RecyclerView.Adapter<ParticipantRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<ParticipantModal> participantModalArrayList;
    private Context context;

    // constructor
    public ParticipantRVAdapter(ArrayList<ParticipantModal> participantModalArrayList, Context context) {
        this.participantModalArrayList = participantModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.participant_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        ParticipantModal modal = participantModalArrayList.get(position);
        holder.participantNameTV.setText(modal.getParticipantName());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateParticipantActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getParticipantName());


                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return participantModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView participantNameTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            participantNameTV = itemView.findViewById(R.id.idTVPartipantName);

        }
    }
}