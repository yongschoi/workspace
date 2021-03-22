package yongs.temp.date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import yongs.temp.config.WebMvcConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ReqDtoContorller.class, WebMvcConfig.class})
public class ReqDtoControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void 없는날짜_변환() throws Exception {
        //when
        LocalDate date = LocalDate.parse("2020-02-31", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        //then
        assertThat(date).isEqualTo(LocalDate.of(2020,2,29));
    }

    @Test
    public void GET_없는날짜_LocalDate바인딩() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("date", Arrays.asList("2020-02-31"));

        mvc.perform(get("/req/setter")
                .params(params)
                .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().contentType(MediaType.APPLICATION_JSON))
           .andExpect(content().json("{\"date\":\"2020-02-29\"}"));
    }

    @Test
    public void POST_없는날짜_LocalDate바인딩() throws Exception {
        String content = "{\"date\":\"2020-02-31\"}";
        mvc.perform(post("/req/setter")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().contentType(MediaType.APPLICATION_JSON))
           .andExpect(content().json("{\"date\":\"2020-02-29\"}"));
    }
}
