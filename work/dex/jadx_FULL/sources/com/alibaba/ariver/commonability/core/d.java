package com.alibaba.ariver.commonability.core;

import androidx.collection.ArrayMap;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Long> f23943a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f23944a = new d();

        private a() {
        }
    }

    public void a(String str) {
        if (this.f23943a.containsKey(str)) {
            return;
        }
        this.f23943a.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    private d() {
        this.f23943a = new ArrayMap();
    }

    public void a(String str, int i) {
        Long lRemove;
        if (this.f23943a.containsKey(str) && (lRemove = this.f23943a.remove(str)) != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - lRemove.longValue();
            RVLogger.d(str, "cost time:" + jCurrentTimeMillis);
            com.alibaba.ariver.commonability.core.util.c.a("1010466").a(i).a("scene", str).a(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(jCurrentTimeMillis)).a();
        }
    }

    public static d a() {
        return a.f23944a;
    }
}
