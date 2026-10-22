package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.gj9;
import com.zj.adlib.nm6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements ElementaryStreamReader {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 128;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.d f3100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f3102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f3104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3105a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3106b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f3107b;
    public int c;

    public b() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        sb0.k(this.f3101a);
        while (om6Var.a() > 0) {
            int i = this.f30710a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int iMin = Math.min(om6Var.a(), this.c - this.b);
                        this.f3101a.c(om6Var, iMin);
                        int i2 = this.b + iMin;
                        this.b = i2;
                        int i3 = this.c;
                        if (i2 == i3) {
                            long j = this.f3106b;
                            if (j != -9223372036854775807L) {
                                this.f3101a.e(j, 1, i3, 0, null);
                                this.f3106b += this.f3099a;
                            }
                            this.f30710a = 0;
                        }
                    }
                } else if (c(om6Var, this.f3103a.d(), 128)) {
                    d();
                    this.f3103a.S(0);
                    this.f3101a.c(this.f3103a, 128);
                    this.f30710a = 2;
                }
            } else if (e(om6Var)) {
                this.f30710a = 1;
                this.f3103a.d()[0] = 11;
                this.f3103a.d()[1] = 119;
                this.b = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        this.f3107b = cVar.b();
        this.f3101a = extractorOutput.b(cVar.c(), 1);
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
        this.f3102a.q(0);
        Ac3Util.SyncFrameInfo syncFrameInfoE = Ac3Util.e(this.f3102a);
        com.google.android.exoplayer2.d dVar = this.f3100a;
        if (dVar == null || syncFrameInfoE.c != dVar.U || syncFrameInfoE.b != dVar.V || !gj9.c(syncFrameInfoE.f2351a, dVar.k)) {
            com.google.android.exoplayer2.d dVarE = new com.google.android.exoplayer2.d.b().S(this.f3107b).e0(syncFrameInfoE.f2351a).H(syncFrameInfoE.c).f0(syncFrameInfoE.b).V(this.f3104a).E();
            this.f3100a = dVarE;
            this.f3101a.f(dVarE);
        }
        this.c = syncFrameInfoE.d;
        this.f3099a = (((long) syncFrameInfoE.e) * 1000000) / ((long) this.f3100a.V);
    }

    public final boolean e(om6 om6Var) {
        while (true) {
            if (om6Var.a() <= 0) {
                return false;
            }
            if (this.f3105a) {
                int iG = om6Var.G();
                if (iG == 119) {
                    this.f3105a = false;
                    return true;
                }
                this.f3105a = iG == 11;
            } else {
                this.f3105a = om6Var.G() == 11;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f3106b = j;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f30710a = 0;
        this.b = 0;
        this.f3105a = false;
        this.f3106b = -9223372036854775807L;
    }

    public b(@Nullable String str) {
        nm6 nm6Var = new nm6(new byte[128]);
        this.f3102a = nm6Var;
        this.f3103a = new om6(nm6Var.f18462a);
        this.f30710a = 0;
        this.f3106b = -9223372036854775807L;
        this.f3104a = str;
    }
}
