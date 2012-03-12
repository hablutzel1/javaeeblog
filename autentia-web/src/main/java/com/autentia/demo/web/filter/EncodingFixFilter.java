package com.autentia.demo.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFixFilter implements Filter {
    private FilterConfig filterConfig = null;

    public EncodingFixFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        if (request.getCharacterEncoding() == null) {
            String encoding = "UTF-8";
            if (filterConfig != null) {
                String encodingOverride = filterConfig.getInitParameter("defaultEncoding");
                if (encodingOverride != null)
                    encoding = encodingOverride;
            }
            request.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public String toString() {
        if (filterConfig == null) return ("EncodingFixFilter()");
        StringBuffer sb = new StringBuffer("EncodingFixFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
}