package com.zj.adlib;

import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class gh9 implements Runnable {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransportContext f41906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lh9 f16764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f16765a;

    public gh9(lh9 lh9Var, TransportContext transportContext, int i, Runnable runnable) {
        this.f16764a = lh9Var;
        this.f41906a = transportContext;
        this.K = i;
        this.f16765a = runnable;
    }

    public static Runnable a(lh9 lh9Var, TransportContext transportContext, int i, Runnable runnable) {
        return new gh9(lh9Var, transportContext, i, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        lh9.e(this.f16764a, this.f41906a, this.K, this.f16765a);
    }
}
