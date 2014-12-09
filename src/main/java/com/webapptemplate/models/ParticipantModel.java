package com.webapptemplate.models;

import de.caluga.morphium.annotations.Index;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 09.12.14
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class ParticipantModel {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
