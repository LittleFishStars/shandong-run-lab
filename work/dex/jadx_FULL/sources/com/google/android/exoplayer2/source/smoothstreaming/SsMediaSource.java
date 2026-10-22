package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
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
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.f;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.ab3;
import com.zj.adlib.az4;
import com.zj.adlib.df2;
import com.zj.adlib.gj9;
import com.zj.adlib.li8;
import com.zj.adlib.oh5;
import com.zj.adlib.rg3;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {
    public static final int K = 5000;
    public static final long c = 30000;
    public static final long d = 5000000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Uri f4437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f4438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionManager f4439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g.h f4440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g f4441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CompositeSequenceableLoaderFactory f4442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SsChunkSource.Factory f4443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f4444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource.Factory f4445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataSource f4446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f4447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Loader f4448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LoaderErrorThrower f4449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f4450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TransferListener f4451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4452a;
    public long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final MediaSourceEventListener.a f4453b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<b> f4454b;

    public static final class Factory implements MediaSourceFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30987a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DrmSessionManagerProvider f4455a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CompositeSequenceableLoaderFactory f4456a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SsChunkSource.Factory f4457a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final DataSource.Factory f4458a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LoadErrorHandlingPolicy f4459a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f4460a;

        public Factory(DataSource.Factory factory) {
            this(new com.google.android.exoplayer2.source.smoothstreaming.a.C0692a(factory), factory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public SsMediaSource c(g gVar) {
            sb0.g(gVar.f3327a);
            ParsingLoadable.Parser ssManifestParser = this.f4460a;
            if (ssManifestParser == null) {
                ssManifestParser = new SsManifestParser();
            }
            List<StreamKey> list = gVar.f3327a.f3372a;
            return new SsMediaSource(gVar, null, this.f4458a, !list.isEmpty() ? new rg3(ssManifestParser, list) : ssManifestParser, this.f4457a, this.f4456a, this.f4455a.a(gVar), this.f4459a, this.f30987a);
        }

        public SsMediaSource e(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
            return f(aVar, g.d(Uri.EMPTY));
        }

        public SsMediaSource f(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, g gVar) {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVarCopy = aVar;
            sb0.a(!aVarCopy.f4502a);
            g.h hVar = gVar.f3327a;
            List<StreamKey> listOf = hVar != null ? hVar.f3372a : ImmutableList.of();
            if (!listOf.isEmpty()) {
                aVarCopy = aVarCopy.copy(listOf);
            }
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar2 = aVarCopy;
            g gVarA = gVar.b().F("application/vnd.ms-sstr+xml").L(gVar.f3327a != null ? gVar.f3327a.f30751a : Uri.EMPTY).a();
            return new SsMediaSource(gVarA, aVar2, null, null, this.f4457a, this.f4456a, this.f4455a.a(gVarA), this.f4459a, this.f30987a);
        }

        public Factory g(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f4456a = (CompositeSequenceableLoaderFactory) sb0.h(compositeSequenceableLoaderFactory, "SsMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public int[] getSupportedTypes() {
            return new int[]{1};
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory a(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f4455a = (DrmSessionManagerProvider) sb0.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory i(long j) {
            this.f30987a = j;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f4459a = (LoadErrorHandlingPolicy) sb0.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory k(@Nullable ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> parser) {
            this.f4460a = parser;
            return this;
        }

        public Factory(SsChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.f4457a = (SsChunkSource.Factory) sb0.g(factory);
            this.f4458a = factory2;
            this.f4455a = new com.google.android.exoplayer2.drm.a();
            this.f4459a = new f();
            this.f30987a = 30000L;
            this.f4456a = new df2();
        }
    }

    static {
        ab3.a("goog.exo.smoothstreaming");
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod F(MediaSource.a aVar, Allocator allocator, long j) {
        MediaSourceEventListener.a aVarCreateEventDispatcher = createEventDispatcher(aVar);
        b bVar = new b(this.f4444a, this.f4443a, this.f4451a, this.f4442a, this.f4439a, createDrmEventDispatcher(aVar), this.f4447a, aVarCreateEventDispatcher, this.f4449a, allocator);
        this.f4454b.add(bVar);
        return bVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void M(ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> parsingLoadable, long j, long j2, boolean z) {
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        this.f4447a.onLoadTaskConcluded(parsingLoadable.f5062a);
        this.f4453b.q(az4Var, parsingLoadable.f31120a);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void K(ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> parsingLoadable, long j, long j2) {
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        this.f4447a.onLoadTaskConcluded(parsingLoadable.f5062a);
        this.f4453b.t(az4Var, parsingLoadable.f31120a);
        this.f4444a = parsingLoadable.c();
        this.b = j - j2;
        T();
        U();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public Loader.b A(ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> parsingLoadable, long j, long j2, IOException iOException, int i) {
        az4 az4Var = new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, parsingLoadable.d(), parsingLoadable.b(), j, j2, parsingLoadable.a());
        long jB = this.f4447a.b(new LoadErrorHandlingPolicy.c(az4Var, new oh5(parsingLoadable.f31120a), iOException, i));
        Loader.b bVarG = jB == -9223372036854775807L ? Loader.f5051d : Loader.g(false, jB);
        boolean z = !bVarG.c();
        this.f4453b.x(az4Var, parsingLoadable.f31120a, iOException, z);
        if (z) {
            this.f4447a.onLoadTaskConcluded(parsingLoadable.f5062a);
        }
        return bVarG;
    }

    public final void T() {
        li8 li8Var;
        for (int i = 0; i < this.f4454b.size(); i++) {
            this.f4454b.get(i).l(this.f4444a);
        }
        long jMax = Long.MIN_VALUE;
        long jMax2 = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar : this.f4444a.f4503a) {
            if (bVar.f4517f > 0) {
                jMax2 = Math.min(jMax2, bVar.e(0));
                jMax = Math.max(jMax, bVar.e(bVar.f4517f - 1) + bVar.c(bVar.f4517f - 1));
            }
        }
        if (jMax2 == Long.MAX_VALUE) {
            long j = this.f4444a.f4502a ? -9223372036854775807L : 0L;
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f4444a;
            boolean z = aVar.f4502a;
            li8Var = new li8(j, 0L, 0L, 0L, true, z, z, (Object) aVar, this.f4441a);
        } else {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar2 = this.f4444a;
            if (aVar2.f4502a) {
                long j2 = aVar2.f4504b;
                if (j2 != -9223372036854775807L && j2 > 0) {
                    jMax2 = Math.max(jMax2, jMax - j2);
                }
                long j3 = jMax2;
                long j4 = jMax - j3;
                long jZ0 = j4 - gj9.Z0(this.f30986a);
                if (jZ0 < 5000000) {
                    jZ0 = Math.min(5000000L, j4 / 2);
                }
                li8Var = new li8(-9223372036854775807L, j4, j3, jZ0, true, true, true, (Object) this.f4444a, this.f4441a);
            } else {
                long j5 = aVar2.f4500a;
                long j6 = j5 != -9223372036854775807L ? j5 : jMax - jMax2;
                li8Var = new li8(jMax2 + j6, j6, jMax2, 0L, true, false, false, (Object) this.f4444a, this.f4441a);
            }
        }
        refreshSourceInfo(li8Var);
    }

    public final void U() {
        if (this.f4444a.f4502a) {
            this.f4438a.postDelayed(new Runnable() { // from class: com.zj.adlib.ap8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40578a.V();
                }
            }, Math.max(0L, (this.b + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    public final void V() {
        if (this.f4448a.h()) {
            return;
        }
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f4446a, this.f4437a, 4, this.f4450a);
        this.f4453b.z(new az4(parsingLoadable.f5062a, parsingLoadable.f5063a, this.f4448a.l(parsingLoadable, this, this.f4447a.getMinimumLoadableRetryCount(parsingLoadable.f31120a))), parsingLoadable.f31120a);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public g b() {
        return this.f4441a;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void j(MediaPeriod mediaPeriod) {
        ((b) mediaPeriod).k();
        this.f4454b.remove(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.f4449a.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@Nullable TransferListener transferListener) {
        this.f4451a = transferListener;
        this.f4439a.prepare();
        this.f4439a.c(Looper.myLooper(), getPlayerId());
        if (this.f4452a) {
            this.f4449a = new LoaderErrorThrower.a();
            T();
            return;
        }
        this.f4446a = this.f4445a.a();
        Loader loader = new Loader("SsMediaSource");
        this.f4448a = loader;
        this.f4449a = loader;
        this.f4438a = gj9.y();
        V();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.f4444a = this.f4452a ? this.f4444a : null;
        this.f4446a = null;
        this.b = 0L;
        Loader loader = this.f4448a;
        if (loader != null) {
            loader.j();
            this.f4448a = null;
        }
        Handler handler = this.f4438a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4438a = null;
        }
        this.f4439a.release();
    }

    public SsMediaSource(g gVar, @Nullable com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, @Nullable DataSource.Factory factory, @Nullable ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> parser, SsChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        sb0.i(aVar == null || !aVar.f4502a);
        this.f4441a = gVar;
        g.h hVar = (g.h) sb0.g(gVar.f3327a);
        this.f4440a = hVar;
        this.f4444a = aVar;
        this.f4437a = hVar.f30751a.equals(Uri.EMPTY) ? null : gj9.G(hVar.f30751a);
        this.f4445a = factory;
        this.f4450a = parser;
        this.f4443a = factory2;
        this.f4442a = compositeSequenceableLoaderFactory;
        this.f4439a = drmSessionManager;
        this.f4447a = loadErrorHandlingPolicy;
        this.f30986a = j;
        this.f4453b = createEventDispatcher(null);
        this.f4452a = aVar != null;
        this.f4454b = new ArrayList<>();
    }
}
