package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.sb0;
import com.zj.adlib.x38;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BinarySearchSeeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f30614a = 262144;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f2690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TimestampSeeker f2691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f2692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public c f2693a;

    public interface SeekTimestampConverter {
        long timeUsToTargetTime(long j);
    }

    public interface TimestampSeeker {
        d a(ExtractorInput extractorInput, long j) throws IOException;

        default void onSeekFinished() {
        }
    }

    public static class a implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30615a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SeekTimestampConverter f2694a;
        public final long b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;

        public a(SeekTimestampConverter seekTimestampConverter, long j, long j2, long j3, long j4, long j5, long j6) {
            this.f2694a = seekTimestampConverter;
            this.f30615a = j;
            this.b = j2;
            this.c = j3;
            this.d = j4;
            this.e = j5;
            this.f = j6;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.a a(long j) {
            return new SeekMap.a(new x38(j, c.calculateNextSearchBytePosition(this.f2694a.timeUsToTargetTime(j), this.b, this.c, this.d, this.e, this.f)));
        }

        public long g(long j) {
            return this.f2694a.timeUsToTargetTime(j);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.f30615a;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }
    }

    public static final class b implements SeekTimestampConverter {
        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
        public long timeUsToTargetTime(long j) {
            return j;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30616a;
        public final long b;
        public final long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f30616a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = calculateNextSearchBytePosition(j2, j3, j4, j5, j6, j7);
        }

        public static long calculateNextSearchBytePosition(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return gj9.t(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        public final long h() {
            return this.g;
        }

        public final long i() {
            return this.f;
        }

        public final long j() {
            return this.h;
        }

        public final long k() {
            return this.f30616a;
        }

        public final long l() {
            return this.b;
        }

        public final void m() {
            this.h = calculateNextSearchBytePosition(this.b, this.d, this.e, this.f, this.g, this.c);
        }

        public final void n(long j, long j2) {
            this.e = j;
            this.g = j2;
            m();
        }

        public final void o(long j, long j2) {
            this.d = j;
            this.f = j2;
            m();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f30617a = new d(-3, -9223372036854775807L, -1);
        public static final int b = 0;
        public static final int c = -1;
        public static final int d = -2;
        public static final int e = -3;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f2695a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2696a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final long f2697b;

        public d(int i, long j, long j2) {
            this.f2695a = i;
            this.f2696a = j;
            this.f2697b = j2;
        }

        public static d d(long j, long j2) {
            return new d(-1, j, j2);
        }

        public static d e(long j) {
            return new d(0, -9223372036854775807L, j);
        }

        public static d f(long j, long j2) {
            return new d(-2, j, j2);
        }
    }

    public BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.f2691a = timestampSeeker;
        this.f2690a = i;
        this.f2692a = new a(seekTimestampConverter, j, j2, j3, j4, j5, j6);
    }

    public final SeekMap a() {
        return this.f2692a;
    }

    public int b(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        while (true) {
            c cVar = (c) sb0.k(this.f2693a);
            long jI = cVar.i();
            long jH = cVar.h();
            long j = cVar.j();
            if (jH - jI <= this.f2690a) {
                markSeekOperationFinished(false, jI);
                return seekToPosition(extractorInput, jI, iv6Var);
            }
            if (!skipInputUntilPosition(extractorInput, j)) {
                return seekToPosition(extractorInput, j, iv6Var);
            }
            extractorInput.resetPeekPosition();
            d dVarA = this.f2691a.a(extractorInput, cVar.l());
            int i = dVarA.f2695a;
            if (i == -3) {
                markSeekOperationFinished(false, j);
                return seekToPosition(extractorInput, j, iv6Var);
            }
            if (i == -2) {
                cVar.o(dVarA.f2696a, dVarA.f2697b);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    skipInputUntilPosition(extractorInput, dVarA.f2697b);
                    markSeekOperationFinished(true, dVarA.f2697b);
                    return seekToPosition(extractorInput, dVarA.f2697b, iv6Var);
                }
                cVar.n(dVarA.f2696a, dVarA.f2697b);
            }
        }
    }

    public final boolean c() {
        return this.f2693a != null;
    }

    public c createSeekParamsForTargetTimeUs(long j) {
        return new c(j, this.f2692a.g(j), this.f2692a.b, this.f2692a.c, this.f2692a.d, this.f2692a.e, this.f2692a.f);
    }

    public final void d(long j) {
        c cVar = this.f2693a;
        if (cVar == null || cVar.k() != j) {
            this.f2693a = createSeekParamsForTargetTimeUs(j);
        }
    }

    public final void markSeekOperationFinished(boolean z, long j) {
        this.f2693a = null;
        this.f2691a.onSeekFinished();
        onSeekOperationFinished(z, j);
    }

    public void onSeekOperationFinished(boolean z, long j) {
    }

    public final int seekToPosition(ExtractorInput extractorInput, long j, iv6 iv6Var) {
        if (j == extractorInput.getPosition()) {
            return 0;
        }
        iv6Var.f42452a = j;
        return 1;
    }

    public final boolean skipInputUntilPosition(ExtractorInput extractorInput, long j) throws IOException {
        long position = j - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }
}
