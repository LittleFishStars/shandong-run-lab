package com.alibaba.analytics.core.selfmonitor;

import com.alibaba.analytics.a.j;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements com.alibaba.analytics.core.a.d.a {
    public static final g mMonitor = new g();
    private String aM = null;

    @Override // com.alibaba.analytics.core.a.d.a
    public void c(String str, String str2) {
        j.d((String) null, CachedContentIndex.a.e, str, "value", str2);
        if (str2 != null && !str2.equalsIgnoreCase(this.aM)) {
            HashMap map = new HashMap();
            map.put("value", str2);
            map.put("arrival_time", Long.valueOf(System.currentTimeMillis() / 1000));
            map.put("app_start_time", Long.valueOf(com.alibaba.analytics.core.d.g.a().b()));
            mMonitor.a(f.a(f.n, JSON.toJSONString(map), Double.valueOf(1.0d)));
            j.d((String) null, "json", JSON.toJSONString(map));
        }
        this.aM = str2;
    }

    public void start() {
        com.alibaba.analytics.core.a.d.a().a("test_config_arrival_rate", this);
    }
}
