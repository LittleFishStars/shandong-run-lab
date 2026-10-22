package com.alibaba.ariver.kernel.common.runnable;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OneShotRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24269a = "AriverKernel:OneShotRunnable";
    static boolean sUseWeakRef = false;
    private String b;
    private WeakReference<Runnable> c;
    private Runnable d;
    private AtomicBoolean e;

    public OneShotRunnable(Runnable runnable) {
        this("EMPTY", runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.e.getAndSet(true)) {
            RVLogger.d(f24269a, "OneShotRunnable [" + this.b + "] already executed!");
            return;
        }
        if (!sUseWeakRef) {
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
                this.d = null;
                return;
            }
            return;
        }
        WeakReference<Runnable> weakReference = this.c;
        if (weakReference != null) {
            Runnable runnable2 = weakReference.get();
            if (runnable2 != null) {
                runnable2.run();
            } else {
                RVLogger.d(f24269a, "OneShotRunnable [" + this.b + "] already recycled!");
            }
            this.c = null;
        }
    }

    public OneShotRunnable(String str, Runnable runnable) {
        this.e = new AtomicBoolean(false);
        this.b = str;
        if (sUseWeakRef) {
            this.c = new WeakReference<>(runnable);
        } else {
            this.d = runnable;
        }
    }
}
