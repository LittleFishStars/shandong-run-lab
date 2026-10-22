package com.alibaba.triver.kit.api.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ActionSheetCache {
    private Map<String, Object> mData = new HashMap();

    public void add(String str, Object obj) {
        if (this.mData == null) {
            this.mData = new HashMap();
        }
        this.mData.put(str, obj);
    }

    public Map<String, Object> getData() {
        return this.mData;
    }

    public void setData(Map<String, Object> map) {
        this.mData = map;
    }
}
