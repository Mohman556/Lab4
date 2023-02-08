package com.example.accessingdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private MainController AddrController;

    @Autowired
    private ViewController viewController;

    @Test
    public void contextLoadsMainController() throws Exception {
        assertThat(AddrController).isNotNull();
    }

    @Test
    public void contextLoadsGUIController() throws Exception {
        assertThat(viewController).isNotNull();
    }



}
