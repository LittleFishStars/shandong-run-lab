package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f30713a = {73, 68, com.alibaba.ariver.resource.parser.a.e.l};
    public static final String c = "AdtsReader";
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final int m = 5;
    public static final int n = 2;
    public static final int o = 8;
    public static final int p = 256;
    public static final int q = 512;
    public static final int r = 768;
    public static final int s = 1024;
    public static final int t = 10;
    public static final int u = 6;
    public static final int v = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f3124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f3126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3127a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3128b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TrackOutput f3129b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f3130b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3131b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f3132c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f3133c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public TrackOutput f3134c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3135c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3136d;
    public int e;
    public int f;
    public int g;

    public e(boolean z) {
        this(z, null);
    }

    public static boolean j(int i2) {
        return (i2 & 65526) == 65520;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) throws ParserException {
        c();
        while (om6Var.a() > 0) {
            int i2 = this.f3121a;
            if (i2 == 0) {
                g(om6Var);
            } else if (i2 == 1) {
                d(om6Var);
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (f(om6Var, this.f3124a.f18462a, this.f3131b ? 7 : 5)) {
                        k();
                    }
                } else {
                    if (i2 != 4) {
                        throw new IllegalStateException();
                    }
                    m(om6Var);
                }
            } else if (f(om6Var, this.f3125a.d(), 10)) {
                l();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3130b = cVar.b();
        TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 1);
        this.f3123a = trackOutputB;
        this.f3134c = trackOutputB;
        if (!this.f3127a) {
            this.f3129b = new com.google.android.exoplayer2.extractor.d();
            return;
        }
        cVar.a();
        TrackOutput trackOutputB2 = extractorOutput.b(cVar.c(), 5);
        this.f3129b = trackOutputB2;
        trackOutputB2.f(new com.google.android.exoplayer2.d.b().S(cVar.b()).e0("application/id3").E());
    }

    @EnsuresNonNull({com.alibaba.ariver.remotedebug.b.c.g, "currentOutput", "id3Output"})
    public final void c() {
        sb0.g(this.f3123a);
        gj9.k(this.f3134c);
        gj9.k(this.f3129b);
    }

    public final void d(om6 om6Var) {
        if (om6Var.a() == 0) {
            return;
        }
        this.f3124a.f18462a[0] = om6Var.d()[om6Var.e()];
        this.f3124a.q(2);
        int iH = this.f3124a.h(4);
        int i2 = this.e;
        if (i2 != -1 && iH != i2) {
            n();
            return;
        }
        if (!this.f3135c) {
            this.f3135c = true;
            this.d = this.f;
            this.e = iH;
        }
        q();
    }

    public final boolean e(om6 om6Var, int i2) {
        om6Var.S(i2 + 1);
        if (!t(om6Var, this.f3124a.f18462a, 1)) {
            return false;
        }
        this.f3124a.q(4);
        int iH = this.f3124a.h(1);
        int i3 = this.d;
        if (i3 != -1 && iH != i3) {
            return false;
        }
        if (this.e != -1) {
            if (!t(om6Var, this.f3124a.f18462a, 1)) {
                return true;
            }
            this.f3124a.q(2);
            if (this.f3124a.h(4) != this.e) {
                return false;
            }
            om6Var.S(i2 + 2);
        }
        if (!t(om6Var, this.f3124a.f18462a, 4)) {
            return true;
        }
        this.f3124a.q(14);
        int iH2 = this.f3124a.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrD = om6Var.d();
        int iF = om6Var.f();
        int i4 = i2 + iH2;
        if (i4 >= iF) {
            return true;
        }
        byte b = bArrD[i4];
        if (b == -1) {
            int i5 = i4 + 1;
            if (i5 == iF) {
                return true;
            }
            return i((byte) -1, bArrD[i5]) && ((bArrD[i5] & 8) >> 3) == iH;
        }
        if (b != 73) {
            return false;
        }
        int i6 = i4 + 1;
        if (i6 == iF) {
            return true;
        }
        if (bArrD[i6] != 68) {
            return false;
        }
        int i7 = i4 + 2;
        return i7 == iF || bArrD[i7] == 51;
    }

    public final boolean f(om6 om6Var, byte[] bArr, int i2) {
        int iMin = Math.min(om6Var.a(), i2 - this.b);
        om6Var.k(bArr, this.b, iMin);
        int i3 = this.b + iMin;
        this.b = i3;
        return i3 == i2;
    }

    public final void g(om6 om6Var) {
        byte[] bArrD = om6Var.d();
        int iE = om6Var.e();
        int iF = om6Var.f();
        while (iE < iF) {
            int i2 = iE + 1;
            int i3 = bArrD[iE] & 255;
            if (this.f3132c == 512 && i((byte) -1, (byte) i3) && (this.f3135c || e(om6Var, i2 - 2))) {
                this.f = (i3 & 8) >> 3;
                this.f3131b = (i3 & 1) == 0;
                if (this.f3135c) {
                    q();
                } else {
                    o();
                }
                om6Var.S(i2);
                return;
            }
            int i4 = this.f3132c;
            int i5 = i3 | i4;
            if (i5 == 329) {
                this.f3132c = 768;
            } else if (i5 == 511) {
                this.f3132c = 512;
            } else if (i5 == 836) {
                this.f3132c = 1024;
            } else if (i5 == 1075) {
                r();
                om6Var.S(i2);
                return;
            } else if (i4 != 256) {
                this.f3132c = 256;
                i2--;
            }
            iE = i2;
        }
        om6Var.S(iE);
    }

    public long h() {
        return this.f3122a;
    }

    public final boolean i(byte b, byte b2) {
        return j(((b & 255) << 8) | (b2 & 255));
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void k() throws ParserException {
        this.f3124a.q(0);
        if (this.f3136d) {
            this.f3124a.s(10);
        } else {
            int iH = this.f3124a.h(2) + 1;
            if (iH != 2) {
                Log.n(c, "Detected audio object type: " + iH + ", but assuming AAC LC.");
                iH = 2;
            }
            this.f3124a.s(5);
            byte[] bArrB = AacUtil.b(iH, this.e, this.f3124a.h(3));
            AacUtil.b bVarF = AacUtil.f(bArrB);
            com.google.android.exoplayer2.d dVarE = new com.google.android.exoplayer2.d.b().S(this.f3130b).e0("audio/mp4a-latm").I(bVarF.f2344a).H(bVarF.b).f0(bVarF.f30530a).T(Collections.singletonList(bArrB)).V(this.f3126a).E();
            this.f3122a = 1024000000 / ((long) dVarE.V);
            this.f3123a.f(dVarE);
            this.f3136d = true;
        }
        this.f3124a.s(4);
        int iH2 = (this.f3124a.h(13) - 2) - 5;
        if (this.f3131b) {
            iH2 -= 2;
        }
        s(this.f3123a, this.f3122a, 0, iH2);
    }

    @RequiresNonNull({"id3Output"})
    public final void l() {
        this.f3129b.c(this.f3125a, 10);
        this.f3125a.S(6);
        s(this.f3129b, 0L, 10, this.f3125a.F() + 10);
    }

    @RequiresNonNull({"currentOutput"})
    public final void m(om6 om6Var) {
        int iMin = Math.min(om6Var.a(), this.g - this.b);
        this.f3134c.c(om6Var, iMin);
        int i2 = this.b + iMin;
        this.b = i2;
        int i3 = this.g;
        if (i2 == i3) {
            long j2 = this.f3128b;
            if (j2 != -9223372036854775807L) {
                this.f3134c.e(j2, 1, i3, 0, null);
                this.f3128b += this.f3133c;
            }
            p();
        }
    }

    public final void n() {
        this.f3135c = false;
        p();
    }

    public final void o() {
        this.f3121a = 1;
        this.b = 0;
    }

    public final void p() {
        this.f3121a = 0;
        this.b = 0;
        this.f3132c = 256;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f3128b = j2;
        }
    }

    public final void q() {
        this.f3121a = 3;
        this.b = 0;
    }

    public final void r() {
        this.f3121a = 2;
        this.b = f30713a.length;
        this.g = 0;
        this.f3125a.S(0);
    }

    public final void s(TrackOutput trackOutput, long j2, int i2, int i3) {
        this.f3121a = 4;
        this.b = i2;
        this.f3134c = trackOutput;
        this.f3133c = j2;
        this.g = i3;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f3128b = -9223372036854775807L;
        n();
    }

    public final boolean t(om6 om6Var, byte[] bArr, int i2) {
        if (om6Var.a() < i2) {
            return false;
        }
        om6Var.k(bArr, 0, i2);
        return true;
    }

    public e(boolean z, @Nullable String str) {
        this.f3124a = new nm6(new byte[7]);
        this.f3125a = new om6(Arrays.copyOf(f30713a, 10));
        p();
        this.d = -1;
        this.e = -1;
        this.f3122a = -9223372036854775807L;
        this.f3128b = -9223372036854775807L;
        this.f3127a = z;
        this.f3126a = str;
    }
}
