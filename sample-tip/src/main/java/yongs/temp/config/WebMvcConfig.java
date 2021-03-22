package yongs.temp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yongs.temp.date.LocalDateFormatter;

@Configuration
public class WebMvcConfig {
    @Bean
    public LocalDateFormatter localDateFormatter() {
        return new LocalDateFormatter();
    }
}
