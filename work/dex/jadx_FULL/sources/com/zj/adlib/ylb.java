package com.zj.adlib;

import cn.hzjizhun.admin.base.f0;
import cn.hzjizhun.admin.base.n0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ylb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zmb f46063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f20883a;

    public ylb(zmb zmbVar, Runnable runnable) {
        this.f46063a = zmbVar;
        this.f20883a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f46063a.getClass();
        if (zmb.e() || !f0.b() || this.f46063a.c() || this.f46063a.b() || n0.d()) {
            return;
        }
        this.f46063a.getClass();
        if (zmb.d()) {
            return;
        }
        this.f20883a.run();
    }
}
