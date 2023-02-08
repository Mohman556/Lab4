package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddrRepo extends CrudRepository<AddressBook, Long> {
    AddressBook findByName(String Name);

    AddressBook findById(long ID);

}
