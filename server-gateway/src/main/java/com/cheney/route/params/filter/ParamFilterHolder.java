package com.cheney.route.params.filter;

import java.util.ArrayList;
import java.util.Map;

public class ParamFilterHolder {

    private ArrayList<ParamFilter> paramFilters = new ArrayList<>();

    public void add(ParamFilter paramFilter) {
        if (paramFilter == null) return;
        paramFilters.add(paramFilter);
    }

    public Map start(Params wrap) {
        for (ParamFilter paramFilter : paramFilters) {
            paramFilter.filter(wrap);
        }
        return wrap.unwrap();
    }

}
