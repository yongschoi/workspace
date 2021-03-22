package yongs.temp.xss;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XssReqControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void 태그_치환 () {
        // String content = "<script>alert('바보');</script>";
        // String expected = "&lt;script&gt;alert(&#39;바보&#39;);&lt;/script&gt;";
        String content = "<li>content</li>";
        String expected = "&lt;li&gt;content&lt;/li&gt;";

        ResponseEntity<XssReqDto> response = testRestTemplate.postForEntity(
                "/xss",
                new XssReqDto(content),
                XssReqDto.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getContent()).isEqualTo(expected);
    }
}
