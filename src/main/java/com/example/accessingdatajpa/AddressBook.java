package com.example.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.*;

@Entity
public class AddressBook {

    private Long id;
    private String name = "Book";
    private List<BuddyInfo> Buddies;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public AddressBook() {
        Buddies = new ArrayList<BuddyInfo>();
    }
    public AddressBook(String name) {
        this.name = name;
        Buddies = new ArrayList<BuddyInfo>();
    }
    public void addBud(String name, String pnumber){
        BuddyInfo Bud = new BuddyInfo(name, pnumber);
        Buddies.add(Bud);
    }
    public void addThisBud(BuddyInfo bud){
        Buddies.add(bud);
    }
    public void addNewBud(BuddyInfo bud){
        Buddies.add(bud);
    }
    public void removeBud(String name){
        for (int i = 0; i < Buddies.size(); i++){
            if (Buddies.get(i).getName().equals(name)){
                Buddies.remove(i);
            }
        }
    }
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<BuddyInfo> getBuddies(){
        return Buddies;
    }

    public void setBuddies(List<BuddyInfo> Buddies){this.Buddies = Buddies;}

    public String showBook(){
        String str = "";
        System.out.println("Address Book\n --------------------");
        str += "Address Book\n --------------------";
        for (BuddyInfo bud : Buddies){
           System.out.println("Name : "+ bud.getName() + " - Phone Number: " + bud.getPnumber());
           str += "Name : "+ bud.getName() + " - Phone Number: " + bud.getPnumber();
        }

        return str;
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        book.addBud("Lanks", "613737111");
        book.addBud("Dooks", "613350350");
        book.showBook();
    }


}
