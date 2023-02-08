package com.example.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;

    private String pnumber;
    public BuddyInfo(String name, String pnumber) {
        this.name = name;
        this.pnumber = pnumber;
    }
    public BuddyInfo() {
        this.name = "Mo";
        this.pnumber = "613520";
    }

    public String getName() {
        return name;
    }


    public String getPnumber() {
        return pnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Buddy - Name: " + getName() + ". Phone Number: " + getPnumber();
    }
}
