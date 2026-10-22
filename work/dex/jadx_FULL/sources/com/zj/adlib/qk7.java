package com.zj.adlib;

import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44231a = "RtpVp9Reader";
    public static final long c = 90000;
    public static final int e = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f19136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f19137a;
    public int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f19135a = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f19139b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19134a = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f19141c = -1;
    public int d = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19138a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19140b = false;

    public qk7(b bVar) {
        this.f19137a = bVar;
    }

    public static long d(long j, long j2, long j3) {
        return j + gj9.o1(j2 - j3, 1000000L, 90000L);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) {
        int i2;
        int i3;
        sb0.k(this.f19136a);
        if (e(om6Var, i)) {
            int i4 = (this.b == 0 && this.f19138a && (om6Var.h() & 4) == 0) ? 1 : 0;
            if (!this.f19140b && (i2 = this.f19141c) != -1 && (i3 = this.d) != -1) {
                d dVar = this.f19137a.f4394a;
                if (i2 != dVar.Q || i3 != dVar.R) {
                    this.f19136a.f(dVar.b().j0(this.f19141c).Q(this.d).E());
                }
                this.f19140b = true;
            }
            int iA = om6Var.a();
            this.f19136a.c(om6Var, iA);
            this.b += iA;
            if (z) {
                if (this.f19135a == -9223372036854775807L) {
                    this.f19135a = j;
                }
                this.f19136a.e(d(this.f19139b, j, this.f19135a), i4, this.b, 0, null);
                this.b = 0;
                this.f19138a = false;
            }
            this.f19134a = i;
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 2);
        this.f19136a = trackOutputB;
        trackOutputB.f(this.f19137a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
    }

    public final boolean e(om6 om6Var, int i) {
        int iG = om6Var.G();
        if (this.f19138a) {
            int iB = kk7.b(this.f19134a);
            if (i != iB) {
                Log.n(f44231a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
                return false;
            }
        } else {
            if ((iG & 8) == 0) {
                Log.n(f44231a, "First payload octet of the RTP packet is not the beginning of a new VP9 partition, Dropping current packet.");
                return false;
            }
            this.f19138a = true;
        }
        if ((iG & 128) != 0 && (om6Var.G() & 128) != 0 && om6Var.a() < 1) {
            return false;
        }
        int i2 = iG & 16;
        sb0.b(i2 == 0, "VP9 flexible mode is not supported.");
        if ((iG & 32) != 0) {
            om6Var.T(1);
            if (om6Var.a() < 1) {
                return false;
            }
            if (i2 == 0) {
                om6Var.T(1);
            }
        }
        if ((iG & 2) != 0) {
            int iG2 = om6Var.G();
            int i3 = (iG2 >> 5) & 7;
            if ((iG2 & 16) != 0) {
                int i4 = i3 + 1;
                if (om6Var.a() < i4 * 4) {
                    return false;
                }
                for (int i5 = 0; i5 < i4; i5++) {
                    this.f19141c = om6Var.M();
                    this.d = om6Var.M();
                }
            }
            if ((iG2 & 8) != 0) {
                int iG3 = om6Var.G();
                if (om6Var.a() < iG3) {
                    return false;
                }
                for (int i6 = 0; i6 < iG3; i6++) {
                    int iM = (om6Var.M() & 12) >> 2;
                    if (om6Var.a() < iM) {
                        return false;
                    }
                    om6Var.T(iM);
                }
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f19135a = j;
        this.b = 0;
        this.f19139b = j2;
    }
}
