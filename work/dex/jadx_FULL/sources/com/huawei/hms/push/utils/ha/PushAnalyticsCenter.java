package com.huawei.hms.push.utils.ha;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class PushAnalyticsCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PushBaseAnalytics f37639a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static PushAnalyticsCenter f37640a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f37640a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f37639a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f37639a = pushBaseAnalytics;
    }
}
