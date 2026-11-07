
package com.klu.MultiParameterTesting;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class AdditionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdditionWithNegativeNumber() throws Exception {

        MvcResult result = mockMvc.perform(get("/ms1/add")
                .param("a", "-5")
                .param("b", "5"))

                .andExpect(status().isOk())
                .andExpect(content().string("MS 1.1 - Additon = 0"))
                .andReturn();

        System.out.println("========== TEST OUTPUT ==========");
        System.out.println(result.getResponse().getContentAsString());
        System.out.println("=================================");
    }
}
