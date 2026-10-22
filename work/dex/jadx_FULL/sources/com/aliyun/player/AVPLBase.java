package com.aliyun.player;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.aliyun.player.nativeclass.CacheConfig;
import com.aliyun.player.nativeclass.JniListPlayerBase;
import com.aliyun.player.nativeclass.MediaInfo;
import com.aliyun.player.nativeclass.PlayerConfig;
import com.aliyun.player.nativeclass.TrackInfo;
import com.aliyun.player.videoview.AliDisplayView;
import com.cicada.player.utils.media.DrmCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AVPLBase implements IListPlayer, IPlayer {
    private JniListPlayerBase mListPlayer;
    private IPlayer mNativePlayer;
    private IPlayer mPrerenderPlayer;

    public AVPLBase(Context context, String str) {
        this.mListPlayer = null;
        this.mNativePlayer = null;
        this.mPrerenderPlayer = null;
        this.mNativePlayer = getNativePlayer(context, str);
        this.mPrerenderPlayer = getPrerenderPlayer(context, str);
        this.mListPlayer = createListPlayer(context, str, this.mNativePlayer.getNativeContextAddr(), this.mPrerenderPlayer.getNativeContextAddr());
    }

    @Override // com.aliyun.player.IPlayer
    public void addExtSubtitle(String str) {
        getCurrentPlayer().addExtSubtitle(str);
    }

    @Override // com.aliyun.player.IListPlayer
    public void clear() {
        this.mListPlayer.clear();
    }

    @Override // com.aliyun.player.IPlayer
    public void clearScreen() {
        getCurrentPlayer().clearScreen();
    }

    public abstract JniListPlayerBase createListPlayer(Context context, String str, long j, long j2);

    @Override // com.aliyun.player.IPlayer
    public TrackInfo currentTrack(int i) {
        return getCurrentPlayer().currentTrack(i);
    }

    @Override // com.aliyun.player.IPlayer
    public TrackInfo currentTrack(TrackInfo.Type type) {
        return getCurrentPlayer().currentTrack(type);
    }

    @Override // com.aliyun.player.IPlayer
    public void enableHardwareDecoder(boolean z) {
        getCurrentPlayer().enableHardwareDecoder(z);
    }

    @Override // com.aliyun.player.IListPlayer
    public void enablePreloadStrategy(IListPlayer.StrategyType strategyType, boolean z) {
        this.mListPlayer.enablePreloadStrategy(strategyType.getValue(), z);
    }

    @Override // com.aliyun.player.IPlayer
    public String getCacheFilePath(String str) {
        return getCurrentPlayer().getCacheFilePath(str);
    }

    @Override // com.aliyun.player.IPlayer
    public String getCacheFilePath(String str, String str2, String str3, int i) {
        return getCurrentPlayer().getCacheFilePath(str, str2, str3, i);
    }

    @Override // com.aliyun.player.IPlayer
    public PlayerConfig getConfig() {
        return getCurrentPlayer().getConfig();
    }

    public JniListPlayerBase getCorePlayer() {
        return this.mListPlayer;
    }

    public IPlayer getCurrentPlayer() {
        return getCurrentPlayerIndex() == 1 ? this.mPrerenderPlayer : this.mNativePlayer;
    }

    public abstract long getCurrentPlayerIndex();

    public IPlayer getCurrentPrerenderPlayer(long j) {
        if (j == 0) {
            return this.mNativePlayer;
        }
        if (j == 1) {
            return this.mPrerenderPlayer;
        }
        return null;
    }

    @Override // com.aliyun.player.IListPlayer
    public String getCurrentUid() {
        return this.mListPlayer.getCurrentUid();
    }

    @Override // com.aliyun.player.IPlayer
    public long getDuration() {
        return getCurrentPlayer().getDuration();
    }

    @Override // com.aliyun.player.IListPlayer
    public int getMaxPreloadMemorySizeMB() {
        return this.mListPlayer.getMaxPreloadMemorySizeMB();
    }

    @Override // com.aliyun.player.IPlayer
    public MediaInfo getMediaInfo() {
        return getCurrentPlayer().getMediaInfo();
    }

    @Override // com.aliyun.player.IPlayer
    public IPlayer.MirrorMode getMirrorMode() {
        return getCurrentPlayer().getMirrorMode();
    }

    @Override // com.aliyun.player.IPlayer
    public long getNativeContextAddr() {
        return this.mNativePlayer.getNativeContextAddr();
    }

    public IPlayer getNativePlayer() {
        return this.mNativePlayer;
    }

    public abstract IPlayer getNativePlayer(Context context, String str);

    @Override // com.aliyun.player.IPlayer
    public Object getOption(IPlayer.Option option) {
        return getCurrentPlayer().getOption(option);
    }

    @Override // com.aliyun.player.IPlayer
    public String getPlayerName() {
        return getCurrentPlayer().getPlayerName();
    }

    public IPlayer getPrerenderPlayer() {
        return this.mPrerenderPlayer;
    }

    public abstract IPlayer getPrerenderPlayer(Context context, String str);

    @Override // com.aliyun.player.IPlayer
    public String getPropertyString(IPlayer.PropertyKey propertyKey) {
        return getCurrentPlayer().getPropertyString(propertyKey);
    }

    @Override // com.aliyun.player.IPlayer
    public IPlayer.RotateMode getRotateMode() {
        return getCurrentPlayer().getRotateMode();
    }

    @Override // com.aliyun.player.IPlayer
    public IPlayer.ScaleMode getScaleMode() {
        return getCurrentPlayer().getScaleMode();
    }

    @Override // com.aliyun.player.IPlayer
    public float getSpeed() {
        return getCurrentPlayer().getSpeed();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoHeight() {
        return getCurrentPlayer().getVideoHeight();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoRotation() {
        return getCurrentPlayer().getVideoRotation();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoWidth() {
        return getCurrentPlayer().getVideoWidth();
    }

    @Override // com.aliyun.player.IPlayer
    public float getVolume() {
        return getCurrentPlayer().getVolume();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isAutoPlay() {
        return getCurrentPlayer().isAutoPlay();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isLoop() {
        return getCurrentPlayer().isLoop();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isMute() {
        return getCurrentPlayer().isMute();
    }

    @Override // com.aliyun.player.IPlayer
    public void pause() {
        getCurrentPlayer().pause();
    }

    @Override // com.aliyun.player.IPlayer
    public void prepare() {
        getCurrentPlayer().prepare();
    }

    @Override // com.aliyun.player.IPlayer
    public void redraw() {
        getCurrentPlayer().redraw();
    }

    @Override // com.aliyun.player.IPlayer
    public void release() {
        this.mListPlayer.release();
        this.mNativePlayer.release();
        this.mPrerenderPlayer.release();
    }

    @Override // com.aliyun.player.IPlayer
    public void reload() {
        getCurrentPlayer().reload();
    }

    @Override // com.aliyun.player.IListPlayer
    public void removeSource(String str) {
        this.mListPlayer.removeSource(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void reset() {
        getCurrentPlayer().reset();
    }

    @Override // com.aliyun.player.IPlayer
    public void seekTo(long j) {
        getCurrentPlayer().seekTo(j);
    }

    @Override // com.aliyun.player.IPlayer
    public void seekTo(long j, IPlayer.SeekMode seekMode) {
        getCurrentPlayer().seekTo(j, seekMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void selectExtSubtitle(int i, boolean z) {
        getCurrentPlayer().selectExtSubtitle(i, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void selectTrack(int i) {
        getCurrentPlayer().selectTrack(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void selectTrack(int i, boolean z) {
        getCurrentPlayer().selectTrack(i, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void sendCustomEvent(String str) {
        getCurrentPlayer().sendCustomEvent(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setAutoPlay(boolean z) {
        getCurrentPlayer().setAutoPlay(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setCacheConfig(CacheConfig cacheConfig) {
        getCurrentPlayer().setCacheConfig(cacheConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setConfig(PlayerConfig playerConfig) {
        IPlayer iPlayer = this.mNativePlayer;
        if (iPlayer != null) {
            iPlayer.setConfig(playerConfig);
        }
        IPlayer iPlayer2 = this.mPrerenderPlayer;
        if (iPlayer2 != null) {
            iPlayer2.setConfig(playerConfig);
        }
    }

    @Override // com.aliyun.player.IPlayer
    public void setDefaultBandWidth(int i) {
        getCurrentPlayer().setDefaultBandWidth(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        getCurrentPlayer().setDisplay(surfaceHolder);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDisplayView(AliDisplayView aliDisplayView) {
        getCurrentPlayer().setDisplayView(aliDisplayView);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDrmCallback(DrmCallback drmCallback) {
        getCurrentPlayer().setDrmCallback(drmCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFastStart(boolean z) {
        getCurrentPlayer().setFastStart(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFilterConfig(FilterConfig filterConfig) {
        getCurrentPlayer().setFilterConfig(filterConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFilterInvalid(String str, boolean z) {
        getCurrentPlayer().setFilterInvalid(str, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setIPResolveType(IPlayer.IPResolveType iPResolveType) {
        getCurrentPlayer().setIPResolveType(iPResolveType);
    }

    @Override // com.aliyun.player.IPlayer
    public void setLoop(boolean z) {
        getCurrentPlayer().setLoop(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMaxAccurateSeekDelta(int i) {
        getCurrentPlayer().setMaxAccurateSeekDelta(i);
    }

    @Override // com.aliyun.player.IListPlayer
    public void setMaxPreloadMemorySizeMB(int i) {
        this.mListPlayer.setMaxPreloadMemorySizeMB(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMirrorMode(IPlayer.MirrorMode mirrorMode) {
        getCurrentPlayer().setMirrorMode(mirrorMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMute(boolean z) {
        getCurrentPlayer().setMute(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnChooseTrackIndexListener(IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener) {
        getCurrentPlayer().setOnChooseTrackIndexListener(onChooseTrackIndexListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        getCurrentPlayer().setOnCompletionListener(onCompletionListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        getCurrentPlayer().setOnErrorListener(onErrorListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        getCurrentPlayer().setOnInfoListener(onInfoListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnLoadingStatusListener(IPlayer.OnLoadingStatusListener onLoadingStatusListener) {
        getCurrentPlayer().setOnLoadingStatusListener(onLoadingStatusListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnPreRenderFrameCallback(IPlayer.OnPreRenderFrameCallback onPreRenderFrameCallback) {
        getCurrentPlayer().setOnPreRenderFrameCallback(onPreRenderFrameCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        getCurrentPlayer().setOnPreparedListener(onPreparedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnRenderFrameCallback(IPlayer.OnRenderFrameCallback onRenderFrameCallback) {
        getCurrentPlayer().setOnRenderFrameCallback(onRenderFrameCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnRenderingStartListener(IPlayer.OnRenderingStartListener onRenderingStartListener) {
        getCurrentPlayer().setOnRenderingStartListener(onRenderingStartListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnReportEventListener(IPlayer.OnReportEventListener onReportEventListener) {
        getCurrentPlayer().setOnReportEventListener(onReportEventListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        getCurrentPlayer().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSeiDataListener(IPlayer.OnSeiDataListener onSeiDataListener) {
        getCurrentPlayer().setOnSeiDataListener(onSeiDataListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSnapShotListener(IPlayer.OnSnapShotListener onSnapShotListener) {
        getCurrentPlayer().setOnSnapShotListener(onSnapShotListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnStateChangedListener(IPlayer.OnStateChangedListener onStateChangedListener) {
        getCurrentPlayer().setOnStateChangedListener(onStateChangedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnStreamSwitchedListener(IPlayer.OnStreamSwitchedListener onStreamSwitchedListener) {
        getCurrentPlayer().setOnStreamSwitchedListener(onStreamSwitchedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSubtitleDisplayListener(IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener) {
        getCurrentPlayer().setOnSubtitleDisplayListener(onSubtitleDisplayListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnTrackChangedListener(IPlayer.OnTrackChangedListener onTrackChangedListener) {
        getCurrentPlayer().setOnTrackChangedListener(onTrackChangedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnTrackReadyListener(IPlayer.OnTrackReadyListener onTrackReadyListener) {
        getCurrentPlayer().setOnTrackReadyListener(onTrackReadyListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnVideoRenderedListener(IPlayer.OnVideoRenderedListener onVideoRenderedListener) {
        getCurrentPlayer().setOnVideoRenderedListener(onVideoRenderedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnVideoSizeChangedListener(IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        getCurrentPlayer().setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOutputAudioChannel(IPlayer.OutputAudioChannel outputAudioChannel) {
        getCurrentPlayer().setOutputAudioChannel(outputAudioChannel);
    }

    @Override // com.aliyun.player.IPlayer
    public void setPreferPlayerName(String str) {
        getCurrentPlayer().setPreferPlayerName(str);
    }

    @Override // com.aliyun.player.IListPlayer
    public void setPreloadCount(int i) {
        this.mListPlayer.setPreloadCount(i);
    }

    @Override // com.aliyun.player.IListPlayer
    public void setPreloadScene(IListPlayer.SceneType sceneType) {
        this.mListPlayer.setPreloadScene(sceneType.getValue());
    }

    @Override // com.aliyun.player.IListPlayer
    public void setPreloadStrategy(IListPlayer.StrategyType strategyType, String str) {
        this.mListPlayer.setPreloadStrategyParam(strategyType.getValue(), str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setRenderFrameCallbackConfig(IPlayer.RenderFrameCallbackConfig renderFrameCallbackConfig) {
        getCurrentPlayer().setRenderFrameCallbackConfig(renderFrameCallbackConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setRotateMode(IPlayer.RotateMode rotateMode) {
        getCurrentPlayer().setRotateMode(rotateMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setScaleMode(IPlayer.ScaleMode scaleMode) {
        getCurrentPlayer().setScaleMode(scaleMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setSpeed(float f) {
        getCurrentPlayer().setSpeed(f);
    }

    @Override // com.aliyun.player.IPlayer
    public void setStreamDelayTime(int i, int i2) {
        getCurrentPlayer().setStreamDelayTime(i, i2);
    }

    @Override // com.aliyun.player.IPlayer
    public void setSurface(Surface surface) {
        getCurrentPlayer().setSurface(surface);
    }

    @Override // com.aliyun.player.IPlayer
    public void setTraceId(String str) {
        getCurrentPlayer().setTraceId(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVideoBackgroundColor(int i) {
        getCurrentPlayer().setVideoBackgroundColor(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVideoTag(int[] iArr) {
        getCurrentPlayer().setVideoTag(iArr);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVolume(float f) {
        getCurrentPlayer().setVolume(f);
    }

    @Override // com.aliyun.player.IPlayer
    public void snapshot() {
        getCurrentPlayer().snapshot();
    }

    @Override // com.aliyun.player.IPlayer
    public void start() {
        getCurrentPlayer().start();
    }

    @Override // com.aliyun.player.IPlayer
    public void stop() {
        getCurrentPlayer().stop();
    }

    @Override // com.aliyun.player.IPlayer
    public void surfaceChanged() {
        getCurrentPlayer().surfaceChanged();
    }

    @Override // com.aliyun.player.IPlayer
    public void switchStream(String str) {
        getCurrentPlayer().switchStream(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void updateFilterConfig(String str, FilterConfig.FilterOptions filterOptions) {
        getCurrentPlayer().updateFilterConfig(str, filterOptions);
    }
}
