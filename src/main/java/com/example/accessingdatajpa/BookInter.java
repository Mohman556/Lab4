package com.example.accessingdatajpa;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookInter {
    void saveBuddy(String addressBookName, BuddyInfo buddyInfo);
    void removeBuddy(String addressBookName, String firstName);
    void updateBuddyAddress(String addressBookName, String name, String newAddress);
    List<BuddyInfo> getBuddies(String addressBookName);
}
