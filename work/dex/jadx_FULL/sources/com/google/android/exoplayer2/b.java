package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.ab3;
import com.zj.adlib.at6;
import com.zj.adlib.ga9;
import com.zj.adlib.gj9;
import com.zj.adlib.gk5;
import com.zj.adlib.hp9;
import com.zj.adlib.kw9;
import com.zj.adlib.mt9;
import com.zj.adlib.na9;
import com.zj.adlib.p82;
import com.zj.adlib.pi0;
import com.zj.adlib.ps1;
import com.zj.adlib.rs6;
import com.zj.adlib.sb0;
import com.zj.adlib.ue7;
import com.zj.adlib.w38;
import com.zj.adlib.wa9;
import com.zj.adlib.xy1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30570a = "ExoPlayerImpl";
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f2504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AudioTrack f2506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Looper f2507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Surface f2508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public SurfaceHolder f2509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TextureView f2510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioBecomingNoisyManager f2511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioFocusManager f2512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DeviceInfo f2513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExoPlayerImplInternal.PlaybackInfoUpdateListener f2514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExoPlayerImplInternal f2515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaMetadata f2516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Player.b f2517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Player f2518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StreamVolumeManager f2519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f2520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AnalyticsCollector f2521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.audio.a f2522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f2523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f2524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f2525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource.Factory f2526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ShuffleOrder f2527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackSelector f2528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BandwidthMeter f2529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f2530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HandlerWrapper f2531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ListenerSet<Player.Listener> f2532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public PriorityTaskManager f2533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public VideoFrameMetadataListener f2534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public CameraMotionListener f2535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public SphericalGLSurfaceView f2536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hp9 f2537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kw9 f2538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mt9 f2539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public p82 f2540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ps1 f2541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public rs6 f2542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public w38 f2543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wa9 f2544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xy1 f2545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Object f2546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<e> f2547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CopyOnWriteArraySet<ExoPlayer.AudioOffloadListener> f2548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Renderer[] f2550a;
    public MediaMetadata b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Player.b f2551b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f2552b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public p82 f2553b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2554b;
    public final long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public MediaMetadata f2555c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2556c;
    public final long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2557d;
    public final long e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2558e;
    public long f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2559f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.b$b, reason: collision with other inner class name */
    @RequiresApi(31)
    public static final class C0676b {
        @DoNotInline
        public static at6 a(Context context, b bVar, boolean z) {
            com.google.android.exoplayer2.analytics.c cVarH0 = com.google.android.exoplayer2.analytics.c.H0(context);
            if (cVarH0 == null) {
                Log.n(b.f30570a, "MediaMetricsService unavailable.");
                return new at6(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z) {
                bVar.d0(cVarH0);
            }
            return new at6(cVarH0.O0());
        }
    }

    public final class c implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, ExoPlayer.AudioOffloadListener {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(Player.Listener listener) {
            listener.x(b.this.f2516a);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void a(com.google.android.exoplayer2.d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            b.this.f2525a = dVar;
            b.this.f2521a.a(dVar, decoderReuseEvaluation);
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void b(final Metadata metadata) {
            b bVar = b.this;
            bVar.f2555c = bVar.f2555c.b().I(metadata).F();
            MediaMetadata mediaMetadataQ1 = b.this.q1();
            if (!mediaMetadataQ1.equals(b.this.f2516a)) {
                b.this.f2516a = mediaMetadataQ1;
                b.this.f2532a.j(14, new ListenerSet.Event() { // from class: com.zj.adlib.na3
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        this.f43480a.u((Player.Listener) obj);
                    }
                });
            }
            b.this.f2532a.j(28, new ListenerSet.Event() { // from class: com.zj.adlib.oa3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).b(metadata);
                }
            });
            b.this.f2532a.g();
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void c(p82 p82Var) {
            b.this.f2540a = p82Var;
            b.this.f2521a.c(p82Var);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void d(com.google.android.exoplayer2.d dVar, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            b.this.f2552b = dVar;
            b.this.f2521a.d(dVar, decoderReuseEvaluation);
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void executePlayerCommand(int i) {
            boolean playWhenReady = b.this.getPlayWhenReady();
            b.this.y2(playWhenReady, i, b.z1(playWhenReady, i));
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void f(p82 p82Var) {
            b.this.f2521a.f(p82Var);
            b.this.f2552b = null;
            b.this.f2553b = null;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void h(p82 p82Var) {
            b.this.f2521a.h(p82Var);
            b.this.f2525a = null;
            b.this.f2540a = null;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void i(p82 p82Var) {
            b.this.f2553b = p82Var;
            b.this.f2521a.i(p82Var);
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void j(final xy1 xy1Var) {
            b.this.f2545a = xy1Var;
            b.this.f2532a.m(27, new ListenerSet.Event() { // from class: com.zj.adlib.ta3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).j(xy1Var);
                }
            });
        }

        @Override // com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener
        public void onAudioBecomingNoisy() {
            b.this.y2(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioCodecError(Exception exc) {
            b.this.f2521a.onAudioCodecError(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j, long j2) {
            b.this.f2521a.onAudioDecoderInitialized(str, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderReleased(String str) {
            b.this.f2521a.onAudioDecoderReleased(str);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioPositionAdvancing(long j) {
            b.this.f2521a.onAudioPositionAdvancing(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkError(Exception exc) {
            b.this.f2521a.onAudioSinkError(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioUnderrun(int i, long j, long j2) {
            b.this.f2521a.onAudioUnderrun(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(final List<Cue> list) {
            b.this.f2532a.m(27, new ListenerSet.Event() { // from class: com.zj.adlib.pa3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onCues(list);
                }
            });
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
            b.this.f2521a.onDroppedFrames(i, j);
        }

        @Override // com.google.android.exoplayer2.ExoPlayer.AudioOffloadListener
        public void onExperimentalSleepingForOffloadChanged(boolean z) {
            b.this.B2();
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Object obj, long j) {
            b.this.f2521a.onRenderedFirstFrame(obj, j);
            if (b.this.f2546a == obj) {
                b.this.f2532a.m(26, new ListenerSet.Event() { // from class: com.zj.adlib.ua3
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj2) {
                        ((Player.Listener) obj2).onRenderedFirstFrame();
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onSkipSilenceEnabledChanged(final boolean z) {
            if (b.this.g == z) {
                return;
            }
            b.this.g = z;
            b.this.f2532a.m(23, new ListenerSet.Event() { // from class: com.zj.adlib.ra3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onSkipSilenceEnabledChanged(z);
                }
            });
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamTypeChanged(int i) {
            final DeviceInfo deviceInfoR1 = b.r1(b.this.f2519a);
            if (deviceInfoR1.equals(b.this.f2513a)) {
                return;
            }
            b.this.f2513a = deviceInfoR1;
            b.this.f2532a.m(29, new ListenerSet.Event() { // from class: com.zj.adlib.qa3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).A(deviceInfoR1);
                }
            });
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamVolumeChanged(final int i, final boolean z) {
            b.this.f2532a.m(30, new ListenerSet.Event() { // from class: com.zj.adlib.sa3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onDeviceVolumeChanged(i, z);
                }
            });
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.t2(surfaceTexture);
            b.this.k2(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            b.this.v2(null);
            b.this.k2(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.k2(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoCodecError(Exception exc) {
            b.this.f2521a.onVideoCodecError(exc);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j, long j2) {
            b.this.f2521a.onVideoDecoderInitialized(str, j, j2);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderReleased(String str) {
            b.this.f2521a.onVideoDecoderReleased(str);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoFrameProcessingOffset(long j, int i) {
            b.this.f2521a.onVideoFrameProcessingOffset(j, i);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(final hp9 hp9Var) {
            b.this.f2537a = hp9Var;
            b.this.f2532a.m(25, new ListenerSet.Event() { // from class: com.zj.adlib.wa3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onVideoSizeChanged(hp9Var);
                }
            });
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
        public void onVideoSurfaceCreated(Surface surface) {
            b.this.v2(surface);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
        public void onVideoSurfaceDestroyed(Surface surface) {
            b.this.v2(null);
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void setVolumeMultiplier(float f) {
            b.this.q2();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            b.this.k2(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (b.this.f2559f) {
                b.this.v2(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (b.this.f2559f) {
                b.this.v2(null);
            }
            b.this.k2(0, 0);
        }
    }

    public static final class d implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {
        public static final int K = 7;
        public static final int L = 8;
        public static final int M = 10000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public VideoFrameMetadataListener f30572a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public CameraMotionListener f2560a;

        @Nullable
        public VideoFrameMetadataListener b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public CameraMotionListener f2561b;

        public d() {
        }

        @Override // com.google.android.exoplayer2.video.VideoFrameMetadataListener
        public void b(long j, long j2, com.google.android.exoplayer2.d dVar, @Nullable MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.b;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.b(j, j2, dVar, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.f30572a;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.b(j, j2, dVar, mediaFormat);
            }
        }

        @Override // com.google.android.exoplayer2.PlayerMessage.Target
        public void handleMessage(int i, @Nullable Object obj) {
            if (i == 7) {
                this.f30572a = (VideoFrameMetadataListener) obj;
                return;
            }
            if (i == 8) {
                this.f2560a = (CameraMotionListener) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.b = null;
                this.f2561b = null;
            } else {
                this.b = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f2561b = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }

        @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
        public void onCameraMotion(long j, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.f2561b;
            if (cameraMotionListener != null) {
                cameraMotionListener.onCameraMotion(j, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.f2560a;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotion(j, fArr);
            }
        }

        @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
        public void onCameraMotionReset() {
            CameraMotionListener cameraMotionListener = this.f2561b;
            if (cameraMotionListener != null) {
                cameraMotionListener.onCameraMotionReset();
            }
            CameraMotionListener cameraMotionListener2 = this.f2560a;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotionReset();
            }
        }
    }

    public static final class e implements MediaSourceInfoHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Timeline f30573a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Object f2562a;

        public e(Object obj, Timeline timeline) {
            this.f2562a = obj;
            this.f30573a = timeline;
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public Timeline a() {
            return this.f30573a;
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public Object getUid() {
            return this.f2562a;
        }
    }

    static {
        ab3.a("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public b(ExoPlayer.a aVar, @Nullable Player player) {
        ps1 ps1Var = new ps1();
        this.f2541a = ps1Var;
        try {
            Log.h(f30570a, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + ab3.c + "] [" + gj9.d + "]");
            Context applicationContext = aVar.f2036a.getApplicationContext();
            this.f2505a = applicationContext;
            AnalyticsCollector analyticsCollectorApply = aVar.f2042a.apply(aVar.f2040a);
            this.f2521a = analyticsCollectorApply;
            this.f2533a = aVar.f2041a;
            this.f2522a = aVar.f2039a;
            this.T0 = aVar.b;
            this.U0 = aVar.c;
            this.g = aVar.f2051c;
            this.e = aVar.e;
            c cVar = new c();
            this.f2523a = cVar;
            d dVar = new d();
            this.f2524a = dVar;
            Handler handler = new Handler(aVar.f2037a);
            Renderer[] rendererArrA = aVar.f2043a.get().a(handler, cVar, cVar, cVar, cVar);
            this.f2550a = rendererArrA;
            sb0.i(rendererArrA.length > 0);
            TrackSelector trackSelector = aVar.f2050c.get();
            this.f2528a = trackSelector;
            this.f2526a = aVar.f2047b.get();
            BandwidthMeter bandwidthMeter = aVar.f2054e.get();
            this.f2529a = bandwidthMeter;
            this.f2549a = aVar.f2053d;
            this.f2543a = aVar.f2044a;
            this.c = aVar.f2046b;
            this.d = aVar.f2049c;
            this.f2558e = aVar.f2055e;
            Looper looper = aVar.f2037a;
            this.f2507a = looper;
            Clock clock = aVar.f2040a;
            this.f2530a = clock;
            Player player2 = player == null ? this : player;
            this.f2518a = player2;
            this.f2532a = new ListenerSet<>(looper, clock, new ListenerSet.IterationFinishedEvent() { // from class: com.zj.adlib.u93
                @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
                public final void a(Object obj, a aVar2) {
                    this.f45094a.H1((Player.Listener) obj, aVar2);
                }
            });
            this.f2548a = new CopyOnWriteArraySet<>();
            this.f2547a = new ArrayList();
            this.f2527a = new ShuffleOrder.a(0);
            wa9 wa9Var = new wa9(new ue7[rendererArrA.length], new ExoTrackSelection[rendererArrA.length], p.f3610a, null);
            this.f2544a = wa9Var;
            this.f2520a = new Timeline.b();
            Player.b bVarF = new Player.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).e(29, trackSelector.c()).f();
            this.f2517a = bVarF;
            this.f2551b = new Player.b.a().b(bVarF).a(4).a(10).f();
            this.f2531a = clock.a(looper, null);
            ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener = new ExoPlayerImplInternal.PlaybackInfoUpdateListener() { // from class: com.zj.adlib.ea3
                @Override // com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdateListener
                public final void a(ExoPlayerImplInternal.e eVar) {
                    this.f41389a.J1(eVar);
                }
            };
            this.f2514a = playbackInfoUpdateListener;
            this.f2542a = rs6.j(wa9Var);
            analyticsCollectorApply.N(player2, looper);
            int i = gj9.f41922a;
            ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(rendererArrA, trackSelector, wa9Var, aVar.f2052d.get(), bandwidthMeter, this.P0, this.f2554b, analyticsCollectorApply, this.f2543a, aVar.f2038a, aVar.d, this.f2558e, looper, clock, playbackInfoUpdateListener, i < 31 ? new at6() : C0676b.a(applicationContext, this, aVar.f));
            this.f2515a = exoPlayerImplInternal;
            this.f2504a = 1.0f;
            this.P0 = 0;
            MediaMetadata mediaMetadata = MediaMetadata.f2102a;
            this.f2516a = mediaMetadata;
            this.b = mediaMetadata;
            this.f2555c = mediaMetadata;
            this.Y0 = -1;
            if (i < 21) {
                this.X0 = E1(0);
            } else {
                this.X0 = gj9.K(applicationContext);
            }
            this.f2545a = xy1.f20750a;
            this.h = true;
            u(analyticsCollectorApply);
            bandwidthMeter.c(new Handler(looper), analyticsCollectorApply);
            n(cVar);
            long j = aVar.f2035a;
            if (j > 0) {
                exoPlayerImplInternal.s(j);
            }
            AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(aVar.f2036a, handler, cVar);
            this.f2511a = audioBecomingNoisyManager;
            audioBecomingNoisyManager.b(aVar.f2048b);
            AudioFocusManager audioFocusManager = new AudioFocusManager(aVar.f2036a, handler, cVar);
            this.f2512a = audioFocusManager;
            audioFocusManager.n(aVar.f2045a ? this.f2522a : null);
            StreamVolumeManager streamVolumeManager = new StreamVolumeManager(aVar.f2036a, handler, cVar);
            this.f2519a = streamVolumeManager;
            streamVolumeManager.m(gj9.r0(this.f2522a.M));
            mt9 mt9Var = new mt9(aVar.f2036a);
            this.f2539a = mt9Var;
            mt9Var.a(aVar.f30482a != 0);
            kw9 kw9Var = new kw9(aVar.f2036a);
            this.f2538a = kw9Var;
            kw9Var.a(aVar.f30482a == 2);
            this.f2513a = r1(streamVolumeManager);
            this.f2537a = hp9.f17050a;
            trackSelector.g(this.f2522a);
            p2(1, 10, Integer.valueOf(this.X0));
            p2(2, 10, Integer.valueOf(this.X0));
            p2(1, 3, this.f2522a);
            p2(2, 4, Integer.valueOf(this.T0));
            p2(2, 5, Integer.valueOf(this.U0));
            p2(1, 9, Boolean.valueOf(this.g));
            p2(2, 7, dVar);
            p2(6, 8, dVar);
            ps1Var.f();
        } catch (Throwable th) {
            this.f2541a.f();
            throw th;
        }
    }

    public static long C1(rs6 rs6Var) {
        Timeline.d dVar = new Timeline.d();
        Timeline.b bVar = new Timeline.b();
        rs6Var.f19408a.l(((gk5) rs6Var.f19410a).f16805a, bVar);
        return rs6Var.f19406a == -9223372036854775807L ? rs6Var.f19408a.t(bVar.K, dVar).f() : bVar.s() + rs6Var.f19406a;
    }

    public static boolean F1(rs6 rs6Var) {
        return rs6Var.f44526a == 3 && rs6Var.f19417b && rs6Var.b == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H1(Player.Listener listener, com.google.android.exoplayer2.util.a aVar) {
        listener.t(this.f2518a, new Player.c(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J1(final ExoPlayerImplInternal.e eVar) {
        this.f2531a.post(new Runnable() { // from class: com.zj.adlib.ha3
            @Override // java.lang.Runnable
            public final void run() {
                this.f16954a.I1(eVar);
            }
        });
    }

    public static /* synthetic */ void K1(Player.Listener listener) {
        listener.onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N1(Player.Listener listener) {
        listener.z(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(Player.Listener listener) {
        listener.E(this.f2551b);
    }

    public static /* synthetic */ void U1(rs6 rs6Var, int i, Player.Listener listener) {
        listener.r(rs6Var.f19408a, i);
    }

    public static /* synthetic */ void V1(int i, Player.d dVar, Player.d dVar2, Player.Listener listener) {
        listener.onPositionDiscontinuity(i);
        listener.C(dVar, dVar2, i);
    }

    public static /* synthetic */ void X1(rs6 rs6Var, Player.Listener listener) {
        listener.H(rs6Var.f19407a);
    }

    public static /* synthetic */ void Y1(rs6 rs6Var, Player.Listener listener) {
        listener.onPlayerError(rs6Var.f19407a);
    }

    public static /* synthetic */ void Z1(rs6 rs6Var, Player.Listener listener) {
        listener.G(rs6Var.f19412a.f20397a);
    }

    public static /* synthetic */ void b2(rs6 rs6Var, Player.Listener listener) {
        listener.onLoadingChanged(rs6Var.f19414a);
        listener.onIsLoadingChanged(rs6Var.f19414a);
    }

    public static /* synthetic */ void c2(rs6 rs6Var, Player.Listener listener) {
        listener.onPlayerStateChanged(rs6Var.f19417b, rs6Var.f44526a);
    }

    public static /* synthetic */ void d2(rs6 rs6Var, Player.Listener listener) {
        listener.onPlaybackStateChanged(rs6Var.f44526a);
    }

    public static /* synthetic */ void e2(rs6 rs6Var, int i, Player.Listener listener) {
        listener.onPlayWhenReadyChanged(rs6Var.f19417b, i);
    }

    public static /* synthetic */ void f2(rs6 rs6Var, Player.Listener listener) {
        listener.onPlaybackSuppressionReasonChanged(rs6Var.b);
    }

    public static /* synthetic */ void g2(rs6 rs6Var, Player.Listener listener) {
        listener.onIsPlayingChanged(F1(rs6Var));
    }

    public static /* synthetic */ void h2(rs6 rs6Var, Player.Listener listener) {
        listener.g(rs6Var.f19409a);
    }

    public static DeviceInfo r1(StreamVolumeManager streamVolumeManager) {
        return new DeviceInfo(0, streamVolumeManager.e(), streamVolumeManager.d());
    }

    public static int z1(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public ExoPlayer.TextComponent A() {
        C2();
        return this;
    }

    public final Player.d A1(long j) {
        g gVar;
        Object obj;
        int iF;
        Object obj2;
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        if (this.f2542a.f19408a.w()) {
            gVar = null;
            obj = null;
            iF = -1;
            obj2 = null;
        } else {
            rs6 rs6Var = this.f2542a;
            Object obj3 = ((gk5) rs6Var.f19410a).f16805a;
            rs6Var.f19408a.l(obj3, this.f2520a);
            iF = this.f2542a.f19408a.f(obj3);
            obj = obj3;
            obj2 = this.f2542a.f19408a.t(currentMediaItemIndex, ((BasePlayer) this).f30475a).f2200a;
            gVar = ((BasePlayer) this).f30475a.f2199a;
        }
        long jH1 = gj9.H1(j);
        long jH2 = this.f2542a.f19410a.c() ? gj9.H1(C1(this.f2542a)) : jH1;
        MediaSource.a aVar = this.f2542a.f19410a;
        return new Player.d(obj2, currentMediaItemIndex, gVar, obj, iF, jH1, jH2, ((gk5) aVar).f41928a, aVar.b);
    }

    public final void A2(boolean z) {
        PriorityTaskManager priorityTaskManager = this.f2533a;
        if (priorityTaskManager != null) {
            if (z && !this.j) {
                priorityTaskManager.a(0);
                this.j = true;
            } else {
                if (z || !this.j) {
                    return;
                }
                priorityTaskManager.e(0);
                this.j = false;
            }
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Renderer B(int i) {
        C2();
        return this.f2550a[i];
    }

    public final Player.d B1(int i, rs6 rs6Var, int i2) {
        int i3;
        Object obj;
        g gVar;
        Object obj2;
        int i4;
        long jC1;
        long jC2;
        Timeline.b bVar = new Timeline.b();
        if (rs6Var.f19408a.w()) {
            i3 = i2;
            obj = null;
            gVar = null;
            obj2 = null;
            i4 = -1;
        } else {
            Object obj3 = ((gk5) rs6Var.f19410a).f16805a;
            rs6Var.f19408a.l(obj3, bVar);
            int i5 = bVar.K;
            int iF = rs6Var.f19408a.f(obj3);
            Object obj4 = rs6Var.f19408a.t(i5, ((BasePlayer) this).f30475a).f2200a;
            gVar = ((BasePlayer) this).f30475a.f2199a;
            obj2 = obj3;
            i4 = iF;
            obj = obj4;
            i3 = i5;
        }
        if (i == 0) {
            if (rs6Var.f19410a.c()) {
                MediaSource.a aVar = rs6Var.f19410a;
                jC1 = bVar.e(((gk5) aVar).f41928a, aVar.b);
                jC2 = C1(rs6Var);
            } else {
                jC1 = rs6Var.f19410a.c != -1 ? C1(this.f2542a) : bVar.b + bVar.f2190a;
                jC2 = jC1;
            }
        } else if (rs6Var.f19410a.c()) {
            jC1 = rs6Var.e;
            jC2 = C1(rs6Var);
        } else {
            jC1 = bVar.b + rs6Var.e;
            jC2 = jC1;
        }
        long jH1 = gj9.H1(jC1);
        long jH2 = gj9.H1(jC2);
        MediaSource.a aVar2 = rs6Var.f19410a;
        return new Player.d(obj, i3, gVar, obj2, i4, jH1, jH2, ((gk5) aVar2).f41928a, aVar2.b);
    }

    public final void B2() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.f2539a.b(getPlayWhenReady() && !experimentalIsSleepingForOffload());
                this.f2538a.b(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.f2539a.b(false);
        this.f2538a.b(false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void C(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.f2548a.remove(audioOffloadListener);
    }

    public final void C2() {
        this.f2541a.c();
        if (Thread.currentThread() != getApplicationLooper().getThread()) {
            String strH = gj9.H("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), getApplicationLooper().getThread().getName());
            if (this.h) {
                throw new IllegalStateException(strH);
            }
            Log.o(f30570a, strH, this.i ? null : new IllegalStateException());
            this.i = true;
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void D(MediaSource mediaSource) {
        C2();
        setMediaSources(Collections.singletonList(mediaSource));
    }

    /* JADX INFO: renamed from: D1, reason: merged with bridge method [inline-methods] */
    public final void I1(ExoPlayerImplInternal.e eVar) {
        long j;
        boolean z;
        long jL2;
        int i = this.Q0 - eVar.f30488a;
        this.Q0 = i;
        boolean z2 = true;
        if (eVar.f2095b) {
            this.R0 = eVar.b;
            this.f2556c = true;
        }
        if (eVar.f2096c) {
            this.S0 = eVar.c;
        }
        if (i == 0) {
            Timeline timeline = eVar.f2093a.f19408a;
            if (!this.f2542a.f19408a.w() && timeline.w()) {
                this.Y0 = -1;
                this.f = 0L;
                this.Z0 = 0;
            }
            if (!timeline.w()) {
                List<Timeline> listF = ((k) timeline).F();
                sb0.i(listF.size() == this.f2547a.size());
                for (int i2 = 0; i2 < listF.size(); i2++) {
                    this.f2547a.get(i2).f30573a = listF.get(i2);
                }
            }
            if (this.f2556c) {
                if (eVar.f2093a.f19410a.equals(this.f2542a.f19410a) && eVar.f2093a.f19415b == this.f2542a.e) {
                    z2 = false;
                }
                if (z2) {
                    if (timeline.w() || eVar.f2093a.f19410a.c()) {
                        jL2 = eVar.f2093a.f19415b;
                    } else {
                        rs6 rs6Var = eVar.f2093a;
                        jL2 = l2(timeline, rs6Var.f19410a, rs6Var.f19415b);
                    }
                    j = jL2;
                } else {
                    j = -9223372036854775807L;
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.f2556c = false;
            z2(eVar.f2093a, 1, this.S0, false, z, this.R0, j, -1);
        }
    }

    public final int E1(int i) {
        AudioTrack audioTrack = this.f2506a;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i) {
            this.f2506a.release();
            this.f2506a = null;
        }
        if (this.f2506a == null) {
            this.f2506a = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.f2506a.getAudioSessionId();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public com.google.android.exoplayer2.d F() {
        C2();
        return this.f2525a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void G(MediaSource mediaSource, long j) {
        C2();
        setMediaSources(Collections.singletonList(mediaSource), 0, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void H(@Nullable w38 w38Var) {
        C2();
        if (w38Var == null) {
            w38Var = w38.e;
        }
        if (this.f2543a.equals(w38Var)) {
            return;
        }
        this.f2543a = w38Var;
        this.f2515a.X0(w38Var);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public TrackSelector I() {
        C2();
        return this.f2528a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void J(MediaSource mediaSource, boolean z, boolean z2) {
        C2();
        y(mediaSource, z);
        prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.trackselection.c K() {
        C2();
        return this.f2528a.a();
    }

    @Override // com.google.android.exoplayer2.Player
    public void L(final com.google.android.exoplayer2.trackselection.c cVar) {
        C2();
        if (!this.f2528a.c() || cVar.equals(this.f2528a.a())) {
            return;
        }
        this.f2528a.h(cVar);
        this.f2532a.m(19, new ListenerSet.Event() { // from class: com.zj.adlib.ca3
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).q(cVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public com.google.android.exoplayer2.d M() {
        C2();
        return this.f2552b;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void N(@Nullable PriorityTaskManager priorityTaskManager) {
        C2();
        if (gj9.c(this.f2533a, priorityTaskManager)) {
            return;
        }
        if (this.j) {
            ((PriorityTaskManager) sb0.g(this.f2533a)).e(0);
        }
        if (priorityTaskManager == null || !isLoading()) {
            this.j = false;
        } else {
            priorityTaskManager.a(0);
            this.j = true;
        }
        this.f2533a = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Clock O() {
        return this.f2530a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public AnalyticsCollector P() {
        C2();
        return this.f2521a;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.b Q() {
        C2();
        return this.f2551b;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void R(ShuffleOrder shuffleOrder) {
        C2();
        this.f2527a = shuffleOrder;
        Timeline timelineS1 = s1();
        rs6 rs6VarI2 = i2(this.f2542a, timelineS1, j2(timelineS1, getCurrentMediaItemIndex(), getCurrentPosition()));
        this.Q0++;
        this.f2515a.b1(shuffleOrder);
        z2(rs6VarI2, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void S(int i, MediaSource mediaSource) {
        C2();
        addMediaSources(i, Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void T(AnalyticsListener analyticsListener) {
        this.f2521a.u(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void V(Player.Listener listener) {
        sb0.g(listener);
        this.f2532a.l(listener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public na9 W() {
        C2();
        return new na9(this.f2542a.f19412a.f20399a);
    }

    @Override // com.google.android.exoplayer2.Player
    public void X(MediaMetadata mediaMetadata) {
        C2();
        sb0.g(mediaMetadata);
        if (mediaMetadata.equals(this.b)) {
            return;
        }
        this.b = mediaMetadata;
        this.f2532a.m(15, new ListenerSet.Event() { // from class: com.zj.adlib.ja3
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                this.f42539a.N1((Player.Listener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public ExoPlaybackException f() {
        C2();
        return this.f2542a.f19407a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void a(CameraMotionListener cameraMotionListener) {
        C2();
        this.f2535a = cameraMotionListener;
        u1(this.f2524a).t(8).q(cameraMotionListener).m();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline a0() {
        C2();
        return this.f2542a.f19408a;
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, List<g> list) {
        C2();
        addMediaSources(Math.min(i, this.f2547a.size()), t1(list));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(List<MediaSource> list) {
        C2();
        addMediaSources(this.f2547a.size(), list);
    }

    @Override // com.google.android.exoplayer2.Player
    public j b() {
        C2();
        return this.f2542a.f19409a;
    }

    @Override // com.google.android.exoplayer2.Player
    public void c(j jVar) {
        C2();
        if (jVar == null) {
            jVar = j.f3398a;
        }
        if (this.f2542a.f19409a.equals(jVar)) {
            return;
        }
        rs6 rs6VarF = this.f2542a.f(jVar);
        this.Q0++;
        this.f2515a.T0(jVar);
        z2(rs6VarF, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void c0(MediaSource mediaSource) {
        C2();
        D(mediaSource);
        prepare();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void clearAuxEffectInfo() {
        C2();
        e(new pi0(0, 0.0f));
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurface() {
        C2();
        o2();
        v2(null);
        k2(0, 0);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        C2();
        if (surfaceHolder == null || surfaceHolder != this.f2509a) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        C2();
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        C2();
        if (textureView == null || textureView != this.f2510a) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public com.google.android.exoplayer2.audio.a d() {
        C2();
        return this.f2522a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void d0(AnalyticsListener analyticsListener) {
        sb0.g(analyticsListener);
        this.f2521a.p(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void decreaseDeviceVolume() {
        C2();
        this.f2519a.c();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void e(pi0 pi0Var) {
        C2();
        p2(1, 6, pi0Var);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public ExoPlayer.DeviceComponent e0() {
        C2();
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean experimentalIsSleepingForOffload() {
        C2();
        return this.f2542a.f19419c;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        C2();
        this.f2515a.t(z);
        Iterator<ExoPlayer.AudioOffloadListener> it = this.f2548a.iterator();
        while (it.hasNext()) {
            it.next().onExperimentalOffloadSchedulingEnabledChanged(z);
        }
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public DeviceInfo g() {
        C2();
        return this.f2513a;
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.f2507a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public int getAudioSessionId() {
        C2();
        return this.X0;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        C2();
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        rs6 rs6Var = this.f2542a;
        return rs6Var.f19416b.equals(rs6Var.f19410a) ? gj9.H1(this.f2542a.f19418c) : getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        C2();
        if (this.f2542a.f19408a.w()) {
            return this.f;
        }
        rs6 rs6Var = this.f2542a;
        if (((gk5) rs6Var.f19416b).f16804a != ((gk5) rs6Var.f19410a).f16804a) {
            return rs6Var.f19408a.t(getCurrentMediaItemIndex(), ((BasePlayer) this).f30475a).g();
        }
        long j = rs6Var.f19418c;
        if (this.f2542a.f19416b.c()) {
            rs6 rs6Var2 = this.f2542a;
            Timeline.b bVarL = rs6Var2.f19408a.l(((gk5) rs6Var2.f19416b).f16805a, this.f2520a);
            long jI = bVarL.i(((gk5) this.f2542a.f19416b).f41928a);
            j = jI == Long.MIN_VALUE ? bVarL.f2190a : jI;
        }
        rs6 rs6Var3 = this.f2542a;
        return gj9.H1(l2(rs6Var3.f19408a, rs6Var3.f19416b, j));
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        C2();
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        rs6 rs6Var = this.f2542a;
        rs6Var.f19408a.l(((gk5) rs6Var.f19410a).f16805a, this.f2520a);
        rs6 rs6Var2 = this.f2542a;
        return rs6Var2.f19406a == -9223372036854775807L ? rs6Var2.f19408a.t(getCurrentMediaItemIndex(), ((BasePlayer) this).f30475a).e() : this.f2520a.r() + gj9.H1(this.f2542a.f19406a);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        C2();
        if (isPlayingAd()) {
            return ((gk5) this.f2542a.f19410a).f41928a;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        C2();
        if (isPlayingAd()) {
            return this.f2542a.f19410a.b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentMediaItemIndex() {
        C2();
        int iX1 = x1();
        if (iX1 == -1) {
            return 0;
        }
        return iX1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        C2();
        if (this.f2542a.f19408a.w()) {
            return this.Z0;
        }
        rs6 rs6Var = this.f2542a;
        return rs6Var.f19408a.f(((gk5) rs6Var.f19410a).f16805a);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        C2();
        return gj9.H1(w1(this.f2542a));
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public int getDeviceVolume() {
        C2();
        return this.f2519a.g();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        C2();
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        rs6 rs6Var = this.f2542a;
        MediaSource.a aVar = rs6Var.f19410a;
        rs6Var.f19408a.l(((gk5) aVar).f16805a, this.f2520a);
        return gj9.H1(this.f2520a.e(((gk5) aVar).f41928a, aVar.b));
    }

    @Override // com.google.android.exoplayer2.Player
    public long getMaxSeekToPreviousPosition() {
        C2();
        return 3000L;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        C2();
        return this.f2558e;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        C2();
        return this.f2542a.f19417b;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.f2515a.A();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        C2();
        return this.f2542a.f44526a;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        C2();
        return this.f2542a.b;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getRendererCount() {
        C2();
        return this.f2550a.length;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getRendererType(int i) {
        C2();
        return this.f2550a[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        C2();
        return this.P0;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekBackIncrement() {
        C2();
        return this.c;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekForwardIncrement() {
        C2();
        return this.d;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        C2();
        return this.f2554b;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public boolean getSkipSilenceEnabled() {
        C2();
        return this.g;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        C2();
        return gj9.H1(this.f2542a.d);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public int getVideoChangeFrameRateStrategy() {
        C2();
        return this.U0;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public int getVideoScalingMode() {
        C2();
        return this.T0;
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public float getVolume() {
        C2();
        return this.f2504a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void h(final com.google.android.exoplayer2.audio.a aVar, boolean z) {
        C2();
        if (this.k) {
            return;
        }
        if (!gj9.c(this.f2522a, aVar)) {
            this.f2522a = aVar;
            p2(1, 3, aVar);
            this.f2519a.m(gj9.r0(aVar.M));
            this.f2532a.j(20, new ListenerSet.Event() { // from class: com.zj.adlib.ga3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).B(aVar);
                }
            });
        }
        this.f2512a.n(z ? aVar : null);
        this.f2528a.g(aVar);
        boolean playWhenReady = getPlayWhenReady();
        int iQ = this.f2512a.q(playWhenReady, getPlaybackState());
        y2(playWhenReady, iQ, z1(playWhenReady, iQ));
        this.f2532a.g();
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata h0() {
        C2();
        return this.f2516a;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void i(CameraMotionListener cameraMotionListener) {
        C2();
        if (this.f2535a != cameraMotionListener) {
            return;
        }
        u1(this.f2524a).t(8).q(null).m();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage i0(PlayerMessage.Target target) {
        C2();
        return u1(target);
    }

    public final rs6 i2(rs6 rs6Var, Timeline timeline, @Nullable Pair<Object, Long> pair) {
        sb0.a(timeline.w() || pair != null);
        Timeline timeline2 = rs6Var.f19408a;
        rs6 rs6VarI = rs6Var.i(timeline);
        if (timeline.w()) {
            MediaSource.a aVarK = rs6.k();
            long jZ0 = gj9.Z0(this.f);
            rs6 rs6VarB = rs6VarI.c(aVarK, jZ0, jZ0, jZ0, 0L, ga9.f16735a, this.f2544a, ImmutableList.of()).b(aVarK);
            rs6VarB.f19418c = rs6VarB.e;
            return rs6VarB;
        }
        Object obj = ((gk5) rs6VarI.f19410a).f16805a;
        boolean z = !obj.equals(((Pair) gj9.k(pair)).first);
        MediaSource.a aVar = z ? new MediaSource.a(pair.first) : rs6VarI.f19410a;
        long jLongValue = ((Long) pair.second).longValue();
        long jZ1 = gj9.Z0(getContentPosition());
        if (!timeline2.w()) {
            jZ1 -= timeline2.l(obj, this.f2520a).s();
        }
        if (z || jLongValue < jZ1) {
            sb0.i(!aVar.c());
            rs6 rs6VarB2 = rs6VarI.c(aVar, jLongValue, jLongValue, jLongValue, 0L, z ? ga9.f16735a : rs6VarI.f19411a, z ? this.f2544a : rs6VarI.f19412a, z ? ImmutableList.of() : rs6VarI.f19413a).b(aVar);
            rs6VarB2.f19418c = jLongValue;
            return rs6VarB2;
        }
        if (jLongValue == jZ1) {
            int iF = timeline.f(((gk5) rs6VarI.f19416b).f16805a);
            if (iF == -1 || timeline.j(iF, this.f2520a).K != timeline.l(((gk5) aVar).f16805a, this.f2520a).K) {
                timeline.l(((gk5) aVar).f16805a, this.f2520a);
                long jE = aVar.c() ? this.f2520a.e(((gk5) aVar).f41928a, aVar.b) : this.f2520a.f2190a;
                rs6VarI = rs6VarI.c(aVar, rs6VarI.e, rs6VarI.e, rs6VarI.f19415b, jE - rs6VarI.e, rs6VarI.f19411a, rs6VarI.f19412a, rs6VarI.f19413a).b(aVar);
                rs6VarI.f19418c = jE;
            }
        } else {
            sb0.i(!aVar.c());
            long jMax = Math.max(0L, rs6VarI.d - (jLongValue - jZ1));
            long j = rs6VarI.f19418c;
            if (rs6VarI.f19416b.equals(rs6VarI.f19410a)) {
                j = jLongValue + jMax;
            }
            rs6VarI = rs6VarI.c(aVar, jLongValue, jLongValue, jLongValue, jMax, rs6VarI.f19411a, rs6VarI.f19412a, rs6VarI.f19413a);
            rs6VarI.f19418c = j;
        }
        return rs6VarI;
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void increaseDeviceVolume() {
        C2();
        this.f2519a.i();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public boolean isDeviceMuted() {
        C2();
        return this.f2519a.j();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        C2();
        return this.f2542a.f19414a;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        C2();
        return this.f2542a.f19410a.c();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public hp9 j() {
        C2();
        return this.f2537a;
    }

    @Nullable
    public final Pair<Object, Long> j2(Timeline timeline, int i, long j) {
        if (timeline.w()) {
            this.Y0 = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.f = j;
            this.Z0 = 0;
            return null;
        }
        if (i == -1 || i >= timeline.v()) {
            i = timeline.e(this.f2554b);
            j = timeline.t(i, ((BasePlayer) this).f30475a).e();
        }
        return timeline.p(((BasePlayer) this).f30475a, this.f2520a, i, gj9.Z0(j));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void k(VideoFrameMetadataListener videoFrameMetadataListener) {
        C2();
        if (this.f2534a != videoFrameMetadataListener) {
            return;
        }
        u1(this.f2524a).t(7).q(null).m();
    }

    public final void k2(final int i, final int i2) {
        if (i == this.V0 && i2 == this.W0) {
            return;
        }
        this.V0 = i;
        this.W0 = i2;
        this.f2532a.m(24, new ListenerSet.Event() { // from class: com.zj.adlib.i93
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).onSurfaceSizeChanged(i, i2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void l(VideoFrameMetadataListener videoFrameMetadataListener) {
        C2();
        this.f2534a = videoFrameMetadataListener;
        u1(this.f2524a).t(7).q(videoFrameMetadataListener).m();
    }

    public final long l2(Timeline timeline, MediaSource.a aVar, long j) {
        timeline.l(((gk5) aVar).f16805a, this.f2520a);
        return j + this.f2520a.s();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.TextComponent
    public xy1 m() {
        C2();
        return this.f2545a;
    }

    public final rs6 m2(int i, int i2) {
        boolean z = false;
        sb0.a(i >= 0 && i2 >= i && i2 <= this.f2547a.size());
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        Timeline timelineA0 = a0();
        int size = this.f2547a.size();
        this.Q0++;
        n2(i, i2);
        Timeline timelineS1 = s1();
        rs6 rs6VarI2 = i2(this.f2542a, timelineS1, y1(timelineA0, timelineS1));
        int i3 = rs6VarI2.f44526a;
        if (i3 != 1 && i3 != 4 && i < i2 && i2 == size && currentMediaItemIndex >= rs6VarI2.f19408a.v()) {
            z = true;
        }
        if (z) {
            rs6VarI2 = rs6VarI2.g(4);
        }
        this.f2515a.n0(i, i2, this.f2527a);
        return rs6VarI2;
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        C2();
        sb0.a(i >= 0 && i <= i2 && i2 <= this.f2547a.size() && i3 >= 0);
        Timeline timelineA0 = a0();
        this.Q0++;
        int iMin = Math.min(i3, this.f2547a.size() - (i2 - i));
        gj9.Y0(this.f2547a, i, i2, iMin);
        Timeline timelineS1 = s1();
        rs6 rs6VarI2 = i2(this.f2542a, timelineS1, y1(timelineA0, timelineS1));
        this.f2515a.d0(i, i2, iMin, this.f2527a);
        z2(rs6VarI2, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void n(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.f2548a.add(audioOffloadListener);
    }

    public final void n2(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.f2547a.remove(i3);
        }
        this.f2527a = this.f2527a.a(i, i2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public ga9 o() {
        C2();
        return this.f2542a.f19411a;
    }

    public final void o2() {
        if (this.f2536a != null) {
            u1(this.f2524a).t(10000).q(null).m();
            this.f2536a.removeVideoSurfaceListener(this.f2523a);
            this.f2536a = null;
        }
        TextureView textureView = this.f2510a;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f2523a) {
                Log.n(f30570a, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f2510a.setSurfaceTextureListener(null);
            }
            this.f2510a = null;
        }
        SurfaceHolder surfaceHolder = this.f2509a;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f2523a);
            this.f2509a = null;
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public p82 p() {
        C2();
        return this.f2540a;
    }

    public final List<MediaSourceList.c> p1(int i, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            MediaSourceList.c cVar = new MediaSourceList.c(list.get(i2), this.f2549a);
            arrayList.add(cVar);
            this.f2547a.add(i2 + i, new e(cVar.f2159a, cVar.f2158a.U()));
        }
        this.f2527a = this.f2527a.b(i, arrayList.size());
        return arrayList;
    }

    public final void p2(int i, int i2, @Nullable Object obj) {
        for (Renderer renderer : this.f2550a) {
            if (renderer.getTrackType() == i) {
                u1(renderer).t(i2).q(obj).m();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        C2();
        boolean playWhenReady = getPlayWhenReady();
        int iQ = this.f2512a.q(playWhenReady, 2);
        y2(playWhenReady, iQ, z1(playWhenReady, iQ));
        rs6 rs6Var = this.f2542a;
        if (rs6Var.f44526a != 1) {
            return;
        }
        rs6 rs6VarE = rs6Var.e(null);
        rs6 rs6VarG = rs6VarE.g(rs6VarE.f19408a.w() ? 4 : 2);
        this.Q0++;
        this.f2515a.i0();
        z2(rs6VarG, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void q(MediaSource mediaSource) {
        C2();
        addMediaSources(Collections.singletonList(mediaSource));
    }

    public final MediaMetadata q1() {
        Timeline timelineA0 = a0();
        if (timelineA0.w()) {
            return this.f2555c;
        }
        return this.f2555c.b().H(timelineA0.t(getCurrentMediaItemIndex(), ((BasePlayer) this).f30475a).f2199a.f3323a).F();
    }

    public final void q2() {
        p2(1, 2, Float.valueOf(this.f2504a * this.f2512a.h()));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public p82 r() {
        C2();
        return this.f2553b;
    }

    public final void r2(List<MediaSource> list, int i, long j, boolean z) {
        int iE;
        long j2;
        int iX1 = x1();
        long currentPosition = getCurrentPosition();
        this.Q0++;
        if (!this.f2547a.isEmpty()) {
            n2(0, this.f2547a.size());
        }
        List<MediaSourceList.c> listP1 = p1(0, list);
        Timeline timelineS1 = s1();
        if (!timelineS1.w() && i >= timelineS1.v()) {
            throw new IllegalSeekPositionException(timelineS1, i, j);
        }
        if (z) {
            j2 = -9223372036854775807L;
            iE = timelineS1.e(this.f2554b);
        } else if (i == -1) {
            iE = iX1;
            j2 = currentPosition;
        } else {
            iE = i;
            j2 = j;
        }
        rs6 rs6VarI2 = i2(this.f2542a, timelineS1, j2(timelineS1, iE, j2));
        int i2 = rs6VarI2.f44526a;
        if (iE != -1 && i2 != 1) {
            i2 = (timelineS1.w() || iE >= timelineS1.v()) ? 4 : 2;
        }
        rs6 rs6VarG = rs6VarI2.g(i2);
        this.f2515a.N0(listP1, iE, gj9.Z0(j2), this.f2527a);
        z2(rs6VarG, 0, 1, false, (((gk5) this.f2542a.f19410a).f16805a.equals(((gk5) rs6VarG.f19410a).f16805a) || this.f2542a.f19408a.w()) ? false : true, 4, w1(rs6VarG), -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        AudioTrack audioTrack;
        Log.h(f30570a, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + ab3.c + "] [" + gj9.d + "] [" + ab3.b() + "]");
        C2();
        if (gj9.f41922a < 21 && (audioTrack = this.f2506a) != null) {
            audioTrack.release();
            this.f2506a = null;
        }
        this.f2511a.b(false);
        this.f2519a.k();
        this.f2539a.b(false);
        this.f2538a.b(false);
        this.f2512a.j();
        if (!this.f2515a.k0()) {
            this.f2532a.m(10, new ListenerSet.Event() { // from class: com.zj.adlib.z93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.K1((Player.Listener) obj);
                }
            });
        }
        this.f2532a.k();
        this.f2531a.removeCallbacksAndMessages(null);
        this.f2529a.f(this.f2521a);
        rs6 rs6VarG = this.f2542a.g(1);
        this.f2542a = rs6VarG;
        rs6 rs6VarB = rs6VarG.b(rs6VarG.f19410a);
        this.f2542a = rs6VarB;
        rs6VarB.f19418c = rs6VarB.e;
        this.f2542a.d = 0L;
        this.f2521a.release();
        this.f2528a.e();
        o2();
        Surface surface = this.f2508a;
        if (surface != null) {
            surface.release();
            this.f2508a = null;
        }
        if (this.j) {
            ((PriorityTaskManager) sb0.g(this.f2533a)).e(0);
            this.j = false;
        }
        this.f2545a = xy1.f20750a;
        this.k = true;
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        C2();
        rs6 rs6VarM2 = m2(i, Math.min(i2, this.f2547a.size()));
        z2(rs6VarM2, 0, 1, false, !((gk5) rs6VarM2.f19410a).f16805a.equals(((gk5) this.f2542a.f19410a).f16805a), 4, w1(rs6VarM2), -1);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void retry() {
        C2();
        prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public p s() {
        C2();
        return this.f2542a.f19412a.f20397a;
    }

    public final Timeline s1() {
        return new k(this.f2547a, this.f2527a);
    }

    public final void s2(SurfaceHolder surfaceHolder) {
        this.f2559f = false;
        this.f2509a = surfaceHolder;
        surfaceHolder.addCallback(this.f2523a);
        Surface surface = this.f2509a.getSurface();
        if (surface == null || !surface.isValid()) {
            k2(0, 0);
        } else {
            Rect surfaceFrame = this.f2509a.getSurfaceFrame();
            k2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        C2();
        this.f2521a.notifySeekStarted();
        Timeline timeline = this.f2542a.f19408a;
        if (i < 0 || (!timeline.w() && i >= timeline.v())) {
            throw new IllegalSeekPositionException(timeline, i, j);
        }
        this.Q0++;
        if (isPlayingAd()) {
            Log.n(f30570a, "seekTo ignored because an ad is playing");
            ExoPlayerImplInternal.e eVar = new ExoPlayerImplInternal.e(this.f2542a);
            eVar.b(1);
            this.f2514a.a(eVar);
            return;
        }
        int i2 = getPlaybackState() != 1 ? 2 : 1;
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        rs6 rs6VarI2 = i2(this.f2542a.g(i2), timeline, j2(timeline, i, j));
        this.f2515a.A0(timeline, i, gj9.Z0(j));
        z2(rs6VarI2, 0, 1, true, true, 1, w1(rs6VarI2), currentMediaItemIndex);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setAudioSessionId(final int i) {
        C2();
        if (this.X0 == i) {
            return;
        }
        if (i == 0) {
            i = gj9.f41922a < 21 ? E1(0) : gj9.K(this.f2505a);
        } else if (gj9.f41922a < 21) {
            E1(i);
        }
        this.X0 = i;
        p2(1, 10, Integer.valueOf(i));
        p2(2, 10, Integer.valueOf(i));
        this.f2532a.m(21, new ListenerSet.Event() { // from class: com.zj.adlib.ia3
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).onAudioSessionIdChanged(i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void setDeviceMuted(boolean z) {
        C2();
        this.f2519a.l(z);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void setDeviceVolume(int i) {
        C2();
        this.f2519a.n(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        C2();
        if (this.f2557d != z) {
            this.f2557d = z;
            if (this.f2515a.K0(z)) {
                return;
            }
            w2(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(2), 1003));
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setHandleAudioBecomingNoisy(boolean z) {
        C2();
        if (this.k) {
            return;
        }
        this.f2511a.b(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setHandleWakeLock(boolean z) {
        C2();
        setWakeMode(z ? 1 : 0);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<g> list, boolean z) {
        C2();
        setMediaSources(t1(list), z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list) {
        C2();
        setMediaSources(list, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z) {
        C2();
        if (this.f2558e == z) {
            return;
        }
        this.f2558e = z;
        this.f2515a.P0(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        C2();
        int iQ = this.f2512a.q(z, getPlaybackState());
        y2(z, iQ, z1(z, iQ));
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(final int i) {
        C2();
        if (this.P0 != i) {
            this.P0 = i;
            this.f2515a.V0(i);
            this.f2532a.j(8, new ListenerSet.Event() { // from class: com.zj.adlib.ba3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onRepeatModeChanged(i);
                }
            });
            x2();
            this.f2532a.g();
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(final boolean z) {
        C2();
        if (this.f2554b != z) {
            this.f2554b = z;
            this.f2515a.Z0(z);
            this.f2532a.j(9, new ListenerSet.Event() { // from class: com.zj.adlib.ka3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onShuffleModeEnabledChanged(z);
                }
            });
            x2();
            this.f2532a.g();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setSkipSilenceEnabled(final boolean z) {
        C2();
        if (this.g == z) {
            return;
        }
        this.g = z;
        p2(1, 9, Boolean.valueOf(z));
        this.f2532a.m(23, new ListenerSet.Event() { // from class: com.zj.adlib.fa3
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).onSkipSilenceEnabledChanged(z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoChangeFrameRateStrategy(int i) {
        C2();
        if (this.U0 == i) {
            return;
        }
        this.U0 = i;
        p2(2, 5, Integer.valueOf(i));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoScalingMode(int i) {
        C2();
        this.T0 = i;
        p2(2, 4, Integer.valueOf(i));
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurface(@Nullable Surface surface) {
        C2();
        o2();
        v2(surface);
        int i = surface == null ? 0 : -1;
        k2(i, i);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        C2();
        if (surfaceHolder == null) {
            clearVideoSurface();
            return;
        }
        o2();
        this.f2559f = true;
        this.f2509a = surfaceHolder;
        surfaceHolder.addCallback(this.f2523a);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            v2(null);
            k2(0, 0);
        } else {
            v2(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            k2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        C2();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            o2();
            v2(surfaceView);
            s2(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof SphericalGLSurfaceView)) {
                setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            o2();
            this.f2536a = (SphericalGLSurfaceView) surfaceView;
            u1(this.f2524a).t(10000).q(this.f2536a).m();
            this.f2536a.addVideoSurfaceListener(this.f2523a);
            v2(this.f2536a.getVideoSurface());
            s2(surfaceView.getHolder());
        }
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoTextureView(@Nullable TextureView textureView) {
        C2();
        if (textureView == null) {
            clearVideoSurface();
            return;
        }
        o2();
        this.f2510a = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.n(f30570a, "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f2523a);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            v2(null);
            k2(0, 0);
        } else {
            t2(surfaceTexture);
            k2(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setVolume(float f) {
        C2();
        final float fR = gj9.r(f, 0.0f, 1.0f);
        if (this.f2504a == fR) {
            return;
        }
        this.f2504a = fR;
        q2();
        this.f2532a.m(22, new ListenerSet.Event() { // from class: com.zj.adlib.aa3
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((Player.Listener) obj).onVolumeChanged(fR);
            }
        });
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setWakeMode(int i) {
        C2();
        if (i == 0) {
            this.f2539a.a(false);
            this.f2538a.a(false);
        } else if (i == 1) {
            this.f2539a.a(true);
            this.f2538a.a(false);
        } else {
            if (i != 2) {
                return;
            }
            this.f2539a.a(true);
            this.f2538a.a(true);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        C2();
        stop(false);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public w38 t() {
        C2();
        return this.f2543a;
    }

    public final List<MediaSource> t1(List<g> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.f2526a.c(list.get(i)));
        }
        return arrayList;
    }

    public final void t2(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        v2(surface);
        this.f2508a = surface;
    }

    @Override // com.google.android.exoplayer2.Player
    public void u(Player.Listener listener) {
        sb0.g(listener);
        this.f2532a.c(listener);
    }

    public final PlayerMessage u1(PlayerMessage.Target target) {
        int iX1 = x1();
        ExoPlayerImplInternal exoPlayerImplInternal = this.f2515a;
        Timeline timeline = this.f2542a.f19408a;
        if (iX1 == -1) {
            iX1 = 0;
        }
        return new PlayerMessage(exoPlayerImplInternal, target, timeline, iX1, this.f2530a, exoPlayerImplInternal.A());
    }

    public void u2(boolean z) {
        this.h = z;
    }

    public final Pair<Boolean, Integer> v1(rs6 rs6Var, rs6 rs6Var2, boolean z, int i, boolean z2) {
        Timeline timeline = rs6Var2.f19408a;
        Timeline timeline2 = rs6Var.f19408a;
        if (timeline2.w() && timeline.w()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i2 = 3;
        if (timeline2.w() != timeline.w()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (timeline.t(timeline.l(((gk5) rs6Var2.f19410a).f16805a, this.f2520a).K, ((BasePlayer) this).f30475a).f2200a.equals(timeline2.t(timeline2.l(((gk5) rs6Var.f19410a).f16805a, this.f2520a).K, ((BasePlayer) this).f30475a).f2200a)) {
            return (z && i == 0 && ((gk5) rs6Var2.f19410a).f16804a < ((gk5) rs6Var.f19410a).f16804a) ? new Pair<>(Boolean.TRUE, 0) : new Pair<>(Boolean.FALSE, -1);
        }
        if (z && i == 0) {
            i2 = 1;
        } else if (z && i == 1) {
            i2 = 2;
        } else if (!z2) {
            throw new IllegalStateException();
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(i2));
    }

    public final void v2(@Nullable Object obj) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Renderer[] rendererArr = this.f2550a;
        int length = rendererArr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            Renderer renderer = rendererArr[i];
            if (renderer.getTrackType() == 2) {
                arrayList.add(u1(renderer).t(1).q(obj).m());
            }
            i++;
        }
        Object obj2 = this.f2546a;
        if (obj2 == null || obj2 == obj) {
            z = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).b(this.e);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z = false;
            Object obj3 = this.f2546a;
            Surface surface = this.f2508a;
            if (obj3 == surface) {
                surface.release();
                this.f2508a = null;
            }
        }
        this.f2546a = obj;
        if (z) {
            w2(false, ExoPlaybackException.createForUnexpected(new ExoTimeoutException(3), 1003));
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public ExoPlayer.AudioComponent w() {
        C2();
        return this;
    }

    public final long w1(rs6 rs6Var) {
        if (rs6Var.f19408a.w()) {
            return gj9.Z0(this.f);
        }
        return rs6Var.f19410a.c() ? rs6Var.e : l2(rs6Var.f19408a, rs6Var.f19410a, rs6Var.e);
    }

    public final void w2(boolean z, @Nullable ExoPlaybackException exoPlaybackException) {
        rs6 rs6VarB;
        if (z) {
            rs6VarB = m2(0, this.f2547a.size()).e(null);
        } else {
            rs6 rs6Var = this.f2542a;
            rs6VarB = rs6Var.b(rs6Var.f19410a);
            rs6VarB.f19418c = rs6VarB.e;
            rs6VarB.d = 0L;
        }
        rs6 rs6VarG = rs6VarB.g(1);
        if (exoPlaybackException != null) {
            rs6VarG = rs6VarG.e(exoPlaybackException);
        }
        rs6 rs6Var2 = rs6VarG;
        this.Q0++;
        this.f2515a.k1();
        z2(rs6Var2, 0, 1, false, rs6Var2.f19408a.w() && !this.f2542a.f19408a.w(), 4, w1(rs6Var2), -1);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public ExoPlayer.VideoComponent x() {
        C2();
        return this;
    }

    public final int x1() {
        if (this.f2542a.f19408a.w()) {
            return this.Y0;
        }
        rs6 rs6Var = this.f2542a;
        return rs6Var.f19408a.l(((gk5) rs6Var.f19410a).f16805a, this.f2520a).K;
    }

    public final void x2() {
        Player.b bVar = this.f2551b;
        Player.b bVarP = gj9.P(this.f2518a, this.f2517a);
        this.f2551b = bVarP;
        if (bVarP.equals(bVar)) {
            return;
        }
        this.f2532a.j(13, new ListenerSet.Event() { // from class: com.zj.adlib.da3
            @Override // com.google.android.exoplayer2.util.ListenerSet.Event
            public final void invoke(Object obj) {
                this.f41137a.T1((Player.Listener) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void y(MediaSource mediaSource, boolean z) {
        C2();
        setMediaSources(Collections.singletonList(mediaSource), z);
    }

    @Nullable
    public final Pair<Object, Long> y1(Timeline timeline, Timeline timeline2) {
        long contentPosition = getContentPosition();
        if (timeline.w() || timeline2.w()) {
            boolean z = !timeline.w() && timeline2.w();
            int iX1 = z ? -1 : x1();
            if (z) {
                contentPosition = -9223372036854775807L;
            }
            return j2(timeline2, iX1, contentPosition);
        }
        Pair<Object, Long> pairP = timeline.p(((BasePlayer) this).f30475a, this.f2520a, getCurrentMediaItemIndex(), gj9.Z0(contentPosition));
        Object obj = ((Pair) gj9.k(pairP)).first;
        if (timeline2.f(obj) != -1) {
            return pairP;
        }
        Object objY0 = ExoPlayerImplInternal.y0(((BasePlayer) this).f30475a, this.f2520a, this.P0, this.f2554b, obj, timeline, timeline2);
        if (objY0 == null) {
            return j2(timeline2, -1, -9223372036854775807L);
        }
        timeline2.l(objY0, this.f2520a);
        int i = this.f2520a.K;
        return j2(timeline2, i, timeline2.t(i, ((BasePlayer) this).f30475a).e());
    }

    public final void y2(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        rs6 rs6Var = this.f2542a;
        if (rs6Var.f19417b == z2 && rs6Var.b == i3) {
            return;
        }
        this.Q0++;
        rs6 rs6VarD = rs6Var.d(z2, i3);
        this.f2515a.R0(z2, i3);
        z2(rs6VarD, 0, i2, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata z() {
        C2();
        return this.b;
    }

    public final void z2(final rs6 rs6Var, final int i, final int i2, boolean z, boolean z2, final int i3, long j, int i4) {
        rs6 rs6Var2 = this.f2542a;
        this.f2542a = rs6Var;
        Pair<Boolean, Integer> pairV1 = v1(rs6Var, rs6Var2, z2, i3, !rs6Var2.f19408a.equals(rs6Var.f19408a));
        boolean zBooleanValue = ((Boolean) pairV1.first).booleanValue();
        final int iIntValue = ((Integer) pairV1.second).intValue();
        MediaMetadata mediaMetadataQ1 = this.f2516a;
        final g gVar = null;
        if (zBooleanValue) {
            if (!rs6Var.f19408a.w()) {
                gVar = rs6Var.f19408a.t(rs6Var.f19408a.l(((gk5) rs6Var.f19410a).f16805a, this.f2520a).K, ((BasePlayer) this).f30475a).f2199a;
            }
            this.f2555c = MediaMetadata.f2102a;
        }
        if (zBooleanValue || !rs6Var2.f19413a.equals(rs6Var.f19413a)) {
            this.f2555c = this.f2555c.b().J(rs6Var.f19413a).F();
            mediaMetadataQ1 = q1();
        }
        boolean z3 = !mediaMetadataQ1.equals(this.f2516a);
        this.f2516a = mediaMetadataQ1;
        boolean z4 = rs6Var2.f19417b != rs6Var.f19417b;
        boolean z5 = rs6Var2.f44526a != rs6Var.f44526a;
        if (z5 || z4) {
            B2();
        }
        boolean z6 = rs6Var2.f19414a;
        boolean z7 = rs6Var.f19414a;
        boolean z8 = z6 != z7;
        if (z8) {
            A2(z7);
        }
        if (!rs6Var2.f19408a.equals(rs6Var.f19408a)) {
            this.f2532a.j(0, new ListenerSet.Event() { // from class: com.zj.adlib.la3
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.U1(rs6Var, i, (Player.Listener) obj);
                }
            });
        }
        if (z2) {
            final Player.d dVarB1 = B1(i3, rs6Var2, i4);
            final Player.d dVarA1 = A1(j);
            this.f2532a.j(11, new ListenerSet.Event() { // from class: com.zj.adlib.p93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.V1(i3, dVarB1, dVarA1, (Player.Listener) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.f2532a.j(1, new ListenerSet.Event() { // from class: com.zj.adlib.q93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).F(gVar, iIntValue);
                }
            });
        }
        if (rs6Var2.f19407a != rs6Var.f19407a) {
            this.f2532a.j(10, new ListenerSet.Event() { // from class: com.zj.adlib.r93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.X1(rs6Var, (Player.Listener) obj);
                }
            });
            if (rs6Var.f19407a != null) {
                this.f2532a.j(10, new ListenerSet.Event() { // from class: com.zj.adlib.s93
                    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        b.Y1(rs6Var, (Player.Listener) obj);
                    }
                });
            }
        }
        wa9 wa9Var = rs6Var2.f19412a;
        wa9 wa9Var2 = rs6Var.f19412a;
        if (wa9Var != wa9Var2) {
            this.f2528a.d(wa9Var2.f20398a);
            this.f2532a.j(2, new ListenerSet.Event() { // from class: com.zj.adlib.t93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.Z1(rs6Var, (Player.Listener) obj);
                }
            });
        }
        if (z3) {
            final MediaMetadata mediaMetadata = this.f2516a;
            this.f2532a.j(14, new ListenerSet.Event() { // from class: com.zj.adlib.v93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).x(mediaMetadata);
                }
            });
        }
        if (z8) {
            this.f2532a.j(3, new ListenerSet.Event() { // from class: com.zj.adlib.w93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.b2(rs6Var, (Player.Listener) obj);
                }
            });
        }
        if (z5 || z4) {
            this.f2532a.j(-1, new ListenerSet.Event() { // from class: com.zj.adlib.x93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.c2(rs6Var, (Player.Listener) obj);
                }
            });
        }
        if (z5) {
            this.f2532a.j(4, new ListenerSet.Event() { // from class: com.zj.adlib.y93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.d2(rs6Var, (Player.Listener) obj);
                }
            });
        }
        if (z4) {
            this.f2532a.j(5, new ListenerSet.Event() { // from class: com.zj.adlib.j93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.e2(rs6Var, i2, (Player.Listener) obj);
                }
            });
        }
        if (rs6Var2.b != rs6Var.b) {
            this.f2532a.j(6, new ListenerSet.Event() { // from class: com.zj.adlib.k93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.f2(rs6Var, (Player.Listener) obj);
                }
            });
        }
        if (F1(rs6Var2) != F1(rs6Var)) {
            this.f2532a.j(7, new ListenerSet.Event() { // from class: com.zj.adlib.l93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.g2(rs6Var, (Player.Listener) obj);
                }
            });
        }
        if (!rs6Var2.f19409a.equals(rs6Var.f19409a)) {
            this.f2532a.j(12, new ListenerSet.Event() { // from class: com.zj.adlib.m93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    b.h2(rs6Var, (Player.Listener) obj);
                }
            });
        }
        if (z) {
            this.f2532a.j(-1, new ListenerSet.Event() { // from class: com.zj.adlib.n93
                @Override // com.google.android.exoplayer2.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onSeekProcessed();
                }
            });
        }
        x2();
        this.f2532a.g();
        if (rs6Var2.f19419c != rs6Var.f19419c) {
            Iterator<ExoPlayer.AudioOffloadListener> it = this.f2548a.iterator();
            while (it.hasNext()) {
                it.next().onExperimentalSleepingForOffloadChanged(rs6Var.f19419c);
            }
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(int i, List<MediaSource> list) {
        C2();
        sb0.a(i >= 0);
        Timeline timelineA0 = a0();
        this.Q0++;
        List<MediaSourceList.c> listP1 = p1(i, list);
        Timeline timelineS1 = s1();
        rs6 rs6VarI2 = i2(this.f2542a, timelineS1, y1(timelineA0, timelineS1));
        this.f2515a.j(i, listP1, this.f2527a);
        z2(rs6VarI2, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<g> list, int i, long j) {
        C2();
        setMediaSources(t1(list), i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, boolean z) {
        C2();
        r2(list, -1, -9223372036854775807L, z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z) {
        C2();
        this.f2512a.q(getPlayWhenReady(), 1);
        w2(z, null);
        this.f2545a = xy1.f20750a;
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurface(@Nullable Surface surface) {
        C2();
        if (surface == null || surface != this.f2546a) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, int i, long j) {
        C2();
        r2(list, i, j, false);
    }
}
