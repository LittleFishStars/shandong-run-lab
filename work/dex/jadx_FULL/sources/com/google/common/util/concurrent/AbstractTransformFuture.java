package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public ListenableFuture<? extends I> f32324a;

    @CheckForNull
    public F c;

    public static final class a<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public a(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public ListenableFuture<? extends O> K(AsyncFunction<? super I, ? extends O> asyncFunction, @ParametricNullness I i) throws Exception {
            ListenableFuture<? extends O> listenableFutureApply = asyncFunction.apply(i);
            com.google.common.base.i.V(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class b<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        public b(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @ParametricNullness
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public O K(Function<? super I, ? extends O> function, @ParametricNullness I i) {
            return function.apply(i);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(@ParametricNullness O o) {
            set(o);
        }
    }

    public AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f) {
        this.f32324a = (ListenableFuture) com.google.common.base.i.E(listenableFuture);
        this.c = (F) com.google.common.base.i.E(f);
    }

    public static <I, O> ListenableFuture<O> I(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        com.google.common.base.i.E(function);
        b bVar = new b(listenableFuture, function);
        listenableFuture.addListener(bVar, j.p(executor, bVar));
        return bVar;
    }

    public static <I, O> ListenableFuture<O> J(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        com.google.common.base.i.E(executor);
        a aVar = new a(listenableFuture, asyncFunction);
        listenableFuture.addListener(aVar, j.p(executor, aVar));
        return aVar;
    }

    @ParametricNullness
    @ForOverride
    public abstract T K(F f, @ParametricNullness I i) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        x(this.f32324a);
        this.f32324a = null;
        this.c = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public String pendingToString() {
        String string;
        ListenableFuture<? extends I> listenableFuture = this.f32324a;
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
        if (f == null) {
            if (strPendingToString == null) {
                return null;
            }
            String strValueOf2 = String.valueOf(string);
            return strPendingToString.length() != 0 ? strValueOf2.concat(strPendingToString) : new String(strValueOf2);
        }
        String strValueOf3 = String.valueOf(f);
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 11 + strValueOf3.length());
        sb2.append(string);
        sb2.append("function=[");
        sb2.append(strValueOf3);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.f32324a;
        F f = this.c;
        if ((isCancelled() | (listenableFuture == null)) || (f == null)) {
            return;
        }
        this.f32324a = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                Object objK = K(f, f.h(listenableFuture));
                this.c = null;
                setResult(objK);
            } catch (Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.c = null;
                }
            }
        } catch (Error e) {
            setException(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e2) {
            setException(e2);
        } catch (ExecutionException e3) {
            setException(e3.getCause());
        }
    }

    @ForOverride
    public abstract void setResult(@ParametricNullness T t);
}
