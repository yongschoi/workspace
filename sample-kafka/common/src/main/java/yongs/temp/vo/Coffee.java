package yongs.temp.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

/**
 * Created by yogschoi@gmail.com on 2020-11-28
 * Github : http://github.com/yogschoi
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    private String name;
    private Integer price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate birthday;
}
