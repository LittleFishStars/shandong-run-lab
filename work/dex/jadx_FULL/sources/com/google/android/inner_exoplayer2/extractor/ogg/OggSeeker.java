package com.google.android.inner_exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.extractor.ExtractorInput;
import com.google.android.inner_exoplayer2.extractor.SeekMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
interface OggSeeker {
    @Nullable
    SeekMap createSeekMap();

    long read(ExtractorInput extractorInput);

    void startSeek(long j);
}
