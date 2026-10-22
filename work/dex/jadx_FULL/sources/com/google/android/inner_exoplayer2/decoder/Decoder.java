package com.google.android.inner_exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.decoder.DecoderException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface Decoder<I, O, E extends DecoderException> {
    @Nullable
    I dequeueInputBuffer();

    @Nullable
    O dequeueOutputBuffer();

    void flush();

    String getName();

    void queueInputBuffer(I i);

    void release();
}
