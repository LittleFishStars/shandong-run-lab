package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.text.SubtitleDecoderFactory;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.zj.adlib.bv8;
import com.zj.adlib.gj9;
import com.zj.adlib.iv6;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DefaultMediaSourceFactory implements MediaSourceFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30816a = "DMediaSourceFactory";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f3649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f3651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AdsLoader.Provider f3652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AdViewProvider f3653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataSource.Factory f3654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public LoadErrorHandlingPolicy f3655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3656a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3657b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public MediaSource.Factory f3658b;
    public long c;

    @Deprecated
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public DrmSessionManagerProvider f30817a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ExtractorsFactory f3659a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public DataSource.Factory f3660a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public LoadErrorHandlingPolicy f3661a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<Integer, Supplier<MediaSource.Factory>> f3662a = new HashMap();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Set<Integer> f3663a = new HashSet();
        public final Map<Integer, MediaSource.Factory> b = new HashMap();

        public a(ExtractorsFactory extractorsFactory) {
            this.f3659a = extractorsFactory;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ MediaSource.Factory m(DataSource.Factory factory) {
            return new g.b(factory, this.f3659a);
        }

        public final void f() {
            n(0);
            n(1);
            n(2);
            n(3);
            n(4);
        }

        @Nullable
        public MediaSource.Factory g(int i) {
            MediaSource.Factory factory = this.b.get(Integer.valueOf(i));
            if (factory != null) {
                return factory;
            }
            Supplier<MediaSource.Factory> supplierN = n(i);
            if (supplierN == null) {
                return null;
            }
            MediaSource.Factory factory2 = supplierN.get();
            DrmSessionManagerProvider drmSessionManagerProvider = this.f30817a;
            if (drmSessionManagerProvider != null) {
                factory2.a(drmSessionManagerProvider);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f3661a;
            if (loadErrorHandlingPolicy != null) {
                factory2.b(loadErrorHandlingPolicy);
            }
            this.b.put(Integer.valueOf(i), factory2);
            return factory2;
        }

        public int[] h() {
            f();
            return Ints.B(this.f3663a);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0075  */
        @Nullable
        public final Supplier<MediaSource.Factory> n(int i) {
            Supplier<MediaSource.Factory> supplier;
            Supplier<MediaSource.Factory> supplier2;
            if (this.f3662a.containsKey(Integer.valueOf(i))) {
                return this.f3662a.get(Integer.valueOf(i));
            }
            final DataSource.Factory factory = (DataSource.Factory) sb0.g(this.f3660a);
            Supplier<MediaSource.Factory> supplier3 = null;
            try {
                if (i == 0) {
                    final Class clsAsSubclass = DashMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                    supplier = new Supplier() { // from class: com.zj.adlib.ah2
                        @Override // com.google.common.base.Supplier
                        public final Object get() {
                            return DefaultMediaSourceFactory.f(clsAsSubclass, factory);
                        }
                    };
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                final Class clsAsSubclass2 = RtspMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                                supplier2 = new Supplier() { // from class: com.zj.adlib.dh2
                                    @Override // com.google.common.base.Supplier
                                    public final Object get() {
                                        return DefaultMediaSourceFactory.e(clsAsSubclass2);
                                    }
                                };
                            } else if (i == 4) {
                                supplier2 = new Supplier() { // from class: com.zj.adlib.eh2
                                    @Override // com.google.common.base.Supplier
                                    public final Object get() {
                                        return this.f41436a.m(factory);
                                    }
                                };
                            }
                            supplier3 = supplier2;
                        } else {
                            final Class clsAsSubclass3 = HlsMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                            supplier = new Supplier() { // from class: com.zj.adlib.ch2
                                @Override // com.google.common.base.Supplier
                                public final Object get() {
                                    return DefaultMediaSourceFactory.f(clsAsSubclass3, factory);
                                }
                            };
                        }
                        this.f3662a.put(Integer.valueOf(i), supplier3);
                        if (supplier3 != null) {
                            this.f3663a.add(Integer.valueOf(i));
                        }
                        return supplier3;
                    }
                    final Class clsAsSubclass4 = SsMediaSource.Factory.class.asSubclass(MediaSource.Factory.class);
                    supplier = new Supplier() { // from class: com.zj.adlib.bh2
                        @Override // com.google.common.base.Supplier
                        public final Object get() {
                            return DefaultMediaSourceFactory.f(clsAsSubclass4, factory);
                        }
                    };
                }
                supplier3 = supplier;
            } catch (ClassNotFoundException unused) {
            }
            this.f3662a.put(Integer.valueOf(i), supplier3);
            if (supplier3 != null) {
                this.f3663a.add(Integer.valueOf(i));
            }
            return supplier3;
        }

        public void o(DataSource.Factory factory) {
            if (factory != this.f3660a) {
                this.f3660a = factory;
                this.f3662a.clear();
                this.b.clear();
            }
        }

        public void p(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f30817a = drmSessionManagerProvider;
            Iterator<MediaSource.Factory> it = this.b.values().iterator();
            while (it.hasNext()) {
                it.next().a(drmSessionManagerProvider);
            }
        }

        public void q(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f3661a = loadErrorHandlingPolicy;
            Iterator<MediaSource.Factory> it = this.b.values().iterator();
            while (it.hasNext()) {
                it.next().b(loadErrorHandlingPolicy);
            }
        }
    }

    public static final class b implements Extractor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.d f30818a;

        public b(com.google.android.exoplayer2.d dVar) {
            this.f30818a = dVar;
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public void b(ExtractorOutput extractorOutput) {
            TrackOutput trackOutputB = extractorOutput.b(0, 3);
            extractorOutput.d(new SeekMap.b(-9223372036854775807L));
            extractorOutput.endTracks();
            trackOutputB.f(this.f30818a.b().e0("text/x-unknown").I(this.f30818a.k).E());
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
            return extractorInput.skip(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public boolean d(ExtractorInput extractorInput) {
            return true;
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public void release() {
        }

        @Override // com.google.android.exoplayer2.extractor.Extractor
        public void seek(long j, long j2) {
        }
    }

    public DefaultMediaSourceFactory(Context context) {
        this(new com.google.android.exoplayer2.upstream.c.a(context));
    }

    public static /* synthetic */ MediaSource.Factory e(Class cls) {
        return l(cls);
    }

    public static /* synthetic */ MediaSource.Factory f(Class cls, DataSource.Factory factory) {
        return m(cls, factory);
    }

    public static /* synthetic */ Extractor[] i(com.google.android.exoplayer2.d dVar) {
        Extractor[] extractorArr = new Extractor[1];
        SubtitleDecoderFactory subtitleDecoderFactory = SubtitleDecoderFactory.f31005a;
        extractorArr[0] = subtitleDecoderFactory.a(dVar) ? new bv8(subtitleDecoderFactory.b(dVar), dVar) : new b(dVar);
        return extractorArr;
    }

    public static MediaSource j(com.google.android.exoplayer2.g gVar, MediaSource mediaSource) {
        com.google.android.exoplayer2.g.d dVar = gVar.f3324a;
        long j = dVar.f3343a;
        if (j == 0 && dVar.b == Long.MIN_VALUE && !dVar.f3345b) {
            return mediaSource;
        }
        long jZ0 = gj9.Z0(j);
        long jZ1 = gj9.Z0(gVar.f3324a.b);
        com.google.android.exoplayer2.g.d dVar2 = gVar.f3324a;
        return new ClippingMediaSource(mediaSource, jZ0, jZ1, !dVar2.c, dVar2.f3344a, dVar2.f3345b);
    }

    public static MediaSource.Factory l(Class<? extends MediaSource.Factory> cls) {
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static MediaSource.Factory m(Class<? extends MediaSource.Factory> cls, DataSource.Factory factory) {
        try {
            return cls.getConstructor(DataSource.Factory.class).newInstance(factory);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public MediaSource c(com.google.android.exoplayer2.g gVar) {
        sb0.g(gVar.f3327a);
        String scheme = gVar.f3327a.f30751a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            return ((MediaSource.Factory) sb0.g(this.f3658b)).c(gVar);
        }
        com.google.android.exoplayer2.g.h hVar = gVar.f3327a;
        int iF0 = gj9.F0(hVar.f30751a, hVar.f3371a);
        MediaSource.Factory factoryG = this.f3651a.g(iF0);
        sb0.l(factoryG, "No suitable media source factory found for content type: " + iF0);
        com.google.android.exoplayer2.g.C0682g.a aVarB = gVar.f3326a.b();
        if (gVar.f3326a.f3363a == -9223372036854775807L) {
            aVarB.k(this.f3650a);
        }
        if (gVar.f3326a.f3362a == -3.4028235E38f) {
            aVarB.j(this.f3649a);
        }
        if (gVar.f3326a.b == -3.4028235E38f) {
            aVarB.h(this.b);
        }
        if (gVar.f3326a.f3364b == -9223372036854775807L) {
            aVarB.i(this.f3657b);
        }
        if (gVar.f3326a.c == -9223372036854775807L) {
            aVarB.g(this.c);
        }
        com.google.android.exoplayer2.g.C0682g c0682gF = aVarB.f();
        if (!c0682gF.equals(gVar.f3326a)) {
            gVar = gVar.b().x(c0682gF).a();
        }
        MediaSource mediaSourceC = factoryG.c(gVar);
        ImmutableList<com.google.android.exoplayer2.g.l> immutableList = ((com.google.android.exoplayer2.g.h) gj9.k(gVar.f3327a)).f3369a;
        if (!immutableList.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[immutableList.size() + 1];
            mediaSourceArr[0] = mediaSourceC;
            for (int i = 0; i < immutableList.size(); i++) {
                if (this.f3656a) {
                    final com.google.android.exoplayer2.d dVarE = new com.google.android.exoplayer2.d.b().e0(immutableList.get(i).f3380a).V(immutableList.get(i).f3381b).g0(immutableList.get(i).f30754a).c0(immutableList.get(i).b).U(immutableList.get(i).c).S(immutableList.get(i).d).E();
                    g.b bVar = new g.b(this.f3654a, new ExtractorsFactory() { // from class: com.zj.adlib.zg2
                        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
                        public final Extractor[] d() {
                            return DefaultMediaSourceFactory.i(dVarE);
                        }
                    });
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f3655a;
                    if (loadErrorHandlingPolicy != null) {
                        bVar.b(loadErrorHandlingPolicy);
                    }
                    mediaSourceArr[i + 1] = bVar.c(com.google.android.exoplayer2.g.e(immutableList.get(i).f3379a.toString()));
                } else {
                    k.b bVar2 = new k.b(this.f3654a);
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.f3655a;
                    if (loadErrorHandlingPolicy2 != null) {
                        bVar2.b(loadErrorHandlingPolicy2);
                    }
                    mediaSourceArr[i + 1] = bVar2.a(immutableList.get(i), -9223372036854775807L);
                }
            }
            mediaSourceC = new MergingMediaSource(mediaSourceArr);
        }
        return k(gVar, j(gVar, mediaSourceC));
    }

    public DefaultMediaSourceFactory g() {
        this.f3652a = null;
        this.f3653a = null;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    public int[] getSupportedTypes() {
        return this.f3651a.h();
    }

    public DefaultMediaSourceFactory h(boolean z) {
        this.f3656a = z;
        return this;
    }

    public final MediaSource k(com.google.android.exoplayer2.g gVar, MediaSource mediaSource) {
        sb0.g(gVar.f3327a);
        com.google.android.exoplayer2.g.b bVar = gVar.f3327a.f3367a;
        if (bVar == null) {
            return mediaSource;
        }
        AdsLoader.Provider provider = this.f3652a;
        AdViewProvider adViewProvider = this.f3653a;
        if (provider == null || adViewProvider == null) {
            Log.n(f30816a, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoaderA = provider.a(bVar);
        if (adsLoaderA == null) {
            Log.n(f30816a, "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        DataSpec dataSpec = new DataSpec(bVar.f30741a);
        Object obj = bVar.f3330a;
        return new AdsMediaSource(mediaSource, dataSpec, obj != null ? obj : ImmutableList.of((Uri) gVar.f, gVar.f3327a.f30751a, bVar.f30741a), this, adsLoaderA, adViewProvider);
    }

    @Deprecated
    public DefaultMediaSourceFactory n(@Nullable AdViewProvider adViewProvider) {
        this.f3653a = adViewProvider;
        return this;
    }

    @Deprecated
    public DefaultMediaSourceFactory o(@Nullable AdsLoader.Provider provider) {
        this.f3652a = provider;
        return this;
    }

    public DefaultMediaSourceFactory p(DataSource.Factory factory) {
        this.f3654a = factory;
        this.f3651a.o(factory);
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory a(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.f3651a.p((DrmSessionManagerProvider) sb0.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    public DefaultMediaSourceFactory r(long j) {
        this.c = j;
        return this;
    }

    public DefaultMediaSourceFactory s(float f) {
        this.b = f;
        return this;
    }

    public DefaultMediaSourceFactory t(long j) {
        this.f3657b = j;
        return this;
    }

    public DefaultMediaSourceFactory u(float f) {
        this.f3649a = f;
        return this;
    }

    public DefaultMediaSourceFactory v(long j) {
        this.f3650a = j;
        return this;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Factory
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public DefaultMediaSourceFactory b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.f3655a = (LoadErrorHandlingPolicy) sb0.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f3651a.q(loadErrorHandlingPolicy);
        return this;
    }

    public DefaultMediaSourceFactory x(AdsLoader.Provider provider, AdViewProvider adViewProvider) {
        this.f3652a = (AdsLoader.Provider) sb0.g(provider);
        this.f3653a = (AdViewProvider) sb0.g(adViewProvider);
        return this;
    }

    public DefaultMediaSourceFactory y(@Nullable MediaSource.Factory factory) {
        this.f3658b = factory;
        return this;
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this(new com.google.android.exoplayer2.upstream.c.a(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.f3654a = factory;
        a aVar = new a(extractorsFactory);
        this.f3651a = aVar;
        aVar.o(factory);
        this.f3650a = -9223372036854775807L;
        this.f3657b = -9223372036854775807L;
        this.c = -9223372036854775807L;
        this.f3649a = -3.4028235E38f;
        this.b = -3.4028235E38f;
    }
}
