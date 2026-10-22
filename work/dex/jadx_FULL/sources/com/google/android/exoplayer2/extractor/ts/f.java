package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.js2;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements ElementaryStreamReader {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 18;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.d f3138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f3141a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f3143b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3140a = new om6(new byte[18]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30714a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3142b = -9223372036854775807L;

    public f(@Nullable String str) {
        this.f3141a = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        sb0.k(this.f3139a);
        while (om6Var.a() > 0) {
            int i = this.f30714a;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(om6Var.a(), this.d - this.b);
                    this.f3139a.c(om6Var, iMin);
                    int i2 = this.b + iMin;
                    this.b = i2;
                    int i3 = this.d;
                    if (i2 == i3) {
                        long j = this.f3142b;
                        if (j != -9223372036854775807L) {
                            this.f3139a.e(j, 1, i3, 0, null);
                            this.f3142b += this.f3137a;
                        }
                        this.f30714a = 0;
                    }
                } else if (c(om6Var, this.f3140a.d(), 18)) {
                    d();
                    this.f3140a.S(0);
                    this.f3139a.c(this.f3140a, 18);
                    this.f30714a = 2;
                }
            } else if (e(om6Var)) {
                this.f30714a = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3143b = cVar.b();
        this.f3139a = extractorOutput.b(cVar.c(), 1);
    }

    public final boolean c(om6 om6Var, byte[] bArr, int i) {
        int iMin = Math.min(om6Var.a(), i - this.b);
        om6Var.k(bArr, this.b, iMin);
        int i2 = this.b + iMin;
        this.b = i2;
        return i2 == i;
    }

    @RequiresNonNull({com.alibaba.ariver.remotedebug.b.c.g})
    public final void d() {
        byte[] bArrD = this.f3140a.d();
        if (this.f3138a == null) {
            com.google.android.exoplayer2.d dVarG = js2.g(bArrD, this.f3143b, this.f3141a, null);
            this.f3138a = dVarG;
            this.f3139a.f(dVarG);
        }
        this.d = js2.a(bArrD);
        this.f3137a = (int) ((((long) js2.f(bArrD)) * 1000000) / ((long) this.f3138a.V));
    }

    public final boolean e(om6 om6Var) {
        while (om6Var.a() > 0) {
            int i = this.c << 8;
            this.c = i;
            int iG = i | om6Var.G();
            this.c = iG;
            if (js2.d(iG)) {
                byte[] bArrD = this.f3140a.d();
                int i2 = this.c;
                bArrD[0] = (byte) ((i2 >> 24) & 255);
                bArrD[1] = (byte) ((i2 >> 16) & 255);
                bArrD[2] = (byte) ((i2 >> 8) & 255);
                bArrD[3] = (byte) (i2 & 255);
                this.b = 4;
                this.c = 0;
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f3142b = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f30714a = 0;
        this.b = 0;
        this.c = 0;
        this.f3142b = -9223372036854775807L;
    }
}
