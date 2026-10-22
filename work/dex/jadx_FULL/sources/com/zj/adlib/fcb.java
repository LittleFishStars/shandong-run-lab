package com.zj.adlib;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class fcb extends com.amap.api.col.p0003l.iw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static fcb f41644a = new fcb();

    public fcb() {
        super(5120);
    }

    public static String b(String str) {
        return str == null ? "" : str;
    }

    public static fcb d() {
        return f41644a;
    }

    public final byte[] c(byte[] bArr, byte[] bArr2, List<? extends ueb> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int iC = xeb.c(((com.amap.api.col.p0003l.iw) this).f25978a, bArr);
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                ueb uebVar = list.get(i);
                iArr[i] = cfb.b(((com.amap.api.col.p0003l.iw) this).f25978a, (byte) uebVar.a(), cfb.c(((com.amap.api.col.p0003l.iw) this).f25978a, uebVar.b()));
            }
            ((com.amap.api.col.p0003l.iw) this).f25978a.w(xeb.b(((com.amap.api.col.p0003l.iw) this).f25978a, iC, bArr2 != null ? xeb.f(((com.amap.api.col.p0003l.iw) this).f25978a, bArr2) : 0, xeb.d(((com.amap.api.col.p0003l.iw) this).f25978a, iArr)));
            return ((com.amap.api.col.p0003l.iw) this).f25978a.z();
        } catch (Throwable th) {
            phb.a(th);
            return null;
        }
    }

    public final byte[] e() {
        super.a();
        try {
            ((com.amap.api.col.p0003l.iw) this).f25978a.w(ohb.b(((com.amap.api.col.p0003l.iw) this).f25978a, nhb.a(), ((com.amap.api.col.p0003l.iw) this).f25978a.b(nhb.m()), ((com.amap.api.col.p0003l.iw) this).f25978a.b(nhb.g()), (byte) nhb.A(), ((com.amap.api.col.p0003l.iw) this).f25978a.b(nhb.s()), ((com.amap.api.col.p0003l.iw) this).f25978a.b(nhb.q()), ((com.amap.api.col.p0003l.iw) this).f25978a.b(b(nhb.o())), ((com.amap.api.col.p0003l.iw) this).f25978a.b(b(nhb.u())), mhb.a(nhb.C()), ((com.amap.api.col.p0003l.iw) this).f25978a.b(nhb.y()), ((com.amap.api.col.p0003l.iw) this).f25978a.b(nhb.w()), ((com.amap.api.col.p0003l.iw) this).f25978a.b(nhb.i()), ((com.amap.api.col.p0003l.iw) this).f25978a.b(nhb.k())));
            return ((com.amap.api.col.p0003l.iw) this).f25978a.z();
        } catch (Exception e) {
            phb.a(e);
            return null;
        }
    }
}
