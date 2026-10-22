package com.zj.adlib;

import com.google.android.gms.tasks.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zrc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f46329a;

    public zrc(f fVar) {
        this.f46329a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f46329a.f5849a) {
            f fVar = this.f46329a;
            if (fVar.f31413a != null) {
                fVar.f31413a.onCanceled();
            }
        }
    }
}
