package org.example.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // 获取请求的Origin头
        String originHeader = httpRequest.getHeader("Origin");
        String requestHeaders = httpRequest.getHeader("Access-Control-Request-Headers");
        httpResponse.setHeader("Access-Control-Allow-Origin", originHeader);
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Max-Age", "16800");
        if (requestHeaders != null && !requestHeaders.isEmpty()) {
            httpResponse.setHeader("Access-Control-Allow-Headers", requestHeaders);
        } else {
            // 如果请求中没有Access-Control-Request-Headers头，则设置默认的允许的头
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}