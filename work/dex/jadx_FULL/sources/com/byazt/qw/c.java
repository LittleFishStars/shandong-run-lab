package com.byazt.qw;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 726, 20})
public class c implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f28985a = 2;
    public static int c = 1;
    public static long m = 0;
    public static int n = 1;
    public static int nu = 0;
    public static int tt = 2;
    public static int uj = 0;
    public static int ve = 3;
    public static long z;
    public long da;
    public long i;
    public long sl;
    public long sp;
    public long t;
    public int u;
    public long x;
    public long yp;

    public static long a() {
        long jX = ve.ve().x();
        long jCurrentTimeMillis = System.currentTimeMillis() - jX;
        if (ve.ve().i() > jX) {
            return 0L;
        }
        return jX == 0 ? System.currentTimeMillis() - ve.ve().c() : jCurrentTimeMillis;
    }

    public static int n() {
        int i = nu;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static long sp() {
        long jI = ve.ve().i();
        if (ve.ve().x() > jI) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jI;
        if (jI == 0) {
            return 0L;
        }
        return jCurrentTimeMillis;
    }

    public static long uj() {
        return m + sp();
    }

    public static long ve() {
        return z + a();
    }

    public long c() {
        return this.sl;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        c cVar = (c) obj;
        return (this.sp <= cVar.sp && this.i <= cVar.i && this.da <= cVar.da) ? 0 : 1;
    }

    public long da() {
        return this.x;
    }

    public long i() {
        return this.sp;
    }

    public long sl() {
        return this.i;
    }

    public long t() {
        return this.da;
    }

    public long tt() {
        return this.t;
    }

    public int u() {
        return this.u;
    }

    public long x() {
        return this.yp;
    }

    public void c(long j) {
        this.sl = j;
    }

    public void n(long j) {
        this.x = j;
    }

    public void tt(long j) {
        this.t = j;
    }

    public static void c(int i) {
        tt ttVar = new tt();
        long jSp = ve.ve().sp();
        List<c> listC = ttVar.c(jSp);
        Collections.sort(listC);
        HashSet hashSet = new HashSet();
        if (listC != null && !listC.isEmpty()) {
            z = 0L;
            m = 0L;
            nu = 0;
            for (c cVar : listC) {
                if (cVar.u() == tt) {
                    m += c(cVar, jSp);
                } else if (cVar.u() == ve) {
                    z += cVar.c();
                } else if (cVar.u() == c && cVar.sp == jSp) {
                    hashSet.add(Long.valueOf(cVar.da()));
                }
            }
        }
        nu = hashSet.size();
        if (i == n) {
            nu = 1;
        }
        ttVar.c();
    }

    public void tt(int i) {
        this.u = i;
    }

    public void uj(long j) {
        this.sp = j;
    }

    public void ve(long j) {
        this.yp = j;
    }

    public void sp(long j) {
        this.da = j;
    }

    public void a(long j) {
        this.i = j;
    }

    private static long c(c cVar, long j) {
        long j2 = j - 518400000;
        long jX = cVar.x();
        if (jX - cVar.tt() >= j2) {
            return cVar.tt();
        }
        long j3 = jX - j2;
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static void c(int i, long j, long j2) {
        c cVar = new c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC = ve.ve().c();
        cVar.uj(ve.ve().sp());
        cVar.n(jC);
        cVar.tt(i);
        cVar.ve(jCurrentTimeMillis);
        if (i == c) {
            cVar.c(0L);
            cVar.tt(0L);
            cVar.sp(0L);
            cVar.a(0L);
        } else if (i == tt) {
            cVar.c(0L);
            cVar.tt(j2);
            cVar.sp(0L);
            cVar.a(jCurrentTimeMillis);
        } else if (i == ve) {
            cVar.c(j);
            cVar.tt(0L);
            cVar.sp(jCurrentTimeMillis);
            cVar.a(0L);
        }
        new tt().insert(cVar);
    }
}
