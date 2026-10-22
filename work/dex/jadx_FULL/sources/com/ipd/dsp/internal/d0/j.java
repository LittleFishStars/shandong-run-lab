package com.ipd.dsp.internal.d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j<T, Y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<T, a<Y>> f38278a = new LinkedHashMap(100, 0.75f, true);
    public final long b;
    public long c;
    public long d;

    public static final class a<Y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Y f38279a;
        public final int b;

        public a(Y y, int i) {
            this.f38279a = y;
            this.b = i;
        }
    }

    public j(long j) {
        this.b = j;
        this.c = j;
    }

    public synchronized void a(float f) {
        try {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Multiplier must be >= 0");
            }
            this.c = Math.round(this.b * f);
            d();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(@NonNull T t, @Nullable Y y) {
    }

    public synchronized long b() {
        return this.c;
    }

    public int c(@Nullable Y y) {
        return 1;
    }

    public synchronized long c() {
        return this.d;
    }

    @Nullable
    public synchronized Y d(@NonNull T t) {
        a<Y> aVarRemove = this.f38278a.remove(t);
        if (aVarRemove == null) {
            return null;
        }
        this.d -= (long) aVarRemove.b;
        return aVarRemove.f38279a;
    }

    public synchronized int e() {
        return this.f38278a.size();
    }

    @Nullable
    public synchronized Y b(@NonNull T t) {
        a<Y> aVar = this.f38278a.get(t);
        if (aVar == null) {
            return null;
        }
        return aVar.f38279a;
    }

    public synchronized boolean a(@NonNull T t) {
        return this.f38278a.containsKey(t);
    }

    @Nullable
    public synchronized Y b(@NonNull T t, @Nullable Y y) {
        int iC = c(y);
        long j = iC;
        if (j >= this.c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.d += j;
        }
        a<Y> aVarPut = this.f38278a.put(t, y == null ? null : new a<>(y, iC));
        if (aVarPut != null) {
            this.d -= (long) aVarPut.b;
            if (!aVarPut.f38279a.equals(y)) {
                a(t, aVarPut.f38279a);
            }
        }
        d();
        if (aVarPut != null) {
            return aVarPut.f38279a;
        }
        return null;
    }

    public final void d() {
        a(this.c);
    }

    public void a() {
        a(0L);
    }

    public synchronized void a(long j) {
        while (this.d > j) {
            Iterator<Map.Entry<T, a<Y>>> it = this.f38278a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.d -= (long) value.b;
            T key = next.getKey();
            it.remove();
            a(key, value.f38279a);
        }
    }
}
