package com.icddrb.enamappviewdata;


public class ParticipantModal {

    // variables for our participantName,
    // description, tracks and duration, id.
    private String participantName;
    private int id;


    // creating getter and setter methods
    public String getParticipantName() {
        return participantName; }


    public void setParticipantName(String participantName)  {
        this.participantName = participantName;
    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public ParticipantModal(String participantName)    {
        this.participantName = participantName;

    }
}
