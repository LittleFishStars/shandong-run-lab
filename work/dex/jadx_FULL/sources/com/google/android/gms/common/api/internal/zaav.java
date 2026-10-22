package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zaav implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f31261a;

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        Lock lock;
        this.f31261a.f5568a.lock();
        try {
            try {
                if (Thread.interrupted()) {
                    lock = this.f31261a.f5568a;
                } else {
                    zaa();
                    lock = this.f31261a.f5568a;
                }
            } catch (RuntimeException e) {
                this.f31261a.f5560a.u(e);
                lock = this.f31261a.f5568a;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f31261a.f5568a.unlock();
            throw th;
        }
    }

    @WorkerThread
    public abstract void zaa();
}
