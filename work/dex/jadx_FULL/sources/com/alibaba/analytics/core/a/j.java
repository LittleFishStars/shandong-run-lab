package com.alibaba.analytics.core.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@com.alibaba.analytics.core.b.a.c("onlineconfig")
public class j extends com.alibaba.analytics.core.b.b {

    @com.alibaba.analytics.core.b.a.a("groupname")
    private String M = null;

    @com.alibaba.analytics.core.b.a.a("content")
    private String N = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.alibaba.analytics.core.b.a.a("timestamp")
    private long f23759a = 0;

    @com.alibaba.analytics.core.b.a.b
    private boolean C = false;

    public long a() {
        return this.f23759a;
    }

    public String p() {
        return this.M;
    }

    public void q(String str) {
        this.N = str;
    }

    public void r(String str) {
        this.M = str;
    }

    public void w() {
        this.C = true;
    }

    public void a(long j) {
        this.f23759a = j;
    }

    /* JADX INFO: renamed from: p, reason: collision with other method in class */
    public boolean m104p() {
        return this.C;
    }

    public String q() {
        return this.N;
    }
}
