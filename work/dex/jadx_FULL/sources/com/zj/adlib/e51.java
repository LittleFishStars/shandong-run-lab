package com.zj.adlib;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ts.a;
import com.google.android.exoplayer2.extractor.ts.c;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e51 implements HlsMediaChunkExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iv6 f41348a = new iv6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f16194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final Extractor f16195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g89 f16196a;

    public e51(Extractor extractor, d dVar, g89 g89Var) {
        this.f16195a = extractor;
        this.f16194a = dVar;
        this.f16196a = g89Var;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean a(ExtractorInput extractorInput) throws IOException {
        return this.f16195a.c(extractorInput, f41348a) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void b(ExtractorOutput extractorOutput) {
        this.f16195a.b(extractorOutput);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public HlsMediaChunkExtractor c() {
        Extractor mp3Extractor;
        sb0.i(!isReusable());
        Extractor extractor = this.f16195a;
        if (extractor instanceof gv9) {
            mp3Extractor = new gv9(this.f16194a.h, this.f16196a);
        } else if (extractor instanceof AdtsExtractor) {
            mp3Extractor = new AdtsExtractor();
        } else if (extractor instanceof a) {
            mp3Extractor = new a();
        } else if (extractor instanceof c) {
            mp3Extractor = new c();
        } else {
            if (!(extractor instanceof Mp3Extractor)) {
                throw new IllegalStateException("Unexpected extractor type for recreation: " + this.f16195a.getClass().getSimpleName());
            }
            mp3Extractor = new Mp3Extractor();
        }
        return new e51(mp3Extractor, this.f16194a, this.f16196a);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isPackedAudioExtractor() {
        Extractor extractor = this.f16195a;
        return (extractor instanceof AdtsExtractor) || (extractor instanceof a) || (extractor instanceof c) || (extractor instanceof Mp3Extractor);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public boolean isReusable() {
        Extractor extractor = this.f16195a;
        return (extractor instanceof TsExtractor) || (extractor instanceof FragmentedMp4Extractor);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor
    public void onTruncatedSegmentParsed() {
        this.f16195a.seek(0L, 0L);
    }
}
