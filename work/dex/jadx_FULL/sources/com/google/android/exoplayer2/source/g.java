package com.google.android.exoplayer2.source;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.zj.adlib.at6;
import com.zj.adlib.d51;
import com.zj.adlib.li8;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {
    public static final int L = 1048576;
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f4016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.g.h f4017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.g f4018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProgressiveMediaExtractor.Factory f4019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource.Factory f4020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransferListener f4022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4023a;
    public boolean b;
    public boolean c;

    public class a extends ForwardingTimeline {
        public a(g gVar, Timeline timeline) {
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

    public static final class b implements MediaSourceFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30907a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DrmSessionManagerProvider f4024a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ProgressiveMediaExtractor.Factory f4025a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataSource.Factory f4026a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LoadErrorHandlingPolicy f4027a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Object f4028a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f4029a;

        public b(DataSource.Factory factory) {
            this(factory, new DefaultExtractorsFactory());
        }

        public static /* synthetic */ ProgressiveMediaExtractor f(ExtractorsFactory extractorsFactory, at6 at6Var) {
            return new d51(extractorsFactory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public g c(com.google.android.exoplayer2.g gVar) {
            sb0.g(gVar.f3327a);
            com.google.android.exoplayer2.g.h hVar = gVar.f3327a;
            boolean z = hVar.f3370a == null && this.f4028a != null;
            boolean z2 = hVar.b == null && this.f4029a != null;
            if (z && z2) {
                gVar = gVar.b().K(this.f4028a).l(this.f4029a).a();
            } else if (z) {
                gVar = gVar.b().K(this.f4028a).a();
            } else if (z2) {
                gVar = gVar.b().l(this.f4029a).a();
            }
            com.google.android.exoplayer2.g gVar2 = gVar;
            return new g(gVar2, this.f4026a, this.f4025a, this.f4024a.a(gVar2), this.f4027a, this.f30907a, null);
        }

        public b g(int i) {
            this.f30907a = i;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{4};
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b a(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f4024a = (DrmSessionManagerProvider) sb0.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f4027a = (LoadErrorHandlingPolicy) sb0.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public b(DataSource.Factory factory, final ExtractorsFactory extractorsFactory) {
            this(factory, new ProgressiveMediaExtractor.Factory() { // from class: com.zj.adlib.r17
                @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor.Factory
                public final ProgressiveMediaExtractor a(at6 at6Var) {
                    return g.b.f(extractorsFactory, at6Var);
                }
            });
        }

        public b(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new com.google.android.exoplayer2.drm.a(), new com.google.android.exoplayer2.upstream.f(), 1048576);
        }

        public b(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManagerProvider drmSessionManagerProvider, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i) {
            this.f4026a = factory;
            this.f4025a = factory2;
            this.f4024a = drmSessionManagerProvider;
            this.f4027a = loadErrorHandlingPolicy;
            this.f30907a = i;
        }
    }

    public /* synthetic */ g(com.google.android.exoplayer2.g gVar, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i, a aVar) {
        this(gVar, factory, factory2, drmSessionManager, loadErrorHandlingPolicy, i);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        DataSource dataSourceA = this.f4020a.a();
        TransferListener transferListener = this.f4022a;
        if (transferListener != null) {
            dataSourceA.b(transferListener);
        }
        return new ProgressiveMediaPeriod(this.f4017a.f30751a, dataSourceA, this.f4019a.a(getPlayerId()), this.f4016a, createDrmEventDispatcher(aVar), this.f4021a, createEventDispatcher(aVar), this, allocator, this.f4017a.b, this.K);
    }

    public final void P() {
        Timeline li8Var = new li8(this.f30906a, this.b, false, this.c, (Object) null, this.f4018a);
        if (this.f4023a) {
            li8Var = new a(this, li8Var);
        }
        refreshSourceInfo(li8Var);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.g b() {
        return this.f4018a;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).U();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener
    public void onSourceInfoRefreshed(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.f30906a;
        }
        if (!this.f4023a && this.f30906a == j && this.b == z && this.c == z2) {
            return;
        }
        this.f30906a = j;
        this.b = z;
        this.c = z2;
        this.f4023a = false;
        P();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f4022a = transferListener;
        this.f4016a.prepare();
        this.f4016a.c((Looper) sb0.g(Looper.myLooper()), getPlayerId());
        P();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.f4016a.release();
    }

    public g(com.google.android.exoplayer2.g gVar, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i) {
        this.f4017a = (com.google.android.exoplayer2.g.h) sb0.g(gVar.f3327a);
        this.f4018a = gVar;
        this.f4020a = factory;
        this.f4019a = factory2;
        this.f4016a = drmSessionManager;
        this.f4021a = loadErrorHandlingPolicy;
        this.K = i;
        this.f4023a = true;
        this.f30906a = -9223372036854775807L;
    }
}
