package com.alibaba.triver.kit.api.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MenuInfoCache {
    String event;
    private Map<String, Object> mData = new HashMap();

    public Map<String, Object> getData() {
        return this.mData;
    }

    public String getEvent() {
        return this.event;
    }

    public void setData(Map<String, Object> map) {
        this.mData = map;
    }

    public void setEvent(String str) {
        this.event = str;
    }
}
