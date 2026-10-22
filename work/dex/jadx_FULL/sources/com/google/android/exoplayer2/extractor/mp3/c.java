package com.google.android.exoplayer2.extractor.mp3;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.zj.adlib.gj9;
import com.zj.adlib.x38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements Seeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f2932a;
    public final long[] b;

    public c(long[] jArr, long[] jArr2, long j) {
        this.f2932a = jArr;
        this.b = jArr2;
        this.f30666a = j == -9223372036854775807L ? gj9.Z0(jArr2[jArr2.length - 1]) : j;
    }

    public static c b(long j, MlltFrame mlltFrame, long j2) {
        int length = mlltFrame.bytesDeviations.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i3]);
            j3 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new c(jArr, jArr2, j2);
    }

    public static Pair<Long, Long> c(long j, long[] jArr, long[] jArr2) {
        int iJ = gj9.j(jArr, j, true, true);
        long j2 = jArr[iJ];
        long j3 = jArr2[iJ];
        int i = iJ + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? AudioStats.AUDIO_AMPLITUDE_NONE : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        Pair<Long, Long> pairC = c(gj9.H1(gj9.t(j, 0L, this.f30666a)), this.b, this.f2932a);
        return new SeekMap.a(new x38(gj9.Z0(((Long) pairC.first).longValue()), ((Long) pairC.second).longValue()));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f30666a;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return gj9.Z0(((Long) c(j, this.f2932a, this.b).second).longValue());
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
