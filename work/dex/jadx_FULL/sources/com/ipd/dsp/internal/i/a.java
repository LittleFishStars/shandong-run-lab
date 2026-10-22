package com.ipd.dsp.internal.i;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f38324a;
    public final Executor b;

    @VisibleForTesting
    public final Map<com.ipd.dsp.internal.f.f, d> c;
    public final ReferenceQueue<p<?>> d;
    public p.a e;
    public volatile boolean f;

    @Nullable
    public volatile c g;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.i.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0882a implements ThreadFactory {

        /* JADX INFO: renamed from: com.ipd.dsp.internal.i.a$a$a, reason: collision with other inner class name */
        public class RunnableC0883a implements Runnable {
            public final /* synthetic */ Runnable f;

            public RunnableC0883a(Runnable runnable) {
                this.f = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(new RunnableC0883a(runnable), "glide-active-resources");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    @VisibleForTesting
    public interface c {
        void a();
    }

    @VisibleForTesting
    public static final class d extends WeakReference<p<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.f.f f38325a;
        public final boolean b;

        @Nullable
        public v<?> c;

        public d(@NonNull com.ipd.dsp.internal.f.f fVar, @NonNull p<?> pVar, @NonNull ReferenceQueue<? super p<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            this.f38325a = (com.ipd.dsp.internal.f.f) com.ipd.dsp.internal.d0.m.a(fVar);
            this.c = (pVar.f() && z) ? (v) com.ipd.dsp.internal.d0.m.a(pVar.b()) : null;
            this.b = pVar.f();
        }

        public void a() {
            this.c = null;
            clear();
        }
    }

    public a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0882a()));
    }

    public void a(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.e = aVar;
            }
        }
    }

    @Nullable
    public synchronized p<?> b(com.ipd.dsp.internal.f.f fVar) {
        d dVar = this.c.get(fVar);
        if (dVar == null) {
            return null;
        }
        p<?> pVar = dVar.get();
        if (pVar != null) {
            return pVar;
        }
        a(dVar);
        return pVar;
    }

    @VisibleForTesting
    public a(boolean z, Executor executor) {
        this.c = new HashMap();
        this.d = new ReferenceQueue<>();
        this.f38324a = z;
        this.b = executor;
        executor.execute(new b());
    }

    @VisibleForTesting
    public void b() {
        this.f = true;
        Executor executor = this.b;
        if (executor instanceof ExecutorService) {
            com.ipd.dsp.internal.d0.f.a((ExecutorService) executor);
        }
    }

    public synchronized void a(com.ipd.dsp.internal.f.f fVar, p<?> pVar) {
        d dVarPut = this.c.put(fVar, new d(fVar, pVar, this.d, this.f38324a));
        if (dVarPut != null) {
            dVarPut.a();
        }
    }

    public synchronized void a(com.ipd.dsp.internal.f.f fVar) {
        d dVarRemove = this.c.remove(fVar);
        if (dVarRemove != null) {
            dVarRemove.a();
        }
    }

    public void a(@NonNull d dVar) {
        v<?> vVar;
        synchronized (this) {
            this.c.remove(dVar.f38325a);
            if (dVar.b && (vVar = dVar.c) != null) {
                this.e.a(dVar.f38325a, new p<>(vVar, true, false, dVar.f38325a, this.e));
            }
        }
    }

    public void a() {
        while (!this.f) {
            try {
                a((d) this.d.remove());
                c cVar = this.g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @VisibleForTesting
    public void a(c cVar) {
        this.g = cVar;
    }
}
