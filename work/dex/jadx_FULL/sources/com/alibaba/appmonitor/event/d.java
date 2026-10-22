package com.alibaba.appmonitor.event;

import com.alibaba.appmonitor.pool.ReuseJSONObject;
import com.alibaba.fastjson.JSONObject;
import com.zj.adlib.nd9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class d implements com.alibaba.appmonitor.pool.b {
    public String bg;
    public int eventId;
    public long k = Long.MAX_VALUE;
    public long l = 0;
    public String module;
    public String monitorPoint;

    public JSONObject a() {
        JSONObject jSONObject = (JSONObject) com.alibaba.appmonitor.pool.a.a().a(ReuseJSONObject.class, new Object[0]);
        jSONObject.put("page", (Object) this.module);
        jSONObject.put("monitorPoint", (Object) this.monitorPoint);
        jSONObject.put(nd9.f18397d, (Object) Long.valueOf(this.k));
        jSONObject.put("end", (Object) Long.valueOf(this.l));
        String str = this.bg;
        if (str != null) {
            jSONObject.put("arg", (Object) str);
        }
        return jSONObject;
    }

    public void c(Long l) {
        if (l == null) {
            l = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        if (this.k > l.longValue()) {
            this.k = l.longValue();
        }
        if (this.l < l.longValue()) {
            this.l = l.longValue();
        }
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void clean() {
        this.eventId = 0;
        this.module = null;
        this.monitorPoint = null;
        this.bg = null;
        this.k = Long.MAX_VALUE;
        this.l = 0L;
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
        Object obj;
        this.eventId = ((Integer) objArr[0]).intValue();
        this.module = (String) objArr[1];
        this.monitorPoint = (String) objArr[2];
        if (objArr.length <= 3 || (obj = objArr[3]) == null) {
            return;
        }
        this.bg = (String) obj;
    }
}
