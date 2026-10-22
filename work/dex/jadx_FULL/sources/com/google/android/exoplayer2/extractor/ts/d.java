package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.mr;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements ElementaryStreamReader {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.d f3112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f3114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f3116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3117a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3118b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f3119b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3120b;
    public int c;

    public d() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        sb0.k(this.f3113a);
        while (om6Var.a() > 0) {
            int i = this.f30712a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(om6Var.a(), this.c - this.b);
                        this.f3113a.c(om6Var, iMin);
                        int i2 = this.b + iMin;
                        this.b = i2;
                        int i3 = this.c;
                        if (i2 == i3) {
                            long j = this.f3118b;
                            if (j != -9223372036854775807L) {
                                this.f3113a.e(j, 1, i3, 0, null);
                                this.f3118b += this.f3111a;
                            }
                            this.f30712a = 0;
                        }
                    }
                } else if (c(om6Var, this.f3115a.d(), 16)) {
                    d();
                    this.f3115a.S(0);
                    this.f3113a.c(this.f3115a, 16);
                    this.f30712a = 2;
                }
            } else if (e(om6Var)) {
                this.f30712a = 1;
                this.f3115a.d()[0] = -84;
                this.f3115a.d()[1] = (byte) (this.f3120b ? 65 : 64);
                this.b = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3119b = cVar.b();
        this.f3113a = extractorOutput.b(cVar.c(), 1);
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
        this.f3114a.q(0);
        mr.b bVarD = mr.d(this.f3114a);
        com.google.android.exoplayer2.d dVar = this.f3112a;
        if (dVar == null || bVarD.c != dVar.U || bVarD.b != dVar.V || !"audio/ac4".equals(dVar.k)) {
            com.google.android.exoplayer2.d dVarE = new com.google.android.exoplayer2.d.b().S(this.f3119b).e0("audio/ac4").H(bVarD.c).f0(bVarD.b).V(this.f3116a).E();
            this.f3112a = dVarE;
            this.f3113a.f(dVarE);
        }
        this.c = bVarD.d;
        this.f3111a = (((long) bVarD.e) * 1000000) / ((long) this.f3112a.V);
    }

    public final boolean e(om6 om6Var) {
        while (true) {
            if (om6Var.a() <= 0) {
                return false;
            }
            if (this.f3117a) {
                int iG = om6Var.G();
                this.f3117a = iG == 172;
                if (iG == 64 || iG == 65) {
                    this.f3120b = iG == 65;
                    return true;
                }
            } else {
                this.f3117a = om6Var.G() == 172;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f3118b = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f30712a = 0;
        this.b = 0;
        this.f3117a = false;
        this.f3120b = false;
        this.f3118b = -9223372036854775807L;
    }

    public d(@Nullable String str) {
        nm6 nm6Var = new nm6(new byte[16]);
        this.f3114a = nm6Var;
        this.f3115a = new om6(nm6Var.f18462a);
        this.f30712a = 0;
        this.b = 0;
        this.f3117a = false;
        this.f3120b = false;
        this.f3118b = -9223372036854775807L;
        this.f3116a = str;
    }
}
