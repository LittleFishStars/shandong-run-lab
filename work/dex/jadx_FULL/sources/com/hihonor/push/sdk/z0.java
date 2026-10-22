package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f32688a;
    public final /* synthetic */ Callable b;

    public z0(n0 n0Var, Callable callable) {
        this.f32688a = n0Var;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f32688a.a(this.b.call());
        } catch (Exception e) {
            this.f32688a.a(e);
        }
    }
}
