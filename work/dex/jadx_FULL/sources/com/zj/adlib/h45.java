package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.LottieListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h45<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Executor f42047a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f16928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile f45<T> f16929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<LottieListener<T>> f16930a;
    public final Set<LottieListener<Throwable>> b;

    public class a extends FutureTask<f45<T>> {
        public a(Callable<f45<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                h45.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                h45.this.setResult(new f45(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public h45(Callable<f45<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        f45<T> f45Var = this.f16929a;
        if (f45Var == null) {
            return;
        }
        if (f45Var.b() != null) {
            h(f45Var.b());
        } else {
            f(f45Var.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(@Nullable f45<T> f45Var) {
        if (this.f16929a != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f16929a = f45Var;
        g();
    }

    public synchronized h45<T> c(LottieListener<Throwable> lottieListener) {
        f45<T> f45Var = this.f16929a;
        if (f45Var != null && f45Var.a() != null) {
            lottieListener.onResult(f45Var.a());
        }
        this.b.add(lottieListener);
        return this;
    }

    public synchronized h45<T> d(LottieListener<T> lottieListener) {
        f45<T> f45Var = this.f16929a;
        if (f45Var != null && f45Var.b() != null) {
            lottieListener.onResult(f45Var.b());
        }
        this.f16930a.add(lottieListener);
        return this;
    }

    public final synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            g25.f("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(th);
        }
    }

    public final void g() {
        this.f16928a.post(new Runnable() { // from class: com.zj.adlib.g45
            @Override // java.lang.Runnable
            public final void run() {
                this.f41817a.e();
            }
        });
    }

    public final synchronized void h(T t) {
        Iterator it = new ArrayList(this.f16930a).iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(t);
        }
    }

    public synchronized h45<T> i(LottieListener<Throwable> lottieListener) {
        this.b.remove(lottieListener);
        return this;
    }

    public synchronized h45<T> j(LottieListener<T> lottieListener) {
        this.f16930a.remove(lottieListener);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public h45(Callable<f45<T>> callable, boolean z) {
        this.f16930a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.f16928a = new Handler(Looper.getMainLooper());
        this.f16929a = null;
        if (!z) {
            f42047a.execute(new a(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (Throwable th) {
            setResult(new f45<>(th));
        }
    }
}
