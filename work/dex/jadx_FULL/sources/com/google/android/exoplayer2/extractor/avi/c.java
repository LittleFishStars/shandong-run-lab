package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30633a = "AviStreamHeaderChunk";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f2731a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public c(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f2731a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public static c d(om6 om6Var) {
        int iR = om6Var.r();
        om6Var.T(12);
        int iR2 = om6Var.r();
        int iR3 = om6Var.r();
        int iR4 = om6Var.r();
        om6Var.T(4);
        int iR5 = om6Var.r();
        int iR6 = om6Var.r();
        om6Var.T(8);
        return new c(iR, iR2, iR3, iR4, iR5, iR6);
    }

    public long a() {
        return gj9.o1(this.e, ((long) this.c) * 1000000, this.d);
    }

    public float b() {
        return this.d / this.c;
    }

    public int c() {
        int i = this.f2731a;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        Log.n(f30633a, "Found unsupported streamType fourCC: " + Integer.toHexString(this.f2731a));
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviChunk
    public int getType() {
        return 1752331379;
    }
}
