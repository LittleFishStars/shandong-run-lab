package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzbh;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class iq5 extends zzbh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f42420a = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ThreadPoolExecutor f17255a;

    public iq5() {
        final ThreadFactory threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.zj.adlib.r3d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(final Runnable runnable) {
                return threadFactoryDefaultThreadFactory.newThread(new Runnable() { // from class: com.zj.adlib.uzc
                    @Override // java.lang.Runnable
                    public final void run() {
                        iq5.b(runnable);
                    }
                });
            }
        });
        this.f17255a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static /* synthetic */ void b(Runnable runnable) {
        f42420a.set(new ArrayDeque());
        runnable.run();
    }

    public static void c(Deque deque, Runnable runnable) {
        yw6.l(deque);
        deque.add(runnable);
        if (deque.size() <= 1) {
            do {
                runnable.run();
                deque.removeFirst();
                runnable = (Runnable) deque.peekFirst();
            } while (runnable != null);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbh, java.util.concurrent.Executor
    public final void execute(@NonNull final Runnable runnable) {
        Deque deque = (Deque) f42420a.get();
        if (deque == null || deque.size() > 1) {
            this.f17255a.execute(new Runnable() { // from class: com.zj.adlib.q7d
                @Override // java.lang.Runnable
                public final void run() {
                    iq5.c((Deque) iq5.f42420a.get(), runnable);
                }
            });
        } else {
            c(deque, runnable);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbh, com.google.android.gms.internal.mlkit_common.zzaj
    @NonNull
    public final /* synthetic */ Object zza() {
        return this.f17255a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbh
    @NonNull
    public final ExecutorService zzb() {
        return this.f17255a;
    }
}
