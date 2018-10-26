package com.landsone.apigateway.filter.route.params.filter;

import java.util.Map;

public class IgnoreParamsFilter extends AbstractParamFilter {

    /**
     * 不转发的参数name
     */
    private final static String[] ignoreParams = new String[]{"appKey", "platform", "sign"
            , "timestamp", "deviceId"};

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
