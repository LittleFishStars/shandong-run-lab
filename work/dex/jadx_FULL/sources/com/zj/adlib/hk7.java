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
public final class hk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42146a = "RtpH265Reader";
    public static final long c = 90000;
    public static final int d = 3;
    public static final int e = 48;
    public static final int f = 49;
    public static final int g = 19;
    public static final int h = 20;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f17002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f17004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f17005a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f17007b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f17009c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f17006a = new om6();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f17008b = new om6(kw5.f17801a);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f17003a = -9223372036854775807L;
    public int b = -1;

    public hk7(b bVar) {
        this.f17005a = bVar;
    }

    public static int d(int i) {
        return (i == 19 || i == 20) ? 1 : 0;
    }

    public static long g(long j, long j2, long j3) {
        return j + gj9.o1(j2 - j3, 1000000L, 90000L);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) throws ParserException {
        if (om6Var.d().length == 0) {
            throw ParserException.createForMalformedManifest("Empty RTP data packet.", null);
        }
        int i2 = (om6Var.d()[0] >> 1) & 63;
        sb0.k(this.f17004a);
        if (i2 >= 0 && i2 < 48) {
            f(om6Var);
        } else {
            if (i2 == 48) {
                throw new UnsupportedOperationException("need to implement processAggregationPacket");
            }
            if (i2 != 49) {
                throw ParserException.createForMalformedManifest(String.format("RTP H265 payload type [%d] not supported.", Integer.valueOf(i2)), null);
            }
            e(om6Var, i);
        }
        if (z) {
            if (this.f17003a == -9223372036854775807L) {
                this.f17003a = j;
            }
            this.f17004a.e(g(this.f17007b, j, this.f17003a), this.f17002a, this.f17009c, 0, null);
            this.f17009c = 0;
        }
        this.b = i;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 2);
        this.f17004a = trackOutputB;
        trackOutputB.f(this.f17005a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
    }

    @RequiresNonNull({"trackOutput"})
    public final void e(om6 om6Var, int i) throws ParserException {
        if (om6Var.d().length < 3) {
            throw ParserException.createForMalformedManifest("Malformed FU header.", null);
        }
        int i2 = om6Var.d()[1] & 7;
        byte b = om6Var.d()[2];
        int i3 = b & 63;
        boolean z = (b & UnsignedBytes.f32243a) > 0;
        boolean z2 = (b & SignedBytes.f32242a) > 0;
        if (z) {
            this.f17009c += h();
            om6Var.d()[1] = (byte) ((i3 << 1) & 127);
            om6Var.d()[2] = (byte) i2;
            this.f17006a.P(om6Var.d());
            this.f17006a.S(1);
        } else {
            int i4 = (this.b + 1) % 65535;
            if (i != i4) {
                Log.n(f42146a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(i4), Integer.valueOf(i)));
                return;
            } else {
                this.f17006a.P(om6Var.d());
                this.f17006a.S(3);
            }
        }
        int iA = this.f17006a.a();
        this.f17004a.c(this.f17006a, iA);
        this.f17009c += iA;
        if (z2) {
            this.f17002a = d(i3);
        }
    }

    @RequiresNonNull({"trackOutput"})
    public final void f(om6 om6Var) {
        int iA = om6Var.a();
        this.f17009c += h();
        this.f17004a.c(om6Var, iA);
        this.f17009c += iA;
        this.f17002a = d((om6Var.d()[0] >> 1) & 63);
    }

    public final int h() {
        this.f17008b.S(0);
        int iA = this.f17008b.a();
        ((TrackOutput) sb0.g(this.f17004a)).c(this.f17008b, iA);
        return iA;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f17003a = j;
        this.f17009c = 0;
        this.f17007b = j2;
    }
}
