package com.cheney.javaconfig;

import com.cheney.filter.route.params.filter.IgnoreParamsFilter;
import com.cheney.filter.route.params.filter.ParamFilterHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    /**
     * 请求参数过滤器
     *
     * @return
     */
    @Bean
    public IgnoreParamsFilter ignoreParamsFilter() {
        return new IgnoreParamsFilter();
    }

    /**
     * request参数过滤器管理类
     *
     * @return
     */
    @Bean(name = "paramFilterHolder")
    public ParamFilterHolder paramFilterHolder() {
        ParamFilterHolder filterHolder = new ParamFilterHolder();
        filterHolder.add(ignoreParamsFilter());
        return filterHolder;
    }

}
