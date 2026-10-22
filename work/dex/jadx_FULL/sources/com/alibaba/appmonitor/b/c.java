package com.alibaba.appmonitor.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends com.alibaba.analytics.core.b.b {

    @com.alibaba.analytics.core.b.a.a("access")
    public String aj;

    @com.alibaba.analytics.core.b.a.a("sub_access")
    public String ak;

    @com.alibaba.analytics.core.b.a.a("commit_time")
    public long m;

    @com.alibaba.analytics.core.b.a.a("module")
    public String module;

    @com.alibaba.analytics.core.b.a.a("monitor_point")
    public String monitorPoint;

    public c() {
    }

    public String toString() {
        return "TempEvent{}";
    }

    public c(String str, String str2, String str3, String str4) {
        this.module = str;
        this.monitorPoint = str2;
        this.m = System.currentTimeMillis() / 1000;
        this.aj = str3;
        this.ak = str4;
    }
}
