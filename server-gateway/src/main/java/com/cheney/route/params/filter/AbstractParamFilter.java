package com.landsone.apigateway.filter.route.params.filter;

public abstract class AbstractParamFilter implements ParamFilter {

    @Override
    public int compareTo(ParamFilter o) {
        return this.order() - o.order();
    }

    /**
     * 排序默认10
     *
     * @return int
     */
    @Override
    public int order() {
        return 10;
    }
}
