package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.kw5;
import com.zj.adlib.om6;
import com.zj.adlib.ri0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends TagPayloadReader {
    public static final int c = 7;
    public static final int d = 1;
    public static final int e = 5;
    public static final int f = 0;
    public static final int g = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f2770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2771a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f2772b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2773b;

    public d(TrackOutput trackOutput) {
        super(trackOutput);
        this.f2770a = new om6(kw5.f17801a);
        this.f2772b = new om6(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void b() {
        this.f2773b = false;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(om6 om6Var) throws TagPayloadReader.UnsupportedFormatException {
        int iG = om6Var.G();
        int i = (iG >> 4) & 15;
        int i2 = iG & 15;
        if (i2 == 7) {
            this.b = i;
            return i != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i2);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parsePayload(om6 om6Var, long j) throws ParserException {
        int iG = om6Var.G();
        long jP = j + (((long) om6Var.p()) * 1000);
        if (iG == 0 && !this.f2771a) {
            om6 om6Var2 = new om6(new byte[om6Var.a()]);
            om6Var.k(om6Var2.d(), 0, om6Var.a());
            ri0 ri0VarB = ri0.b(om6Var2);
            this.f30648a = ri0VarB.f19327a;
            ((TagPayloadReader) this).f30644a.f(new com.google.android.exoplayer2.d.b().e0("video/avc").I(ri0VarB.f19328a).j0(ri0VarB.b).Q(ri0VarB.c).a0(ri0VarB.f44460a).T(ri0VarB.f19329a).E());
            this.f2771a = true;
            return false;
        }
        if (iG != 1 || !this.f2771a) {
            return false;
        }
        int i = this.b == 1 ? 1 : 0;
        if (!this.f2773b && i == 0) {
            return false;
        }
        byte[] bArrD = this.f2772b.d();
        bArrD[0] = 0;
        bArrD[1] = 0;
        bArrD[2] = 0;
        int i2 = 4 - this.f30648a;
        int i3 = 0;
        while (om6Var.a() > 0) {
            om6Var.k(this.f2772b.d(), i2, this.f30648a);
            this.f2772b.S(0);
            int iK = this.f2772b.K();
            this.f2770a.S(0);
            ((TagPayloadReader) this).f30644a.c(this.f2770a, 4);
            ((TagPayloadReader) this).f30644a.c(om6Var, iK);
            i3 = i3 + 4 + iK;
        }
        ((TagPayloadReader) this).f30644a.e(jP, i, i3, 0, null);
        this.f2773b = true;
        return true;
    }
}
