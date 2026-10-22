package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zabg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zabf f31262a;

    public zabg(zabf zabfVar) {
        this.f31262a = zabfVar;
    }

    public final void a(r rVar) {
        Lock lock;
        rVar.f5603a.lock();
        try {
            if (rVar.f5597a != this.f31262a) {
                lock = rVar.f5603a;
            } else {
                zaa();
                lock = rVar.f5603a;
            }
            lock.unlock();
        } catch (Throwable th) {
            rVar.f5603a.unlock();
            throw th;
        }
    }

    public abstract void zaa();
}
