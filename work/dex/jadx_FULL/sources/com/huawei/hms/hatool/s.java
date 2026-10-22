package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class s {
    static Map<String, l1> b = new HashMap();
    private static s c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g1 f37584a = new g1();

    private s() {
    }

    public static s c() {
        if (c == null) {
            d();
        }
        return c;
    }

    private static synchronized void d() {
        if (c == null) {
            c = new s();
        }
    }

    public l1 a(String str) {
        return b.get(str);
    }

    public Set<String> a() {
        return b.keySet();
    }

    public void a(String str, l1 l1Var) {
        b.put(str, l1Var);
    }

    public g1 b() {
        return this.f37584a;
    }
}
