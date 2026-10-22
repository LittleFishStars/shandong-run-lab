package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30726a = "Id3Reader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3248a;
    public int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3247a = new om6(10);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3245a = -9223372036854775807L;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void a(om6 om6Var) {
        sb0.k(this.f3246a);
        if (this.f3248a) {
            int iA = om6Var.a();
            int i = this.b;
            if (i < 10) {
                int iMin = Math.min(iA, 10 - i);
                System.arraycopy(om6Var.d(), om6Var.e(), this.f3247a.d(), this.b, iMin);
                if (this.b + iMin == 10) {
                    this.f3247a.S(0);
                    if (73 != this.f3247a.G() || 68 != this.f3247a.G() || 51 != this.f3247a.G()) {
                        Log.n(f30726a, "Discarding invalid ID3 tag");
                        this.f3248a = false;
                        return;
                    } else {
                        this.f3247a.T(3);
                        this.f3244a = this.f3247a.F() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f3244a - this.b);
            this.f3246a.c(om6Var, iMin2);
            this.b += iMin2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar) {
        cVar.a();
        TrackOutput trackOutputB = extractorOutput.b(cVar.c(), 5);
        this.f3246a = trackOutputB;
        trackOutputB.f(new com.google.android.exoplayer2.d.b().S(cVar.b()).e0("application/id3").E());
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        int i;
        sb0.k(this.f3246a);
        if (this.f3248a && (i = this.f3244a) != 0 && this.b == i) {
            long j = this.f3245a;
            if (j != -9223372036854775807L) {
                this.f3246a.e(j, 1, i, 0, null);
            }
            this.f3248a = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f3248a = true;
        if (j != -9223372036854775807L) {
            this.f3245a = j;
        }
        this.f3244a = 0;
        this.b = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.f3248a = false;
        this.f3245a = -9223372036854775807L;
    }
}
