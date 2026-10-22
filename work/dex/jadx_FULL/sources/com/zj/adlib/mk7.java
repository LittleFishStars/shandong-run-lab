package com.zj.adlib;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mk7 {

    @VisibleForTesting
    public static final int c = 1000;
    public static final int d = 5000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public int f43322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public final TreeSet<a> f18236a = new TreeSet<>(new Comparator() { // from class: com.zj.adlib.lk7
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return mk7.d((mk7.a) obj, (mk7.a) obj2);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public boolean f18237a;

    @GuardedBy("this")
    public int b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f43323a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final kk7 f18238a;

        public a(kk7 kk7Var, long j) {
            this.f18238a = kk7Var;
            this.f43323a = j;
        }
    }

    public mk7() {
        g();
    }

    public static int c(int i, int i2) {
        int iMin;
        int i3 = i - i2;
        if (Math.abs(i3) <= 1000 || (iMin = (Math.min(i, i2) - Math.max(i, i2)) + 65535) >= 1000) {
            return i3;
        }
        return i < i2 ? iMin : -iMin;
    }

    public static /* synthetic */ int d(a aVar, a aVar2) {
        return c(aVar.f18238a.f17721a, aVar2.f18238a.f17721a);
    }

    public final synchronized void b(a aVar) {
        this.f43322a = aVar.f18238a.f17721a;
        this.f18236a.add(aVar);
    }

    public synchronized boolean e(kk7 kk7Var, long j) {
        if (this.f18236a.size() >= 5000) {
            throw new IllegalStateException("Queue size limit of 5000 reached.");
        }
        int i = kk7Var.f17721a;
        if (!this.f18237a) {
            g();
            this.b = kk7.c(i);
            this.f18237a = true;
            b(new a(kk7Var, j));
            return true;
        }
        if (Math.abs(c(i, kk7.b(this.f43322a))) < 1000) {
            if (c(i, this.b) <= 0) {
                return false;
            }
            b(new a(kk7Var, j));
            return true;
        }
        this.b = kk7.c(i);
        this.f18236a.clear();
        b(new a(kk7Var, j));
        return true;
    }

    @Nullable
    public synchronized kk7 f(long j) {
        if (this.f18236a.isEmpty()) {
            return null;
        }
        a aVarFirst = this.f18236a.first();
        int i = aVarFirst.f18238a.f17721a;
        if (i != kk7.b(this.b) && j < aVarFirst.f43323a) {
            return null;
        }
        this.f18236a.pollFirst();
        this.b = i;
        return aVarFirst.f18238a;
    }

    public synchronized void g() {
        this.f18236a.clear();
        this.f18237a = false;
        this.b = -1;
        this.f43322a = -1;
    }
}
