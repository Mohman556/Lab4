package com.example.accessingdatajpa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInterimpl implements BookInter {
    private final AddrRepo addressBookRepo;
    private final BuddyRepository buddyInfoRepo;

    public BookInterimpl(AddrRepo addressBookRepo, BuddyRepository buddyInfoRepo) {
        this.addressBookRepo = addressBookRepo;
        this.buddyInfoRepo = buddyInfoRepo;
    }

    @Override
    public void saveBuddy(String addressBookName, BuddyInfo buddyInfoModel) {
        BuddyInfo b = buddyInfoRepo.save(buddyInfoModel);
        AddressBook addressBookModel = addressBookRepo.findByName(addressBookName);
        if (addressBookModel != null) {
            addressBookModel.addThisBud(b);
        } else {
            addressBookModel = new AddressBook(addressBookName);
            addressBookModel.addThisBud(b);
        }
        addressBookRepo.save(addressBookModel);

    }

    @Override
    public void removeBuddy(String addressBookName, String name) {
        BuddyInfo buddyInfoModel = buddyInfoRepo.findByName(name);
        AddressBook addressBookModel = addressBookRepo.findByName(addressBookName);
        addressBookModel.removeBud(name);
        buddyInfoRepo.delete(buddyInfoModel);
        addressBookRepo.save(addressBookModel);
    }

    @Override
    public void updateBuddyAddress(String addressBookName, String name, String newAddress) {
        AddressBook addressBookModel = addressBookRepo.findByName(addressBookName);
        BuddyInfo buddyInfoModel = buddyInfoRepo.findByName(name);
        addressBookModel.removeBud(name);
        buddyInfoRepo.save(buddyInfoModel);
        addressBookModel.addThisBud(buddyInfoModel);
        addressBookRepo.save(addressBookModel);
    }

    @Override
    public List<BuddyInfo> getBuddies(String addressBookName) {
        AddressBook addressBookModel = addressBookRepo.findByName(addressBookName);
        return addressBookModel.getBuddies();
    }
}
