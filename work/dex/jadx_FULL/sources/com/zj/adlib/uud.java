package com.zj.adlib;

import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class uud implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e19 f45232a;

    public /* synthetic */ uud(e19 e19Var, jud judVar) {
        this.f45232a = e19Var;
        yw6.r(((Thread) e19Var.f16171a.getAndSet(Thread.currentThread())) == null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f45232a.f16171a.set(null);
        this.f45232a.e();
    }
}
