package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.c;
import com.zj.adlib.hp9;
import com.zj.adlib.xy1;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class e implements Player {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Player f30612a;

    public static final class a implements Player.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Player.Listener f30613a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final e f2689a;

        public a(e eVar, Player.Listener listener) {
            this.f2689a = eVar;
            this.f30613a = listener;
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void A(DeviceInfo deviceInfo) {
            this.f30613a.A(deviceInfo);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void B(com.google.android.exoplayer2.audio.a aVar) {
            this.f30613a.B(aVar);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void C(Player.d dVar, Player.d dVar2, int i) {
            this.f30613a.C(dVar, dVar2, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void E(Player.b bVar) {
            this.f30613a.E(bVar);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void F(@Nullable g gVar, int i) {
            this.f30613a.F(gVar, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void G(p pVar) {
            this.f30613a.G(pVar);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void H(@Nullable PlaybackException playbackException) {
            this.f30613a.H(playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void b(Metadata metadata) {
            this.f30613a.b(metadata);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f2689a.equals(aVar.f2689a)) {
                return this.f30613a.equals(aVar.f30613a);
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void g(j jVar) {
            this.f30613a.g(jVar);
        }

        public int hashCode() {
            return (this.f2689a.hashCode() * 31) + this.f30613a.hashCode();
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void j(xy1 xy1Var) {
            this.f30613a.j(xy1Var);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onAudioSessionIdChanged(int i) {
            this.f30613a.onAudioSessionIdChanged(i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onCues(List<Cue> list) {
            this.f30613a.onCues(list);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onDeviceVolumeChanged(int i, boolean z) {
            this.f30613a.onDeviceVolumeChanged(i, z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onIsLoadingChanged(boolean z) {
            this.f30613a.onIsLoadingChanged(z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onIsPlayingChanged(boolean z) {
            this.f30613a.onIsPlayingChanged(z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onLoadingChanged(boolean z) {
            this.f30613a.onIsLoadingChanged(z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onMaxSeekToPreviousPositionChanged(long j) {
            this.f30613a.onMaxSeekToPreviousPositionChanged(j);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            this.f30613a.onPlayWhenReadyChanged(z, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlaybackStateChanged(int i) {
            this.f30613a.onPlaybackStateChanged(i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlaybackSuppressionReasonChanged(int i) {
            this.f30613a.onPlaybackSuppressionReasonChanged(i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlayerError(PlaybackException playbackException) {
            this.f30613a.onPlayerError(playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlayerStateChanged(boolean z, int i) {
            this.f30613a.onPlayerStateChanged(z, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPositionDiscontinuity(int i) {
            this.f30613a.onPositionDiscontinuity(i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onRenderedFirstFrame() {
            this.f30613a.onRenderedFirstFrame();
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onRepeatModeChanged(int i) {
            this.f30613a.onRepeatModeChanged(i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onSeekBackIncrementChanged(long j) {
            this.f30613a.onSeekBackIncrementChanged(j);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onSeekForwardIncrementChanged(long j) {
            this.f30613a.onSeekForwardIncrementChanged(j);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onSeekProcessed() {
            this.f30613a.onSeekProcessed();
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onShuffleModeEnabledChanged(boolean z) {
            this.f30613a.onShuffleModeEnabledChanged(z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onSkipSilenceEnabledChanged(boolean z) {
            this.f30613a.onSkipSilenceEnabledChanged(z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onSurfaceSizeChanged(int i, int i2) {
            this.f30613a.onSurfaceSizeChanged(i, i2);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onVideoSizeChanged(hp9 hp9Var) {
            this.f30613a.onVideoSizeChanged(hp9Var);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onVolumeChanged(float f) {
            this.f30613a.onVolumeChanged(f);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void q(c cVar) {
            this.f30613a.q(cVar);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void r(Timeline timeline, int i) {
            this.f30613a.r(timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void t(Player player, Player.c cVar) {
            this.f30613a.t(this.f2689a, cVar);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void x(MediaMetadata mediaMetadata) {
            this.f30613a.x(mediaMetadata);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void z(MediaMetadata mediaMetadata) {
            this.f30613a.z(mediaMetadata);
        }
    }

    public e(Player player) {
        this.f30612a = player;
    }

    @Override // com.google.android.exoplayer2.Player
    public void E(int i, g gVar) {
        this.f30612a.E(i, gVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public c K() {
        return this.f30612a.K();
    }

    @Override // com.google.android.exoplayer2.Player
    public void L(c cVar) {
        this.f30612a.L(cVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.b Q() {
        return this.f30612a.Q();
    }

    @Override // com.google.android.exoplayer2.Player
    public void U(g gVar, boolean z) {
        this.f30612a.U(gVar, z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void V(Player.Listener listener) {
        this.f30612a.V(new a(this, listener));
    }

    @Override // com.google.android.exoplayer2.Player
    public void X(MediaMetadata mediaMetadata) {
        this.f30612a.X(mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public g Z() {
        return this.f30612a.Z();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline a0() {
        return this.f30612a.a0();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(List<g> list) {
        this.f30612a.addMediaItems(list);
    }

    @Override // com.google.android.exoplayer2.Player
    public j b() {
        return this.f30612a.b();
    }

    @Override // com.google.android.exoplayer2.Player
    public void b0(g gVar) {
        this.f30612a.b0(gVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public void c(j jVar) {
        this.f30612a.c(jVar);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean canAdvertiseSession() {
        return this.f30612a.canAdvertiseSession();
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearMediaItems() {
        this.f30612a.clearMediaItems();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurface() {
        this.f30612a.clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        this.f30612a.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        this.f30612a.clearVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoTextureView(@Nullable TextureView textureView) {
        this.f30612a.clearVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public com.google.android.exoplayer2.audio.a d() {
        return this.f30612a.d();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void decreaseDeviceVolume() {
        this.f30612a.decreaseDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public PlaybackException f() {
        return this.f30612a.f();
    }

    @Override // com.google.android.exoplayer2.Player
    public void f0(g gVar) {
        this.f30612a.f0(gVar);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public DeviceInfo g() {
        return this.f30612a.g();
    }

    @Override // com.google.android.exoplayer2.Player
    public void g0(g gVar, long j) {
        this.f30612a.g0(gVar, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.f30612a.getApplicationLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getBufferedPercentage() {
        return this.f30612a.getBufferedPercentage();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        return this.f30612a.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        return this.f30612a.getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentDuration() {
        return this.f30612a.getContentDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        return this.f30612a.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        return this.f30612a.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        return this.f30612a.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentLiveOffset() {
        return this.f30612a.getCurrentLiveOffset();
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public Object getCurrentManifest() {
        return this.f30612a.getCurrentManifest();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentMediaItemIndex() {
        return this.f30612a.getCurrentMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        return this.f30612a.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        return this.f30612a.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public int getCurrentWindowIndex() {
        return this.f30612a.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public int getDeviceVolume() {
        return this.f30612a.getDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        return this.f30612a.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getMaxSeekToPreviousPosition() {
        return this.f30612a.getMaxSeekToPreviousPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getMediaItemCount() {
        return this.f30612a.getMediaItemCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getNextMediaItemIndex() {
        return this.f30612a.getNextMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public int getNextWindowIndex() {
        return this.f30612a.getNextWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.f30612a.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.f30612a.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return this.f30612a.getPlaybackSuppressionReason();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPreviousMediaItemIndex() {
        return this.f30612a.getPreviousMediaItemIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public int getPreviousWindowIndex() {
        return this.f30612a.getPreviousWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.f30612a.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekBackIncrement() {
        return this.f30612a.getSeekBackIncrement();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getSeekForwardIncrement() {
        return this.f30612a.getSeekForwardIncrement();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.f30612a.getShuffleModeEnabled();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        return this.f30612a.getTotalBufferedDuration();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public float getVolume() {
        return this.f30612a.getVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata h0() {
        return this.f30612a.h0();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean hasNext() {
        return this.f30612a.hasNext();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean hasNextMediaItem() {
        return this.f30612a.hasNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean hasNextWindow() {
        return this.f30612a.hasNextWindow();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean hasPrevious() {
        return this.f30612a.hasPrevious();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean hasPreviousMediaItem() {
        return this.f30612a.hasPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean hasPreviousWindow() {
        return this.f30612a.hasPreviousWindow();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void increaseDeviceVolume() {
        this.f30612a.increaseDeviceVolume();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCommandAvailable(int i) {
        return this.f30612a.isCommandAvailable(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentMediaItemDynamic() {
        return this.f30612a.isCurrentMediaItemDynamic();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentMediaItemLive() {
        return this.f30612a.isCurrentMediaItemLive();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentMediaItemSeekable() {
        return this.f30612a.isCurrentMediaItemSeekable();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean isCurrentWindowDynamic() {
        return this.f30612a.isCurrentWindowDynamic();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean isCurrentWindowLive() {
        return this.f30612a.isCurrentWindowLive();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public boolean isCurrentWindowSeekable() {
        return this.f30612a.isCurrentWindowSeekable();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public boolean isDeviceMuted() {
        return this.f30612a.isDeviceMuted();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return this.f30612a.isLoading();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlaying() {
        return this.f30612a.isPlaying();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return this.f30612a.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public hp9 j() {
        return this.f30612a.j();
    }

    public Player j0() {
        return this.f30612a;
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.TextComponent
    public xy1 m() {
        return this.f30612a.m();
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItem(int i, int i2) {
        this.f30612a.moveMediaItem(i, i2);
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        this.f30612a.moveMediaItems(i, i2, i3);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void next() {
        this.f30612a.next();
    }

    @Override // com.google.android.exoplayer2.Player
    public void pause() {
        this.f30612a.pause();
    }

    @Override // com.google.android.exoplayer2.Player
    public void play() {
        this.f30612a.play();
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        this.f30612a.prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void previous() {
        this.f30612a.previous();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        this.f30612a.release();
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItem(int i) {
        this.f30612a.removeMediaItem(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        this.f30612a.removeMediaItems(i, i2);
    }

    @Override // com.google.android.exoplayer2.Player
    public p s() {
        return this.f30612a.s();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekBack() {
        this.f30612a.seekBack();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekForward() {
        this.f30612a.seekForward();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(long j) {
        this.f30612a.seekTo(j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition() {
        this.f30612a.seekToDefaultPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToNext() {
        this.f30612a.seekToNext();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToNextMediaItem() {
        this.f30612a.seekToNextMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void seekToNextWindow() {
        this.f30612a.seekToNextWindow();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToPrevious() {
        this.f30612a.seekToPrevious();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToPreviousMediaItem() {
        this.f30612a.seekToPreviousMediaItem();
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void seekToPreviousWindow() {
        this.f30612a.seekToPreviousWindow();
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void setDeviceMuted(boolean z) {
        this.f30612a.setDeviceMuted(z);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.DeviceComponent
    public void setDeviceVolume(int i) {
        this.f30612a.setDeviceVolume(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<g> list) {
        this.f30612a.setMediaItems(list);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        this.f30612a.setPlayWhenReady(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackSpeed(float f) {
        this.f30612a.setPlaybackSpeed(f);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        this.f30612a.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        this.f30612a.setShuffleModeEnabled(z);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurface(@Nullable Surface surface) {
        this.f30612a.setVideoSurface(surface);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        this.f30612a.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        this.f30612a.setVideoSurfaceView(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void setVideoTextureView(@Nullable TextureView textureView) {
        this.f30612a.setVideoTextureView(textureView);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.AudioComponent
    public void setVolume(float f) {
        this.f30612a.setVolume(f);
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        this.f30612a.stop();
    }

    @Override // com.google.android.exoplayer2.Player
    public void u(Player.Listener listener) {
        this.f30612a.u(new a(this, listener));
    }

    @Override // com.google.android.exoplayer2.Player
    public g v(int i) {
        return this.f30612a.v(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata z() {
        return this.f30612a.z();
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, List<g> list) {
        this.f30612a.addMediaItems(i, list);
    }

    @Override // com.google.android.exoplayer2.Player, com.google.android.exoplayer2.ExoPlayer.VideoComponent
    public void clearVideoSurface(@Nullable Surface surface) {
        this.f30612a.clearVideoSurface(surface);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        this.f30612a.seekTo(i, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition(int i) {
        this.f30612a.seekToDefaultPosition(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<g> list, boolean z) {
        this.f30612a.setMediaItems(list, z);
    }

    @Override // com.google.android.exoplayer2.Player
    @Deprecated
    public void stop(boolean z) {
        this.f30612a.stop(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(List<g> list, int i, long j) {
        this.f30612a.setMediaItems(list, i, j);
    }
}
