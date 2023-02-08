package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class MainController {


    private final BookInter Books;

    public MainController(BookInter Books){
        this.Books = Books;
    }


    @PostMapping("/{addressBookName}/buddies")
    public ResponseEntity<?> create(@PathVariable("addressBookName") String addressBookName,
                                    @RequestBody BuddyInfo buddyInfoModel) {
        try {
            Books.saveBuddy(addressBookName, buddyInfoModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/addressbook").toUriString());
        return ResponseEntity.created(uri).body(buddyInfoModel);
    }

    @GetMapping("/{addressBookName}/buddies")
    public ResponseEntity<?> get(@PathVariable("addressBookName") String addressBookName) {
        List<BuddyInfo> buddies;
        try {
            buddies = Books.getBuddies(addressBookName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + addressBookName); //ResponseEntity.status(HttpStatus.NOT_FOUND).body("No buddies found for AddressBook with name of " + addressBookName);
        }
        return ResponseEntity.ok().body(buddies);
    }

    @PutMapping("/{addressBookName}/buddies/{buddyName}")
    public ResponseEntity<?> update(@PathVariable("addressBookName") String addressBookName,
                                    @PathVariable("buddyName") String buddyName,
                                    @RequestBody Map<String, String> values) {
        try {
            Books.updateBuddyAddress(addressBookName, buddyName, values.get("newAddress"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("New Address has been updated to buddy named " + buddyName);
    }

    @DeleteMapping("/{addressBookName}/buddies/{buddyName}")
    public ResponseEntity<?> delete(@PathVariable("addressBookName") String addressBookName,
                                    @PathVariable("buddyName") String buddyName) {
        try {
            Books.removeBuddy(addressBookName, buddyName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Buddy named " + buddyName + " has been deleted!");
    }


}
