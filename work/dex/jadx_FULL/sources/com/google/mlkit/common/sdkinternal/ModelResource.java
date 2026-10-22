package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.MlKitException;
import com.zj.adlib.e19;
import com.zj.adlib.imd;
import com.zj.adlib.yd1;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public abstract class ModelResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @KeepForSdk
    public final e19 f32454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f6624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicInteger f6625a;

    public ModelResource() {
        this.f6625a = new AtomicInteger(0);
        this.f6624a = new AtomicBoolean(false);
        this.f32454a = new e19();
    }

    @NonNull
    @KeepForSdk
    public <T> Task<T> a(@NonNull final Executor executor, @NonNull final Callable<T> callable, @NonNull final CancellationToken cancellationToken) {
        yw6.r(this.f6625a.get() > 0);
        if (cancellationToken.a()) {
            return com.google.android.gms.tasks.a.c();
        }
        final yd1 yd1Var = new yd1();
        final z09 z09Var = new z09(yd1Var.b());
        this.f32454a.b(new Executor() { // from class: com.zj.adlib.zdd
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                Executor executor2 = executor;
                CancellationToken cancellationToken2 = cancellationToken;
                yd1 yd1Var2 = yd1Var;
                z09 z09Var2 = z09Var;
                try {
                    executor2.execute(runnable);
                } catch (RuntimeException e) {
                    if (cancellationToken2.a()) {
                        yd1Var2.a();
                    } else {
                        z09Var2.b(e);
                    }
                    throw e;
                }
            }
        }, new Runnable() { // from class: com.zj.adlib.ahd
            @Override // java.lang.Runnable
            public final void run() {
                this.f15271a.g(cancellationToken, yd1Var, callable, z09Var);
            }
        });
        return z09Var.a();
    }

    @KeepForSdk
    public boolean b() {
        return this.f6624a.get();
    }

    @KeepForSdk
    @VisibleForTesting
    @WorkerThread
    public abstract void c() throws MlKitException;

    @KeepForSdk
    public void d() {
        this.f6625a.incrementAndGet();
    }

    @KeepForSdk
    public void e(@NonNull Executor executor) {
        f(executor);
    }

    @NonNull
    @KeepForSdk
    public Task<Void> f(@NonNull Executor executor) {
        yw6.r(this.f6625a.get() > 0);
        final z09 z09Var = new z09();
        this.f32454a.b(executor, new Runnable() { // from class: com.zj.adlib.yad
            @Override // java.lang.Runnable
            public final void run() {
                this.f45988a.h(z09Var);
            }
        });
        return z09Var.a();
    }

    public final /* synthetic */ void g(CancellationToken cancellationToken, yd1 yd1Var, Callable callable, z09 z09Var) {
        try {
            if (cancellationToken.a()) {
                yd1Var.a();
                return;
            }
            try {
                if (!this.f6624a.get()) {
                    c();
                    this.f6624a.set(true);
                }
                if (cancellationToken.a()) {
                    yd1Var.a();
                    return;
                }
                Object objCall = callable.call();
                if (cancellationToken.a()) {
                    yd1Var.a();
                } else {
                    z09Var.setResult(objCall);
                }
            } catch (RuntimeException e) {
                throw new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e);
            }
        } catch (Exception e2) {
            if (cancellationToken.a()) {
                yd1Var.a();
            } else {
                z09Var.b(e2);
            }
        }
    }

    public final /* synthetic */ void h(z09 z09Var) {
        int iDecrementAndGet = this.f6625a.decrementAndGet();
        yw6.r(iDecrementAndGet >= 0);
        if (iDecrementAndGet == 0) {
            release();
            this.f6624a.set(false);
        }
        imd.a();
        z09Var.setResult(null);
    }

    @KeepForSdk
    @WorkerThread
    public abstract void release();

    @KeepForSdk
    public ModelResource(@NonNull e19 e19Var) {
        this.f6625a = new AtomicInteger(0);
        this.f6624a = new AtomicBoolean(false);
        this.f32454a = e19Var;
    }
}
