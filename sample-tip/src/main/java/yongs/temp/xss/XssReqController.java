package yongs.temp.xss;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class XssReqController {
    @PostMapping("/xss")
    public @ResponseBody XssReqDto xss (@RequestBody XssReqDto xssReqDto) {
        log.info("requestDto={}", xssReqDto);

        return xssReqDto;
    }
}