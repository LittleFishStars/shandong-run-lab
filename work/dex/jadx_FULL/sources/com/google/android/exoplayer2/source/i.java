package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.li8;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import com.zj.adlib.yk3;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i extends BaseMediaSource {
    public static final int K = 44100;
    public static final int L = 2;
    public static final int M = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.exoplayer2.d f30937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f4271a;
    public static final com.google.android.exoplayer2.g b;
    public static final String f = "SilenceMediaSource";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f4272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.g f4273a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30938a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Object f4274a;

        public i a() {
            sb0.i(this.f30938a > 0);
            return new i(this.f30938a, i.b.b().K(this.f4274a).a());
        }

        public b b(@IntRange(from = 1) long j) {
            this.f30938a = j;
            return this;
        }

        public b c(@Nullable Object obj) {
            this.f4274a = obj;
            return this;
        }
    }

    public static final class c implements MediaPeriod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ga9 f30939a = new ga9(new da9(i.f30937a));

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f4275a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ArrayList<SampleStream> f4276a = new ArrayList<>();

        public c(long j) {
            this.f4275a = j;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long a(long j, w38 w38Var) {
            return b(j);
        }

        public final long b(long j) {
            return gj9.t(j, 0L, this.f4275a);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void c(MediaPeriod.Callback callback, long j) {
            callback.h(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j, boolean z) {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public ga9 e() {
            return f30939a;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            long jB = b(j);
            for (int i = 0; i < exoTrackSelectionArr.length; i++) {
                SampleStream sampleStream = sampleStreamArr[i];
                if (sampleStream != null && (exoTrackSelectionArr[i] == null || !zArr[i])) {
                    this.f4276a.remove(sampleStream);
                    sampleStreamArr[i] = null;
                }
                if (sampleStreamArr[i] == null && exoTrackSelectionArr[i] != null) {
                    d dVar = new d(this.f4275a);
                    dVar.a(jB);
                    this.f4276a.add(dVar);
                    sampleStreamArr[i] = dVar;
                    zArr2[i] = true;
                }
            }
            return jB;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            return -9223372036854775807L;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void reevaluateBuffer(long j) {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long j) {
            long jB = b(j);
            for (int i = 0; i < this.f4276a.size(); i++) {
                ((d) this.f4276a.get(i)).a(jB);
            }
            return jB;
        }
    }

    public static final class d implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30940a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4277a;
        public long b;

        public d(long j) {
            this.f30940a = i.U(j);
            a(0L);
        }

        public void a(long j) {
            this.b = gj9.t(i.U(j), 0L, this.f30940a);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int b(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (!this.f4277a || (i & 2) != 0) {
                yk3Var.f46052a = i.f30937a;
                this.f4277a = true;
                return -5;
            }
            long j = this.f30940a;
            long j2 = this.b;
            long j3 = j - j2;
            if (j3 == 0) {
                decoderInputBuffer.a(4);
                return -4;
            }
            decoderInputBuffer.f30576a = i.V(j2);
            decoderInputBuffer.a(1);
            int iMin = (int) Math.min(i.f4271a.length, j3);
            if ((i & 4) == 0) {
                decoderInputBuffer.k(iMin);
                decoderInputBuffer.f2588a.put(i.f4271a, 0, iMin);
            }
            if ((i & 1) == 0) {
                this.b += (long) iMin;
            }
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            long j2 = this.b;
            a(j);
            return (int) ((this.b - j2) / ((long) i.f4271a.length));
        }
    }

    static {
        com.google.android.exoplayer2.d dVarE = new com.google.android.exoplayer2.d.b().e0("audio/raw").H(2).f0(K).Y(2).E();
        f30937a = dVarE;
        b = new com.google.android.exoplayer2.g.c().D("SilenceMediaSource").L(Uri.EMPTY).F(dVarE.k).a();
        f4271a = new byte[gj9.p0(2, 2) * 1024];
    }

    public static long U(long j) {
        return ((long) gj9.p0(2, 2)) * ((j * 44100) / 1000000);
    }

    public static long V(long j) {
        return ((j / ((long) gj9.p0(2, 2))) * 1000000) / 44100;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        return new c(this.f4272a);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return this.f4273a;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        refreshSourceInfo(new li8(this.f4272a, true, false, false, (Object) null, this.f4273a));
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    public i(long j) {
        this(j, b);
    }

    public i(long j, com.google.android.exoplayer2.g gVar) {
        sb0.a(j >= 0);
        this.f4272a = j;
        this.f4273a = gVar;
    }
}
