package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.c;
import com.zj.adlib.iv6;
import com.zj.adlib.mr;
import com.zj.adlib.om6;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30711a = new ExtractorsFactory() { // from class: com.zj.adlib.lr
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return c.e();
        }
    };
    public static final int d = 8192;
    public static final int e = 16384;
    public static final int f = 7;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f3108a = new d();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3109a = new om6(16384);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3110a;

    public static /* synthetic */ Extractor[] e() {
        return new Extractor[]{new c()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f3108a.b(extractorOutput, new TsPayloadReader.c(0, 1));
        extractorOutput.endTracks();
        extractorOutput.d(new SeekMap.b(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        int i = extractorInput.read(this.f3109a.d(), 0, 16384);
        if (i == -1) {
            return -1;
        }
        this.f3109a.S(0);
        this.f3109a.R(i);
        if (!this.f3110a) {
            this.f3108a.packetStarted(0L, 4);
            this.f3110a = true;
        }
        this.f3108a.a(this.f3109a);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        om6 om6Var = new om6(10);
        int i = 0;
        while (true) {
            extractorInput.peekFully(om6Var.d(), 0, 10);
            om6Var.S(0);
            if (om6Var.J() != 4801587) {
                break;
            }
            om6Var.T(3);
            int iF = om6Var.F();
            i += iF + 10;
            extractorInput.advancePeekPosition(iF);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        int i2 = 0;
        int i3 = i;
        while (true) {
            extractorInput.peekFully(om6Var.d(), 0, 7);
            om6Var.S(0);
            int iM = om6Var.M();
            if (iM == 44096 || iM == 44097) {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iE = mr.e(om6Var.d(), iM);
                if (iE == -1) {
                    return false;
                }
                extractorInput.advancePeekPosition(iE - 7);
            } else {
                extractorInput.resetPeekPosition();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                extractorInput.advancePeekPosition(i3);
                i2 = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f3110a = false;
        this.f3108a.seek();
    }
}
