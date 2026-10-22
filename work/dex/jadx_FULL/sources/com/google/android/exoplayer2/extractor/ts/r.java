package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.zj.adlib.g89;
import com.zj.adlib.gj9;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r implements TsPayloadReader {
    public static final int f = 3;
    public static final int g = 32;
    public static final int h = 4098;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SectionPayloadReader f30733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3295a = new om6(32);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3296a;
    public boolean b;
    public int d;
    public int e;

    public r(SectionPayloadReader sectionPayloadReader) {
        this.f30733a = sectionPayloadReader;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void a(om6 om6Var, int i) {
        int iE;
        boolean z = (i & 1) != 0;
        if (z) {
            iE = om6Var.e() + om6Var.G();
        } else {
            iE = -1;
        }
        if (this.b) {
            if (!z) {
                return;
            }
            this.b = false;
            om6Var.S(iE);
            this.e = 0;
        }
        while (om6Var.a() > 0) {
            int i2 = this.e;
            if (i2 < 3) {
                if (i2 == 0) {
                    int iG = om6Var.G();
                    om6Var.S(om6Var.e() - 1);
                    if (iG == 255) {
                        this.b = true;
                        return;
                    }
                }
                int iMin = Math.min(om6Var.a(), 3 - this.e);
                om6Var.k(this.f3295a.d(), this.e, iMin);
                int i3 = this.e + iMin;
                this.e = i3;
                if (i3 == 3) {
                    this.f3295a.S(0);
                    this.f3295a.R(3);
                    this.f3295a.T(1);
                    int iG2 = this.f3295a.G();
                    int iG3 = this.f3295a.G();
                    this.f3296a = (iG2 & 128) != 0;
                    this.d = (((iG2 & 15) << 8) | iG3) + 3;
                    int iB = this.f3295a.b();
                    int i4 = this.d;
                    if (iB < i4) {
                        this.f3295a.c(Math.min(4098, Math.max(i4, this.f3295a.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(om6Var.a(), this.d - this.e);
                om6Var.k(this.f3295a.d(), this.e, iMin2);
                int i5 = this.e + iMin2;
                this.e = i5;
                int i6 = this.d;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.f3296a) {
                        this.f3295a.R(i6);
                    } else {
                        if (gj9.v(this.f3295a.d(), 0, this.d, -1) != 0) {
                            this.b = true;
                            return;
                        }
                        this.f3295a.R(this.d - 4);
                    }
                    this.f3295a.S(0);
                    this.f30733a.a(this.f3295a);
                    this.e = 0;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void b(g89 g89Var, ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        this.f30733a.b(g89Var, extractorOutput, cVar);
        this.b = true;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void seek() {
        this.b = true;
    }
}
