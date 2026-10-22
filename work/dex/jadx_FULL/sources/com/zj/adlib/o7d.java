package com.zj.adlib;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o7d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f43687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ h f18575a;

    public o7d(h hVar, Task task) {
        this.f18575a = hVar;
        this.f43687a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f18575a.f5853a) {
            h hVar = this.f18575a;
            if (hVar.f31415a != null) {
                hVar.f31415a.onFailure((Exception) yw6.l(this.f43687a.q()));
            }
        }
    }
}
