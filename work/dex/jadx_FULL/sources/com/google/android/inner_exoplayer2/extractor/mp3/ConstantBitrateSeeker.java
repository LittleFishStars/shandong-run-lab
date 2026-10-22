package com.google.android.inner_exoplayer2.extractor.mp3;

import com.google.android.inner_exoplayer2.audio.MpegAudioUtil;
import com.google.android.inner_exoplayer2.extractor.ConstantBitrateSeekMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public ConstantBitrateSeeker(long j, long j2, MpegAudioUtil.Header header, boolean z) {
        super(j, j2, header.bitrate, header.frameSize, z);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return getTimeUsAtPosition(j);
    }
}
