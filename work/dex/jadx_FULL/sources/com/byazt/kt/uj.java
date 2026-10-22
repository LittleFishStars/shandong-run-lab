package com.byazt.kt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 15})
public final class uj implements Runnable {
    public static final ThreadLocal<uj> c = new ThreadLocal<>();
    public static Comparator<tt> n = new Comparator<tt>() { // from class: com.byazt.kt.uj.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(tt ttVar, tt ttVar2) {
            RecyclerView recyclerView = ttVar.uj;
            if ((recyclerView == null) != (ttVar2.uj == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = ttVar.c;
            if (z != ttVar2.c) {
                return z ? -1 : 1;
            }
            int i = ttVar2.tt - ttVar.tt;
            if (i != 0) {
                return i;
            }
            int i2 = ttVar.ve - ttVar2.ve;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    public long uj;
    public long ve;
    public ArrayList<RecyclerView> tt = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<tt> f28751a = new ArrayList<>();

    @com.byazt.zqa.c(c = {0, 1, 166, 153})
    public static class tt {
        public boolean c;
        public int n;
        public int tt;
        public RecyclerView uj;
        public int ve;

        public void c() {
            this.c = false;
            this.tt = 0;
            this.ve = 0;
            this.uj = null;
            this.n = 0;
        }
    }

    public void c(RecyclerView recyclerView) {
        this.tt.add(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.byazt.km.c.c("RV Prefetch");
            if (!this.tt.isEmpty()) {
                int size = this.tt.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.tt.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    c(TimeUnit.MILLISECONDS.toNanos(jMax) + this.uj);
                }
            }
        } finally {
            this.ve = 0L;
            com.byazt.km.c.c();
        }
    }

    public void tt(RecyclerView recyclerView) {
        this.tt.remove(recyclerView);
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 123})
    public static class c implements RecyclerView.i.c {
        public int c;
        public int tt;
        public int uj;
        public int[] ve;

        public void c(int i, int i2) {
            this.c = i;
            this.tt = i2;
        }

        @Override // com.byazt.kt.RecyclerView.i.c
        public void tt(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.uj * 2;
            int[] iArr = this.ve;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.ve = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.ve = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.ve;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.uj++;
        }

        public void c(RecyclerView recyclerView, boolean z) {
            this.uj = 0;
            int[] iArr = this.ve;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.yp;
            if (recyclerView.u == null || iVar == null || !iVar.yp()) {
                return;
            }
            if (z) {
                if (!recyclerView.f28736a.uj()) {
                    iVar.c(recyclerView.u.c(), this);
                }
            } else if (!recyclerView.rl()) {
                iVar.c(this.c, this.tt, recyclerView.h, this);
            }
            int i = this.uj;
            if (i > iVar.m) {
                iVar.m = i;
                iVar.nu = z;
                recyclerView.n.tt();
            }
        }

        public boolean c(int i) {
            if (this.ve != null) {
                int i2 = this.uj * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.ve[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void c() {
            int[] iArr = this.ve;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.uj = 0;
        }
    }

    private void tt(long j) {
        for (int i = 0; i < this.f28751a.size(); i++) {
            tt ttVar = this.f28751a.get(i);
            if (ttVar.uj == null) {
                return;
            }
            c(ttVar, j);
            ttVar.c();
        }
    }

    public void c(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.ve == 0) {
            this.ve = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.md.c(i, i2);
    }

    private void c() {
        tt ttVar;
        int size = this.tt.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.tt.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.md.c(recyclerView, false);
                i += recyclerView.md.uj;
            }
        }
        this.f28751a.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.tt.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                c cVar = recyclerView2.md;
                int iAbs = Math.abs(cVar.c) + Math.abs(cVar.tt);
                for (int i5 = 0; i5 < cVar.uj * 2; i5 += 2) {
                    if (i3 >= this.f28751a.size()) {
                        ttVar = new tt();
                        this.f28751a.add(ttVar);
                    } else {
                        ttVar = this.f28751a.get(i3);
                    }
                    int[] iArr = cVar.ve;
                    int i6 = iArr[i5 + 1];
                    ttVar.c = i6 <= iAbs;
                    ttVar.tt = iAbs;
                    ttVar.ve = i6;
                    ttVar.uj = recyclerView2;
                    ttVar.n = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f28751a, n);
    }

    public static boolean c(RecyclerView recyclerView, int i) {
        int iVe = recyclerView.sp.ve();
        for (int i2 = 0; i2 < iVe; i2++) {
            RecyclerView.gu guVarN = RecyclerView.n(recyclerView.sp.uj(i2));
            if (guVarN.ve == i && !guVarN.yp()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.gu c(RecyclerView recyclerView, int i, long j) {
        if (c(recyclerView, i)) {
            return null;
        }
        RecyclerView.m mVar = recyclerView.n;
        try {
            recyclerView.t();
            RecyclerView.gu guVarC = mVar.c(i, false, j);
            if (guVarC != null) {
                if (guVarC.m() && !guVarC.yp()) {
                    mVar.c(guVarC.c);
                } else {
                    mVar.c(guVarC, false);
                }
            }
            return guVarC;
        } finally {
            recyclerView.tt(false);
        }
    }

    private void c(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.gu && recyclerView.sp.ve() != 0) {
                recyclerView.ve();
            }
            c cVar = recyclerView.md;
            cVar.c(recyclerView, true);
            if (cVar.uj != 0) {
                try {
                    com.byazt.km.c.c("RV Nested Prefetch");
                    recyclerView.h.c(recyclerView.u);
                    for (int i = 0; i < cVar.uj * 2; i += 2) {
                        c(recyclerView, cVar.ve[i], j);
                    }
                    com.byazt.km.c.c();
                } catch (Throwable th) {
                    com.byazt.km.c.c();
                    throw th;
                }
            }
        }
    }

    private void c(tt ttVar, long j) {
        RecyclerView.gu guVarC = c(ttVar.uj, ttVar.n, ttVar.c ? Long.MAX_VALUE : j);
        if (guVarC == null || guVarC.tt == null || !guVarC.m() || guVarC.yp()) {
            return;
        }
        c(guVarC.tt.get(), j);
    }

    public void c(long j) {
        c();
        tt(j);
    }
}
