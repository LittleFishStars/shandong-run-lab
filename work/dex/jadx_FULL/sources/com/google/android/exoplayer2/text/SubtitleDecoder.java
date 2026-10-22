package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.Decoder;
import com.zj.adlib.cv8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface SubtitleDecoder extends Decoder<cv8, SubtitleOutputBuffer, SubtitleDecoderException> {
    void setPositionUs(long j);
}
