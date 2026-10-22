package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.zj.adlib.ad3;
import com.zj.adlib.ax6;
import com.zj.adlib.i69;
import com.zj.adlib.nu6;
import com.zj.adlib.t01;
import com.zj.adlib.x68;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BasePool<V> implements Pool<V> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MemoryTrimmableRegistry f1647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    @GuardedBy("this")
    public final a f1648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PoolStatsTracker f1649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nu6 f1650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Set<V> f1652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1653a;

    @VisibleForTesting
    @GuardedBy("this")
    public final a b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Class<?> f1651a = getClass();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final SparseArray<t01<V>> f29993a = new SparseArray<>();

    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    @VisibleForTesting
    @NotThreadSafe
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f29994a = "com.facebook.imagepipeline.memory.BasePool.Counter";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f1654a;
        public int b;

        public void a(int i) {
            int i2;
            int i3 = this.b;
            if (i3 < i || (i2 = this.f1654a) <= 0) {
                ad3.y0(f29994a, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.b), Integer.valueOf(this.f1654a));
            } else {
                this.f1654a = i2 - 1;
                this.b = i3 - i;
            }
        }

        public void b(int i) {
            this.f1654a++;
            this.b += i;
        }

        public void c() {
            this.f1654a = 0;
            this.b = 0;
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, nu6 nu6Var, PoolStatsTracker poolStatsTracker) {
        this.f1647a = (MemoryTrimmableRegistry) ax6.i(memoryTrimmableRegistry);
        this.f1650a = (nu6) ax6.i(nu6Var);
        this.f1649a = (PoolStatsTracker) ax6.i(poolStatsTracker);
        g(new SparseIntArray(0));
        this.f1652a = x68.g();
        this.b = new a();
        this.f1648a = new a();
    }

    @Override // com.facebook.imagepipeline.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void a(V v) {
        ax6.i(v);
        int bucketedSizeForValue = getBucketedSizeForValue(v);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            t01<V> t01VarE = e(bucketedSizeForValue);
            if (!this.f1652a.remove(v)) {
                ad3.s(this.f1651a, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                free(v);
                this.f1649a.a(sizeInBytes);
            } else if (t01VarE == null || t01VarE.g() || h() || !isReusable(v)) {
                if (t01VarE != null) {
                    t01VarE.b();
                }
                if (ad3.R(2)) {
                    ad3.W(this.f1651a, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                }
                free(v);
                this.f1648a.a(sizeInBytes);
                this.f1649a.a(sizeInBytes);
            } else {
                t01VarE.i(v);
                this.b.b(sizeInBytes);
                this.f1648a.a(sizeInBytes);
                this.f1649a.g(sizeInBytes);
                if (ad3.R(2)) {
                    ad3.W(this.f1651a, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                }
            }
            i();
        }
    }

    public abstract V alloc(int i);

    @VisibleForTesting
    public synchronized boolean b(int i) {
        nu6 nu6Var = this.f1650a;
        int i2 = nu6Var.f43610a;
        int i3 = this.f1648a.b;
        if (i > i2 - i3) {
            this.f1649a.c();
            return false;
        }
        int i4 = nu6Var.b;
        if (i > i4 - (i3 + this.b.b)) {
            l(i4 - i);
        }
        if (i <= i2 - (this.f1648a.b + this.b.b)) {
            return true;
        }
        this.f1649a.c();
        return false;
    }

    public final synchronized void c() {
        ax6.o(!h() || this.b.b == 0);
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void d(MemoryTrimType memoryTrimType) {
        k();
    }

    @VisibleForTesting
    public synchronized t01<V> e(int i) {
        t01<V> t01Var = this.f29993a.get(i);
        if (t01Var == null && this.f1653a) {
            if (ad3.R(2)) {
                ad3.V(this.f1651a, "creating new bucket %s", Integer.valueOf(i));
            }
            t01<V> t01VarJ = j(i);
            this.f29993a.put(i, t01VarJ);
            return t01VarJ;
        }
        return t01Var;
    }

    public synchronized Map<String, Integer> f() {
        HashMap map;
        map = new HashMap();
        for (int i = 0; i < this.f29993a.size(); i++) {
            map.put(PoolStatsTracker.f29997a + getSizeInBytes(this.f29993a.keyAt(i)), Integer.valueOf(this.f29993a.valueAt(i).e()));
        }
        map.put(PoolStatsTracker.f, Integer.valueOf(this.f1650a.b));
        map.put(PoolStatsTracker.g, Integer.valueOf(this.f1650a.f43610a));
        map.put(PoolStatsTracker.b, Integer.valueOf(this.f1648a.f1654a));
        map.put(PoolStatsTracker.c, Integer.valueOf(this.f1648a.b));
        map.put(PoolStatsTracker.d, Integer.valueOf(this.b.f1654a));
        map.put(PoolStatsTracker.e, Integer.valueOf(this.b.b));
        return map;
    }

    @VisibleForTesting
    public abstract void free(V v);

    public final synchronized void g(SparseIntArray sparseIntArray) {
        ax6.i(sparseIntArray);
        this.f29993a.clear();
        SparseIntArray sparseIntArray2 = this.f1650a.f18513a;
        if (sparseIntArray2 != null) {
            for (int i = 0; i < sparseIntArray2.size(); i++) {
                int iKeyAt = sparseIntArray2.keyAt(i);
                this.f29993a.put(iKeyAt, new t01<>(getSizeInBytes(iKeyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(iKeyAt, 0)));
            }
            this.f1653a = false;
        } else {
            this.f1653a = true;
        }
    }

    @Override // com.facebook.imagepipeline.memory.Pool
    public V get(int i) throws Throwable {
        V vAlloc;
        V vC;
        c();
        int bucketedSize = getBucketedSize(i);
        synchronized (this) {
            t01<V> t01VarE = e(bucketedSize);
            if (t01VarE != null && (vC = t01VarE.c()) != null) {
                ax6.o(this.f1652a.add(vC));
                int bucketedSizeForValue = getBucketedSizeForValue(vC);
                int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
                this.f1648a.b(sizeInBytes);
                this.b.a(sizeInBytes);
                this.f1649a.e(sizeInBytes);
                i();
                if (ad3.R(2)) {
                    ad3.W(this.f1651a, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(vC)), Integer.valueOf(bucketedSizeForValue));
                }
                return vC;
            }
            int sizeInBytes2 = getSizeInBytes(bucketedSize);
            if (!b(sizeInBytes2)) {
                throw new PoolSizeViolationException(this.f1650a.f43610a, this.f1648a.b, this.b.b, sizeInBytes2);
            }
            this.f1648a.b(sizeInBytes2);
            if (t01VarE != null) {
                t01VarE.f();
            }
            try {
                vAlloc = alloc(bucketedSize);
            } catch (Throwable th) {
                synchronized (this) {
                    this.f1648a.a(sizeInBytes2);
                    t01<V> t01VarE2 = e(bucketedSize);
                    if (t01VarE2 != null) {
                        t01VarE2.b();
                    }
                    i69.f(th);
                    vAlloc = null;
                }
            }
            synchronized (this) {
                ax6.o(this.f1652a.add(vAlloc));
                m();
                this.f1649a.f(sizeInBytes2);
                i();
                if (ad3.R(2)) {
                    ad3.W(this.f1651a, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(vAlloc)), Integer.valueOf(bucketedSize));
                }
            }
            return vAlloc;
        }
    }

    public abstract int getBucketedSize(int i);

    public abstract int getBucketedSizeForValue(V v);

    public abstract int getSizeInBytes(int i);

    @VisibleForTesting
    public synchronized boolean h() {
        boolean z;
        z = this.f1648a.b + this.b.b > this.f1650a.b;
        if (z) {
            this.f1649a.b();
        }
        return z;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    public final void i() {
        if (ad3.R(2)) {
            ad3.Y(this.f1651a, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.f1648a.f1654a), Integer.valueOf(this.f1648a.b), Integer.valueOf(this.b.f1654a), Integer.valueOf(this.b.b));
        }
    }

    public void initialize() {
        this.f1647a.b(this);
        this.f1649a.d(this);
    }

    public boolean isReusable(V v) {
        ax6.i(v);
        return true;
    }

    public t01<V> j(int i) {
        return new t01<>(getSizeInBytes(i), Integer.MAX_VALUE, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public void k() {
        int i;
        ArrayList arrayList = new ArrayList(this.f29993a.size());
        SparseIntArray sparseIntArray = new SparseIntArray();
        synchronized (this) {
            for (int i2 = 0; i2 < this.f29993a.size(); i2++) {
                t01<V> t01VarValueAt = this.f29993a.valueAt(i2);
                if (t01VarValueAt.d() > 0) {
                    arrayList.add(t01VarValueAt);
                }
                sparseIntArray.put(this.f29993a.keyAt(i2), t01VarValueAt.e());
            }
            g(sparseIntArray);
            this.b.c();
            i();
        }
        onParamsChanged();
        for (i = 0; i < arrayList.size(); i++) {
            t01 t01Var = (t01) arrayList.get(i);
            while (true) {
                Object objH = t01Var.h();
                if (objH == null) {
                    break;
                } else {
                    free(objH);
                }
            }
        }
    }

    @VisibleForTesting
    public synchronized void l(int i) {
        int i2 = this.f1648a.b;
        int i3 = this.b.b;
        int iMin = Math.min((i2 + i3) - i, i3);
        if (iMin <= 0) {
            return;
        }
        if (ad3.R(2)) {
            ad3.X(this.f1651a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.f1648a.b + this.b.b), Integer.valueOf(iMin));
        }
        i();
        for (int i4 = 0; i4 < this.f29993a.size() && iMin > 0; i4++) {
            t01<V> t01VarValueAt = this.f29993a.valueAt(i4);
            while (iMin > 0) {
                V vH = t01VarValueAt.h();
                if (vH == null) {
                    break;
                }
                free(vH);
                int i5 = t01VarValueAt.f44820a;
                iMin -= i5;
                this.b.a(i5);
            }
        }
        i();
        if (ad3.R(2)) {
            ad3.W(this.f1651a, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.f1648a.b + this.b.b));
        }
    }

    @VisibleForTesting
    public synchronized void m() {
        if (h()) {
            l(this.f1650a.b);
        }
    }

    public void onParamsChanged() {
    }
}
