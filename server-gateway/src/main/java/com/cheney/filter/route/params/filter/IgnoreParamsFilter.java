package com.cheney.filter.route.params.filter;

import com.cheney.bean.Params;

import java.util.Map;

public class IgnoreParamsFilter extends AbstractParamFilter {

    /**
     * 不转发的参数name
     */
    private final static String[] ignoreParams = new String[]{};

    @Override
    public int order() {
        return 1;
    }

    @Override
    public Map filter(Params params) {
        for (String s : ignoreParams) {
            params.remove(s);
        }
        return params.unwrap();
    }

}
