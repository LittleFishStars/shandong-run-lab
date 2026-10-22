package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class dk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41218a = "RtpAmrReader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f16033a = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] b = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f16034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f16036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f16037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16035a = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f16039b = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16040b = 0;

    public dk7(b bVar) {
        this.f16037a = bVar;
        this.f16038a = "audio/amr-wb".equals(sb0.g(bVar.f4394a.k));
        this.f16034a = bVar.f4396b;
    }

    public static int d(int i, boolean z) {
        boolean z2 = (i >= 0 && i <= 8) || i == 15;
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(z ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i);
        sb0.b(z2, sb.toString());
        return z ? b[i] : f16033a[i];
    }

    public static long e(long j, long j2, long j3, int i) {
        return j + gj9.o1(j2 - j3, 1000000L, i);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) {
        int iB;
        sb0.k(this.f16036a);
        int i2 = this.f16039b;
        if (i2 != -1 && i != (iB = kk7.b(i2))) {
            Log.n(f41218a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i)));
        }
        om6Var.T(1);
        int iD = d((om6Var.h() >> 3) & 15, this.f16038a);
        int iA = om6Var.a();
        sb0.b(iA == iD, "compound payload not supported currently");
        this.f16036a.c(om6Var, iA);
        this.f16036a.e(e(this.f16040b, j, this.f16035a, this.f16034a), 1, iA, 0, null);
        this.f16039b = i;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 1);
        this.f16036a = trackOutputB;
        trackOutputB.f(this.f16037a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
        this.f16035a = j;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f16035a = j;
        this.f16040b = j2;
    }
}
