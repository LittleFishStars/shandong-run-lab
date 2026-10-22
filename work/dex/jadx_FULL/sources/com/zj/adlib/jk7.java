package com.zj.adlib;

import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.util.Log;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42609a = "RtpOpusReader";
    public static final long c = 48000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f17419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f17420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17421a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f17422b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f17418a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f17417a = -1;

    public jk7(b bVar) {
        this.f17420a = bVar;
    }

    public static long d(long j, long j2, long j3) {
        return j + gj9.o1(j2 - j3, 1000000L, c);
    }

    public static void e(om6 om6Var) {
        int iE = om6Var.e();
        sb0.b(om6Var.f() > 18, "ID Header has insufficient data");
        sb0.b(om6Var.D(8).equals("OpusHead"), "ID Header missing");
        sb0.b(om6Var.G() == 1, "version number must always be 1");
        om6Var.S(iE);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) {
        sb0.k(this.f17419a);
        if (this.f17421a) {
            if (this.f17422b) {
                int iB = kk7.b(this.f17417a);
                if (i != iB) {
                    Log.n(f42609a, gj9.H("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i)));
                }
                int iA = om6Var.a();
                this.f17419a.c(om6Var, iA);
                this.f17419a.e(d(this.b, j, this.f17418a), 1, iA, 0, null);
            } else {
                sb0.b(om6Var.f() >= 8, "Comment Header has insufficient data");
                sb0.b(om6Var.D(8).equals("OpusTags"), "Comment Header should follow ID Header");
                this.f17422b = true;
            }
        } else {
            e(om6Var);
            List<byte[]> listA = sd6.a(om6Var.d());
            d.b bVarB = this.f17420a.f4394a.b();
            bVarB.T(listA);
            this.f17419a.f(bVarB.E());
            this.f17421a = true;
        }
        this.f17417a = i;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 1);
        this.f17419a = trackOutputB;
        trackOutputB.f(this.f17420a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
        this.f17418a = j;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f17418a = j;
        this.b = j2;
    }
}
