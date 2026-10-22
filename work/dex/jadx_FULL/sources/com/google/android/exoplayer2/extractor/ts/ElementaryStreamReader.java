package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ElementaryStreamReader {
    void a(om6 om6Var) throws ParserException;

    void b(ExtractorOutput extractorOutput, TsPayloadReader.c cVar);

    void packetFinished();

    void packetStarted(long j, int i);

    void seek();
}
