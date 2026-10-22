package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public class g<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ListenableFuture<?> f32422a = new g(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Logger f6588a = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @ParametricNullness
    public final V f6589a;

    public static final class a<V> extends AbstractFuture.TrustedFuture<V> {
        public a() {
            cancel(false);
        }
    }

    public static final class b<V> extends AbstractFuture.TrustedFuture<V> {
        public b(Throwable th) {
            setException(th);
        }
    }

    public g(@ParametricNullness V v) {
        this.f6589a = v;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        com.google.common.base.i.F(runnable, "Runnable was null.");
        com.google.common.base.i.F(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = f6588a;
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 57 + strValueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            logger.log(level, sb.toString(), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get() {
        return this.f6589a;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public String toString() {
        String string = super.toString();
        String strValueOf = String.valueOf(this.f6589a);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 27 + strValueOf.length());
        sb.append(string);
        sb.append("[status=SUCCESS, result=[");
        sb.append(strValueOf);
        sb.append("]]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    @ParametricNullness
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        com.google.common.base.i.E(timeUnit);
        return get();
    }
}
