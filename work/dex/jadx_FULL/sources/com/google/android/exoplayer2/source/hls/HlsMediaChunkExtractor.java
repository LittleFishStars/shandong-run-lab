package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface HlsMediaChunkExtractor {
    boolean a(ExtractorInput extractorInput) throws IOException;

    void b(ExtractorOutput extractorOutput);

    HlsMediaChunkExtractor c();

    boolean isPackedAudioExtractor();

    boolean isReusable();

    void onTruncatedSegmentParsed();
}
