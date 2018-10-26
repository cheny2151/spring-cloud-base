package com.cheney.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

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
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        System.out.println(request.getParameter("test"));
        request.setAttribute("zuul", "success");
        System.out.println(request.getAttribute("zuul"));
        return null;
    }

}
