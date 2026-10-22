package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Log;
import com.google.common.primitives.Bytes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ik7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42379a = "RtpMpeg4Reader";
    public static final long c = 90000;
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f17223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f17225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f17226a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f17227b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f17224a = -9223372036854775807L;
    public int b = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f17228c = 0;

    public ik7(b bVar) {
        this.f17226a = bVar;
    }

    public static int d(om6 om6Var) {
        int iJ = Bytes.j(om6Var.d(), new byte[]{0, 0, 1, -74});
        if (iJ == -1) {
            return 0;
        }
        om6Var.S(iJ + 4);
        return (om6Var.h() >> 6) == 0 ? 1 : 0;
    }

    public static long e(long j, long j2, long j3) {
        return j + gj9.o1(j2 - j3, 1000000L, 90000L);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) {
        int iB;
        sb0.k(this.f17225a);
        int i2 = this.b;
        if (i2 != -1 && i != (iB = kk7.b(i2))) {
            Log.n(f42379a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
        }
        int iA = om6Var.a();
        this.f17225a.c(om6Var, iA);
        if (this.f17228c == 0) {
            this.f17223a = d(om6Var);
        }
        this.f17228c += iA;
        if (z) {
            if (this.f17224a == -9223372036854775807L) {
                this.f17224a = j;
            }
            this.f17225a.e(e(this.f17227b, j, this.f17224a), this.f17223a, this.f17228c, 0, null);
            this.f17228c = 0;
        }
        this.b = i;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 2);
        this.f17225a = trackOutputB;
        ((TrackOutput) gj9.k(trackOutputB)).f(this.f17226a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f17224a = j;
        this.f17227b = j2;
        this.f17228c = 0;
    }
}
