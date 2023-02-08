package com.example.accessingdatajpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BuddyRepository extends CrudRepository<BuddyInfo, Long>{
    BuddyInfo findByName(String Name);
    BuddyInfo findById(long ID);
}
