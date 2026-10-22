package com.zj.adlib;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Log;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41929a = "RtpH264Reader";
    public static final long c = 90000;
    public static final int d = 2;
    public static final int e = 24;
    public static final int f = 28;
    public static final int g = 5;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f16808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f16809a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16811b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f16813c;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f16812b = new om6(kw5.f17801a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f16810a = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16807a = -9223372036854775807L;
    public int b = -1;

    public gk7(b bVar) {
        this.f16809a = bVar;
    }

    public static int d(int i) {
        return i == 5 ? 1 : 0;
    }

    public static long h(long j, long j2, long j3) {
        return j + gj9.o1(j2 - j3, 1000000L, 90000L);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) throws ParserException {
        try {
            int i2 = om6Var.d()[0] & 31;
            sb0.k(this.f16808a);
            if (i2 > 0 && i2 < 24) {
                f(om6Var);
            } else if (i2 == 24) {
                g(om6Var);
            } else {
                if (i2 != 28) {
                    throw ParserException.createForMalformedManifest(String.format("RTP H264 packetization mode [%d] not supported.", Integer.valueOf(i2)), null);
                }
                e(om6Var, i);
            }
            if (z) {
                if (this.f16807a == -9223372036854775807L) {
                    this.f16807a = j;
                }
                this.f16808a.e(h(this.f16811b, j, this.f16807a), this.f16806a, this.f16813c, 0, null);
                this.f16813c = 0;
            }
            this.b = i;
        } catch (IndexOutOfBoundsException e2) {
            throw ParserException.createForMalformedManifest(null, e2);
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 2);
        this.f16808a = trackOutputB;
        ((TrackOutput) gj9.k(trackOutputB)).f(this.f16809a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
    }

    @RequiresNonNull({"trackOutput"})
    public final void e(om6 om6Var, int i) {
        byte b = om6Var.d()[0];
        byte b2 = om6Var.d()[1];
        int i2 = (b & 224) | (b2 & 31);
        boolean z = (b2 & UnsignedBytes.f32243a) > 0;
        boolean z2 = (b2 & SignedBytes.f32242a) > 0;
        if (z) {
            this.f16813c += i();
            om6Var.d()[1] = (byte) i2;
            this.f16810a.P(om6Var.d());
            this.f16810a.S(1);
        } else {
            int iB = kk7.b(this.b);
            if (i != iB) {
                Log.n(f41929a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i)));
                return;
            } else {
                this.f16810a.P(om6Var.d());
                this.f16810a.S(2);
            }
        }
        int iA = this.f16810a.a();
        this.f16808a.c(this.f16810a, iA);
        this.f16813c += iA;
        if (z2) {
            this.f16806a = d(i2 & 31);
        }
    }

    @RequiresNonNull({"trackOutput"})
    public final void f(om6 om6Var) {
        int iA = om6Var.a();
        this.f16813c += i();
        this.f16808a.c(om6Var, iA);
        this.f16813c += iA;
        this.f16806a = d(om6Var.d()[0] & 31);
    }

    @RequiresNonNull({"trackOutput"})
    public final void g(om6 om6Var) {
        om6Var.G();
        while (om6Var.a() > 4) {
            int iM = om6Var.M();
            this.f16813c += i();
            this.f16808a.c(om6Var, iM);
            this.f16813c += iM;
        }
        this.f16806a = 0;
    }

    public final int i() {
        this.f16812b.S(0);
        int iA = this.f16812b.a();
        ((TrackOutput) sb0.g(this.f16808a)).c(this.f16812b, iA);
        return iA;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f16807a = j;
        this.f16813c = 0;
        this.f16811b = j2;
    }
}
