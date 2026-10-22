package com.byazt.ga;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 67})
public class u<T> {
    public static Executor c = com.byazt.bwm.tt.tt(new com.byazt.bwm.x("ie/LottieTask"));
    public volatile t<T> n;
    public final Set<da<T>> tt;
    public final Handler uj;
    public final Set<da<Throwable>> ve;

    @com.byazt.zqa.c(c = {0, 1, 256, 57})
    public class c extends FutureTask<t<T>> {
        public c(Callable<t<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                u.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                u.this.setResult(new t(e));
            }
        }
    }

    public u(Callable<t<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(t<T> tVar) {
        if (this.n != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.n = tVar;
        c();
    }

    public synchronized u<T> tt(da<T> daVar) {
        this.tt.remove(daVar);
        return this;
    }

    public synchronized u<T> uj(da<Throwable> daVar) {
        this.ve.remove(daVar);
        return this;
    }

    public synchronized u<T> ve(da<Throwable> daVar) {
        t<T> tVar = this.n;
        if (tVar != null && tVar.tt() != null) {
            daVar.c(tVar.tt());
        }
        this.ve.add(daVar);
        return this;
    }

    public u(Callable<t<T>> callable, boolean z) {
        this.tt = new LinkedHashSet(1);
        this.ve = new LinkedHashSet(1);
        this.uj = new Handler(Looper.getMainLooper());
        this.n = null;
        if (!z) {
            c.execute(new c(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (Throwable th) {
            setResult(new t<>(th));
        }
    }

    public synchronized u<T> c(da<T> daVar) {
        t<T> tVar = this.n;
        if (tVar != null && tVar.c() != null) {
            daVar.c(tVar.c());
        }
        this.tt.add(daVar);
        return this;
    }

    private void c() {
        this.uj.post(new Runnable() { // from class: com.byazt.ga.u.1
            @Override // java.lang.Runnable
            public void run() {
                t tVar = u.this.n;
                if (tVar == null) {
                    return;
                }
                if (tVar.c() != null) {
                    u.this.c(tVar.c());
                } else {
                    u.this.c(tVar.tt());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(T t) {
        Iterator it = new ArrayList(this.tt).iterator();
        while (it.hasNext()) {
            ((da) it.next()).c(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(Throwable th) {
        ArrayList arrayList = new ArrayList(this.ve);
        if (arrayList.isEmpty()) {
            com.byazt.kk.a.c("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((da) it.next()).c(th);
        }
    }
}
