package com.zj.adlib;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gvd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iud f41998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Callable f16889a;

    public gvd(iud iudVar, Callable callable) {
        this.f41998a = iudVar;
        this.f16889a = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f41998a.z(this.f16889a.call());
        } catch (Exception e) {
            this.f41998a.y(e);
        } catch (Throwable th) {
            this.f41998a.y(new RuntimeException(th));
        }
    }
}
