package com.zj.adlib;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xdd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f45803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ i f20648a;

    public xdd(i iVar, Task task) {
        this.f20648a = iVar;
        this.f45803a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f20648a.f5855a) {
            i iVar = this.f20648a;
            if (iVar.f31416a != null) {
                iVar.f31416a.onSuccess(this.f45803a.r());
            }
        }
    }
}
