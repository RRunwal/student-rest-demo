package com.galvanize;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void testGetStudentInfo() throws Exception {
        String url = "/student?studentName=Rachana&studentId=1&studentEmail=rrunwal@aol.com&courseStartDate=2/1/2020&courseEndDate=5/15/2020&courseName=Java&score=67";
        mvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("rrunwal@aol.com")))
                .andExpect(jsonPath("$.courseDays").value(104));
    }

    @Test
    void testPostStudentObject() throws Exception {
        String json = "{\"studentName\":\"Rachana\",\"studentId\":\"1\",\"studentEmail\":\"rrunwal@aol.com\",\"courseStartDate\":\"2/1/2020\",\"courseEndDate\":\"5/15/2020\",\"courseName\":\"Java\",\"score\":\"67\"}";
        mvc.perform(post("/student")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("rrunwal@aol.com")))
                .andExpect(jsonPath("$.courseDays").value(104));
    }
}
