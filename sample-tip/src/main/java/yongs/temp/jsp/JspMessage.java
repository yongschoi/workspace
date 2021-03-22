package yongs.temp.jsp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JspMessage {
    private String message;
    public JspMessage(String message) {
        this.message = message;
    }
}
