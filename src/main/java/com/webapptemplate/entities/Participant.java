package com.webapptemplate.entities;

import de.caluga.morphium.annotations.Entity;
import de.caluga.morphium.annotations.Id;
import de.caluga.morphium.annotations.Index;
import org.bson.types.ObjectId;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 14.08.14
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */


@Entity @Index(value = {"lastName:text,firstName:text"})
public class Participant {

    @Id
    private ObjectId id;
    @Index
    private String firstName;
    @Index
    private String lastName;

    @Index
    private int age;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
