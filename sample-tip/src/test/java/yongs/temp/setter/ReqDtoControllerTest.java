package yongs.temp.setter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import yongs.temp.config.WebMvcConfig;
import yongs.temp.date.ReqDtoContorller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({RequestDtoSetterController.class, WebMvcConfig.class})
public class ReqDtoControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void POST_RequestBody에서_setter없이() throws Exception {
        String content = objectMapper.writeValueAsString(new RequestSetterDto("yongschoi", 1000L));
        mvc.perform(post("/request/setter")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().contentType(MediaType.APPLICATION_JSON))
           .andExpect(content().json(content));
    }

    @Test
    public void GET_RequestBody에서_setter없이() throws Exception {
        String expected = objectMapper.writeValueAsString(new RequestSetterDto("yongschoi", 1000L,  LocalDate.of(2019,2,22), RequestSetterDto.RequestType.GET));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("name", Arrays.asList("yongschoi"));
        params.put("amount", Arrays.asList("1000"));
        params.put("date", Arrays.asList("2019-02-22"));
        params.put("requestType", Arrays.asList("GET"));

        mvc.perform(get("/request/setter")
                .params(params)
                .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().contentType(MediaType.APPLICATION_JSON))
           .andExpect(content().json(expected));
    }
}
