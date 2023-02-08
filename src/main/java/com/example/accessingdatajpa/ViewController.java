package com.example.accessingdatajpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private final AddrRepo Addr;

    public ViewController(AddrRepo addr) {
        Addr = addr;
    }


    @GetMapping
    public String getAddressBook(Model model) {
        AddressBook addressBook = Addr.findByName("mybook");
        model.addAttribute("AddressBookModel", addressBook);
        model.addAttribute("Buddies", addressBook.getBuddies());
        return "view2";
    }
//    @RequestMapping (value = "/getting", method = RequestMethod.GET)
//    public String getting(@RequestParam(value = "Name") String name, Model model){
//        AddressBook addr = Addr.findByName(name);
//        model.addAttribute("AddressBook", addr);
//        model.addAttribute("Buddies", addr.getBuddies());
//        return "View";
//    }
}
