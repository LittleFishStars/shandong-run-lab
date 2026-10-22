package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
interface EbmlReader {
    boolean a(ExtractorInput extractorInput) throws IOException;

    void b(EbmlProcessor ebmlProcessor);

    void reset();
}
