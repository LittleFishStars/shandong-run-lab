package com.kc.cw.ad.internal;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class s implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f39061a = -1;
    private ArrayList<String> b = new ArrayList<>();

    public abstract void c();

    public void e() {
        this.f39061a = System.currentTimeMillis();
    }

    public void f() {
        if (this.b.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("Mediation Classes: \n");
        for (int size = this.b.size(); size > 0; size--) {
            sb.append(String.format("%d: %s\n", Integer.valueOf(size), this.b.get(size - 1)));
        }
        com.kc.cw.ad.internal.c.f.c(com.kc.cw.ad.internal.c.f.b, sb.toString());
        this.b.clear();
    }
}
