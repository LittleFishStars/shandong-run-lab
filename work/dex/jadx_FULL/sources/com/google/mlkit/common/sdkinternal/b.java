package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.MlKitException;
import com.zj.adlib.h7c;
import com.zj.adlib.z09;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @GuardedBy("lock")
    public static b f32457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f6627a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f6628a;

    public b(Looper looper) {
        this.f6628a = new h7c(looper);
    }

    @NonNull
    @KeepForSdk
    public static b b() {
        b bVar;
        synchronized (f6627a) {
            if (f32457a == null) {
                HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                handlerThread.start();
                f32457a = new b(handlerThread.getLooper());
            }
            bVar = f32457a;
        }
        return bVar;
    }

    @NonNull
    @KeepForSdk
    public static Executor g() {
        return zzh.zza;
    }

    @NonNull
    @KeepForSdk
    public Handler a() {
        return this.f6628a;
    }

    @NonNull
    @KeepForSdk
    public <ResultT> Task<ResultT> c(@NonNull final Callable<ResultT> callable) {
        final z09 z09Var = new z09();
        d(new Runnable() { // from class: com.zj.adlib.noc
            @Override // java.lang.Runnable
            public final void run() {
                Callable callable2 = callable;
                z09 z09Var2 = z09Var;
                try {
                    z09Var2.setResult(callable2.call());
                } catch (MlKitException e) {
                    z09Var2.b(e);
                } catch (Exception e2) {
                    z09Var2.b(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e2));
                }
            }
        });
        return z09Var.a();
    }

    @KeepForSdk
    public void d(@NonNull Runnable runnable) {
        g().execute(runnable);
    }

    @KeepForSdk
    public void e(@NonNull Runnable runnable, long j) {
        this.f6628a.postDelayed(runnable, j);
    }

    @NonNull
    @KeepForSdk
    public <ResultT> Task<ResultT> f(@NonNull Callable<Task<ResultT>> callable) {
        return (Task<ResultT>) c(callable).p(com.google.android.gms.internal.mlkit_common.c.a(), new Continuation() { // from class: com.zj.adlib.dsc
            @Override // com.google.android.gms.tasks.Continuation
            public final Object a(Task task) {
                return (Task) task.r();
            }
        });
    }
}
