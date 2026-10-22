package com.byazt.qw;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 726, 46})
public class n {
    public static int c = -1;
    public static int n = 3;
    public static int tt = 0;
    public static int uj = 2;
    public static int ve = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28986a = c;
    public long sp = 0;
    public long x = 0;
    public long i = 0;
    public final List<a> da = new ArrayList();

    public void c(long j) {
        this.f28986a = tt;
        this.sp = j;
    }

    public void tt(long j) {
        int i;
        int i2 = this.f28986a;
        if (i2 == c || i2 == (i = n)) {
            return;
        }
        this.f28986a = i;
        this.i = j;
    }

    public void uj(long j) {
        int i = this.f28986a;
        if (i == c || i != uj) {
            return;
        }
        this.f28986a = ve;
        this.da.add(new a(this.x, j));
        this.x = 0L;
    }

    public void ve(long j) {
        int i;
        int i2 = this.f28986a;
        if (i2 == c || i2 == (i = uj) || i2 == n) {
            return;
        }
        this.f28986a = i;
        this.x = j;
    }

    public long c(long j, long j2) {
        long j3;
        long j4;
        long jTt;
        long j5 = this.i;
        if (j5 != 0 && j > j5) {
            return 0L;
        }
        int i = 0;
        for (a aVar : this.da) {
            if (aVar.tt() > j) {
                if (j < aVar.c()) {
                    j4 = i;
                    jTt = aVar.tt() - aVar.c();
                } else {
                    j4 = i;
                    jTt = aVar.tt() - j;
                }
                i = (int) (j4 + jTt);
            }
        }
        long j6 = this.sp;
        if (j6 < j) {
            long j7 = this.x;
            if (j7 == 0) {
                j7 = this.i;
                if (j7 == 0) {
                    j3 = j2 - j;
                }
            } else if (j7 <= j) {
                return 0L;
            }
            return (j7 - j) - ((long) i);
        }
        long j8 = this.x;
        if (j8 == 0) {
            j8 = this.i;
            if (j8 == 0) {
                j3 = j2 - j6;
            }
        } else if (j8 <= j6) {
            return 0L;
        }
        return (j8 - j6) - ((long) i);
        return j3 - ((long) i);
    }

    public int c() {
        return this.f28986a;
    }
}
