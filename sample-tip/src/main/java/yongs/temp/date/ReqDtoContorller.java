package yongs.temp.date;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ReqDtoContorller {
    @GetMapping("/req/setter")
    public ReqDto getRequestSetter (ReqDto requestSetterDto) {
        log.info("requestDto={}", requestSetterDto.toString());

        return requestSetterDto;
    }

    @PostMapping("/req/setter")
    public ReqDto postRequestSetter (@RequestBody ReqDto requestSetterDto) {
        log.info("requestDto={}", requestSetterDto.toString());

        return requestSetterDto;
    }
}
