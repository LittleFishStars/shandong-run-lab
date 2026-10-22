package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public PrepareListener f3667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaPeriod.Callback f3668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaPeriod f3669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource.a f3670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaSource f3671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Allocator f3672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3673a;
    public long b = -9223372036854775807L;

    public interface PrepareListener {
        void a(MediaSource.a aVar);

        void b(MediaSource.a aVar, IOException iOException);
    }

    public MaskingMediaPeriod(MediaSource.a aVar, Allocator allocator, long j) {
        this.f3670a = aVar;
        this.f3672a = allocator;
        this.f30820a = j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long a(long j, w38 w38Var) {
        return ((MediaPeriod) gj9.k(this.f3669a)).a(j, w38Var);
    }

    public void b(MediaSource.a aVar) {
        long j = j(this.f30820a);
        MediaPeriod mediaPeriodF = ((MediaSource) sb0.g(this.f3671a)).F(aVar, this.f3672a, j);
        this.f3669a = mediaPeriodF;
        if (this.f3668a != null) {
            mediaPeriodF.c(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void c(MediaPeriod.Callback callback, long j) {
        this.f3668a = callback;
        MediaPeriod mediaPeriod = this.f3669a;
        if (mediaPeriod != null) {
            mediaPeriod.c(this, j(this.f30820a));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        MediaPeriod mediaPeriod = this.f3669a;
        return mediaPeriod != null && mediaPeriod.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        ((MediaPeriod) gj9.k(this.f3669a)).discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public ga9 e() {
        return ((MediaPeriod) gj9.k(this.f3669a)).e();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long f(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.b;
        if (j3 == -9223372036854775807L || j != this.f30820a) {
            j2 = j;
        } else {
            this.b = -9223372036854775807L;
            j2 = j3;
        }
        return ((MediaPeriod) gj9.k(this.f3669a)).f(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    public long g() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return ((MediaPeriod) gj9.k(this.f3669a)).getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return ((MediaPeriod) gj9.k(this.f3669a)).getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void h(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) gj9.k(this.f3668a)).h(this);
        PrepareListener prepareListener = this.f3667a;
        if (prepareListener != null) {
            prepareListener.a(this.f3670a);
        }
    }

    public long i() {
        return this.f30820a;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        MediaPeriod mediaPeriod = this.f3669a;
        return mediaPeriod != null && mediaPeriod.isLoading();
    }

    public final long j(long j) {
        long j2 = this.b;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void d(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) gj9.k(this.f3668a)).d(this);
    }

    public void l(long j) {
        this.b = j;
    }

    public void m() {
        if (this.f3669a != null) {
            ((MediaSource) sb0.g(this.f3671a)).j(this.f3669a);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.f3669a;
            if (mediaPeriod != null) {
                mediaPeriod.maybeThrowPrepareError();
            } else {
                MediaSource mediaSource = this.f3671a;
                if (mediaSource != null) {
                    mediaSource.maybeThrowSourceInfoRefreshError();
                }
            }
        } catch (IOException e) {
            PrepareListener prepareListener = this.f3667a;
            if (prepareListener == null) {
                throw e;
            }
            if (this.f3673a) {
                return;
            }
            this.f3673a = true;
            prepareListener.b(this.f3670a, e);
        }
    }

    public void n(MediaSource mediaSource) {
        sb0.i(this.f3671a == null);
        this.f3671a = mediaSource;
    }

    public void o(PrepareListener prepareListener) {
        this.f3667a = prepareListener;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return ((MediaPeriod) gj9.k(this.f3669a)).readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        ((MediaPeriod) gj9.k(this.f3669a)).reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        return ((MediaPeriod) gj9.k(this.f3669a)).seekToUs(j);
    }
}
