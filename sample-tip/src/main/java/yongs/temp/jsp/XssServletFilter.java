package yongs.temp.jsp;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeFilter;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilterWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class XssServletFilter implements Filter {
    private String[] acceptUrls;
    private XssEscapeFilter xssEscapeFilter = XssEscapeFilter.getInstance();

    public XssServletFilter(String[] acceptUrls){
        this.acceptUrls = acceptUrls;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(excludeUrl(request)){
            chain.doFilter(request, response); //걸러내는 URI일 경우 요청값 그대로 처리
        }else{
            chain.doFilter(new XssEscapeServletFilterWrapper(request, xssEscapeFilter), response);
        }
    }

    private boolean excludeUrl(ServletRequest request) {
        String uri = ((HttpServletRequest) request).getRequestURI().toString().trim();
        log.info("XssServletFilter Uri : {}", uri);
        boolean returnValue = false;
        for(String url : this.acceptUrls) {
            if(uri.startsWith(url)){
                returnValue = true;
            }
        }
        return returnValue;
    }
    @Override
    public void destroy() { }
}
