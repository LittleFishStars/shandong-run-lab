package com.zj.adlib;

import com.huachenjie.push.interfaces.PushMessageListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class p47 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static p47 f43901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PushMessageListener f18769a;

    public static p47 a() {
        p47 p47Var;
        synchronized (p47.class) {
            if (f43901a == null) {
                f43901a = new p47();
            }
            p47Var = f43901a;
        }
        return p47Var;
    }

    public PushMessageListener b() {
        return this.f18769a;
    }

    public void c(PushMessageListener pushMessageListener) {
        this.f18769a = pushMessageListener;
    }
}
