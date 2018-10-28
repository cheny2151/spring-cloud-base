package com.cheney.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Map参数包装类
 */
public class Params {

    private Map<String, List<Object>> params1;

    private Map<String, Object> params2;

    private boolean isGet;

    @SuppressWarnings("unchecked")
    public Params(Object params, boolean isGet) {
        if (isGet) {
            this.params1 = (Map<String, List<Object>>) params;
            this.isGet = true;
        } else {
            this.params2 = (Map<String, Object>) params;
            this.isGet = false;
        }

    }

    public Object get(String key) {
        if (isGet)
            return params1.get(key);
        else
            return params2.get(key);
    }

    public void remove(String key) {
        if (isGet)
            params1.remove(key);
        else
            params2.remove(key);
    }

    public void put(String key, Object value) {
        if (isGet) {
            if (List.class.isAssignableFrom(value.getClass())) {
                params1.put(key, (List<Object>) value);
            } else {
                ArrayList<Object> list = new ArrayList<>();
                list.add(value);
                params1.put(key, list);
            }
        } else {
            params2.put(key, value);
        }
    }

    public boolean contains(String key) {
        if (isGet)
            return params1.containsKey(key);
        else
            return params2.containsKey(key);
    }

    public Map unwrap() {
        if (isGet)
            return params1;
        else
            return params2;
    }

}
