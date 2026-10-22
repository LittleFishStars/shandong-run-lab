package com.google.android.inner_exoplayer2.extractor.mkv;

import com.google.android.inner_exoplayer2.extractor.ExtractorInput;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
interface EbmlReader {
    void init(EbmlProcessor ebmlProcessor);

    boolean read(ExtractorInput extractorInput);

    void reset();
}
