package com.dtv.models;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 14.08.14
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class ParticipantRequestResult {

    private List<Participant> participants;
    private long numFound;


    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }


    public long getNumFound() {
        return numFound;
    }

    public void setNumFound(long numFound) {
        this.numFound = numFound;
    }
}
