package com.beizi.fusion;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class qn {
    private static volatile qn b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f27699a = new HashMap();

    public static qn a() {
        if (b == null) {
            synchronized (qn.class) {
                if (b == null) {
                    b = new qn();
                }
            }
        }
        return b;
    }

    public void b(String str) {
        if (this.f27699a.containsKey(str)) {
            this.f27699a.remove(str);
        }
    }

    public void a(String str, long j) {
        this.f27699a.put(str, Long.valueOf(j));
    }

    public long a(String str) {
        if (this.f27699a.containsKey(str)) {
            return ((Long) this.f27699a.get(str)).longValue();
        }
        return 0L;
    }
}
