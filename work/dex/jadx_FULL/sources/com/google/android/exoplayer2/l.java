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
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.c;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.zj.adlib.ga9;
import com.zj.adlib.hp9;
import com.zj.adlib.na9;
import com.zj.adlib.p82;
import com.zj.adlib.pi0;
import com.zj.adlib.ps1;
import com.zj.adlib.w38;
import com.zj.adlib.xy1;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public class l extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f30759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ps1 f3403a;

    @Deprecated
    public l(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z, Clock clock, Looper looper) {
        this(new ExoPlayer.a(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector).o0(z).Y(clock).d0(looper));
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    @Deprecated
    public ExoPlayer.TextComponent A() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Renderer B(int i) {
        l0();
        return this.f30759a.B(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void C(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        l0();
        this.f30759a.C(audioOffloadListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void D(MediaSource mediaSource) {
        l0();
        this.f30759a.D(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public d F() {
        l0();
        return this.f30759a.F();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void G(MediaSource mediaSource, long j) {
        l0();
        this.f30759a.G(mediaSource, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void H(@Nullable w38 w38Var) {
        l0();
        this.f30759a.H(w38Var);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public TrackSelector I() {
        l0();
        return this.f30759a.I();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void J(MediaSource mediaSource, boolean z, boolean z2) {
        l0();
        this.f30759a.J(mediaSource, z, z2);
    }

    @Override // com.google.android.exoplayer2.Player
    public c K() {
        l0();
        return this.f30759a.K();
    }

    @Override // com.google.android.exoplayer2.Player
    public void L(c cVar) {
        l0();
        this.f30759a.L(cVar);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public d M() {
        l0();
        return this.f30759a.M();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void N(@Nullable PriorityTaskManager priorityTaskManager) {
        l0();
        this.f30759a.N(priorityTaskManager);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Clock O() {
        l0();
        return this.f30759a.O();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public AnalyticsCollector P() {
        l0();
        return this.f30759a.P();
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.b Q() {
        l0();
        return this.f30759a.Q();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void R(ShuffleOrder shuffleOrder) {
        l0();
        this.f30759a.R(shuffleOrder);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void S(int i, MediaSource mediaSource) {
        l0();
        this.f30759a.S(i, mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void T(AnalyticsListener analyticsListener) {
        l0();
        this.f30759a.T(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void V(Player.Listener listener) {
        l0();
        this.f30759a.V(listener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public na9 W() {
        l0();
        return this.f30759a.W();
    }

    @Override // com.google.android.exoplayer2.Player
    public void X(MediaMetadata mediaMetadata) {
        l0();
        this.f30759a.X(mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    /* JADX INFO: renamed from: Y */
    public ExoPlaybackException f() {
        l0();
        return this.f30759a.f();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void a(CameraMotionListener cameraMotionListener) {
        l0();
        this.f30759a.a(cameraMotionListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline a0() {
        l0();
        return this.f30759a.a0();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, List<g> list) {
        l0();
        this.f30759a.addMediaItems(i, list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(List<MediaSource> list) {
        l0();
        this.f30759a.addMediaSources(list);
    }

    @Override // com.google.android.exoplayer2.Player
    public j b() {
        l0();
        return this.f30759a.b();
    }

    @Override // com.google.android.exoplayer2.Player
    public void c(j jVar) {
        l0();
        this.f30759a.c(jVar);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void c0(MediaSource mediaSource) {
        l0();
        this.f30759a.c0(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void clearAuxEffectInfo() {
        l0();
        this.f30759a.clearAuxEffectInfo();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurface() {
        l0();
        this.f30759a.clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        l0();
        this.f30759a.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        l0();
        this.f30759a.clearVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        l0();
        this.f30759a.clearVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public com.google.android.exoplayer2.audio.a d() {
        l0();
        return this.f30759a.d();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void d0(AnalyticsListener analyticsListener) {
        l0();
        this.f30759a.d0(analyticsListener);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void decreaseDeviceVolume() {
        l0();
        this.f30759a.decreaseDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void e(pi0 pi0Var) {
        l0();
        this.f30759a.e(pi0Var);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    @Deprecated
    public ExoPlayer.DeviceComponent e0() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean experimentalIsSleepingForOffload() {
        l0();
        return this.f30759a.experimentalIsSleepingForOffload();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        l0();
        this.f30759a.experimentalSetOffloadSchedulingEnabled(z);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public DeviceInfo g() {
        l0();
        return this.f30759a.g();
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        l0();
        return this.f30759a.getApplicationLooper();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public int getAudioSessionId() {
        l0();
        return this.f30759a.getAudioSessionId();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        l0();
        return this.f30759a.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        l0();
        return this.f30759a.getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        l0();
        return this.f30759a.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        l0();
        return this.f30759a.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        l0();
        return this.f30759a.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentMediaItemIndex() {
        l0();
        return this.f30759a.getCurrentMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        l0();
        return this.f30759a.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        l0();
        return this.f30759a.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public int getDeviceVolume() {
        l0();
        return this.f30759a.getDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        l0();
        return this.f30759a.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getMaxSeekToPreviousPosition() {
        l0();
        return this.f30759a.getMaxSeekToPreviousPosition();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        l0();
        return this.f30759a.getPauseAtEndOfMediaItems();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        l0();
        return this.f30759a.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        l0();
        return this.f30759a.getPlaybackLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        l0();
        return this.f30759a.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        l0();
        return this.f30759a.getPlaybackSuppressionReason();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getRendererCount() {
        l0();
        return this.f30759a.getRendererCount();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public int getRendererType(int i) {
        l0();
        return this.f30759a.getRendererType(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        l0();
        return this.f30759a.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekBackIncrement() {
        l0();
        return this.f30759a.getSeekBackIncrement();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekForwardIncrement() {
        l0();
        return this.f30759a.getSeekForwardIncrement();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        l0();
        return this.f30759a.getShuffleModeEnabled();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public boolean getSkipSilenceEnabled() {
        l0();
        return this.f30759a.getSkipSilenceEnabled();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        l0();
        return this.f30759a.getTotalBufferedDuration();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public int getVideoChangeFrameRateStrategy() {
        l0();
        return this.f30759a.getVideoChangeFrameRateStrategy();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public int getVideoScalingMode() {
        l0();
        return this.f30759a.getVideoScalingMode();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public float getVolume() {
        l0();
        return this.f30759a.getVolume();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void h(com.google.android.exoplayer2.audio.a aVar, boolean z) {
        l0();
        this.f30759a.h(aVar, z);
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata h0() {
        l0();
        return this.f30759a.h0();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void i(CameraMotionListener cameraMotionListener) {
        l0();
        this.f30759a.i(cameraMotionListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage i0(PlayerMessage.Target target) {
        l0();
        return this.f30759a.i0(target);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void increaseDeviceVolume() {
        l0();
        this.f30759a.increaseDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public boolean isDeviceMuted() {
        l0();
        return this.f30759a.isDeviceMuted();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        l0();
        return this.f30759a.isLoading();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        l0();
        return this.f30759a.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public hp9 j() {
        l0();
        return this.f30759a.j();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void k(VideoFrameMetadataListener videoFrameMetadataListener) {
        l0();
        this.f30759a.k(videoFrameMetadataListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void l(VideoFrameMetadataListener videoFrameMetadataListener) {
        l0();
        this.f30759a.l(videoFrameMetadataListener);
    }

    public final void l0() {
        this.f3403a.c();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.TextComponent
    public xy1 m() {
        l0();
        return this.f30759a.m();
    }

    public void m0(boolean z) {
        l0();
        this.f30759a.u2(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        l0();
        this.f30759a.moveMediaItems(i, i2, i3);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void n(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        l0();
        this.f30759a.n(audioOffloadListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public ga9 o() {
        l0();
        return this.f30759a.o();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public p82 p() {
        l0();
        return this.f30759a.p();
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        l0();
        this.f30759a.prepare();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void q(MediaSource mediaSource) {
        l0();
        this.f30759a.q(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    public p82 r() {
        l0();
        return this.f30759a.r();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        l0();
        this.f30759a.release();
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        l0();
        this.f30759a.removeMediaItems(i, i2);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void retry() {
        l0();
        this.f30759a.retry();
    }

    @Override // com.google.android.exoplayer2.Player
    public p s() {
        l0();
        return this.f30759a.s();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        l0();
        this.f30759a.seekTo(i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setAudioSessionId(int i) {
        l0();
        this.f30759a.setAudioSessionId(i);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void setDeviceMuted(boolean z) {
        l0();
        this.f30759a.setDeviceMuted(z);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void setDeviceVolume(int i) {
        l0();
        this.f30759a.setDeviceVolume(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        l0();
        this.f30759a.setForegroundMode(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setHandleAudioBecomingNoisy(boolean z) {
        l0();
        this.f30759a.setHandleAudioBecomingNoisy(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Deprecated
    public void setHandleWakeLock(boolean z) {
        l0();
        this.f30759a.setHandleWakeLock(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<g> list, boolean z) {
        l0();
        this.f30759a.setMediaItems(list, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list) {
        l0();
        this.f30759a.setMediaSources(list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z) {
        l0();
        this.f30759a.setPauseAtEndOfMediaItems(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        l0();
        this.f30759a.setPlayWhenReady(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        l0();
        this.f30759a.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        l0();
        this.f30759a.setShuffleModeEnabled(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setSkipSilenceEnabled(boolean z) {
        l0();
        this.f30759a.setSkipSilenceEnabled(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoChangeFrameRateStrategy(int i) {
        l0();
        this.f30759a.setVideoChangeFrameRateStrategy(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoScalingMode(int i) {
        l0();
        this.f30759a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurface(@Nullable Surface surface) {
        l0();
        this.f30759a.setVideoSurface(surface);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        l0();
        this.f30759a.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        l0();
        this.f30759a.setVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoTextureView(@Nullable TextureView textureView) {
        l0();
        this.f30759a.setVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setVolume(float f) {
        l0();
        this.f30759a.setVolume(f);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setWakeMode(int i) {
        l0();
        this.f30759a.setWakeMode(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        l0();
        this.f30759a.stop();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public w38 t() {
        l0();
        return this.f30759a.t();
    }

    @Override // com.google.android.exoplayer2.Player
    public void u(Player.Listener listener) {
        l0();
        this.f30759a.u(listener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    @Deprecated
    public ExoPlayer.AudioComponent w() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @Nullable
    @Deprecated
    public ExoPlayer.VideoComponent x() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void y(MediaSource mediaSource, boolean z) {
        l0();
        this.f30759a.y(mediaSource, z);
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata z() {
        l0();
        return this.f30759a.z();
    }

    @Deprecated
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExoPlayer.a f30760a;

        @Deprecated
        public a(Context context) {
            this.f30760a = new ExoPlayer.a(context);
        }

        @Deprecated
        public l b() {
            return this.f30760a.x();
        }

        @Deprecated
        public a c(long j) {
            this.f30760a.y(j);
            return this;
        }

        @Deprecated
        public a d(AnalyticsCollector analyticsCollector) {
            this.f30760a.V(analyticsCollector);
            return this;
        }

        @Deprecated
        public a e(com.google.android.exoplayer2.audio.a aVar, boolean z) {
            this.f30760a.W(aVar, z);
            return this;
        }

        @Deprecated
        public a f(BandwidthMeter bandwidthMeter) {
            this.f30760a.X(bandwidthMeter);
            return this;
        }

        @VisibleForTesting
        @Deprecated
        public a g(Clock clock) {
            this.f30760a.Y(clock);
            return this;
        }

        @Deprecated
        public a h(long j) {
            this.f30760a.Z(j);
            return this;
        }

        @Deprecated
        public a i(boolean z) {
            this.f30760a.a0(z);
            return this;
        }

        @Deprecated
        public a j(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            this.f30760a.b0(livePlaybackSpeedControl);
            return this;
        }

        @Deprecated
        public a k(LoadControl loadControl) {
            this.f30760a.c0(loadControl);
            return this;
        }

        @Deprecated
        public a l(Looper looper) {
            this.f30760a.d0(looper);
            return this;
        }

        @Deprecated
        public a m(MediaSource.Factory factory) {
            this.f30760a.e0(factory);
            return this;
        }

        @Deprecated
        public a n(boolean z) {
            this.f30760a.f0(z);
            return this;
        }

        @Deprecated
        public a o(@Nullable PriorityTaskManager priorityTaskManager) {
            this.f30760a.g0(priorityTaskManager);
            return this;
        }

        @Deprecated
        public a p(long j) {
            this.f30760a.h0(j);
            return this;
        }

        @Deprecated
        public a q(@IntRange(from = 1) long j) {
            this.f30760a.j0(j);
            return this;
        }

        @Deprecated
        public a r(@IntRange(from = 1) long j) {
            this.f30760a.k0(j);
            return this;
        }

        @Deprecated
        public a s(w38 w38Var) {
            this.f30760a.l0(w38Var);
            return this;
        }

        @Deprecated
        public a t(boolean z) {
            this.f30760a.m0(z);
            return this;
        }

        @Deprecated
        public a u(TrackSelector trackSelector) {
            this.f30760a.n0(trackSelector);
            return this;
        }

        @Deprecated
        public a v(boolean z) {
            this.f30760a.o0(z);
            return this;
        }

        @Deprecated
        public a w(int i) {
            this.f30760a.q0(i);
            return this;
        }

        @Deprecated
        public a x(int i) {
            this.f30760a.r0(i);
            return this;
        }

        @Deprecated
        public a y(int i) {
            this.f30760a.s0(i);
            return this;
        }

        @Deprecated
        public a(Context context, RenderersFactory renderersFactory) {
            this.f30760a = new ExoPlayer.a(context, renderersFactory);
        }

        @Deprecated
        public a(Context context, ExtractorsFactory extractorsFactory) {
            this.f30760a = new ExoPlayer.a(context, new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public a(Context context, RenderersFactory renderersFactory, ExtractorsFactory extractorsFactory) {
            this.f30760a = new ExoPlayer.a(context, renderersFactory, new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public a(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this.f30760a = new ExoPlayer.a(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(int i, List<MediaSource> list) {
        l0();
        this.f30759a.addMediaSources(i, list);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurface(@Nullable Surface surface) {
        l0();
        this.f30759a.clearVideoSurface(surface);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<g> list, int i, long j) {
        l0();
        this.f30759a.setMediaItems(list, i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, boolean z) {
        l0();
        this.f30759a.setMediaSources(list, z);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void stop(boolean z) {
        l0();
        this.f30759a.stop(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(List<MediaSource> list, int i, long j) {
        l0();
        this.f30759a.setMediaSources(list, i, j);
    }

    public l(a aVar) {
        this(aVar.f30760a);
    }

    public l(ExoPlayer.a aVar) {
        ps1 ps1Var = new ps1();
        this.f3403a = ps1Var;
        try {
            this.f30759a = new b(aVar, this);
            ps1Var.f();
        } catch (Throwable th) {
            this.f3403a.f();
            throw th;
        }
    }
}
