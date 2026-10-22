package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class y {
    private static y b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f37592a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.f37592a.containsKey(str)) {
            this.f37592a.put(str, new p0());
        }
        return this.f37592a.get(str);
    }

    public static y a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        if (b == null) {
            b = new y();
        }
    }

    public p0 a(String str, long j) {
        p0 p0VarA = a(str);
        p0VarA.a(j);
        return p0VarA;
    }
}
