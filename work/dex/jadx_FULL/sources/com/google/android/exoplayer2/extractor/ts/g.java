package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.om6;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3144a = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<TsPayloadReader.a> f3145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackOutput[] f3147a;
    public int b;

    public g(List<TsPayloadReader.a> list) {
        this.f3145a = list;
        this.f3147a = new TrackOutput[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        if (this.f3146a) {
            if (this.f30715a != 2 || c(om6Var, 32)) {
                if (this.f30715a != 1 || c(om6Var, 0)) {
                    int iE = om6Var.e();
                    int iA = om6Var.a();
                    for (TrackOutput trackOutput : this.f3147a) {
                        om6Var.S(iE);
                        trackOutput.c(om6Var, iA);
                    }
                    this.b += iA;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        for (int i = 0; i < this.f3147a.length; i++) {
            TsPayloadReader.a aVar = this.f3145a.get(i);
            cVar.a();
            TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 3);
            trackOutputB.f(new com.google.android.exoplayer2.d.b().S(cVar.b()).e0("application/dvbsubs").T(Collections.singletonList(aVar.f3090a)).V(aVar.f3089a).E());
            this.f3147a[i] = trackOutputB;
        }
    }

    public final boolean c(om6 om6Var, int i) {
        if (om6Var.a() == 0) {
            return false;
        }
        if (om6Var.G() != i) {
            this.f3146a = false;
        }
        this.f30715a--;
        return this.f3146a;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        if (this.f3146a) {
            if (this.f3144a != -9223372036854775807L) {
                for (TrackOutput trackOutput : this.f3147a) {
                    trackOutput.e(this.f3144a, 1, this.b, 0, null);
                }
            }
            this.f3146a = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f3146a = true;
        if (j != -9223372036854775807L) {
            this.f3144a = j;
        }
        this.b = 0;
        this.f30715a = 2;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f3146a = false;
        this.f3144a = -9223372036854775807L;
    }
}
