package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface RtpPayloadReader {

    public interface Factory {
        RtpPayloadReader a(b bVar);
    }

    void a(om6 om6Var, long j, int i, boolean z) throws ParserException;

    void b(ExtractorOutput extractorOutput, int i);

    void c(long j, int i);

    void seek(long j, long j2);
}
