package com.cheney.error;

import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MySendErrorFilter extends SendErrorFilter {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            Throwable throwable = context.getThrowable();
            logger.error(throwable.getMessage(), throwable);
            context.getResponse().getWriter().write("zuul error");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
