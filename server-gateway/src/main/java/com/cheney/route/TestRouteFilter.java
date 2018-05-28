package com.cheney.route;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

@Component
public class TestRouteFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "route";
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
        System.out.println("----route----");
        return null;
    }
}
