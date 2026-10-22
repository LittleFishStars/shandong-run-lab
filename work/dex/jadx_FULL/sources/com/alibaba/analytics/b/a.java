package com.alibaba.analytics.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f23750a = null;
    private static String bf = "6.5.8.27-bc";

    private a() {
    }

    public static synchronized a a() {
        if (f23750a == null) {
            f23750a = new a();
        }
        return f23750a;
    }

    public String E() {
        return bf;
    }
}
