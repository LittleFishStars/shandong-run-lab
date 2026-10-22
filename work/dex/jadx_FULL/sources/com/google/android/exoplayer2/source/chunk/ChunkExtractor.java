package com.google.android.exoplayer2.source.chunk;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.at6;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ChunkExtractor {

    public interface Factory {
        @Nullable
        ChunkExtractor a(int i, com.google.android.exoplayer2.d dVar, boolean z, List<com.google.android.exoplayer2.d> list, @Nullable TrackOutput trackOutput, at6 at6Var);
    }

    public interface TrackOutputProvider {
        TrackOutput b(int i, int i2);
    }

    boolean a(ExtractorInput extractorInput) throws IOException;

    void c(@Nullable TrackOutputProvider trackOutputProvider, long j, long j2);

    @Nullable
    com.google.android.exoplayer2.d[] e();

    @Nullable
    com.google.android.exoplayer2.extractor.b f();

    void release();
}
