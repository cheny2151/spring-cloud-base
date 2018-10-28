package com.cheney.filter.error;

import com.cheney.bean.response.ResponseEntity;
import com.cheney.exception.RouteStopException;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RouteErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            Throwable throwable = context.getThrowable();
            if (RouteStopException.class.isAssignableFrom(throwable.getClass())) {
                RouteStopException exception = (RouteStopException) throwable;
                context.setResponseBody(exception.getResponse().toJson());
            } else {
                context.setResponseBody(ResponseEntity.DEFAULT_ERROR_RESPONSE.toJson());
            }
            log.error("error filter -> msg:{}", throwable.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
