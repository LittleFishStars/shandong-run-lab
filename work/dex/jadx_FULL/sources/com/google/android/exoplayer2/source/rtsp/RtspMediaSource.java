package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.ab3;
import com.zj.adlib.al7;
import com.zj.adlib.gj9;
import com.zj.adlib.li8;
import com.zj.adlib.sb0;
import java.io.IOException;
import javax.net.SocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RtspMediaSource extends BaseMediaSource {
    public static final long b = 8000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f4366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.g f4367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RtpDataChannel.Factory f4368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SocketFactory f4369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4370a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4371b;
    public boolean c;
    public final String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30959a = -9223372036854775807L;
    public boolean d = true;

    public static final class Factory implements MediaSourceFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30960a = 8000;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f4372a = "ExoPlayerLib/2.18.0";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public SocketFactory f4373a = SocketFactory.getDefault();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4374a;
        public boolean b;

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public RtspMediaSource c(com.google.android.exoplayer2.g gVar) {
            sb0.g(gVar.f3327a);
            return new RtspMediaSource(gVar, this.f4374a ? new l(this.f30960a) : new n(this.f30960a), this.f4372a, this.f4373a, this.b);
        }

        public Factory e(boolean z) {
            this.b = z;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory a(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        public Factory g(boolean z) {
            this.f4374a = z;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        public Factory i(SocketFactory socketFactory) {
            this.f4373a = socketFactory;
            return this;
        }

        public Factory j(@IntRange(from = 1) long j) {
            sb0.a(j > 0);
            this.f30960a = j;
            return this;
        }

        public Factory k(String str) {
            this.f4372a = str;
            return this;
        }
    }

    public static final class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(Throwable th) {
            super(th);
        }

        public RtspPlaybackException(String str, Throwable th) {
            super(str, th);
        }
    }

    public class a implements RtspMediaPeriod.Listener {
        public a() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod.Listener
        public void a() {
            RtspMediaSource.this.f4371b = false;
            RtspMediaSource.this.U();
        }

        @Override // com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod.Listener
        public void b(al7 al7Var) {
            RtspMediaSource.this.f30959a = gj9.Z0(al7Var.a());
            RtspMediaSource.this.f4371b = !al7Var.c();
            RtspMediaSource.this.c = al7Var.c();
            RtspMediaSource.this.d = false;
            RtspMediaSource.this.U();
        }
    }

    public class b extends ForwardingTimeline {
        public b(RtspMediaSource rtspMediaSource, Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.b k(int i, Timeline.b bVar, boolean z) {
            super.k(i, bVar, z);
            bVar.f2193a = true;
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.d u(int i, Timeline.d dVar, long j) {
            super.u(i, dVar, j);
            dVar.f2208d = true;
            return dVar;
        }
    }

    static {
        ab3.a("goog.exo.rtsp");
    }

    @VisibleForTesting
    public RtspMediaSource(com.google.android.exoplayer2.g gVar, RtpDataChannel.Factory factory, String str, SocketFactory socketFactory, boolean z) {
        this.f4367a = gVar;
        this.f4368a = factory;
        this.f = str;
        this.f4366a = ((com.google.android.exoplayer2.g.h) sb0.g(gVar.f3327a)).f30751a;
        this.f4369a = socketFactory;
        this.f4370a = z;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        return new RtspMediaPeriod(allocator, this.f4368a, this.f4366a, new a(), this.f, this.f4369a, this.f4370a);
    }

    public final void U() {
        Timeline li8Var = new li8(this.f30959a, this.f4371b, false, this.c, (Object) null, this.f4367a);
        if (this.d) {
            li8Var = new b(this, li8Var);
        }
        refreshSourceInfo(li8Var);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return this.f4367a;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        ((RtspMediaPeriod) mediaPeriod).O();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        U();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }
}
