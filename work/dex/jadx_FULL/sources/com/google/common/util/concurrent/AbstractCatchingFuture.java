package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.errorprone.annotations.ForOverride;
import com.zj.adlib.fd4;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public ListenableFuture<? extends V> f32280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Class<X> f6457a;

    @CheckForNull
    public F c;

    public static final class a<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        public a(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public ListenableFuture<? extends V> K(AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws Exception {
            ListenableFuture<? extends V> listenableFutureApply = asyncFunction.apply(x);
            com.google.common.base.i.V(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class b<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        public b(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @ParametricNullness
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public V K(Function<? super X, ? extends V> function, X x) throws Exception {
            return function.apply(x);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(@ParametricNullness V v) {
            set(v);
        }
    }

    public AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        this.f32280a = (ListenableFuture) com.google.common.base.i.E(listenableFuture);
        this.f6457a = (Class) com.google.common.base.i.E(cls);
        this.c = (F) com.google.common.base.i.E(f);
    }

    public static <V, X extends Throwable> ListenableFuture<V> I(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        b bVar = new b(listenableFuture, cls, function);
        listenableFuture.addListener(bVar, j.p(executor, bVar));
        return bVar;
    }

    public static <X extends Throwable, V> ListenableFuture<V> J(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        a aVar = new a(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(aVar, j.p(executor, aVar));
        return aVar;
    }

    @ParametricNullness
    @ForOverride
    public abstract T K(F f, X x) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        x(this.f32280a);
        this.f32280a = null;
        this.f6457a = null;
        this.c = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        String string;
        ListenableFuture<? extends V> listenableFuture = this.f32280a;
        Class<X> cls = this.f6457a;
        F f = this.c;
        String strPendingToString = super.pendingToString();
        if (listenableFuture != null) {
            String strValueOf = String.valueOf(listenableFuture);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 16);
            sb.append("inputFuture=[");
            sb.append(strValueOf);
            sb.append("], ");
            string = sb.toString();
        } else {
            string = "";
        }
        if (cls == null || f == null) {
            if (strPendingToString == null) {
                return null;
            }
            String strValueOf2 = String.valueOf(string);
            return strPendingToString.length() != 0 ? strValueOf2.concat(strPendingToString) : new String(strValueOf2);
        }
        String strValueOf3 = String.valueOf(cls);
        String strValueOf4 = String.valueOf(f);
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 29 + strValueOf3.length() + strValueOf4.length());
        sb2.append(string);
        sb2.append("exceptionType=[");
        sb2.append(strValueOf3);
        sb2.append("], fallback=[");
        sb2.append(strValueOf4);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [F, java.lang.Class<X extends java.lang.Throwable>] */
    @Override // java.lang.Runnable
    public final void run() {
        Object objH;
        ListenableFuture<? extends V> listenableFuture = this.f32280a;
        Class<X> cls = this.f6457a;
        F f = this.c;
        if (((f == null) || ((listenableFuture == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        ?? r3 = (Class<X>) null;
        this.f32280a = null;
        try {
            th = listenableFuture instanceof InternalFutureFailureAccess ? fd4.a((InternalFutureFailureAccess) listenableFuture) : null;
            objH = th == null ? f.h(listenableFuture) : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                String strValueOf = String.valueOf(listenableFuture.getClass());
                String strValueOf2 = String.valueOf(e.getClass());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 35 + strValueOf2.length());
                sb.append("Future type ");
                sb.append(strValueOf);
                sb.append(" threw ");
                sb.append(strValueOf2);
                sb.append(" without a cause");
                cause = new NullPointerException(sb.toString());
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            set(k.a(objH));
            return;
        }
        if (!m.a(th, cls)) {
            setFuture(listenableFuture);
            return;
        }
        try {
            Object objK = K(f, th);
            this.f6457a = null;
            this.c = null;
            setResult(objK);
        } catch (Throwable th2) {
            try {
                setException(th2);
            } finally {
                this.f6457a = null;
                this.c = null;
            }
        }
    }

    @ForOverride
    public abstract void setResult(@ParametricNullness T t);
}
