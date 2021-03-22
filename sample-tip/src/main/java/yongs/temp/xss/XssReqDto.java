package yongs.temp.xss;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class XssReqDto {
    private String content;

    public XssReqDto(String content) {
        this.content = content;
    }
}
