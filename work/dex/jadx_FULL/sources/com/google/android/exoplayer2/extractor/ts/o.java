package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.g89;
import com.zj.adlib.gj9;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o implements SectionPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.android.exoplayer2.d f30729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g89 f3271a;

    public o(String str) {
        this.f30729a = new com.google.android.exoplayer2.d.b().e0(str).E();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void a(om6 om6Var) {
        c();
        long jD = this.f3271a.d();
        long jE = this.f3271a.e();
        if (jD == -9223372036854775807L || jE == -9223372036854775807L) {
            return;
        }
        com.google.android.exoplayer2.d dVar = this.f30729a;
        if (jE != dVar.f2565a) {
            com.google.android.exoplayer2.d dVarE = dVar.b().i0(jE).E();
            this.f30729a = dVarE;
            this.f3270a.f(dVarE);
        }
        int iA = om6Var.a();
        this.f3270a.c(om6Var, iA);
        this.f3270a.e(jD, 1, iA, 0, null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
    public void b(g89 g89Var, ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        this.f3271a = g89Var;
        cVar.a();
        TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 5);
        this.f3270a = trackOutputB;
        trackOutputB.f(this.f30729a);
    }

    @EnsuresNonNull({"timestampAdjuster", com.alibaba.ariver.remotedebug.b.c.g})
    public final void c() {
        sb0.k(this.f3271a);
        gj9.k(this.f3270a);
    }
}
