package com.zj.adlib;

import android.util.Log;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43544a = "RtpPcmReader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f18433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f18434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18432a = -9223372036854775807L;
    public long b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18431a = -1;

    public nk7(b bVar) {
        this.f18434a = bVar;
    }

    public static long d(long j, long j2, long j3, int i) {
        return j + gj9.o1(j2 - j3, 1000000L, i);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) {
        int iB;
        sb0.g(this.f18433a);
        int i2 = this.f18431a;
        if (i2 != -1 && i != (iB = kk7.b(i2))) {
            Log.w(f43544a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i)));
        }
        long jD = d(this.b, j, this.f18432a, this.f18434a.f4396b);
        int iA = om6Var.a();
        this.f18433a.c(om6Var, iA);
        this.f18433a.e(jD, 1, iA, 0, null);
        this.f18431a = i;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 1);
        this.f18433a = trackOutputB;
        trackOutputB.f(this.f18434a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
        this.f18432a = j;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f18432a = j;
        this.b = j2;
    }
}
