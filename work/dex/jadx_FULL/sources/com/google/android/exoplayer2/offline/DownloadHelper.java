package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.common.collect.UnmodifiableIterator;
import com.zj.adlib.at6;
import com.zj.adlib.da9;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.sa9;
import com.zj.adlib.sb0;
import com.zj.adlib.wa9;
import com.zj.adlib.xy1;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DownloadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultTrackSelector.d f30785a = DefaultTrackSelector.d.f31031a.a().K(true).Y0(false).B();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseIntArray f3495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f3496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g.h f3497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Callback f3498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f3499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final MediaSource f3500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DefaultTrackSelector f3501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RendererCapabilities[] f3503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MappingTrackSelector.MappedTrackInfo[] f3504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ga9[] f3505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<ExoTrackSelection>[][] f3506a;
    public List<ExoTrackSelection>[][] b;

    public interface Callback {
        void a(DownloadHelper downloadHelper);

        void b(DownloadHelper downloadHelper, IOException iOException);
    }

    public static class LiveContentUnsupportedException extends IOException {
    }

    public class a implements VideoRendererEventListener {
    }

    public class b implements AudioRendererEventListener {
    }

    public static final class c extends BaseTrackSelection {

        public static final class a implements ExoTrackSelection.Factory {
            public a() {
            }

            @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection.Factory
            public ExoTrackSelection[] a(ExoTrackSelection.a[] aVarArr, BandwidthMeter bandwidthMeter, MediaSource.a aVar, Timeline timeline) {
                ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[aVarArr.length];
                for (int i = 0; i < aVarArr.length; i++) {
                    ExoTrackSelection.a aVar2 = aVarArr[i];
                    exoTrackSelectionArr[i] = aVar2 == null ? null : new c(aVar2.f4675a, aVar2.f4676a);
                }
                return exoTrackSelectionArr;
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public c(da9 da9Var, int[] iArr) {
            super(da9Var, iArr);
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void c(long j, long j2, long j3, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int getSelectedIndex() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        @Nullable
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int getSelectionReason() {
            return 0;
        }
    }

    public static final class d implements BandwidthMeter {
        public d() {
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        @Nullable
        public TransferListener b() {
            return null;
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public void c(Handler handler, BandwidthMeter.EventListener eventListener) {
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public void f(BandwidthMeter.EventListener eventListener) {
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public long getBitrateEstimate() {
            return 0L;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public static final class e implements MediaSource.MediaSourceCaller, MediaPeriod.Callback, Handler.Callback {
        public static final int K = 0;
        public static final int L = 1;
        public static final int M = 2;
        public static final int N = 3;
        public static final int O = 0;
        public static final int P = 1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HandlerThread f3507a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Timeline f3508a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DownloadHelper f3509a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MediaSource f3510a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f3513a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MediaPeriod[] f3514a;
        public final Handler b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Allocator f3511a = new com.google.android.exoplayer2.upstream.a(true, 65536);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ArrayList<MediaPeriod> f3512a = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f30786a = gj9.B(new Handler.Callback() { // from class: com.zj.adlib.iq2
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f42419a.b(message);
            }
        });

        public e(MediaSource mediaSource, DownloadHelper downloadHelper) {
            this.f3510a = mediaSource;
            this.f3509a = downloadHelper;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadHelper");
            this.f3507a = handlerThread;
            handlerThread.start();
            Handler handlerX = gj9.x(handlerThread.getLooper(), this);
            this.b = handlerX;
            handlerX.sendEmptyMessage(0);
        }

        public final boolean b(Message message) {
            if (this.f3513a) {
                return false;
            }
            int i = message.what;
            if (i == 0) {
                try {
                    this.f3509a.Z();
                } catch (ExoPlaybackException e) {
                    this.f30786a.obtainMessage(1, new IOException(e)).sendToTarget();
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            e();
            this.f3509a.Y((IOException) gj9.k(message.obj));
            return true;
        }

        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(MediaPeriod mediaPeriod) {
            if (this.f3512a.contains(mediaPeriod)) {
                this.b.obtainMessage(2, mediaPeriod).sendToTarget();
            }
        }

        public void e() {
            if (this.f3513a) {
                return;
            }
            this.f3513a = true;
            this.b.sendEmptyMessage(3);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void h(MediaPeriod mediaPeriod) {
            this.f3512a.remove(mediaPeriod);
            if (this.f3512a.isEmpty()) {
                this.b.removeMessages(1);
                this.f30786a.sendEmptyMessage(0);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f3510a.x(this, null, at6.f40608a);
                this.b.sendEmptyMessage(1);
                return true;
            }
            int i2 = 0;
            if (i == 1) {
                try {
                    if (this.f3514a == null) {
                        this.f3510a.maybeThrowSourceInfoRefreshError();
                    } else {
                        while (i2 < this.f3512a.size()) {
                            this.f3512a.get(i2).maybeThrowPrepareError();
                            i2++;
                        }
                    }
                    this.b.sendEmptyMessageDelayed(1, 100L);
                } catch (IOException e) {
                    this.f30786a.obtainMessage(1, e).sendToTarget();
                }
                return true;
            }
            if (i == 2) {
                MediaPeriod mediaPeriod = (MediaPeriod) message.obj;
                if (this.f3512a.contains(mediaPeriod)) {
                    mediaPeriod.continueLoading(0L);
                }
                return true;
            }
            if (i != 3) {
                return false;
            }
            MediaPeriod[] mediaPeriodArr = this.f3514a;
            if (mediaPeriodArr != null) {
                int length = mediaPeriodArr.length;
                while (i2 < length) {
                    this.f3510a.j(mediaPeriodArr[i2]);
                    i2++;
                }
            }
            this.f3510a.L(this);
            this.b.removeCallbacksAndMessages(null);
            this.f3507a.quit();
            return true;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
        public void r(MediaSource mediaSource, Timeline timeline) {
            MediaPeriod[] mediaPeriodArr;
            if (this.f3508a != null) {
                return;
            }
            if (timeline.t(0, new Timeline.d()).k()) {
                this.f30786a.obtainMessage(1, new LiveContentUnsupportedException()).sendToTarget();
                return;
            }
            this.f3508a = timeline;
            this.f3514a = new MediaPeriod[timeline.m()];
            int i = 0;
            while (true) {
                mediaPeriodArr = this.f3514a;
                if (i >= mediaPeriodArr.length) {
                    break;
                }
                MediaPeriod mediaPeriodF = this.f3510a.F(new MediaSource.a(timeline.s(i)), this.f3511a, 0L);
                this.f3514a[i] = mediaPeriodF;
                this.f3512a.add(mediaPeriodF);
                i++;
            }
            for (MediaPeriod mediaPeriod : mediaPeriodArr) {
                mediaPeriod.c(this, 0L);
            }
        }
    }

    public DownloadHelper(g gVar, @Nullable MediaSource mediaSource, com.google.android.exoplayer2.trackselection.c cVar, RendererCapabilities[] rendererCapabilitiesArr) {
        this.f3497a = (g.h) sb0.g(gVar.f3327a);
        this.f3500a = mediaSource;
        a aVar = null;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(cVar, new c.a(aVar));
        this.f3501a = defaultTrackSelector;
        this.f3503a = rendererCapabilitiesArr;
        this.f3495a = new SparseIntArray();
        defaultTrackSelector.b(new TrackSelector.InvalidationListener() { // from class: com.zj.adlib.yp2
            @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
            public final void onTrackSelectionsInvalidated() {
                DownloadHelper.U();
            }
        }, new d(aVar));
        this.f3494a = gj9.A();
        this.f3496a = new Timeline.d();
    }

    public static DownloadHelper A(g gVar, com.google.android.exoplayer2.trackselection.c cVar, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        boolean zQ = Q((g.h) sb0.g(gVar.f3327a));
        sb0.a(zQ || factory != null);
        return new DownloadHelper(gVar, zQ ? null : s(gVar, (DataSource.Factory) gj9.k(factory), drmSessionManager), cVar, renderersFactory != null ? M(renderersFactory) : new RendererCapabilities[0]);
    }

    @Deprecated
    public static DownloadHelper B(Context context, Uri uri) {
        return x(context, new g.c().L(uri).a());
    }

    @Deprecated
    public static DownloadHelper C(Context context, Uri uri, @Nullable String str) {
        return x(context, new g.c().L(uri).l(str).a());
    }

    @Deprecated
    public static DownloadHelper D(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return F(uri, factory, renderersFactory, null, G(context));
    }

    @Deprecated
    public static DownloadHelper E(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return F(uri, factory, renderersFactory, null, f30785a);
    }

    @Deprecated
    public static DownloadHelper F(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, com.google.android.exoplayer2.trackselection.c cVar) {
        return A(new g.c().L(uri).F("application/vnd.ms-sstr+xml").a(), cVar, renderersFactory, factory, drmSessionManager);
    }

    public static DefaultTrackSelector.d G(Context context) {
        return DefaultTrackSelector.d.k(context).a().K(true).Y0(false).B();
    }

    public static RendererCapabilities[] M(RenderersFactory renderersFactory) {
        Renderer[] rendererArrA = renderersFactory.a(gj9.A(), new a(), new b(), new TextOutput() { // from class: com.zj.adlib.aq2
            @Override // com.google.android.exoplayer2.text.TextOutput
            public final void j(xy1 xy1Var) {
                DownloadHelper.S(xy1Var);
            }
        }, new MetadataOutput() { // from class: com.zj.adlib.cq2
            @Override // com.google.android.exoplayer2.metadata.MetadataOutput
            public final void b(Metadata metadata) {
                DownloadHelper.T(metadata);
            }
        });
        RendererCapabilities[] rendererCapabilitiesArr = new RendererCapabilities[rendererArrA.length];
        for (int i = 0; i < rendererArrA.length; i++) {
            rendererCapabilitiesArr[i] = rendererArrA[i].a();
        }
        return rendererCapabilitiesArr;
    }

    public static boolean Q(g.h hVar) {
        return gj9.F0(hVar.f30751a, hVar.f3371a) == 4;
    }

    public static /* synthetic */ DrmSessionManager R(DrmSessionManager drmSessionManager, g gVar) {
        return drmSessionManager;
    }

    public static /* synthetic */ void S(xy1 xy1Var) {
    }

    public static /* synthetic */ void T(Metadata metadata) {
    }

    public static /* synthetic */ void U() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(IOException iOException) {
        ((Callback) sb0.g(this.f3498a)).b(this, iOException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        ((Callback) sb0.g(this.f3498a)).a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(Callback callback) {
        callback.a(this);
    }

    public static MediaSource q(DownloadRequest downloadRequest, DataSource.Factory factory) {
        return r(downloadRequest, factory, null);
    }

    public static MediaSource r(DownloadRequest downloadRequest, DataSource.Factory factory, @Nullable DrmSessionManager drmSessionManager) {
        return s(downloadRequest.toMediaItem(), factory, drmSessionManager);
    }

    public static MediaSource s(g gVar, DataSource.Factory factory, @Nullable final DrmSessionManager drmSessionManager) {
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(factory, ExtractorsFactory.f30622a);
        if (drmSessionManager != null) {
            defaultMediaSourceFactory.a(new DrmSessionManagerProvider() { // from class: com.zj.adlib.up2
                @Override // com.google.android.exoplayer2.drm.DrmSessionManagerProvider
                public final DrmSessionManager a(g gVar2) {
                    return DownloadHelper.R(drmSessionManager, gVar2);
                }
            });
        }
        return defaultMediaSourceFactory.c(gVar);
    }

    @Deprecated
    public static DownloadHelper t(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return u(uri, factory, renderersFactory, null, G(context));
    }

    @Deprecated
    public static DownloadHelper u(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, com.google.android.exoplayer2.trackselection.c cVar) {
        return A(new g.c().L(uri).F("application/dash+xml").a(), cVar, renderersFactory, factory, drmSessionManager);
    }

    @Deprecated
    public static DownloadHelper v(Context context, Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return w(uri, factory, renderersFactory, null, G(context));
    }

    @Deprecated
    public static DownloadHelper w(Uri uri, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager drmSessionManager, com.google.android.exoplayer2.trackselection.c cVar) {
        return A(new g.c().L(uri).F("application/x-mpegURL").a(), cVar, renderersFactory, factory, drmSessionManager);
    }

    public static DownloadHelper x(Context context, g gVar) {
        sb0.a(Q((g.h) sb0.g(gVar.f3327a)));
        return A(gVar, G(context), null, null, null);
    }

    public static DownloadHelper y(Context context, g gVar, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return A(gVar, G(context), renderersFactory, factory, null);
    }

    public static DownloadHelper z(g gVar, com.google.android.exoplayer2.trackselection.c cVar, @Nullable RenderersFactory renderersFactory, @Nullable DataSource.Factory factory) {
        return A(gVar, cVar, renderersFactory, factory, null);
    }

    public DownloadRequest H(String str, @Nullable byte[] bArr) {
        DownloadRequest.b bVarE = new DownloadRequest.b(str, this.f3497a.f30751a).e(this.f3497a.f3371a);
        g.f fVar = this.f3497a.f3368a;
        DownloadRequest.b bVarC = bVarE.d(fVar != null ? fVar.c() : null).b(this.f3497a.b).c(bArr);
        if (this.f3500a == null) {
            return bVarC.a();
        }
        o();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.f3506a.length;
        for (int i = 0; i < length; i++) {
            arrayList2.clear();
            int length2 = this.f3506a[i].length;
            for (int i2 = 0; i2 < length2; i2++) {
                arrayList2.addAll(this.f3506a[i][i2]);
            }
            arrayList.addAll(this.f3499a.f3514a[i].getStreamKeys(arrayList2));
        }
        return bVarC.f(arrayList).a();
    }

    public DownloadRequest I(@Nullable byte[] bArr) {
        return H(this.f3497a.f30751a.toString(), bArr);
    }

    @Nullable
    public Object J() {
        if (this.f3500a == null) {
            return null;
        }
        o();
        if (this.f3499a.f3508a.v() > 0) {
            return this.f3499a.f3508a.t(0, this.f3496a).f2205c;
        }
        return null;
    }

    public MappingTrackSelector.MappedTrackInfo K(int i) {
        o();
        return this.f3504a[i];
    }

    public int L() {
        if (this.f3500a == null) {
            return 0;
        }
        o();
        return this.f3505a.length;
    }

    public ga9 N(int i) {
        o();
        return this.f3505a[i];
    }

    public List<ExoTrackSelection> O(int i, int i2) {
        o();
        return this.b[i][i2];
    }

    public p P(int i) {
        o();
        return TrackSelectionUtil.b(this.f3504a[i], this.b[i]);
    }

    public final void Y(final IOException iOException) {
        ((Handler) sb0.g(this.f3494a)).post(new Runnable() { // from class: com.zj.adlib.wp2
            @Override // java.lang.Runnable
            public final void run() {
                this.f45653a.V(iOException);
            }
        });
    }

    public final void Z() throws ExoPlaybackException {
        sb0.g(this.f3499a);
        sb0.g(this.f3499a.f3514a);
        sb0.g(this.f3499a.f3508a);
        int length = this.f3499a.f3514a.length;
        int length2 = this.f3503a.length;
        this.f3506a = (List[][]) Array.newInstance((Class<?>) List.class, length, length2);
        this.b = (List[][]) Array.newInstance((Class<?>) List.class, length, length2);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length2; i2++) {
                this.f3506a[i][i2] = new ArrayList();
                this.b[i][i2] = Collections.unmodifiableList(this.f3506a[i][i2]);
            }
        }
        this.f3505a = new ga9[length];
        this.f3504a = new MappingTrackSelector.MappedTrackInfo[length];
        for (int i3 = 0; i3 < length; i3++) {
            this.f3505a[i3] = this.f3499a.f3514a[i3].e();
            this.f3501a.d(d0(i3).f20398a);
            this.f3504a[i3] = (MappingTrackSelector.MappedTrackInfo) sb0.g(this.f3501a.j());
        }
        e0();
        ((Handler) sb0.g(this.f3494a)).post(new Runnable() { // from class: com.zj.adlib.eq2
            @Override // java.lang.Runnable
            public final void run() {
                this.f41497a.W();
            }
        });
    }

    public void a0(final Callback callback) {
        sb0.i(this.f3498a == null);
        this.f3498a = callback;
        MediaSource mediaSource = this.f3500a;
        if (mediaSource != null) {
            this.f3499a = new e(mediaSource, this);
        } else {
            this.f3494a.post(new Runnable() { // from class: com.zj.adlib.gq2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16849a.X(callback);
                }
            });
        }
    }

    public void b0() {
        e eVar = this.f3499a;
        if (eVar != null) {
            eVar.e();
        }
        this.f3501a.e();
    }

    public void c0(int i, com.google.android.exoplayer2.trackselection.c cVar) {
        try {
            o();
            p(i);
            n(i, cVar);
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    public final wa9 d0(int i) throws ExoPlaybackException {
        boolean z;
        wa9 wa9VarF = this.f3501a.f(this.f3503a, this.f3505a[i], new MediaSource.a(this.f3499a.f3508a.s(i)), this.f3499a.f3508a);
        for (int i2 = 0; i2 < wa9VarF.f45559a; i2++) {
            ExoTrackSelection exoTrackSelection = wa9VarF.f20399a[i2];
            if (exoTrackSelection != null) {
                List<ExoTrackSelection> list = this.f3506a[i][i2];
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        z = false;
                        break;
                    }
                    ExoTrackSelection exoTrackSelection2 = list.get(i3);
                    if (exoTrackSelection2.d().equals(exoTrackSelection.d())) {
                        this.f3495a.clear();
                        for (int i4 = 0; i4 < exoTrackSelection2.length(); i4++) {
                            this.f3495a.put(exoTrackSelection2.getIndexInTrackGroup(i4), 0);
                        }
                        for (int i5 = 0; i5 < exoTrackSelection.length(); i5++) {
                            this.f3495a.put(exoTrackSelection.getIndexInTrackGroup(i5), 0);
                        }
                        int[] iArr = new int[this.f3495a.size()];
                        for (int i6 = 0; i6 < this.f3495a.size(); i6++) {
                            iArr[i6] = this.f3495a.keyAt(i6);
                        }
                        list.set(i3, new c(exoTrackSelection2.d(), iArr));
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (!z) {
                    list.add(exoTrackSelection);
                }
            }
        }
        return wa9VarF;
    }

    @RequiresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    public final void e0() {
        this.f3502a = true;
    }

    public void j(String... strArr) {
        try {
            o();
            DefaultTrackSelector.d.a aVarA = f30785a.a();
            aVarA.K(true);
            for (RendererCapabilities rendererCapabilities : this.f3503a) {
                int trackType = rendererCapabilities.getTrackType();
                aVarA.l0(trackType, trackType != 1);
            }
            int iL = L();
            for (String str : strArr) {
                com.google.android.exoplayer2.trackselection.c cVarB = aVarA.X(str).B();
                for (int i = 0; i < iL; i++) {
                    n(i, cVarB);
                }
            }
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void k(boolean z, String... strArr) {
        try {
            o();
            DefaultTrackSelector.d.a aVarA = f30785a.a();
            aVarA.k0(z);
            aVarA.K(true);
            for (RendererCapabilities rendererCapabilities : this.f3503a) {
                int trackType = rendererCapabilities.getTrackType();
                aVarA.l0(trackType, trackType != 3);
            }
            int iL = L();
            for (String str : strArr) {
                com.google.android.exoplayer2.trackselection.c cVarB = aVarA.c0(str).B();
                for (int i = 0; i < iL; i++) {
                    n(i, cVarB);
                }
            }
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void l(int i, com.google.android.exoplayer2.trackselection.c cVar) {
        try {
            o();
            n(i, cVar);
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void m(int i, int i2, DefaultTrackSelector.d dVar, List<DefaultTrackSelector.f> list) {
        try {
            o();
            DefaultTrackSelector.d.a aVarA = dVar.a();
            int i3 = 0;
            while (i3 < this.f3504a[i].d()) {
                aVarA.D1(i3, i3 != i2);
                i3++;
            }
            if (list.isEmpty()) {
                n(i, aVarA.B());
                return;
            }
            ga9 ga9VarH = this.f3504a[i].h(i2);
            for (int i4 = 0; i4 < list.size(); i4++) {
                aVarA.F1(i2, ga9VarH, list.get(i4));
                n(i, aVarA.B());
            }
        } catch (ExoPlaybackException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    public final void n(int i, com.google.android.exoplayer2.trackselection.c cVar) throws ExoPlaybackException {
        this.f3501a.h(cVar);
        d0(i);
        UnmodifiableIterator<sa9> it = cVar.f4699a.values().iterator();
        while (it.hasNext()) {
            this.f3501a.h(cVar.a().W(it.next()).B());
            d0(i);
        }
    }

    @EnsuresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    public final void o() {
        sb0.i(this.f3502a);
    }

    public void p(int i) {
        o();
        for (int i2 = 0; i2 < this.f3503a.length; i2++) {
            this.f3506a[i][i2].clear();
        }
    }
}
