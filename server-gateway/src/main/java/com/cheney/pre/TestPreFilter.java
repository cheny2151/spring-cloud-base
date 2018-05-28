package com.cheney.pre;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

@Component
public class TestPreFilter extends ZuulFilter {

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
        System.out.println("---pre--");
        return null;
    }

}
