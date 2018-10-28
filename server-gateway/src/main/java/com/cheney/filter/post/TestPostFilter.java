package com.cheney.filter.post;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

@Component
public class TestPostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
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
        return null;
    }

}
