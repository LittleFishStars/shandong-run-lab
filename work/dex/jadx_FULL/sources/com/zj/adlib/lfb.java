package com.zj.adlib;

import android.os.SystemClock;
import android.util.LongSparseArray;
import com.amap.api.col.p0003l.ju;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class lfb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile lfb f43057a;
    public static Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f17934a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f17935b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LongSparseArray<a> f17933a = new LongSparseArray<>();
    public LongSparseArray<a> b = new LongSparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public LongSparseArray<a> f17936c = new LongSparseArray<>();
    public LongSparseArray<a> d = new LongSparseArray<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f43058a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f17937a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f17938a;

        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static lfb a() {
        if (f43057a == null) {
            synchronized (c) {
                if (f43057a == null) {
                    f43057a = new lfb();
                }
            }
        }
        return f43057a;
    }

    public static short c(LongSparseArray<a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            a aVar = longSparseArray.get(j);
            if (aVar == null) {
                return (short) 0;
            }
            short sMax = (short) Math.max(1L, Math.min(32767L, (f() - aVar.f17937a) / 1000));
            if (!aVar.f17938a) {
                sMax = (short) (-sMax);
            }
            return sMax;
        }
    }

    public static void e(List<ju> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long jF = f();
        byte b = 0;
        if (longSparseArray.size() == 0) {
            for (ju juVar : list) {
                a aVar = new a(b);
                aVar.f43058a = juVar.b();
                aVar.f17937a = jF;
                aVar.f17938a = false;
                longSparseArray2.put(juVar.a(), aVar);
            }
            return;
        }
        for (ju juVar2 : list) {
            long jA = juVar2.a();
            a aVar2 = longSparseArray.get(jA);
            if (aVar2 == null) {
                aVar2 = new a(b);
                aVar2.f43058a = juVar2.b();
                aVar2.f17937a = jF;
                aVar2.f17938a = true;
            } else if (aVar2.f43058a != juVar2.b()) {
                aVar2.f43058a = juVar2.b();
                aVar2.f17937a = jF;
                aVar2.f17938a = true;
            }
            longSparseArray2.put(jA, aVar2);
        }
    }

    public static long f() {
        return SystemClock.elapsedRealtime();
    }

    public final short b(long j) {
        return c(this.f17933a, j);
    }

    public final void d(List<ju> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f17934a) {
            e(list, this.f17933a, this.b);
            LongSparseArray<a> longSparseArray = this.f17933a;
            this.f17933a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }

    public final short g(long j) {
        return c(this.f17936c, j);
    }

    public final void h(List<ju> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f17935b) {
            e(list, this.f17936c, this.d);
            LongSparseArray<a> longSparseArray = this.f17936c;
            this.f17936c = this.d;
            this.d = longSparseArray;
            longSparseArray.clear();
        }
    }
}
