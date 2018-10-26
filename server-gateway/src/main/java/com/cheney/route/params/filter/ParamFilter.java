package com.cheney.route.params.filter;

import java.util.Map;

public interface ParamFilter extends Comparable<ParamFilter> {

    /**
     * 过滤参数
     *
     * @param params 参数
     * @return 过滤后新的参数
     */
    Map filter(Params params);

    /**
     * 排序 越小越靠前
     *
     * @return int
     */
    int order();

}
