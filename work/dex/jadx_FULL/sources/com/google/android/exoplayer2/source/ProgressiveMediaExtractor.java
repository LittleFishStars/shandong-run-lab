package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.zj.adlib.at6;
import com.zj.adlib.iv6;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ProgressiveMediaExtractor {

    public interface Factory {
        ProgressiveMediaExtractor a(at6 at6Var);
    }

    void a(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j, long j2, ExtractorOutput extractorOutput) throws IOException;

    int b(iv6 iv6Var) throws IOException;

    void disableSeekingOnMp3Streams();

    long getCurrentInputPosition();

    void release();

    void seek(long j, long j2);
}
