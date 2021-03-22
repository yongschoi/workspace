package yongs.temp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import yongs.temp.jsp.XssServletFilter;
import yongs.temp.xss.HtmlCharacterEscapes;
@Configuration
public class WebXssConfig {
    /*
     * WebXssConfig for lucy-xss-servlet
     */
    private static String[] acceptUrls = {"/admin"};
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new XssServletFilter(acceptUrls));
        // registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
    /*
     * WebXssConfig for JSON
     */
    private final ObjectMapper objectMapper;

    public WebXssConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    public MappingJackson2HttpMessageConverter jsonEscapeConverter() {
        ObjectMapper copy = objectMapper.copy();
        copy.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());
        return new MappingJackson2HttpMessageConverter(copy);
    }
}
