package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rm1<T> implements Cloneable, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedReference<T> f19349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public boolean f19350a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Class<rm1> f19348a = rm1.class;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceReleaser<Closeable> f44482a = new a();

    public static class a implements ResourceReleaser<Closeable> {
        @Override // com.facebook.common.references.ResourceReleaser
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Closeable closeable) {
            try {
                tm1.a(closeable, true);
            } catch (IOException unused) {
            }
        }
    }

    public rm1(SharedReference<T> sharedReference) {
        this.f19349a = (SharedReference) ax6.i(sharedReference);
        sharedReference.b();
    }

    public static boolean F(@Nullable rm1<?> rm1Var) {
        return rm1Var != null && rm1Var.E();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/zj/adlib/rm1<TT;>; */
    @Nullable
    public static rm1 H(@Nullable Closeable closeable) {
        if (closeable == null) {
            return null;
        }
        return new rm1(closeable, f44482a);
    }

    @Nullable
    public static <T> rm1<T> J(@Nullable T t, ResourceReleaser<T> resourceReleaser) {
        if (t == null) {
            return null;
        }
        return new rm1<>(t, resourceReleaser);
    }

    @Nullable
    public static <T> rm1<T> l(@Nullable rm1<T> rm1Var) {
        if (rm1Var != null) {
            return rm1Var.k();
        }
        return null;
    }

    public static <T> List<rm1<T>> m(Collection<rm1<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<rm1<T>> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(l(it.next()));
        }
        return arrayList;
    }

    public static void p(@Nullable rm1<?> rm1Var) {
        if (rm1Var != null) {
            rm1Var.close();
        }
    }

    public static void r(@Nullable Iterable<? extends rm1<?>> iterable) {
        if (iterable != null) {
            Iterator<? extends rm1<?>> it = iterable.iterator();
            while (it.hasNext()) {
                p(it.next());
            }
        }
    }

    public synchronized boolean E() {
        return !this.f19350a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.f19350a) {
                return;
            }
            this.f19350a = true;
            this.f19349a.d();
        }
    }

    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.f19350a) {
                    super.finalize();
                    return;
                }
                ad3.m0(f19348a, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f19349a)), this.f19349a.f().getClass().getSimpleName());
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized rm1<T> clone() {
        ax6.o(E());
        return new rm1<>(this.f19349a);
    }

    public synchronized rm1<T> k() {
        return E() ? new rm1<>(this.f19349a) : null;
    }

    public synchronized T s() {
        ax6.o(!this.f19350a);
        return this.f19349a.f();
    }

    @VisibleForTesting
    public synchronized SharedReference<T> v() {
        return this.f19349a;
    }

    public synchronized int y() {
        return E() ? System.identityHashCode(this.f19349a.f()) : 0;
    }

    public rm1(T t, ResourceReleaser<T> resourceReleaser) {
        this.f19349a = new SharedReference<>(t, resourceReleaser);
    }
}
