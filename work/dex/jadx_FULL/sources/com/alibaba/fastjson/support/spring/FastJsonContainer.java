package com.alibaba.fastjson.support.spring;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FastJsonContainer {
    private PropertyPreFilters filters;
    private Object value;

    public FastJsonContainer(Object obj) {
        this.value = obj;
    }

    public PropertyPreFilters getFilters() {
        return this.filters;
    }

    public Object getValue() {
        return this.value;
    }

    public void setFilters(PropertyPreFilters propertyPreFilters) {
        this.filters = propertyPreFilters;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
