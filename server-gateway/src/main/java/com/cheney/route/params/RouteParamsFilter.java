package com.cheney.route.params;

import com.alibaba.fastjson.JSON;
import com.cheney.route.params.filter.ParamFilterHolder;
import com.cheney.route.params.filter.Params;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.http.ServletInputStreamWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数过滤器
 */
@Slf4j
public class RouteParamsFilter extends ZuulFilter {

    @Resource(name = "paramFilterHolder")
    private ParamFilterHolder paramFilterHolder;

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 50;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        return currentContext.getRouteHost() != null;
    }

    @Override
    public Object run() {
        final RequestContext context = RequestContext.getCurrentContext();
        final HttpServletRequest request = context.getRequest();
        String method = request.getMethod();
        Map<String, Object> params = null;

        if ("GET".equalsIgnoreCase(method)) {
            filterUrl(context);
        } else if ("POST".equalsIgnoreCase(method)
                || "PUT".equalsIgnoreCase(method)
                || "DELETE".equalsIgnoreCase(method)
                ) {
            if ("application/json".equals(context.getRequest().getHeader("Content-Type"))) {
                //只处理application/json
                return null;
            }
            try {
                ServletInputStream inputStream = request.getInputStream();
                ObjectMapper objectMapper = new ObjectMapper();
                //noinspection unchecked
                params = objectMapper.readValue(inputStream, Map.class);
            } catch (Exception e) {
                log.error("参数过滤错误", e);
            }
            filterBody(context, request, params != null ? params : new HashMap<String, Object>());
        }

        return null;
    }

    private void filterUrl(final RequestContext context) {
        Map<String, List<String>> requestQueryParams = context.getRequestQueryParams();
        //包装url参数
        Params params = new Params(requestQueryParams, false);
        //开始过滤
        requestQueryParams = paramFilterHolder.start(params);
        context.setRequestQueryParams(requestQueryParams);
    }

    private void filterBody(final RequestContext context, final HttpServletRequest request, Map<String, Object> params) {

        //包装request参数
        Params wrap = new Params(params, false);
        //开始过滤
        params = paramFilterHolder.start(wrap);
        final byte[] paramsBytes = JSON.toJSONString(params).getBytes(StandardCharsets.UTF_8);

        //重新包装request
        context.setRequest(new HttpServletRequestWrapper(request) {

            @Override
            public ServletInputStream getInputStream() throws IOException {
                return new ServletInputStreamWrapper(paramsBytes);
            }

            @Override
            public int getContentLength() {
                return paramsBytes.length;
            }

            @Override
            public long getContentLengthLong() {
                return paramsBytes.length;
            }
        });

    }

}
