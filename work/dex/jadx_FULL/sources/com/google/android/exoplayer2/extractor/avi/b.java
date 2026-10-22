package com.google.android.exoplayer2.extractor.avi;

import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements AviChunk {
    public static final int e = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30632a;
    public final int b;
    public final int c;
    public final int d;

    public b(int i, int i2, int i3, int i4) {
        this.f30632a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static b b(om6 om6Var) {
        int iR = om6Var.r();
        om6Var.T(8);
        int iR2 = om6Var.r();
        int iR3 = om6Var.r();
        om6Var.T(4);
        int iR4 = om6Var.r();
        om6Var.T(12);
        return new b(iR, iR2, iR3, iR4);
    }

    public boolean a() {
        return (this.b & 16) == 16;
    }

    @Override // com.google.android.exoplayer2.extractor.avi.AviChunk
    public int getType() {
        return 1751742049;
    }
}
