package yongs.temp.vo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TObject implements Serializable {
    private String id;
    private String name;
    private LocalDate date;
}
