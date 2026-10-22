package com.zj.adlib;

import android.os.SystemClock;
import com.amap.api.col.p0003l.ka;
import com.amap.api.col.p0003l.kb;
import com.amap.api.col.p0003l.kc;
import com.amap.api.col.p0003l.kd;
import com.amap.api.col.p0003l.ke;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class dcb extends com.amap.api.col.p0003l.iw {
    public dcb() {
        super(2048);
    }

    public static void e(List<ka> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (ka kaVar : list) {
            if (kaVar instanceof kc) {
                kc kcVar = (kc) kaVar;
                kaVar.g = mfb.b(mfb.a(kcVar.j, kcVar.k));
            } else if (kaVar instanceof kd) {
                kd kdVar = (kd) kaVar;
                kaVar.g = mfb.b(mfb.a(kdVar.j, kdVar.k));
            } else if (kaVar instanceof ke) {
                ke keVar = (ke) kaVar;
                kaVar.g = mfb.b(mfb.a(keVar.j, keVar.k));
            } else if (kaVar instanceof kb) {
                kb kbVar = (kb) kaVar;
                kaVar.g = mfb.b(mfb.a(kbVar.k, kbVar.l));
            }
        }
    }

    public static void g(List<mhb> list) {
        for (mhb mhbVar : list) {
            mhbVar.f18217a = mfb.d(mhbVar.f18215a);
        }
    }

    public final int b(long j, List<mhb> list) {
        g(list);
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            mhb mhbVar = list.get(i);
            int iB = ((com.amap.api.col.p0003l.iw) this).f25978a.b(mhbVar.f18216a);
            long j2 = mhbVar.f18215a;
            iArr[i] = kfb.b(((com.amap.api.col.p0003l.iw) this).f25978a, j2 == j && j2 != -1, j2, (short) mhbVar.f43306a, iB, mhbVar.f18217a, (short) mhbVar.b);
        }
        return jfb.b(((com.amap.api.col.p0003l.iw) this).f25978a, jfb.c(((com.amap.api.col.p0003l.iw) this).f25978a, iArr));
    }

    public final int c(peb.a aVar) {
        int iA;
        int i;
        int i2;
        byte b;
        int iB;
        int iB2;
        byte b2;
        e(aVar.f18833a);
        int size = aVar.f18833a.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            ka kaVar = aVar.f18833a.get(i3);
            if (kaVar instanceof kc) {
                kc kcVar = (kc) kaVar;
                iB = !kcVar.i ? efb.b(((com.amap.api.col.p0003l.iw) this).f25978a, kcVar.j, kcVar.k, kcVar.c, kcVar.l) : efb.c(((com.amap.api.col.p0003l.iw) this).f25978a, kcVar.b(), kcVar.c(), kcVar.j, kcVar.k, kcVar.c, kcVar.m, kcVar.n, kcVar.d, kcVar.l);
                i2 = -1;
                b = 1;
            } else {
                if (kaVar instanceof kd) {
                    kd kdVar = (kd) kaVar;
                    iB2 = ffb.b(((com.amap.api.col.p0003l.iw) this).f25978a, kdVar.b(), kdVar.c(), kdVar.j, kdVar.k, kdVar.l, kdVar.c, kdVar.m, kdVar.d);
                    b2 = 3;
                } else if (kaVar instanceof kb) {
                    kb kbVar = (kb) kaVar;
                    iB = !kbVar.i ? yeb.b(((com.amap.api.col.p0003l.iw) this).f25978a, kbVar.j, kbVar.k, kbVar.l, kbVar.m, kbVar.n, kbVar.c) : yeb.c(((com.amap.api.col.p0003l.iw) this).f25978a, kbVar.j, kbVar.k, kbVar.l, kbVar.m, kbVar.n, kbVar.c, kbVar.d);
                    b = 2;
                    i2 = -1;
                } else if (kaVar instanceof ke) {
                    ke keVar = (ke) kaVar;
                    iB2 = ifb.b(((com.amap.api.col.p0003l.iw) this).f25978a, keVar.b(), keVar.c(), keVar.j, keVar.k, keVar.l, keVar.c, keVar.m, keVar.d);
                    b2 = 4;
                } else {
                    i2 = -1;
                    b = 0;
                    iB = -1;
                }
                b = b2;
                iB = iB2;
                i2 = -1;
            }
            if (iB == i2) {
                return i2;
            }
            iArr[i3] = bfb.b(((com.amap.api.col.p0003l.iw) this).f25978a, kaVar.h ? (byte) 1 : (byte) 0, kaVar.i ? (byte) 1 : (byte) 0, (short) kaVar.g, b, iB);
        }
        int iB3 = ((com.amap.api.col.p0003l.iw) this).f25978a.b(aVar.f18832a);
        int iC = zeb.c(((com.amap.api.col.p0003l.iw) this).f25978a, iArr);
        int size2 = aVar.f18834b.size();
        int[] iArr2 = new int[size2];
        for (int i4 = 0; i4 < size2; i4++) {
            ka kaVar2 = aVar.f18834b.get(i4);
            long jElapsedRealtime = (SystemClock.elapsedRealtime() - kaVar2.e) / 1000;
            if (jElapsedRealtime > 32767 || jElapsedRealtime < 0) {
                jElapsedRealtime = 32767;
            }
            if (kaVar2 instanceof kc) {
                kc kcVar2 = (kc) kaVar2;
                iA = hfb.a(((com.amap.api.col.p0003l.iw) this).f25978a, kcVar2.j, kcVar2.k, (short) jElapsedRealtime);
            } else if (kaVar2 instanceof kd) {
                kd kdVar2 = (kd) kaVar2;
                iA = hfb.a(((com.amap.api.col.p0003l.iw) this).f25978a, kdVar2.j, kdVar2.k, (short) jElapsedRealtime);
            } else {
                if (kaVar2 instanceof kb) {
                    kb kbVar2 = (kb) kaVar2;
                    iA = gfb.a(((com.amap.api.col.p0003l.iw) this).f25978a, kbVar2.j, kbVar2.k, kbVar2.l, (short) jElapsedRealtime);
                    i = 2;
                } else if (kaVar2 instanceof ke) {
                    ke keVar2 = (ke) kaVar2;
                    iA = hfb.a(((com.amap.api.col.p0003l.iw) this).f25978a, keVar2.j, keVar2.k, (short) jElapsedRealtime);
                } else {
                    iA = 0;
                    i = 0;
                }
                iArr2[i4] = afb.b(((com.amap.api.col.p0003l.iw) this).f25978a, (byte) i, iA);
            }
            i = 1;
            iArr2[i4] = afb.b(((com.amap.api.col.p0003l.iw) this).f25978a, (byte) i, iA);
        }
        return zeb.b(((com.amap.api.col.p0003l.iw) this).f25978a, iB3, aVar.f43966a, iC, zeb.f(((com.amap.api.col.p0003l.iw) this).f25978a, iArr2));
    }

    public final int d(lhb lhbVar) {
        return dfb.b(((com.amap.api.col.p0003l.iw) this).f25978a, ((khb) lhbVar).f17706b, lhbVar.c, (int) (((khb) lhbVar).b * 1000000.0d), (int) (((khb) lhbVar).f42823a * 1000000.0d), (int) ((khb) lhbVar).c, (int) ((khb) lhbVar).f17707c, (int) ((khb) lhbVar).f17701a, (short) ((khb) lhbVar).f17705b, lhbVar.f43069a);
    }

    public final byte[] f(lhb lhbVar, peb.a aVar, long j, List<mhb> list) {
        List<ka> list2;
        super.a();
        try {
            int iD = d(lhbVar);
            int iB = -1;
            int iC = (aVar == null || (list2 = aVar.f18833a) == null || list2.size() <= 0) ? -1 : c(aVar);
            if (list != null && list.size() > 0) {
                iB = b(j, list);
            }
            web.a(((com.amap.api.col.p0003l.iw) this).f25978a);
            web.b(((com.amap.api.col.p0003l.iw) this).f25978a, iD);
            if (iC > 0) {
                web.e(((com.amap.api.col.p0003l.iw) this).f25978a, iC);
            }
            if (iB > 0) {
                web.d(((com.amap.api.col.p0003l.iw) this).f25978a, iB);
            }
            ((com.amap.api.col.p0003l.iw) this).f25978a.w(web.c(((com.amap.api.col.p0003l.iw) this).f25978a));
            return ((com.amap.api.col.p0003l.iw) this).f25978a.z();
        } catch (Throwable th) {
            phb.a(th);
            return null;
        }
    }
}
