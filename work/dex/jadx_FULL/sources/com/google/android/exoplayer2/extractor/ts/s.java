package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.google.android.exoplayer2.d> f30734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackOutput[] f3297a;

    public s(List<com.google.android.exoplayer2.d> list) {
        this.f30734a = list;
        this.f3297a = new TrackOutput[list.size()];
    }

    public void a(long j, om6 om6Var) {
        com.google.android.exoplayer2.extractor.a.a(j, om6Var, this.f3297a);
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        for (int i = 0; i < this.f3297a.length; i++) {
            cVar.a();
            TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 3);
            com.google.android.exoplayer2.d dVar = this.f30734a.get(i);
            String str = dVar.k;
            sb0.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String strB = dVar.f;
            if (strB == null) {
                strB = cVar.b();
            }
            trackOutputB.f(new com.google.android.exoplayer2.d.b().S(strB).e0(str).g0(dVar.K).V(dVar.h).F(dVar.Z).T(dVar.f2569a).E());
            this.f3297a[i] = trackOutputB;
        }
    }
}
