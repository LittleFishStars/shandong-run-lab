package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class Closer implements Closeable {
    public static final Suppressor b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final Suppressor f32170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public Throwable f6340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Deque<Closeable> f6341a = new ArrayDeque(4);

    @VisibleForTesting
    public interface Suppressor {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    @VisibleForTesting
    public static final class a implements Suppressor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32171a = new a();

        @Override // com.google.common.io.Closer.Suppressor
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            Logger logger = e.f32186a;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(closeable);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 42);
            sb.append("Suppressing exception thrown when closing ");
            sb.append(strValueOf);
            logger.log(level, sb.toString(), th2);
        }
    }

    @VisibleForTesting
    public static final class b implements Suppressor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f32172a;

        public b(Method method) {
            this.f32172a = method;
        }

        @CheckForNull
        public static b b() {
            try {
                return new b(Throwable.class.getMethod("addSuppressed", Throwable.class));
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.google.common.io.Closer.Suppressor
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th == th2) {
                return;
            }
            try {
                this.f32172a.invoke(th, th2);
            } catch (Throwable unused) {
                a.f32171a.a(closeable, th, th2);
            }
        }
    }

    static {
        Suppressor suppressorB = b.b();
        if (suppressorB == null) {
            suppressorB = a.f32171a;
        }
        b = suppressorB;
    }

    @VisibleForTesting
    public Closer(Suppressor suppressor) {
        this.f32170a = (Suppressor) com.google.common.base.i.E(suppressor);
    }

    public static Closer g() {
        return new Closer(b);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        Throwable th = this.f6340a;
        while (!this.f6341a.isEmpty()) {
            Closeable closeableRemoveFirst = this.f6341a.removeFirst();
            try {
                closeableRemoveFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.f32170a.a(closeableRemoveFirst, th, th2);
                }
            }
        }
        if (this.f6340a != null || th == null) {
            return;
        }
        com.google.common.base.m.t(th, IOException.class);
        throw new AssertionError(th);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <C extends Closeable> C h(@ParametricNullness C c) {
        if (c != null) {
            this.f6341a.addFirst(c);
        }
        return c;
    }

    public RuntimeException j(Throwable th) throws Throwable {
        com.google.common.base.i.E(th);
        this.f6340a = th;
        com.google.common.base.m.t(th, IOException.class);
        throw new RuntimeException(th);
    }

    public <X extends Exception> RuntimeException k(Throwable th, Class<X> cls) throws Exception {
        com.google.common.base.i.E(th);
        this.f6340a = th;
        com.google.common.base.m.t(th, IOException.class);
        com.google.common.base.m.t(th, cls);
        throw new RuntimeException(th);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException l(Throwable th, Class<X1> cls, Class<X2> cls2) throws Exception {
        com.google.common.base.i.E(th);
        this.f6340a = th;
        com.google.common.base.m.t(th, IOException.class);
        com.google.common.base.m.u(th, cls, cls2);
        throw new RuntimeException(th);
    }
}
