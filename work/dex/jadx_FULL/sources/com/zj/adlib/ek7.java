package com.zj.adlib;

import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.source.rtsp.reader.a;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ek7 implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f16335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RtpPayloadReader f16336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16340a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @GuardedBy("lock")
    public boolean f16342b;
    public final int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f16338a = new om6(kk7.d);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final om6 f16341b = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f16339a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mk7 f16337a = new mk7();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f41459a = -9223372036854775807L;
    public volatile int e = -1;

    @GuardedBy("lock")
    public long b = -9223372036854775807L;

    @GuardedBy("lock")
    public long c = -9223372036854775807L;

    public ek7(b bVar, int i) {
        this.d = i;
        this.f16336a = (RtpPayloadReader) sb0.g(new a().a(bVar));
    }

    public static long a(long j) {
        return j - 30;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f16336a.b(extractorOutput, this.d);
        extractorOutput.endTracks();
        extractorOutput.d(new SeekMap.b(-9223372036854775807L));
        this.f16335a = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        sb0.g(this.f16335a);
        int i = extractorInput.read(this.f16338a.d(), 0, kk7.d);
        if (i == -1) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        this.f16338a.S(0);
        this.f16338a.R(i);
        kk7 kk7VarD = kk7.d(this.f16338a);
        if (kk7VarD == null) {
            return 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jA = a(jElapsedRealtime);
        this.f16337a.e(kk7VarD, jElapsedRealtime);
        kk7 kk7VarF = this.f16337a.f(jA);
        if (kk7VarF == null) {
            return 0;
        }
        if (!this.f16340a) {
            if (this.f41459a == -9223372036854775807L) {
                this.f41459a = kk7VarF.f17722a;
            }
            if (this.e == -1) {
                this.e = kk7VarF.f17721a;
            }
            this.f16336a.c(this.f41459a, this.e);
            this.f16340a = true;
        }
        synchronized (this.f16339a) {
            if (!this.f16342b) {
                do {
                    this.f16341b.P(kk7VarF.f17727b);
                    this.f16336a.a(this.f16341b, kk7VarF.f17722a, kk7VarF.f17721a, kk7VarF.f17729c);
                    kk7VarF = this.f16337a.f(jA);
                } while (kk7VarF != null);
            } else if (this.b != -9223372036854775807L && this.c != -9223372036854775807L) {
                this.f16337a.g();
                this.f16336a.seek(this.b, this.c);
                this.f16342b = false;
                this.b = -9223372036854775807L;
                this.c = -9223372036854775807L;
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }

    public boolean e() {
        return this.f16340a;
    }

    public void f() {
        synchronized (this.f16339a) {
            this.f16342b = true;
        }
    }

    public void g(int i) {
        this.e = i;
    }

    public void h(long j) {
        this.f41459a = j;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        synchronized (this.f16339a) {
            this.b = j;
            this.c = j2;
        }
    }
}
