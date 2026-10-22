package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.ResourceReleaser;
import com.zj.adlib.ax6;
import com.zj.adlib.gw1;
import com.zj.adlib.rm1;
import com.zj.adlib.ul5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class CountingMemoryCache<K, V> implements MemoryCache<K, V>, MemoryTrimmable {

    @VisibleForTesting
    public static final long b = TimeUnit.MINUTES.toMillis(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public long f29982a = SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Supplier<ul5> f1634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheTrimStrategy f1635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ValueDescriptor<V> f1636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("this")
    public final gw1<K, c<K, V>> f1637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public ul5 f1638a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("this")
    public final gw1<K, c<K, V>> f1639b;

    public interface CacheTrimStrategy {
        double a(MemoryTrimType memoryTrimType);
    }

    public interface EntryStateObserver<K> {
        void a(K k, boolean z);
    }

    public class a implements ValueDescriptor<c<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ValueDescriptor f1640a;

        public a(ValueDescriptor valueDescriptor) {
            this.f1640a = valueDescriptor;
        }

        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(c<K, V> cVar) {
            return this.f1640a.a(cVar.f1643a.s());
        }
    }

    public class b implements ResourceReleaser<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f29984a;

        public b(c cVar) {
            this.f29984a = cVar;
        }

        @Override // com.facebook.common.references.ResourceReleaser
        public void a(V v) {
            CountingMemoryCache.this.D(this.f29984a);
        }
    }

    @VisibleForTesting
    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final EntryStateObserver<K> f1642a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final rm1<V> f1643a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final K f1644a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29985a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1645a = false;

        public c(K k, rm1<V> rm1Var, @Nullable EntryStateObserver<K> entryStateObserver) {
            this.f1644a = (K) ax6.i(k);
            this.f1643a = (rm1) ax6.i(rm1.l(rm1Var));
            this.f1642a = entryStateObserver;
        }

        @VisibleForTesting
        public static <K, V> c<K, V> a(K k, rm1<V> rm1Var, @Nullable EntryStateObserver<K> entryStateObserver) {
            return new c<>(k, rm1Var, entryStateObserver);
        }
    }

    public CountingMemoryCache(ValueDescriptor<V> valueDescriptor, CacheTrimStrategy cacheTrimStrategy, Supplier<ul5> supplier) {
        this.f1636a = valueDescriptor;
        this.f1637a = new gw1<>(G(valueDescriptor));
        this.f1639b = new gw1<>(G(valueDescriptor));
        this.f1635a = cacheTrimStrategy;
        this.f1634a = supplier;
        this.f1638a = supplier.get();
    }

    public static <K, V> void x(@Nullable c<K, V> cVar) {
        EntryStateObserver<K> entryStateObserver;
        if (cVar == null || (entryStateObserver = cVar.f1642a) == null) {
            return;
        }
        entryStateObserver.a(cVar.f1644a, true);
    }

    public static <K, V> void y(@Nullable c<K, V> cVar) {
        EntryStateObserver<K> entryStateObserver;
        if (cVar == null || (entryStateObserver = cVar.f1642a) == null) {
            return;
        }
        entryStateObserver.a(cVar.f1644a, false);
    }

    public final synchronized void A() {
        if (this.f29982a + b > SystemClock.uptimeMillis()) {
            return;
        }
        this.f29982a = SystemClock.uptimeMillis();
        this.f1638a = this.f1634a.get();
    }

    public final synchronized rm1<V> B(c<K, V> cVar) {
        r(cVar);
        return rm1.J(cVar.f1643a.s(), new b(cVar));
    }

    @Nullable
    public final synchronized rm1<V> C(c<K, V> cVar) {
        ax6.i(cVar);
        return (cVar.f1645a && cVar.f29985a == 0) ? cVar.f1643a : null;
    }

    public final void D(c<K, V> cVar) {
        boolean zU;
        rm1<V> rm1VarC;
        ax6.i(cVar);
        synchronized (this) {
            k(cVar);
            zU = u(cVar);
            rm1VarC = C(cVar);
        }
        rm1.p(rm1VarC);
        if (!zU) {
            cVar = null;
        }
        x(cVar);
        A();
        w();
    }

    @Nullable
    public rm1<V> E(K k) {
        c<K, V> cVarL;
        boolean z;
        rm1<V> rm1Var;
        ax6.i(k);
        synchronized (this) {
            cVarL = this.f1637a.l(k);
            z = false;
            if (cVarL != null) {
                c<K, V> cVarL2 = this.f1639b.l(k);
                ax6.i(cVarL2);
                ax6.o(cVarL2.f29985a == 0);
                rm1Var = cVarL2.f1643a;
                z = true;
            } else {
                rm1Var = null;
            }
        }
        if (z) {
            y(cVarL);
        }
        return rm1Var;
    }

    @Nullable
    public final synchronized ArrayList<c<K, V>> F(int i, int i2) {
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (this.f1637a.d() <= iMax && this.f1637a.h() <= iMax2) {
            return null;
        }
        ArrayList<c<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.f1637a.d() <= iMax && this.f1637a.h() <= iMax2) {
                return arrayList;
            }
            K kE = this.f1637a.e();
            this.f1637a.l(kE);
            arrayList.add(this.f1639b.l(kE));
        }
    }

    public final ValueDescriptor<c<K, V>> G(ValueDescriptor<V> valueDescriptor) {
        return new a(valueDescriptor);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public rm1<V> b(K k) {
        c<K, V> cVarL;
        rm1<V> rm1VarB;
        ax6.i(k);
        synchronized (this) {
            cVarL = this.f1637a.l(k);
            c<K, V> cVarC = this.f1639b.c(k);
            rm1VarB = cVarC != null ? B(cVarC) : null;
        }
        y(cVarL);
        A();
        w();
        return rm1VarB;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int c(Predicate<K> predicate) {
        ArrayList<c<K, V>> arrayListM;
        ArrayList<c<K, V>> arrayListM2;
        synchronized (this) {
            arrayListM = this.f1637a.m(predicate);
            arrayListM2 = this.f1639b.m(predicate);
            t(arrayListM2);
        }
        v(arrayListM2);
        z(arrayListM);
        A();
        w();
        return arrayListM2.size();
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void d(MemoryTrimType memoryTrimType) {
        ArrayList<c<K, V>> arrayListF;
        double dA = this.f1635a.a(memoryTrimType);
        synchronized (this) {
            arrayListF = F(Integer.MAX_VALUE, Math.max(0, ((int) (((double) this.f1639b.h()) * (1.0d - dA))) - p()));
            t(arrayListF);
        }
        v(arrayListF);
        z(arrayListF);
        A();
        w();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public rm1<V> e(K k, rm1<V> rm1Var) {
        return h(k, rm1Var, null);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean f(Predicate<K> predicate) {
        return !this.f1639b.g(predicate).isEmpty();
    }

    public rm1<V> h(K k, rm1<V> rm1Var, EntryStateObserver<K> entryStateObserver) {
        c<K, V> cVarL;
        rm1<V> rm1VarB;
        rm1<V> rm1VarC;
        ax6.i(k);
        ax6.i(rm1Var);
        A();
        synchronized (this) {
            cVarL = this.f1637a.l(k);
            c<K, V> cVarL2 = this.f1639b.l(k);
            rm1VarB = null;
            if (cVarL2 != null) {
                s(cVarL2);
                rm1VarC = C(cVarL2);
            } else {
                rm1VarC = null;
            }
            if (i(rm1Var.s())) {
                c<K, V> cVarA = c.a(k, rm1Var, entryStateObserver);
                this.f1639b.k(k, cVarA);
                rm1VarB = B(cVarA);
            }
        }
        rm1.p(rm1VarC);
        y(cVarL);
        w();
        return rm1VarB;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    public final synchronized boolean i(V v) {
        boolean z;
        int iA = this.f1636a.a(v);
        if (iA <= this.f1638a.e) {
            z = o() <= this.f1638a.b - 1 && p() <= this.f1638a.f45173a - iA;
        }
        return z;
    }

    public void j() {
        ArrayList<c<K, V>> arrayListA;
        ArrayList<c<K, V>> arrayListA2;
        synchronized (this) {
            arrayListA = this.f1637a.a();
            arrayListA2 = this.f1639b.a();
            t(arrayListA2);
        }
        v(arrayListA2);
        z(arrayListA);
        A();
    }

    public final synchronized void k(c<K, V> cVar) {
        ax6.i(cVar);
        ax6.o(cVar.f29985a > 0);
        cVar.f29985a--;
    }

    public synchronized int l() {
        return this.f1639b.d();
    }

    public synchronized int m() {
        return this.f1637a.d();
    }

    public synchronized int n() {
        return this.f1637a.h();
    }

    public synchronized int o() {
        return this.f1639b.d() - this.f1637a.d();
    }

    public synchronized int p() {
        return this.f1639b.h() - this.f1637a.h();
    }

    public synchronized int q() {
        return this.f1639b.h();
    }

    public final synchronized void r(c<K, V> cVar) {
        ax6.i(cVar);
        ax6.o(!cVar.f1645a);
        cVar.f29985a++;
    }

    public final synchronized void s(c<K, V> cVar) {
        ax6.i(cVar);
        ax6.o(!cVar.f1645a);
        cVar.f1645a = true;
    }

    public final synchronized void t(@Nullable ArrayList<c<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<c<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                s(it.next());
            }
        }
    }

    public final synchronized boolean u(c<K, V> cVar) {
        if (cVar.f1645a || cVar.f29985a != 0) {
            return false;
        }
        this.f1637a.k(cVar.f1644a, cVar);
        return true;
    }

    public final void v(@Nullable ArrayList<c<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<c<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                rm1.p(C(it.next()));
            }
        }
    }

    public final void w() {
        ArrayList<c<K, V>> arrayListF;
        synchronized (this) {
            ul5 ul5Var = this.f1638a;
            int iMin = Math.min(ul5Var.d, ul5Var.b - o());
            ul5 ul5Var2 = this.f1638a;
            arrayListF = F(iMin, Math.min(ul5Var2.c, ul5Var2.f45173a - p()));
            t(arrayListF);
        }
        v(arrayListF);
        z(arrayListF);
    }

    public final void z(@Nullable ArrayList<c<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<c<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                y(it.next());
            }
        }
    }
}
