package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.d86;
import com.zj.adlib.e86;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class StreamReader {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f3024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput f3025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OggSeeker f3026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3029a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3030b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3031b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f3032c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f3033d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d86 f3028a = new d86();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f3027a = new b();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.google.android.exoplayer2.d f30691a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public OggSeeker f3034a;
    }

    public static final class c implements OggSeeker {
        public c() {
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long a(ExtractorInput extractorInput) {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public SeekMap b() {
            return new SeekMap.b(-9223372036854775807L);
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public void startSeek(long j) {
        }
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    public final void a() {
        sb0.k(this.f3025a);
        gj9.k(this.f3024a);
    }

    public void b(ExtractorOutput extractorOutput, TrackOutput trackOutput) {
        this.f3024a = extractorOutput;
        this.f3025a = trackOutput;
        reset(true);
    }

    public final int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        a();
        int i = this.f30690a;
        if (i == 0) {
            return e(extractorInput);
        }
        if (i == 1) {
            extractorInput.skipFully((int) this.f3030b);
            this.f30690a = 2;
            return 0;
        }
        if (i == 2) {
            gj9.k(this.f3026a);
            return f(extractorInput, iv6Var);
        }
        if (i == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public long convertGranuleToTime(long j) {
        return (j * 1000000) / ((long) this.b);
    }

    public long convertTimeToGranule(long j) {
        return (((long) this.b) * j) / 1000000;
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    public final boolean d(ExtractorInput extractorInput) throws IOException {
        while (this.f3028a.d(extractorInput)) {
            this.f3033d = extractorInput.getPosition() - this.f3030b;
            if (!readHeaders(this.f3028a.c(), this.f3030b, this.f3027a)) {
                return true;
            }
            this.f3030b = extractorInput.getPosition();
        }
        this.f30690a = 3;
        return false;
    }

    @RequiresNonNull({"trackOutput"})
    public final int e(ExtractorInput extractorInput) throws IOException {
        if (!d(extractorInput)) {
            return -1;
        }
        com.google.android.exoplayer2.d dVar = this.f3027a.f30691a;
        this.b = dVar.V;
        if (!this.f3031b) {
            this.f3025a.f(dVar);
            this.f3031b = true;
        }
        OggSeeker oggSeeker = this.f3027a.f3034a;
        if (oggSeeker != null) {
            this.f3026a = oggSeeker;
        } else if (extractorInput.getLength() == -1) {
            this.f3026a = new c();
        } else {
            e86 e86VarB = this.f3028a.b();
            this.f3026a = new com.google.android.exoplayer2.extractor.ogg.a(this, this.f3030b, extractorInput.getLength(), e86VarB.d + e86VarB.e, e86VarB.f16228a, (e86VarB.b & 4) != 0);
        }
        this.f30690a = 2;
        this.f3028a.f();
        return 0;
    }

    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    public final int f(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        long jA = this.f3026a.a(extractorInput);
        if (jA >= 0) {
            iv6Var.f42452a = jA;
            return 1;
        }
        if (jA < -1) {
            onSeekEnd(-(jA + 2));
        }
        if (!this.f3029a) {
            this.f3024a.d((SeekMap) sb0.k(this.f3026a.b()));
            this.f3029a = true;
        }
        if (this.f3033d <= 0 && !this.f3028a.d(extractorInput)) {
            this.f30690a = 3;
            return -1;
        }
        this.f3033d = 0L;
        om6 om6VarC = this.f3028a.c();
        long jPreparePayload = preparePayload(om6VarC);
        if (jPreparePayload >= 0) {
            long j = this.f3032c;
            if (j + jPreparePayload >= this.f3023a) {
                long jConvertGranuleToTime = convertGranuleToTime(j);
                this.f3025a.c(om6VarC, om6VarC.f());
                this.f3025a.e(jConvertGranuleToTime, 1, om6VarC.f(), 0, null);
                this.f3023a = -1L;
            }
        }
        this.f3032c += jPreparePayload;
        return 0;
    }

    public final void g(long j, long j2) {
        this.f3028a.e();
        if (j == 0) {
            reset(!this.f3029a);
        } else if (this.f30690a != 0) {
            this.f3023a = convertTimeToGranule(j2);
            ((OggSeeker) gj9.k(this.f3026a)).startSeek(this.f3023a);
            this.f30690a = 2;
        }
    }

    public void onSeekEnd(long j) {
        this.f3032c = j;
    }

    public abstract long preparePayload(om6 om6Var);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean readHeaders(om6 om6Var, long j, b bVar) throws IOException;

    public void reset(boolean z) {
        if (z) {
            this.f3027a = new b();
            this.f3030b = 0L;
            this.f30690a = 0;
        } else {
            this.f30690a = 1;
        }
        this.f3023a = -1L;
        this.f3032c = 0L;
    }
}
