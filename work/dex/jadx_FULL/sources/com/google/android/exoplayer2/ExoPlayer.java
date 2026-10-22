package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.a;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.hp9;
import com.zj.adlib.na9;
import com.zj.adlib.p82;
import com.zj.adlib.pi0;
import com.zj.adlib.sb0;
import com.zj.adlib.w38;
import com.zj.adlib.xy1;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ExoPlayer extends Player {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f30481a = 500;
    public static final long b = 2000;

    @Deprecated
    public interface AudioComponent {
        @Deprecated
        void clearAuxEffectInfo();

        @Deprecated
        com.google.android.exoplayer2.audio.a d();

        @Deprecated
        void e(pi0 pi0Var);

        @Deprecated
        int getAudioSessionId();

        @Deprecated
        boolean getSkipSilenceEnabled();

        @Deprecated
        float getVolume();

        @Deprecated
        void h(com.google.android.exoplayer2.audio.a aVar, boolean z);

        @Deprecated
        void setAudioSessionId(int i);

        @Deprecated
        void setSkipSilenceEnabled(boolean z);

        @Deprecated
        void setVolume(float f);
    }

    public interface AudioOffloadListener {
        default void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
        }

        default void onExperimentalSleepingForOffloadChanged(boolean z) {
        }
    }

    @Deprecated
    public interface DeviceComponent {
        @Deprecated
        void decreaseDeviceVolume();

        @Deprecated
        DeviceInfo g();

        @Deprecated
        int getDeviceVolume();

        @Deprecated
        void increaseDeviceVolume();

        @Deprecated
        boolean isDeviceMuted();

        @Deprecated
        void setDeviceMuted(boolean z);

        @Deprecated
        void setDeviceVolume(int i);
    }

    @Deprecated
    public interface TextComponent {
        @Deprecated
        xy1 m();
    }

    @Deprecated
    public interface VideoComponent {
        @Deprecated
        void a(CameraMotionListener cameraMotionListener);

        @Deprecated
        void clearVideoSurface();

        @Deprecated
        void clearVideoSurface(@Nullable Surface surface);

        @Deprecated
        void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void clearVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void clearVideoTextureView(@Nullable TextureView textureView);

        @Deprecated
        int getVideoChangeFrameRateStrategy();

        @Deprecated
        int getVideoScalingMode();

        @Deprecated
        void i(CameraMotionListener cameraMotionListener);

        @Deprecated
        hp9 j();

        @Deprecated
        void k(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void l(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void setVideoChangeFrameRateStrategy(int i);

        @Deprecated
        void setVideoScalingMode(int i);

        @Deprecated
        void setVideoSurface(@Nullable Surface surface);

        @Deprecated
        void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void setVideoSurfaceView(@Nullable SurfaceView surfaceView);

        @Deprecated
        void setVideoTextureView(@Nullable TextureView textureView);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30482a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2035a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Context f2036a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Looper f2037a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LivePlaybackSpeedControl f2038a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public com.google.android.exoplayer2.audio.a f2039a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Clock f2040a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public PriorityTaskManager f2041a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Function<Clock, AnalyticsCollector> f2042a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Supplier<RenderersFactory> f2043a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public w38 f2044a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2045a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f2046b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Supplier<MediaSource.Factory> f2047b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f2048b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public long f2049c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public Supplier<TrackSelector> f2050c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f2051c;
        public long d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public Supplier<LoadControl> f2052d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f2053d;
        public long e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public Supplier<BandwidthMeter> f2054e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public boolean f2055e;
        public boolean f;
        public boolean g;

        public a(final Context context) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: com.zj.adlib.h93
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.z(context);
                }
            }, (Supplier<MediaSource.Factory>) new Supplier() { // from class: com.zj.adlib.p73
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.A(context);
                }
            });
        }

        public static /* synthetic */ MediaSource.Factory A(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        public static /* synthetic */ TrackSelector B(TrackSelector trackSelector) {
            return trackSelector;
        }

        public static /* synthetic */ LoadControl C(LoadControl loadControl) {
            return loadControl;
        }

        public static /* synthetic */ BandwidthMeter D(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        public static /* synthetic */ AnalyticsCollector E(AnalyticsCollector analyticsCollector, Clock clock) {
            return analyticsCollector;
        }

        public static /* synthetic */ TrackSelector F(Context context) {
            return new DefaultTrackSelector(context);
        }

        public static /* synthetic */ RenderersFactory H(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public static /* synthetic */ MediaSource.Factory I(Context context) {
            return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
        }

        public static /* synthetic */ RenderersFactory J(Context context) {
            return new DefaultRenderersFactory(context);
        }

        public static /* synthetic */ MediaSource.Factory K(MediaSource.Factory factory) {
            return factory;
        }

        public static /* synthetic */ RenderersFactory L(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public static /* synthetic */ MediaSource.Factory M(MediaSource.Factory factory) {
            return factory;
        }

        public static /* synthetic */ RenderersFactory N(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public static /* synthetic */ MediaSource.Factory O(MediaSource.Factory factory) {
            return factory;
        }

        public static /* synthetic */ AnalyticsCollector P(AnalyticsCollector analyticsCollector, Clock clock) {
            return analyticsCollector;
        }

        public static /* synthetic */ BandwidthMeter Q(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        public static /* synthetic */ LoadControl R(LoadControl loadControl) {
            return loadControl;
        }

        public static /* synthetic */ MediaSource.Factory S(MediaSource.Factory factory) {
            return factory;
        }

        public static /* synthetic */ RenderersFactory T(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        public static /* synthetic */ TrackSelector U(TrackSelector trackSelector) {
            return trackSelector;
        }

        public static /* synthetic */ RenderersFactory z(Context context) {
            return new DefaultRenderersFactory(context);
        }

        public a V(final AnalyticsCollector analyticsCollector) {
            sb0.i(!this.g);
            this.f2042a = new Function() { // from class: com.zj.adlib.j83
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return ExoPlayer.a.P(analyticsCollector, (Clock) obj);
                }
            };
            return this;
        }

        public a W(com.google.android.exoplayer2.audio.a aVar, boolean z) {
            sb0.i(!this.g);
            this.f2039a = aVar;
            this.f2045a = z;
            return this;
        }

        public a X(final BandwidthMeter bandwidthMeter) {
            sb0.i(!this.g);
            this.f2054e = new Supplier() { // from class: com.zj.adlib.t83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.Q(bandwidthMeter);
                }
            };
            return this;
        }

        @VisibleForTesting
        public a Y(Clock clock) {
            sb0.i(!this.g);
            this.f2040a = clock;
            return this;
        }

        public a Z(long j) {
            sb0.i(!this.g);
            this.e = j;
            return this;
        }

        public a a0(boolean z) {
            sb0.i(!this.g);
            this.f2048b = z;
            return this;
        }

        public a b0(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            sb0.i(!this.g);
            this.f2038a = livePlaybackSpeedControl;
            return this;
        }

        public a c0(final LoadControl loadControl) {
            sb0.i(!this.g);
            this.f2052d = new Supplier() { // from class: com.zj.adlib.x83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.R(loadControl);
                }
            };
            return this;
        }

        public a d0(Looper looper) {
            sb0.i(!this.g);
            this.f2037a = looper;
            return this;
        }

        public a e0(final MediaSource.Factory factory) {
            sb0.i(!this.g);
            this.f2047b = new Supplier() { // from class: com.zj.adlib.v83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.S(factory);
                }
            };
            return this;
        }

        public a f0(boolean z) {
            sb0.i(!this.g);
            this.f2055e = z;
            return this;
        }

        public a g0(@Nullable PriorityTaskManager priorityTaskManager) {
            sb0.i(!this.g);
            this.f2041a = priorityTaskManager;
            return this;
        }

        public a h0(long j) {
            sb0.i(!this.g);
            this.d = j;
            return this;
        }

        public a i0(final RenderersFactory renderersFactory) {
            sb0.i(!this.g);
            this.f2043a = new Supplier() { // from class: com.zj.adlib.s73
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.T(renderersFactory);
                }
            };
            return this;
        }

        public a j0(@IntRange(from = 1) long j) {
            sb0.a(j > 0);
            sb0.i(!this.g);
            this.f2046b = j;
            return this;
        }

        public a k0(@IntRange(from = 1) long j) {
            sb0.a(j > 0);
            sb0.i(!this.g);
            this.f2049c = j;
            return this;
        }

        public a l0(w38 w38Var) {
            sb0.i(!this.g);
            this.f2044a = w38Var;
            return this;
        }

        public a m0(boolean z) {
            sb0.i(!this.g);
            this.f2051c = z;
            return this;
        }

        public a n0(final TrackSelector trackSelector) {
            sb0.i(!this.g);
            this.f2050c = new Supplier() { // from class: com.zj.adlib.n73
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.U(trackSelector);
                }
            };
            return this;
        }

        public a o0(boolean z) {
            sb0.i(!this.g);
            this.f2053d = z;
            return this;
        }

        public a p0(boolean z) {
            sb0.i(!this.g);
            this.f = z;
            return this;
        }

        public a q0(int i) {
            sb0.i(!this.g);
            this.c = i;
            return this;
        }

        public a r0(int i) {
            sb0.i(!this.g);
            this.b = i;
            return this;
        }

        public a s0(int i) {
            sb0.i(!this.g);
            this.f30482a = i;
            return this;
        }

        public ExoPlayer w() {
            sb0.i(!this.g);
            this.g = true;
            return new b(this, null);
        }

        public l x() {
            sb0.i(!this.g);
            this.g = true;
            return new l(this);
        }

        public a y(long j) {
            sb0.i(!this.g);
            this.f2035a = j;
            return this;
        }

        public a(final Context context, final RenderersFactory renderersFactory) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: com.zj.adlib.c83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.H(renderersFactory);
                }
            }, (Supplier<MediaSource.Factory>) new Supplier() { // from class: com.zj.adlib.e83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.I(context);
                }
            });
        }

        public a(final Context context, final MediaSource.Factory factory) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: com.zj.adlib.u73
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.J(context);
                }
            }, (Supplier<MediaSource.Factory>) new Supplier() { // from class: com.zj.adlib.w73
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.K(factory);
                }
            });
        }

        public a(Context context, final RenderersFactory renderersFactory, final MediaSource.Factory factory) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: com.zj.adlib.y73
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.L(renderersFactory);
                }
            }, (Supplier<MediaSource.Factory>) new Supplier() { // from class: com.zj.adlib.a83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.M(factory);
                }
            });
        }

        public a(Context context, final RenderersFactory renderersFactory, final MediaSource.Factory factory, final TrackSelector trackSelector, final LoadControl loadControl, final BandwidthMeter bandwidthMeter, final AnalyticsCollector analyticsCollector) {
            this(context, (Supplier<RenderersFactory>) new Supplier() { // from class: com.zj.adlib.g83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.N(renderersFactory);
                }
            }, (Supplier<MediaSource.Factory>) new Supplier() { // from class: com.zj.adlib.i83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.O(factory);
                }
            }, (Supplier<TrackSelector>) new Supplier() { // from class: com.zj.adlib.l83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.B(trackSelector);
                }
            }, (Supplier<LoadControl>) new Supplier() { // from class: com.zj.adlib.n83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.C(loadControl);
                }
            }, (Supplier<BandwidthMeter>) new Supplier() { // from class: com.zj.adlib.p83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.D(bandwidthMeter);
                }
            }, (Function<Clock, AnalyticsCollector>) new Function() { // from class: com.zj.adlib.r83
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return ExoPlayer.a.E(analyticsCollector, (Clock) obj);
                }
            });
        }

        public a(final Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2) {
            this(context, supplier, supplier2, (Supplier<TrackSelector>) new Supplier() { // from class: com.zj.adlib.z83
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return ExoPlayer.a.F(context);
                }
            }, (Supplier<LoadControl>) new Supplier() { // from class: com.zj.adlib.b93
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return new tg2();
                }
            }, (Supplier<BandwidthMeter>) new Supplier() { // from class: com.zj.adlib.d93
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return b.l(context);
                }
            }, (Function<Clock, AnalyticsCollector>) new Function() { // from class: com.zj.adlib.f93
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return new a((Clock) obj);
                }
            });
        }

        public a(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2, Supplier<TrackSelector> supplier3, Supplier<LoadControl> supplier4, Supplier<BandwidthMeter> supplier5, Function<Clock, AnalyticsCollector> function) {
            this.f2036a = context;
            this.f2043a = supplier;
            this.f2047b = supplier2;
            this.f2050c = supplier3;
            this.f2052d = supplier4;
            this.f2054e = supplier5;
            this.f2042a = function;
            this.f2037a = gj9.Y();
            this.f2039a = com.google.android.exoplayer2.audio.a.f2470a;
            this.f30482a = 0;
            this.b = 1;
            this.c = 0;
            this.f2053d = true;
            this.f2044a = w38.e;
            this.f2046b = 5000L;
            this.f2049c = 15000L;
            this.f2038a = new com.google.android.exoplayer2.a.b().a();
            this.f2040a = Clock.f31152a;
            this.d = 500L;
            this.e = 2000L;
            this.f = true;
        }
    }

    @Nullable
    @Deprecated
    TextComponent A();

    Renderer B(int i);

    void C(AudioOffloadListener audioOffloadListener);

    void D(MediaSource mediaSource);

    @Nullable
    d F();

    void G(MediaSource mediaSource, long j);

    void H(@Nullable w38 w38Var);

    @Nullable
    TrackSelector I();

    @Deprecated
    void J(MediaSource mediaSource, boolean z, boolean z2);

    @Nullable
    d M();

    void N(@Nullable PriorityTaskManager priorityTaskManager);

    Clock O();

    AnalyticsCollector P();

    void R(ShuffleOrder shuffleOrder);

    void S(int i, MediaSource mediaSource);

    void T(AnalyticsListener analyticsListener);

    @Deprecated
    na9 W();

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    /* JADX INFO: renamed from: Y */
    ExoPlaybackException f();

    void a(CameraMotionListener cameraMotionListener);

    void addMediaSources(int i, List<MediaSource> list);

    void addMediaSources(List<MediaSource> list);

    @Deprecated
    void c0(MediaSource mediaSource);

    void clearAuxEffectInfo();

    void d0(AnalyticsListener analyticsListener);

    void e(pi0 pi0Var);

    @Nullable
    @Deprecated
    DeviceComponent e0();

    boolean experimentalIsSleepingForOffload();

    void experimentalSetOffloadSchedulingEnabled(boolean z);

    int getAudioSessionId();

    boolean getPauseAtEndOfMediaItems();

    Looper getPlaybackLooper();

    int getRendererCount();

    int getRendererType(int i);

    boolean getSkipSilenceEnabled();

    int getVideoChangeFrameRateStrategy();

    int getVideoScalingMode();

    void h(com.google.android.exoplayer2.audio.a aVar, boolean z);

    void i(CameraMotionListener cameraMotionListener);

    PlayerMessage i0(PlayerMessage.Target target);

    void k(VideoFrameMetadataListener videoFrameMetadataListener);

    void l(VideoFrameMetadataListener videoFrameMetadataListener);

    void n(AudioOffloadListener audioOffloadListener);

    @Deprecated
    ga9 o();

    @Nullable
    p82 p();

    void q(MediaSource mediaSource);

    @Nullable
    p82 r();

    @Deprecated
    void retry();

    void setAudioSessionId(int i);

    void setForegroundMode(boolean z);

    void setHandleAudioBecomingNoisy(boolean z);

    @Deprecated
    void setHandleWakeLock(boolean z);

    void setMediaSources(List<MediaSource> list);

    void setMediaSources(List<MediaSource> list, int i, long j);

    void setMediaSources(List<MediaSource> list, boolean z);

    void setPauseAtEndOfMediaItems(boolean z);

    void setSkipSilenceEnabled(boolean z);

    void setVideoChangeFrameRateStrategy(int i);

    void setVideoScalingMode(int i);

    void setWakeMode(int i);

    w38 t();

    @Nullable
    @Deprecated
    AudioComponent w();

    @Nullable
    @Deprecated
    VideoComponent x();

    void y(MediaSource mediaSource, boolean z);
}
