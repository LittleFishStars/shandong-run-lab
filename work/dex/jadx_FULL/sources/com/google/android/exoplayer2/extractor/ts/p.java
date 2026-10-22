package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.g89;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p implements TsPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30730a = "PesReader";
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 9;
    public static final int m = 10;
    public static final int n = 10;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ElementaryStreamReader f3273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g89 f3274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3276a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3277d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f3275a = new nm6(new byte[10]);
    public int d = 0;

    public p(ElementaryStreamReader elementaryStreamReader) {
        this.f3273a = elementaryStreamReader;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void a(om6 om6Var, int i2) throws ParserException {
        sb0.k(this.f3274a);
        if ((i2 & 1) != 0) {
            int i3 = this.d;
            if (i3 != 0 && i3 != 1) {
                if (i3 == 2) {
                    Log.n(f30730a, "Unexpected start indicator reading extended header");
                } else {
                    if (i3 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.g != -1) {
                        Log.n(f30730a, "Unexpected start indicator: expected " + this.g + " more bytes");
                    }
                    this.f3273a.packetFinished();
                }
            }
            f(1);
        }
        while (om6Var.a() > 0) {
            int i4 = this.d;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        if (c(om6Var, this.f3275a.f18462a, Math.min(10, this.f)) && c(om6Var, null, this.f)) {
                            e();
                            i2 |= this.f3277d ? 4 : 0;
                            this.f3273a.packetStarted(this.f3272a, i2);
                            f(3);
                        }
                    } else {
                        if (i4 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = om6Var.a();
                        int i5 = this.g;
                        int i6 = i5 != -1 ? iA - i5 : 0;
                        if (i6 > 0) {
                            iA -= i6;
                            om6Var.R(om6Var.e() + iA);
                        }
                        this.f3273a.a(om6Var);
                        int i7 = this.g;
                        if (i7 != -1) {
                            int i8 = i7 - iA;
                            this.g = i8;
                            if (i8 == 0) {
                                this.f3273a.packetFinished();
                                f(1);
                            }
                        }
                    }
                } else if (c(om6Var, this.f3275a.f18462a, 9)) {
                    f(d() ? 2 : 0);
                }
            } else {
                om6Var.T(om6Var.a());
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void b(g89 g89Var, ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        this.f3274a = g89Var;
        this.f3273a.b(extractorOutput, cVar);
    }

    public final boolean c(om6 om6Var, @Nullable byte[] bArr, int i2) {
        int iMin = Math.min(om6Var.a(), i2 - this.e);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            om6Var.T(iMin);
        } else {
            om6Var.k(bArr, this.e, iMin);
        }
        int i3 = this.e + iMin;
        this.e = i3;
        return i3 == i2;
    }

    public final boolean d() {
        this.f3275a.q(0);
        int iH = this.f3275a.h(24);
        if (iH != 1) {
            Log.n(f30730a, "Unexpected start code prefix: " + iH);
            this.g = -1;
            return false;
        }
        this.f3275a.s(8);
        int iH2 = this.f3275a.h(16);
        this.f3275a.s(5);
        this.f3277d = this.f3275a.g();
        this.f3275a.s(2);
        this.f3276a = this.f3275a.g();
        this.b = this.f3275a.g();
        this.f3275a.s(6);
        int iH3 = this.f3275a.h(8);
        this.f = iH3;
        if (iH2 == 0) {
            this.g = -1;
        } else {
            int i2 = ((iH2 + 6) - 9) - iH3;
            this.g = i2;
            if (i2 < 0) {
                Log.n(f30730a, "Found negative packet payload size: " + this.g);
                this.g = -1;
            }
        }
        return true;
    }

    @RequiresNonNull({"timestampAdjuster"})
    public final void e() {
        this.f3275a.q(0);
        this.f3272a = -9223372036854775807L;
        if (this.f3276a) {
            this.f3275a.s(4);
            long jH = ((long) this.f3275a.h(3)) << 30;
            this.f3275a.s(1);
            long jH2 = jH | ((long) (this.f3275a.h(15) << 15));
            this.f3275a.s(1);
            long jH3 = jH2 | ((long) this.f3275a.h(15));
            this.f3275a.s(1);
            if (!this.c && this.b) {
                this.f3275a.s(4);
                long jH4 = ((long) this.f3275a.h(3)) << 30;
                this.f3275a.s(1);
                long jH5 = jH4 | ((long) (this.f3275a.h(15) << 15));
                this.f3275a.s(1);
                long jH6 = jH5 | ((long) this.f3275a.h(15));
                this.f3275a.s(1);
                this.f3274a.b(jH6);
                this.c = true;
            }
            this.f3272a = this.f3274a.b(jH3);
        }
    }

    public final void f(int i2) {
        this.d = i2;
        this.e = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void seek() {
        this.d = 0;
        this.e = 0;
        this.c = false;
        this.f3273a.seek();
    }
}
