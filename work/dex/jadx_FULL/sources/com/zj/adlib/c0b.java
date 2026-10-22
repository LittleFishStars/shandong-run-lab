package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class c0b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c0b f40876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15670a = "";

    public static c0b a() {
        if (f40876a == null) {
            synchronized (c0b.class) {
                if (f40876a == null) {
                    f40876a = new c0b();
                }
            }
        }
        return f40876a;
    }

    public static void b(kha khaVar) {
        try {
            khaVar.p = a().f15670a;
            khaVar.n = "";
            khaVar.o = "";
        } catch (Throwable unused) {
        }
    }
}
