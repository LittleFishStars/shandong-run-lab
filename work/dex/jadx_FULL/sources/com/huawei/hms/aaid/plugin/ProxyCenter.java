package com.huawei.hms.aaid.plugin;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ProxyCenter {
    private PushProxy proxy;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ProxyCenter f37411a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return a.f37411a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
