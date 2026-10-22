package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30735a = 434;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<com.google.android.exoplayer2.d> f3298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackOutput[] f3299a;

    public t(List<com.google.android.exoplayer2.d> list) {
        this.f3298a = list;
        this.f3299a = new TrackOutput[list.size()];
    }

    public void a(long j, om6 om6Var) {
        if (om6Var.a() < 9) {
            return;
        }
        int iO = om6Var.o();
        int iO2 = om6Var.o();
        int iG = om6Var.G();
        if (iO == 434 && iO2 == 1195456820 && iG == 3) {
            com.google.android.exoplayer2.extractor.a.b(j, om6Var, this.f3299a);
        }
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        for (int i = 0; i < this.f3299a.length; i++) {
            cVar.a();
            TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 3);
            com.google.android.exoplayer2.d dVar = this.f3298a.get(i);
            String str = dVar.k;
            sb0.b("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            trackOutputB.f(new com.google.android.exoplayer2.d.b().S(cVar.b()).e0(str).g0(dVar.K).V(dVar.h).F(dVar.Z).T(dVar.f2569a).E());
            this.f3299a[i] = trackOutputB;
        }
    }
}
