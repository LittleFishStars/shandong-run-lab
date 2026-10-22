package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.b;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class da1 implements Cache.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41135a = -1;
    public static final int b = -2;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f15948b = "CachedRegionTracker";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f15949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Cache f15950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f15952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TreeSet<a> f15953a = new TreeSet<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f15951a = new a(0, 0);

    public static class a implements Comparable<a> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f41136a;
        public long b;

        public a(long j, long j2) {
            this.f41136a = j;
            this.b = j2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return gj9.q(this.f41136a, aVar.f41136a);
        }
    }

    public da1(Cache cache, String str, b bVar) {
        this.f15950a = cache;
        this.f15952a = str;
        this.f15949a = bVar;
        synchronized (this) {
            Iterator<aa1> itDescendingIterator = cache.b(str, this).descendingIterator();
            while (itDescendingIterator.hasNext()) {
                f(itDescendingIterator.next());
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void a(Cache cache, aa1 aa1Var) {
        f(aa1Var);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void b(Cache cache, aa1 aa1Var) {
        long j = aa1Var.f40491a;
        a aVar = new a(j, aa1Var.b + j);
        a aVarFloor = this.f15953a.floor(aVar);
        if (aVarFloor == null) {
            Log.d(f15948b, "Removed a span we were not aware of");
            return;
        }
        this.f15953a.remove(aVarFloor);
        long j2 = aVarFloor.f41136a;
        long j3 = aVar.f41136a;
        if (j2 < j3) {
            a aVar2 = new a(j2, j3);
            int iBinarySearch = Arrays.binarySearch(this.f15949a.f2735a, aVar2.b);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            aVar2.K = iBinarySearch;
            this.f15953a.add(aVar2);
        }
        long j4 = aVarFloor.b;
        long j5 = aVar.b;
        if (j4 > j5) {
            a aVar3 = new a(j5 + 1, j4);
            aVar3.K = aVarFloor.K;
            this.f15953a.add(aVar3);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void c(Cache cache, aa1 aa1Var, aa1 aa1Var2) {
    }

    public synchronized int e(long j) {
        int i;
        a aVar = this.f15951a;
        aVar.f41136a = j;
        a aVarFloor = this.f15953a.floor(aVar);
        if (aVarFloor != null) {
            long j2 = aVarFloor.b;
            if (j <= j2 && (i = aVarFloor.K) != -1) {
                b bVar = this.f15949a;
                if (i == bVar.d - 1) {
                    if (j2 == bVar.f2735a[i] + ((long) bVar.f2734a[i])) {
                        return -2;
                    }
                }
                return (int) ((bVar.c[i] + ((bVar.b[i] * (j2 - bVar.f2735a[i])) / ((long) bVar.f2734a[i]))) / 1000);
            }
        }
        return -1;
    }

    public final void f(aa1 aa1Var) {
        long j = aa1Var.f40491a;
        a aVar = new a(j, aa1Var.b + j);
        a aVarFloor = this.f15953a.floor(aVar);
        a aVarCeiling = this.f15953a.ceiling(aVar);
        boolean zG = g(aVarFloor, aVar);
        if (g(aVar, aVarCeiling)) {
            if (zG) {
                aVarFloor.b = aVarCeiling.b;
                aVarFloor.K = aVarCeiling.K;
            } else {
                aVar.b = aVarCeiling.b;
                aVar.K = aVarCeiling.K;
                this.f15953a.add(aVar);
            }
            this.f15953a.remove(aVarCeiling);
            return;
        }
        if (!zG) {
            int iBinarySearch = Arrays.binarySearch(this.f15949a.f2735a, aVar.b);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            aVar.K = iBinarySearch;
            this.f15953a.add(aVar);
            return;
        }
        aVarFloor.b = aVar.b;
        int i = aVarFloor.K;
        while (true) {
            b bVar = this.f15949a;
            if (i >= bVar.d - 1) {
                break;
            }
            int i2 = i + 1;
            if (bVar.f2735a[i2] > aVarFloor.b) {
                break;
            } else {
                i = i2;
            }
        }
        aVarFloor.K = i;
    }

    public final boolean g(@Nullable a aVar, @Nullable a aVar2) {
        return (aVar == null || aVar2 == null || aVar.b != aVar2.f41136a) ? false : true;
    }

    public void h() {
        this.f15950a.d(this.f15952a, this);
    }
}
