package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.f;
import com.zj.adlib.ab3;
import com.zj.adlib.df2;
import com.zj.adlib.gj9;
import com.zj.adlib.ig2;
import com.zj.adlib.kg2;
import com.zj.adlib.li8;
import com.zj.adlib.qg3;
import com.zj.adlib.r04;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int L = 1;
    public static final int M = 3;
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f4037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g.C0682g f4038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g.h f4039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g f4040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CompositeSequenceableLoaderFactory f4041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsDataSourceFactory f4042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsExtractorFactory f4043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HlsPlaylistTracker f4044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransferListener f4046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4047a;
    public final boolean b;

    public static final class Factory implements MediaSourceFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30913a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f4048a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DrmSessionManagerProvider f4049a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CompositeSequenceableLoaderFactory f4050a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HlsDataSourceFactory f4051a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HlsExtractorFactory f4052a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HlsPlaylistParserFactory f4053a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HlsPlaylistTracker.Factory f4054a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LoadErrorHandlingPolicy f4055a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4056a;
        public boolean b;

        public Factory(DataSource.Factory factory) {
            this(new ig2(factory));
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource c(g gVar) {
            sb0.g(gVar.f3327a);
            HlsPlaylistParserFactory qg3Var = this.f4053a;
            List<StreamKey> list = gVar.f3327a.f3372a;
            if (!list.isEmpty()) {
                qg3Var = new qg3(qg3Var, list);
            }
            HlsDataSourceFactory hlsDataSourceFactory = this.f4051a;
            HlsExtractorFactory hlsExtractorFactory = this.f4052a;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.f4050a;
            DrmSessionManager drmSessionManagerA = this.f4049a.a(gVar);
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f4055a;
            return new HlsMediaSource(gVar, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, drmSessionManagerA, loadErrorHandlingPolicy, this.f4054a.a(this.f4051a, loadErrorHandlingPolicy, qg3Var), this.f4048a, this.f4056a, this.f30913a, this.b);
        }

        public Factory e(boolean z) {
            this.f4056a = z;
            return this;
        }

        public Factory f(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f4050a = (CompositeSequenceableLoaderFactory) sb0.h(compositeSequenceableLoaderFactory, "HlsMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Factory a(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f4049a = (DrmSessionManagerProvider) sb0.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        @VisibleForTesting
        public Factory h(long j) {
            this.f4048a = j;
            return this;
        }

        public Factory i(@Nullable HlsExtractorFactory hlsExtractorFactory) {
            if (hlsExtractorFactory == null) {
                hlsExtractorFactory = HlsExtractorFactory.f30911a;
            }
            this.f4052a = hlsExtractorFactory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f4055a = (LoadErrorHandlingPolicy) sb0.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory k(int i) {
            this.f30913a = i;
            return this;
        }

        public Factory l(HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            this.f4053a = (HlsPlaylistParserFactory) sb0.h(hlsPlaylistParserFactory, "HlsMediaSource.Factory#setPlaylistParserFactory no longer handles null by instantiating a new DefaultHlsPlaylistParserFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory m(HlsPlaylistTracker.Factory factory) {
            this.f4054a = (HlsPlaylistTracker.Factory) sb0.h(factory, "HlsMediaSource.Factory#setPlaylistTrackerFactory no longer handles null by defaulting to DefaultHlsPlaylistTracker.FACTORY. Explicitly pass a reference to this instance in order to retain the old behavior.");
            return this;
        }

        public Factory n(boolean z) {
            this.b = z;
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory) {
            this.f4051a = (HlsDataSourceFactory) sb0.g(hlsDataSourceFactory);
            this.f4049a = new com.google.android.exoplayer2.drm.a();
            this.f4053a = new kg2();
            this.f4054a = com.google.android.exoplayer2.source.hls.playlist.a.f30931a;
            this.f4052a = HlsExtractorFactory.f30911a;
            this.f4055a = new f();
            this.f4050a = new df2();
            this.f30913a = 1;
            this.f4048a = -9223372036854775807L;
            this.f4056a = true;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        ab3.a("goog.exo.hls");
    }

    @Nullable
    public static HlsMediaPlaylist.b R(List<HlsMediaPlaylist.b> list, long j) {
        HlsMediaPlaylist.b bVar = null;
        for (int i = 0; i < list.size(); i++) {
            HlsMediaPlaylist.b bVar2 = list.get(i);
            long j2 = ((HlsMediaPlaylist.e) bVar2).b;
            if (j2 > j || !bVar2.b) {
                if (j2 > j) {
                    break;
                }
            } else {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    public static HlsMediaPlaylist.d S(List<HlsMediaPlaylist.d> list, long j) {
        return list.get(gj9.h(list, Long.valueOf(j), true, true));
    }

    public static long V(HlsMediaPlaylist hlsMediaPlaylist, long j) {
        long j2;
        HlsMediaPlaylist.f fVar = hlsMediaPlaylist.f4166a;
        long j3 = hlsMediaPlaylist.f4164a;
        if (j3 != -9223372036854775807L) {
            j2 = hlsMediaPlaylist.f4178f - j3;
        } else {
            long j4 = fVar.c;
            if (j4 == -9223372036854775807L || hlsMediaPlaylist.f4176e == -9223372036854775807L) {
                long j5 = fVar.b;
                j2 = j5 != -9223372036854775807L ? j5 : hlsMediaPlaylist.f4174d * 3;
            } else {
                j2 = j4;
            }
        }
        return j2 + j;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        MediaSourceEventListener.a aVarCreateEventDispatcher = createEventDispatcher(aVar);
        return new c(this.f4043a, this.f4044a, this.f4042a, this.f4046a, this.f4037a, createDrmEventDispatcher(aVar), this.f4045a, aVarCreateEventDispatcher, allocator, this.f4041a, this.f4047a, this.K, this.b, getPlayerId());
    }

    public final li8 P(HlsMediaPlaylist hlsMediaPlaylist, long j, long j2, r04 r04Var) {
        long initialStartTimeUs = hlsMediaPlaylist.f4168b - this.f4044a.getInitialStartTimeUs();
        long j3 = hlsMediaPlaylist.f4177e ? initialStartTimeUs + hlsMediaPlaylist.f4178f : -9223372036854775807L;
        long jT = T(hlsMediaPlaylist);
        long j4 = this.f4038a.f3363a;
        W(hlsMediaPlaylist, gj9.t(j4 != -9223372036854775807L ? gj9.Z0(j4) : V(hlsMediaPlaylist, jT), jT, hlsMediaPlaylist.f4178f + jT));
        return new li8(j, j2, -9223372036854775807L, j3, hlsMediaPlaylist.f4178f, initialStartTimeUs, U(hlsMediaPlaylist, jT), true, !hlsMediaPlaylist.f4177e, hlsMediaPlaylist.f30923a == 2 && hlsMediaPlaylist.f4170b, r04Var, this.f4040a, this.f4038a);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    public final li8 Q(HlsMediaPlaylist hlsMediaPlaylist, long j, long j2, r04 r04Var) {
        long j3;
        if (hlsMediaPlaylist.f4164a == -9223372036854775807L || hlsMediaPlaylist.f4169b.isEmpty()) {
            j3 = 0;
        } else if (hlsMediaPlaylist.f4173c) {
            j3 = hlsMediaPlaylist.f4164a;
        } else {
            long j4 = hlsMediaPlaylist.f4164a;
            if (j4 == hlsMediaPlaylist.f4178f) {
                j3 = hlsMediaPlaylist.f4164a;
            } else {
                j3 = S(hlsMediaPlaylist.f4169b, j4).b;
            }
        }
        long j5 = hlsMediaPlaylist.f4178f;
        return new li8(j, j2, -9223372036854775807L, j5, j5, 0L, j3, true, false, true, r04Var, this.f4040a, null);
    }

    public final long T(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist.f4179f) {
            return gj9.Z0(gj9.m0(this.f30912a)) - hlsMediaPlaylist.d();
        }
        return 0L;
    }

    public final long U(HlsMediaPlaylist hlsMediaPlaylist, long j) {
        long jZ0 = hlsMediaPlaylist.f4164a;
        if (jZ0 == -9223372036854775807L) {
            jZ0 = (hlsMediaPlaylist.f4178f + j) - gj9.Z0(this.f4038a.f3363a);
        }
        if (hlsMediaPlaylist.f4173c) {
            return jZ0;
        }
        HlsMediaPlaylist.b bVarR = R(hlsMediaPlaylist.f4172c, jZ0);
        if (bVarR != null) {
            return ((HlsMediaPlaylist.e) bVarR).b;
        }
        if (hlsMediaPlaylist.f4169b.isEmpty()) {
            return 0L;
        }
        HlsMediaPlaylist.d dVarS = S(hlsMediaPlaylist.f4169b, jZ0);
        HlsMediaPlaylist.b bVarR2 = R(dVarS.f30925a, jZ0);
        return bVarR2 != null ? ((HlsMediaPlaylist.e) bVarR2).b : dVarS.b;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    public final void W(HlsMediaPlaylist hlsMediaPlaylist, long j) {
        boolean z;
        g.C0682g c0682g = this.f4040a.f3326a;
        if (c0682g.f3362a == -3.4028235E38f && c0682g.b == -3.4028235E38f) {
            HlsMediaPlaylist.f fVar = hlsMediaPlaylist.f4166a;
            if (fVar.b == -9223372036854775807L && fVar.c == -9223372036854775807L) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.f4038a = new g.C0682g.a().k(gj9.H1(j)).j(z ? 1.0f : this.f4038a.f3362a).h(z ? 1.0f : this.f4038a.b).f();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public g b() {
        return this.f4040a;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        ((c) mediaPeriod).p();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f4044a.maybeThrowPrimaryPlaylistRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f4046a = transferListener;
        this.f4037a.prepare();
        this.f4037a.c((Looper) sb0.g(Looper.myLooper()), getPlayerId());
        this.f4044a.e(this.f4039a.f30751a, createEventDispatcher(null), this);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.f4044a.stop();
        this.f4037a.release();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    public void z(HlsMediaPlaylist hlsMediaPlaylist) {
        long jH1 = hlsMediaPlaylist.f4179f ? gj9.H1(hlsMediaPlaylist.f4168b) : -9223372036854775807L;
        int i = hlsMediaPlaylist.f30923a;
        long j = (i == 2 || i == 1) ? jH1 : -9223372036854775807L;
        r04 r04Var = new r04((com.google.android.exoplayer2.source.hls.playlist.c) sb0.g(this.f4044a.d()), hlsMediaPlaylist);
        refreshSourceInfo(this.f4044a.isLive() ? P(hlsMediaPlaylist, j, jH1, r04Var) : Q(hlsMediaPlaylist, j, jH1, r04Var));
    }

    public HlsMediaSource(g gVar, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistTracker hlsPlaylistTracker, long j, boolean z, int i, boolean z2) {
        this.f4039a = (g.h) sb0.g(gVar.f3327a);
        this.f4040a = gVar;
        this.f4038a = gVar.f3326a;
        this.f4042a = hlsDataSourceFactory;
        this.f4043a = hlsExtractorFactory;
        this.f4041a = compositeSequenceableLoaderFactory;
        this.f4037a = drmSessionManager;
        this.f4045a = loadErrorHandlingPolicy;
        this.f4044a = hlsPlaylistTracker;
        this.f30912a = j;
        this.f4047a = z;
        this.K = i;
        this.b = z2;
    }
}
