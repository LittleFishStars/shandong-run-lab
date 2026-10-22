package com.zj.adlib;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class szc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f44819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ g f19688a;

    public szc(g gVar, Task task) {
        this.f19688a = gVar;
        this.f44819a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f19688a.f5851a) {
            g gVar = this.f19688a;
            if (gVar.f31414a != null) {
                gVar.f31414a.onComplete(this.f44819a);
            }
        }
    }
}
