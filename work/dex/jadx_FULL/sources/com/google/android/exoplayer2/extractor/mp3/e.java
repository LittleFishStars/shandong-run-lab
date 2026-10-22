package com.google.android.exoplayer2.extractor.mp3;

import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.gj9;
import com.zj.adlib.hs5;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.x38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e implements Seeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30668a = "XingSeeker";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final long[] f2937a;
    public final long b;
    public final long c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final long f2938d;

    public e(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    @Nullable
    public static e b(long j, long j2, hs5.a aVar, om6 om6Var) {
        int iK;
        int i = aVar.f;
        int i2 = aVar.c;
        int iO = om6Var.o();
        if ((iO & 1) != 1 || (iK = om6Var.K()) == 0) {
            return null;
        }
        long jO1 = gj9.o1(iK, ((long) i) * 1000000, i2);
        if ((iO & 6) != 6) {
            return new e(j2, aVar.b, jO1);
        }
        long jI = om6Var.I();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = om6Var.G();
        }
        if (j != -1) {
            long j3 = j2 + jI;
            if (j != j3) {
                Log.n(f30668a, "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new e(j2, aVar.b, jO1, jI, jArr);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        if (!isSeekable()) {
            return new SeekMap.a(new x38(0L, this.f2936a + ((long) this.d)));
        }
        long jT = gj9.t(j, 0L, this.b);
        double d = (jT * 100.0d) / this.b;
        double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                long[] jArr = (long[]) sb0.k(this.f2937a);
                double d3 = jArr[i];
                d2 = d3 + ((d - ((double) i)) * ((i == 99 ? 256.0d : jArr[i + 1]) - d3));
            }
        }
        return new SeekMap.a(new x38(jT, this.f2936a + gj9.t(Math.round((d2 / 256.0d) * this.c), this.d, this.c - 1)));
    }

    public final long c(int i) {
        return (this.b * ((long) i)) / 100;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.f2938d;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        long j2 = j - this.f2936a;
        if (!isSeekable() || j2 <= this.d) {
            return 0L;
        }
        long[] jArr = (long[]) sb0.k(this.f2937a);
        double d = (j2 * 256.0d) / this.c;
        int iJ = gj9.j(jArr, (long) d, true, true);
        long jC = c(iJ);
        long j3 = jArr[iJ];
        int i = iJ + 1;
        long jC2 = c(i);
        long j4 = iJ == 99 ? 256L : jArr[i];
        return jC + Math.round((j3 == j4 ? AudioStats.AUDIO_AMPLITUDE_NONE : (d - j3) / (j4 - j3)) * (jC2 - jC));
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.f2937a != null;
    }

    public e(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.f2936a = j;
        this.d = i;
        this.b = j2;
        this.f2937a = jArr;
        this.c = j3;
        this.f2938d = j3 != -1 ? j + j3 : -1L;
    }
}
