package com.zj.adlib;

import com.google.android.gms.common.api.internal.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r1c implements Runnable {
    public final /* synthetic */ int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f44345a;

    public r1c(t tVar, int i) {
        this.f44345a = tVar;
        this.K = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44345a.h(this.K);
    }
}
