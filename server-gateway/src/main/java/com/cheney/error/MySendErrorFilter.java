package com.cheney.error;

import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MySendErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            context.getResponse().getWriter().write("zuul error");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
