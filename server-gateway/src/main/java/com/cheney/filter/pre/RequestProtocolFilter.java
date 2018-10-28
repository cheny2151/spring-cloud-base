package com.cheney.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;

/**
 * 请求协议过滤器
 */
@Component
public class RequestProtocolFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final RequestContext context = RequestContext.getCurrentContext();
        final HttpServletRequest request = context.getRequest();
        String method = request.getMethod();
        Map<String, String> zuulRequestHeaders = context.getZuulRequestHeaders();
        zuulRequestHeaders.forEach((k, v) -> System.out.println("k:" + k + ";v:" + "v"));
        System.out.println("--------");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headName = headerNames.nextElement();
            System.out.println("headName:" + headName + ";v:" + request.getHeader(headName));
        }
        System.out.println("--------");

        if (method.equalsIgnoreCase("GET")) {

        } else {
            try {
                ServletInputStream inputStream = request.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    System.out.println(temp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
