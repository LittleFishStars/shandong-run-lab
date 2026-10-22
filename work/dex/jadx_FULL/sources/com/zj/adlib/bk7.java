package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.common.base.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bk7 implements RtpPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40766a = "AAC-lbr";
    public static final String b = "AAC-hbr";
    public static final String c = "RtpAacReader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f15545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f15546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f15547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f15548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f15549a = new nm6();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f15550b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f15551b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f15552c;
    public final int d;

    public bk7(b bVar) {
        this.f15548a = bVar;
        this.f15545a = bVar.f4396b;
        String str = (String) sb0.g(bVar.f4395a.get("mode"));
        if (a.a(str, b)) {
            this.f15550b = 13;
            this.f15552c = 3;
        } else {
            if (!a.a(str, f40766a)) {
                throw new UnsupportedOperationException("AAC mode not supported");
            }
            this.f15550b = 6;
            this.f15552c = 2;
        }
        this.d = this.f15552c + this.f15550b;
    }

    public static void d(TrackOutput trackOutput, long j, int i) {
        trackOutput.e(j, 1, i, 0, null);
    }

    public static long e(long j, long j2, long j3, int i) {
        return j + gj9.o1(j2 - j3, 1000000L, i);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void a(om6 om6Var, long j, int i, boolean z) {
        sb0.g(this.f15547a);
        short sC = om6Var.C();
        int i2 = sC / this.d;
        long jE = e(this.f15551b, j, this.f15546a, this.f15545a);
        this.f15549a.n(om6Var);
        if (i2 == 1) {
            int iH = this.f15549a.h(this.f15550b);
            this.f15549a.s(this.f15552c);
            this.f15547a.c(om6Var, om6Var.a());
            if (z) {
                d(this.f15547a, jE, iH);
                return;
            }
            return;
        }
        om6Var.T((sC + 7) / 8);
        for (int i3 = 0; i3 < i2; i3++) {
            int iH2 = this.f15549a.h(this.f15550b);
            this.f15549a.s(this.f15552c);
            this.f15547a.c(om6Var, iH2);
            d(this.f15547a, jE, iH2);
            jE += gj9.o1(i2, 1000000L, this.f15545a);
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void b(ExtractorOutput extractorOutput, int i) {
        TrackOutput trackOutputB = extractorOutput.b(i, 1);
        this.f15547a = trackOutputB;
        trackOutputB.f(this.f15548a.f4394a);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void c(long j, int i) {
        this.f15546a = j;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader
    public void seek(long j, long j2) {
        this.f15546a = j;
        this.f15551b = j2;
    }
}
