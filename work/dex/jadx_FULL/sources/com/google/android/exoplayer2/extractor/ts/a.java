package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.a;
import com.zj.adlib.iv6;
import com.zj.adlib.om6;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30709a = new ExtractorsFactory() { // from class: com.zj.adlib.jr
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return a.e();
        }
    };
    public static final int d = 8192;
    public static final int e = 2935;
    public static final int f = 2786;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f3096a = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f3097a = new om6(f);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3098a;

    public static /* synthetic */ Extractor[] e() {
        return new Extractor[]{new a()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f3096a.b(extractorOutput, new TsPayloadReader.c(0, 1));
        extractorOutput.endTracks();
        extractorOutput.d(new SeekMap.b(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        int i = extractorInput.read(this.f3097a.d(), 0, f);
        if (i == -1) {
            return -1;
        }
        this.f3097a.S(0);
        this.f3097a.R(i);
        if (!this.f3098a) {
            this.f3096a.packetStarted(0L, 4);
            this.f3098a = true;
        }
        this.f3096a.a(this.f3097a);
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
            extractorInput.peekFully(om6Var.d(), 0, 6);
            om6Var.S(0);
            if (om6Var.M() != 2935) {
                extractorInput.resetPeekPosition();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                extractorInput.advancePeekPosition(i3);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int iF2 = Ac3Util.f(om6Var.d());
                if (iF2 == -1) {
                    return false;
                }
                extractorInput.advancePeekPosition(iF2 - 6);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f3098a = false;
        this.f3096a.seek();
    }
}
