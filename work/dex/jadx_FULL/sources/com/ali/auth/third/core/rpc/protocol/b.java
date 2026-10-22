package com.ali.auth.third.core.rpc.protocol;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadLocal<String> f23430a = new ThreadLocal<>();

    public static String a() {
        return f23430a.get();
    }

    public static void a(String str) {
        f23430a.set(str);
    }
}
