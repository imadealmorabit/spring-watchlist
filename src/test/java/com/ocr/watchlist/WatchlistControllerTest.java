package com.ocr.watchlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest
@RunWith(SpringRunner.class)
public class WatchlistControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testShowWatchlistItemForm() throws Exception {

        mockMvc.perform(get("/watchListItemForm"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("watchListItemForm"))
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("watchListItem"));
    }

}
