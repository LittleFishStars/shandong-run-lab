package com.google.android.inner_exoplayer2.extractor.wav;

import com.google.android.inner_exoplayer2.extractor.SeekMap;
import com.google.android.inner_exoplayer2.extractor.SeekPoint;
import com.google.android.inner_exoplayer2.util.Util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class WavSeekMap implements SeekMap {
    private final long blockCount;
    private final long durationUs;
    private final long firstBlockPosition;
    private final int framesPerBlock;
    private final WavFormat wavFormat;

    public WavSeekMap(WavFormat wavFormat, int i, long j, long j2) {
        this.wavFormat = wavFormat;
        this.framesPerBlock = i;
        this.firstBlockPosition = j;
        long j3 = (j2 - j) / ((long) wavFormat.blockSize);
        this.blockCount = j3;
        this.durationUs = blockIndexToTimeUs(j3);
    }

    private long blockIndexToTimeUs(long j) {
        return Util.scaleLargeTimestamp(j * ((long) this.framesPerBlock), 1000000L, this.wavFormat.frameRateHz);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long jConstrainValue = Util.constrainValue((((long) this.wavFormat.frameRateHz) * j) / (((long) this.framesPerBlock) * 1000000), 0L, this.blockCount - 1);
        long j2 = this.firstBlockPosition + (((long) this.wavFormat.blockSize) * jConstrainValue);
        long jBlockIndexToTimeUs = blockIndexToTimeUs(jConstrainValue);
        SeekPoint seekPoint = new SeekPoint(jBlockIndexToTimeUs, j2);
        if (jBlockIndexToTimeUs >= j || jConstrainValue == this.blockCount - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j3 = jConstrainValue + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(blockIndexToTimeUs(j3), this.firstBlockPosition + (((long) this.wavFormat.blockSize) * j3)));
    }

    @Override // com.google.android.inner_exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
