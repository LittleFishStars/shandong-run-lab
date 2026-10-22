package com.ipd.dsp.internal.z;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.internal.a0.p;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.i.q;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g<R> implements d<R>, h<R> {
    public static final a p = new a();
    public final int f;
    public final int g;
    public final boolean h;
    public final a i;

    @Nullable
    @GuardedBy("this")
    public R j;

    @Nullable
    @GuardedBy("this")
    public e k;

    @GuardedBy("this")
    public boolean l;

    @GuardedBy("this")
    public boolean m;

    @GuardedBy("this")
    public boolean n;

    @Nullable
    @GuardedBy("this")
    public q o;

    @VisibleForTesting
    public static class a {
        public void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        public void a(Object obj) {
            obj.notifyAll();
        }
    }

    public g(int i, int i2) {
        this(i, i2, true, p);
    }

    public final synchronized R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.h && !isDone()) {
            o.a();
        }
        if (this.l) {
            throw new CancellationException();
        }
        if (this.n) {
            throw new ExecutionException(this.o);
        }
        if (this.m) {
            return this.j;
        }
        if (l == null) {
            this.i.a(this, 0L);
        } else if (l.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                this.i.a(this, jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.n) {
            throw new ExecutionException(this.o);
        }
        if (this.l) {
            throw new CancellationException();
        }
        if (!this.m) {
            throw new TimeoutException();
        }
        return this.j;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.l = true;
            this.i.a(this);
            e eVar = null;
            if (z) {
                e eVar2 = this.k;
                this.k = null;
                eVar = eVar2;
            }
            if (eVar != null) {
                eVar.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.ipd.dsp.internal.a0.p
    @Nullable
    public synchronized e getRequest() {
        return this.k;
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void getSize(@NonNull com.ipd.dsp.internal.a0.o oVar) {
        oVar.a(this.f, this.g);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.l;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.l || this.m || this.n;
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onDestroy() {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public synchronized void onResourceReady(@NonNull R r, @Nullable com.ipd.dsp.internal.b0.f<? super R> fVar) {
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStart() {
    }

    @Override // com.ipd.dsp.internal.w.k
    public void onStop() {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void removeCallback(@NonNull com.ipd.dsp.internal.a0.o oVar) {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public synchronized void setRequest(@Nullable e eVar) {
        this.k = eVar;
    }

    public String toString() {
        String str;
        e eVar;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            if (this.l) {
                str = "CANCELLED";
            } else if (this.n) {
                str = "FAILURE";
            } else if (this.m) {
                str = com.alipay.sdk.m.k0.c.p;
            } else {
                str = "PENDING";
                eVar = this.k;
            }
            eVar = null;
        }
        if (eVar == null) {
            return str2 + str + "]";
        }
        return str2 + str + ", request=[" + eVar + "]]";
    }

    public g(int i, int i2, boolean z, a aVar) {
        this.f = i;
        this.g = i2;
        this.h = z;
        this.i = aVar;
    }

    @Override // com.ipd.dsp.internal.z.h
    public synchronized boolean onLoadFailed(@Nullable q qVar, Object obj, @NonNull p<R> pVar, boolean z) {
        this.n = true;
        this.o = qVar;
        this.i.a(this);
        return false;
    }

    @Override // com.ipd.dsp.internal.z.h
    public synchronized boolean onResourceReady(@NonNull R r, @NonNull Object obj, p<R> pVar, @NonNull com.ipd.dsp.internal.f.a aVar, boolean z) {
        this.m = true;
        this.j = r;
        this.i.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j)));
    }
}
