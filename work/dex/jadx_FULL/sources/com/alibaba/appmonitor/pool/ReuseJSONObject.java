package com.alibaba.appmonitor.pool;

import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ReuseJSONObject extends JSONObject implements b {
    private static final long serialVersionUID = 1465414806753619992L;

    @Override // com.alibaba.appmonitor.pool.b
    public void clean() {
        for (Object obj : values()) {
            if (obj instanceof b) {
                a.a().a((b) obj);
            }
        }
        super.clear();
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
    }
}
