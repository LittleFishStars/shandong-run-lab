package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.zj.adlib.bp5;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements MediaPeriod, MediaPeriod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ClippingMediaSource.IllegalClippingException f3757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaPeriod.Callback f3758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaPeriod f3759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public C0686a[] f3760a = new C0686a[0];
    public long b;
    public long c;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.a$a, reason: collision with other inner class name */
    public final class C0686a implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SampleStream f30838a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3762a;

        public C0686a(SampleStream sampleStream) {
            this.f30838a = sampleStream;
        }

        public void a() {
            this.f3762a = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (a.this.g()) {
                return -3;
            }
            if (this.f3762a) {
                decoderInputBuffer.i(4);
                return -4;
            }
            int iB = this.f30838a.b(yk3Var, decoderInputBuffer, i);
            if (iB == -5) {
                com.google.android.exoplayer2.d dVar = (com.google.android.exoplayer2.d) sb0.g(yk3Var.f46052a);
                int i2 = dVar.X;
                if (i2 != 0 || dVar.Y != 0) {
                    a aVar = a.this;
                    if (aVar.b != 0) {
                        i2 = 0;
                    }
                    yk3Var.f46052a = dVar.b().N(i2).O(aVar.c == Long.MIN_VALUE ? dVar.Y : 0).E();
                }
                return -5;
            }
            a aVar2 = a.this;
            long j = aVar2.c;
            if (j == Long.MIN_VALUE || ((iB != -4 || decoderInputBuffer.f30576a < j) && !(iB == -3 && aVar2.getBufferedPositionUs() == Long.MIN_VALUE && !decoderInputBuffer.f2589a))) {
                return iB;
            }
            decoderInputBuffer.b();
            decoderInputBuffer.i(4);
            this.f3762a = true;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !a.this.g() && this.f30838a.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.f30838a.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            if (a.this.g()) {
                return -3;
            }
            return this.f30838a.skipData(j);
        }
    }

    public a(MediaPeriod mediaPeriod, boolean z, long j, long j2) {
        this.f3759a = mediaPeriod;
        this.f30837a = z ? j : -9223372036854775807L;
        this.b = j;
        this.c = j2;
    }

    public static boolean k(long j, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    com.google.android.exoplayer2.d dVarA = exoTrackSelection.a();
                    if (!bp5.a(dVarA.k, dVarA.i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        long j2 = this.b;
        if (j == j2) {
            return j2;
        }
        return this.f3759a.a(j, b(j, w38Var));
    }

    public final w38 b(long j, w38 w38Var) {
        long jT = gj9.t(w38Var.f20365a, 0L, j - this.b);
        long j2 = w38Var.f20366b;
        long j3 = this.c;
        long jT2 = gj9.t(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (jT == w38Var.f20365a && jT2 == w38Var.f20366b) ? w38Var : new w38(jT, jT2);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        this.f3758a = callback;
        this.f3759a.c(this, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.f3759a.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        this.f3759a.discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        return this.f3759a.e();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:27:0x0063  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        this.f3760a = new C0686a[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            C0686a[] c0686aArr = this.f3760a;
            C0686a c0686a = (C0686a) sampleStreamArr[i];
            c0686aArr[i] = c0686a;
            if (c0686a != null) {
                sampleStream = c0686a.f30838a;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long jF = this.f3759a.f(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j);
        if (g()) {
            long j3 = this.b;
            if (j == j3 && k(j3, exoTrackSelectionArr)) {
                j2 = jF;
            } else {
                j2 = -9223372036854775807L;
            }
        } else {
            j2 = -9223372036854775807L;
        }
        this.f30837a = j2;
        if (jF != j) {
            if (jF >= this.b) {
                long j4 = this.c;
                z = j4 == Long.MIN_VALUE || jF <= j4;
            }
        }
        sb0.i(z);
        for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
            SampleStream sampleStream2 = sampleStreamArr2[i2];
            if (sampleStream2 == null) {
                this.f3760a[i2] = null;
            } else {
                C0686a[] c0686aArr2 = this.f3760a;
                C0686a c0686a2 = c0686aArr2[i2];
                if (c0686a2 == null || c0686a2.f30838a != sampleStream2) {
                    c0686aArr2[i2] = new C0686a(sampleStream2);
                }
            }
            sampleStreamArr[i2] = this.f3760a[i2];
        }
        return jF;
    }

    public boolean g() {
        return this.f30837a != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f3759a.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.c;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f3759a.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.c;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void h(MediaPeriod mediaPeriod) {
        if (this.f3757a != null) {
            return;
        }
        ((MediaPeriod.Callback) sb0.g(this.f3758a)).h(this);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void d(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) sb0.g(this.f3758a)).d(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.f3759a.isLoading();
    }

    public void j(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f3757a = illegalClippingException;
    }

    public void l(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f3757a;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.f3759a.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (g()) {
            long j = this.f30837a;
            this.f30837a = -9223372036854775807L;
            long discontinuity = readDiscontinuity();
            return discontinuity != -9223372036854775807L ? discontinuity : j;
        }
        long discontinuity2 = this.f3759a.readDiscontinuity();
        if (discontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        sb0.i(discontinuity2 >= this.b);
        long j2 = this.c;
        if (j2 != Long.MIN_VALUE && discontinuity2 > j2) {
            z = false;
        }
        sb0.i(z);
        return discontinuity2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.f3759a.reevaluateBuffer(j);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        this.f30837a = -9223372036854775807L;
        boolean z = false;
        for (C0686a c0686a : this.f3760a) {
            if (c0686a != null) {
                c0686a.a();
            }
        }
        long jSeekToUs = this.f3759a.seekToUs(j);
        if (jSeekToUs == j) {
            z = true;
        } else if (jSeekToUs >= this.b) {
            long j2 = this.c;
            if (j2 == Long.MIN_VALUE || jSeekToUs <= j2) {
                z = true;
            }
        }
        sb0.i(z);
        return jSeekToUs;
    }
}
