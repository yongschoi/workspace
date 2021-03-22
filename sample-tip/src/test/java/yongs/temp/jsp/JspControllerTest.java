package yongs.temp.jsp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import yongs.temp.config.WebMvcConfig;
import yongs.temp.config.WebXssConfig;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest({JspController.class, WebXssConfig.class})
public class JspControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void GET_JSP_lucy_xss_적용() throws Exception {
        String content = "<script>alert('바보');</script>";
        String expected = "&lt;script&gt;alert(&#39;바보&#39;);&lt;/script&gt;";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("keyword", Arrays.asList(content));

        mvc.perform(get("/searching")
                .params(params))
                .andExpect(status().isOk())
                .andExpect(model().attribute("keyword", expected));
    }
    @Test
    public void POST_JSP_lucy_xss_적용() throws Exception {
        String content = "<script>alert('바보');</script>";
        String expected = "&lt;script&gt;alert(&#39;바보&#39;);&lt;/script&gt;";

        mvc.perform(post("/boarding")
                .param("message", content))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", expected));
    }
}
