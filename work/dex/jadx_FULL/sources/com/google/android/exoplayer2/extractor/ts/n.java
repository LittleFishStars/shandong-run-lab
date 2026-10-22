package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.hs5;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n implements ElementaryStreamReader {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hs5.a f3263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f3265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3266a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3267b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f3268b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3269b;
    public int c;

    public n() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        sb0.k(this.f3262a);
        while (om6Var.a() > 0) {
            int i = this.f30728a;
            if (i == 0) {
                c(om6Var);
            } else if (i == 1) {
                e(om6Var);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                d(om6Var);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3268b = cVar.b();
        this.f3262a = extractorOutput.b(cVar.c(), 1);
    }

    public final void c(om6 om6Var) {
        byte[] bArrD = om6Var.d();
        int iF = om6Var.f();
        for (int iE = om6Var.e(); iE < iF; iE++) {
            byte b = bArrD[iE];
            boolean z = (b & 255) == 255;
            boolean z2 = this.f3269b && (b & 224) == 224;
            this.f3269b = z;
            if (z2) {
                om6Var.S(iE + 1);
                this.f3269b = false;
                this.f3264a.d()[1] = bArrD[iE];
                this.b = 2;
                this.f30728a = 1;
                return;
            }
        }
        om6Var.S(iF);
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void d(om6 om6Var) {
        int iMin = Math.min(om6Var.a(), this.c - this.b);
        this.f3262a.c(om6Var, iMin);
        int i = this.b + iMin;
        this.b = i;
        int i2 = this.c;
        if (i < i2) {
            return;
        }
        long j = this.f3267b;
        if (j != -9223372036854775807L) {
            this.f3262a.e(j, 1, i2, 0, null);
            this.f3267b += this.f3261a;
        }
        this.b = 0;
        this.f30728a = 0;
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void e(om6 om6Var) {
        int iMin = Math.min(om6Var.a(), 4 - this.b);
        om6Var.k(this.f3264a.d(), this.b, iMin);
        int i = this.b + iMin;
        this.b = i;
        if (i < 4) {
            return;
        }
        this.f3264a.S(0);
        if (!this.f3263a.a(this.f3264a.o())) {
            this.b = 0;
            this.f30728a = 1;
            return;
        }
        hs5.a aVar = this.f3263a;
        this.c = aVar.b;
        if (!this.f3266a) {
            this.f3261a = (((long) aVar.f) * 1000000) / ((long) aVar.c);
            this.f3262a.f(new com.google.android.exoplayer2.d.b().S(this.f3268b).e0(this.f3263a.f17069a).W(4096).H(this.f3263a.d).f0(this.f3263a.c).V(this.f3265a).E());
            this.f3266a = true;
        }
        this.f3264a.S(0);
        this.f3262a.c(this.f3264a, 4);
        this.f30728a = 2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f3267b = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f30728a = 0;
        this.b = 0;
        this.f3269b = false;
        this.f3267b = -9223372036854775807L;
    }

    public n(@Nullable String str) {
        this.f30728a = 0;
        om6 om6Var = new om6(4);
        this.f3264a = om6Var;
        om6Var.d()[0] = -1;
        this.f3263a = new hs5.a();
        this.f3267b = -9223372036854775807L;
        this.f3265a = str;
    }
}
