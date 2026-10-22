package com.zj.adlib;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class e19 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f41320a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public final Queue f16170a = new ArrayDeque();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicReference f16171a = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public boolean f16172a;

    @KeepForSdk
    public void a() {
        yw6.r(Thread.currentThread().equals(this.f16171a.get()));
    }

    @KeepForSdk
    public void b(@NonNull Executor executor, @NonNull Runnable runnable) {
        synchronized (this.f41320a) {
            if (this.f16172a) {
                this.f16170a.add(new rtd(executor, runnable, null));
            } else {
                this.f16172a = true;
                f(executor, runnable);
            }
        }
    }

    public final void e() {
        synchronized (this.f41320a) {
            if (this.f16170a.isEmpty()) {
                this.f16172a = false;
            } else {
                rtd rtdVar = (rtd) this.f16170a.remove();
                f(rtdVar.f19424a, rtdVar.f44536a);
            }
        }
    }

    public final void f(Executor executor, final Runnable runnable) {
        try {
            executor.execute(new Runnable() { // from class: com.zj.adlib.rrd
                @Override // java.lang.Runnable
                public final void run() {
                    e19 e19Var = this.f44525a;
                    Runnable runnable2 = runnable;
                    uud uudVar = new uud(e19Var, null);
                    try {
                        runnable2.run();
                        uudVar.close();
                    } catch (Throwable th) {
                        try {
                            uudVar.close();
                        } catch (Throwable th2) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            e();
        }
    }
}
