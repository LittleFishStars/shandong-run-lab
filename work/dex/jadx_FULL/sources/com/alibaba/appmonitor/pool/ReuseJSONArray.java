package com.alibaba.appmonitor.pool;

import com.alibaba.fastjson.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ReuseJSONArray extends JSONArray implements b {
    private static final long serialVersionUID = -4243576223670082606L;

    @Override // com.alibaba.appmonitor.pool.b
    public void clean() {
        for (Object obj : this) {
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
