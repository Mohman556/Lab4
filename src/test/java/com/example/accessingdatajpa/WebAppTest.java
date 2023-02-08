package com.example.accessingdatajpa;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class WebAppTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createBuddyTest() throws Exception {
        BuddyInfo buddyInfo = new BuddyInfo("hello", "613-123-1245");

        mockMvc.perform(post("/addressbook/mybook/buddies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(buddyInfo))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("hello"))
                .andExpect(jsonPath("$.pnumber").value("613-123-1245"));
    }

    @Test
    public void getBuddiesTest() throws Exception {
        BuddyInfo buddyInfoModel = new BuddyInfo("mo", "613 500");

        mockMvc.perform(post("/addressbook/mybook/buddies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(buddyInfoModel))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


        mockMvc.perform(get("/addressbook/mybook/buddies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteBuddyTest() throws Exception {
        BuddyInfo buddyInfoModel = new BuddyInfo("Mo", "613-123-1245");

        mockMvc.perform(post("/addressbook/mybuddy/buddies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(buddyInfoModel))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        mockMvc.perform(delete("/addressbook/mybuddy/buddies/Mo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("Buddy named Mo has been deleted!")));
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
