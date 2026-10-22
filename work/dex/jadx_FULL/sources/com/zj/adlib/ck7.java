package com.zj.adlib;

import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ck7 implements RtpPayloadReader {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f15839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f15840a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f15842b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f15843c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f15841a = new nm6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f15838a = -9223372036854775807L;

    public ck7(b bVar) {
        this.f15840a = bVar;
    }

    public static long i(long j, long j2, long j3, int i) {
        return j + gj9.o1(j2 - j3, 1000000L, i);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) {
        int iG = om6Var.G() & 3;
        int iG2 = om6Var.G() & 255;
        long jI = i(this.f15843c, j, this.f15838a, this.f15840a.f4396b);
        if (iG == 0) {
            d();
            if (iG2 == 1) {
                h(om6Var, jI);
                return;
            } else {
                g(om6Var, iG2, jI);
                return;
            }
        }
        if (iG == 1 || iG == 2) {
            d();
        } else if (iG != 3) {
            throw new IllegalArgumentException(String.valueOf(iG));
        }
        f(om6Var, z, iG, jI);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 1);
        this.f15839a = trackOutputB;
        trackOutputB.f(this.f15840a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
        sb0.i(this.f15838a == -9223372036854775807L);
        this.f15838a = j;
    }

    public final void d() {
        if (this.f40985a > 0) {
            e();
        }
    }

    public final void e() {
        ((TrackOutput) gj9.k(this.f15839a)).e(this.f15842b, 1, this.f40985a, 0, null);
        this.f40985a = 0;
    }

    public final void f(om6 om6Var, boolean z, int i, long j) {
        int iA = om6Var.a();
        ((TrackOutput) sb0.g(this.f15839a)).c(om6Var, iA);
        this.f40985a += iA;
        this.f15842b = j;
        if (z && i == 3) {
            e();
        }
    }

    public final void g(om6 om6Var, int i, long j) {
        this.f15841a.o(om6Var.d());
        this.f15841a.t(2);
        for (int i2 = 0; i2 < i; i2++) {
            Ac3Util.SyncFrameInfo syncFrameInfoE = Ac3Util.e(this.f15841a);
            ((TrackOutput) sb0.g(this.f15839a)).c(om6Var, syncFrameInfoE.d);
            ((TrackOutput) gj9.k(this.f15839a)).e(j, 1, syncFrameInfoE.d, 0, null);
            j += ((long) (syncFrameInfoE.e / syncFrameInfoE.b)) * 1000000;
            this.f15841a.t(syncFrameInfoE.d);
        }
    }

    public final void h(om6 om6Var, long j) {
        int iA = om6Var.a();
        ((TrackOutput) sb0.g(this.f15839a)).c(om6Var, iA);
        ((TrackOutput) gj9.k(this.f15839a)).e(j, 1, iA, 0, null);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f15838a = j;
        this.f15843c = j2;
    }
}
