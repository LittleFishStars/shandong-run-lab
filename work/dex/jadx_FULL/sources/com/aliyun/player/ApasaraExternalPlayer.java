package com.aliyun.player;

import android.content.Context;
import android.view.Surface;
import com.aliyun.player.nativeclass.MediaInfo;
import com.aliyun.player.nativeclass.Options;
import com.aliyun.player.nativeclass.TrackInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ApasaraExternalPlayer {
    private static List<ApasaraExternalPlayer> externalPlayerList = new ArrayList();

    public enum DecoderType {
        DT_HARDWARE,
        DT_SOFTWARE;

        public int getValue() {
            return ordinal();
        }
    }

    public interface OnAutoPlayStartListener {
        void onAutoPlayStart();
    }

    public interface OnBufferPositionUpdateListener {
        void onBufferPositionUpdate(long j);
    }

    public interface OnCaptureScreenListener {
        void onCaptureScreen(int i, int i2, byte[] bArr);
    }

    public interface OnCompletionListener {
        void onCompletion();
    }

    public interface OnDRMCallback {
        byte[] onRequestKey(String str, byte[] bArr);

        byte[] onRequestProvision(String str, byte[] bArr);
    }

    public interface OnErrorListener {
        void onError(int i, String str);
    }

    public interface OnEventListener {
        void onEvent(int i, String str);
    }

    public interface OnFirstFrameRenderListener {
        void onFirstFrameRender();
    }

    public interface OnLoadStatusListener {
        void onLoadingEnd();

        void onLoadingProgress(int i);

        void onLoadingStart();
    }

    public interface OnLoopingStartListener {
        void onLoopingStart();
    }

    public interface OnPositionUpdateListener {
        void onPositionUpdate(long j);
    }

    public interface OnPreparedListener {
        void onPrepared();
    }

    public interface OnSeekStatusListener {
        void onSeekEnd(boolean z);

        void onSeekStart(boolean z);
    }

    public interface OnStatusChangedListener {
        void onStatusChanged(int i, int i2);
    }

    public interface OnStreamInfoGetListener {
        void OnStreamInfoGet(MediaInfo mediaInfo);
    }

    public interface OnStreamSwitchSucListener {
        void onStreamSwitchSuc(StreamType streamType, TrackInfo trackInfo);
    }

    public interface OnSubtitleListener {
        void onSubtitleExtAdded(int i, String str);

        void onSubtitleHide(int i, long j);

        void onSubtitleShow(int i, long j, String str);
    }

    public interface OnVideoRenderedListener {
        void onVideoRendered(long j, long j2);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2);
    }

    public enum PlayerStatus {
        PLAYER_IDLE(0),
        PLAYER_INITIALZED(1),
        PLAYER_PREPARINIT(2),
        PLAYER_PREPARING(3),
        PLAYER_PREPARED(4),
        PLAYER_PLAYING(5),
        PLAYER_PAUSED(6),
        PLAYER_STOPPED(7),
        PLAYER_COMPLETION(8),
        PLAYER_ERROR(99);

        private int mValue;

        PlayerStatus(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum PropertyKey {
        PROPERTY_KEY_RESPONSE_INFO,
        PROPERTY_KEY_CONNECT_INFO,
        PROPERTY_KEY_OPEN_TIME_STR,
        PROPERTY_KEY_PROBE_STR,
        PROPERTY_KEY_VIDEO_BUFFER_LEN,
        PROPERTY_KEY_DELAY_INFO,
        PROPERTY_KEY_REMAIN_LIVE_SEG,
        PROPERTY_KEY_NETWORK_IS_CONNECTED
    }

    public enum StreamType {
        ST_TYPE_UNKNOWN(-1),
        ST_TYPE_VIDEO(0),
        ST_TYPE_AUDIO(1),
        ST_TYPE_SUB(2);

        private int mValue;

        StreamType(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static ApasaraExternalPlayer isSupportExternal(Options options) {
        for (ApasaraExternalPlayer apasaraExternalPlayer : externalPlayerList) {
            if (apasaraExternalPlayer.isSupport(options)) {
                return apasaraExternalPlayer;
            }
        }
        return null;
    }

    public static void registerExternalPlayer(ApasaraExternalPlayer apasaraExternalPlayer) {
        if (apasaraExternalPlayer != null) {
            externalPlayerList.add(apasaraExternalPlayer);
        }
    }

    public abstract void addCustomHttpHeader(String str);

    public abstract void addExtSubtitle(String str);

    public abstract void captureScreen();

    public abstract ApasaraExternalPlayer create(Context context, Options options);

    public abstract void enterBackGround(boolean z);

    public abstract long getBufferPosition();

    public abstract int getCurrentStreamIndex(StreamType streamType);

    public abstract TrackInfo getCurrentStreamInfo(StreamType streamType);

    public abstract DecoderType getDecoderType();

    public abstract long getDuration();

    public abstract long getMasterClockPts();

    public abstract IPlayer.MirrorMode getMirrorMode();

    public abstract String getName();

    public abstract String getOption(String str);

    public abstract PlayerStatus getPlayerStatus();

    public abstract long getPlayingPosition();

    public abstract long getPropertyInt(PropertyKey propertyKey);

    public abstract long getPropertyLong(PropertyKey propertyKey);

    public abstract String getPropertyString(PropertyKey propertyKey);

    public abstract IPlayer.RotateMode getRotateMode();

    public abstract IPlayer.ScaleMode getScaleMode();

    public abstract float getSpeed();

    public abstract float getVideoDecodeFps();

    public abstract int getVideoHeight();

    public abstract float getVideoRenderFps();

    public abstract int getVideoRotation();

    public abstract int getVideoWidth();

    public abstract float getVolume();

    public abstract int invokeComponent(String str);

    public abstract boolean isAutoPlay();

    public abstract boolean isLooping();

    public abstract boolean isMute();

    public abstract boolean isSupport(Options options);

    public abstract void mute(boolean z);

    public abstract void pause();

    public abstract void prepare();

    public abstract void reLoad();

    public abstract void release();

    public abstract void removeAllCustomHttpHeader();

    public abstract void seekTo(long j, boolean z);

    public abstract int selectExtSubtitle(int i, boolean z);

    public abstract void setAutoPlay(boolean z);

    public abstract void setDataSource(String str);

    public abstract void setDecoderType(DecoderType decoderType);

    public abstract void setDrmCallback(OnDRMCallback onDRMCallback);

    public abstract void setDropBufferThreshold(int i);

    public abstract void setLooping(boolean z);

    public abstract void setMirrorMode(IPlayer.MirrorMode mirrorMode);

    public abstract void setOnAutoPlayStartListener(OnAutoPlayStartListener onAutoPlayStartListener);

    public abstract void setOnBufferPositionUpdateListener(OnBufferPositionUpdateListener onBufferPositionUpdateListener);

    public abstract void setOnCaptureScreenListener(OnCaptureScreenListener onCaptureScreenListener);

    public abstract void setOnCompletionListener(OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(OnErrorListener onErrorListener);

    public abstract void setOnEventListener(OnEventListener onEventListener);

    public abstract void setOnFirstFrameRenderListener(OnFirstFrameRenderListener onFirstFrameRenderListener);

    public abstract void setOnLoadStatusListener(OnLoadStatusListener onLoadStatusListener);

    public abstract void setOnLoopingStartListener(OnLoopingStartListener onLoopingStartListener);

    public abstract void setOnPositionUpdateListener(OnPositionUpdateListener onPositionUpdateListener);

    public abstract void setOnPreparedListener(OnPreparedListener onPreparedListener);

    public abstract void setOnSeekStatusListener(OnSeekStatusListener onSeekStatusListener);

    public abstract void setOnStatusChangedListener(OnStatusChangedListener onStatusChangedListener);

    public abstract void setOnStreamInfoGetListener(OnStreamInfoGetListener onStreamInfoGetListener);

    public abstract void setOnStreamSwitchSucListener(OnStreamSwitchSucListener onStreamSwitchSucListener);

    public abstract void setOnSubtitleListener(OnSubtitleListener onSubtitleListener);

    public abstract void setOnVideoRenderedListener(OnVideoRenderedListener onVideoRenderedListener);

    public abstract void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    public abstract int setOption(String str, String str2);

    public abstract void setRefer(String str);

    public abstract void setRotateMode(IPlayer.RotateMode rotateMode);

    public abstract void setScaleMode(IPlayer.ScaleMode scaleMode);

    public abstract void setSpeed(float f);

    public abstract void setSurface(Surface surface);

    public abstract void setTimeout(int i);

    public abstract void setUserAgent(String str);

    public abstract void setVideoBackgroundColor(long j);

    public abstract void setVolume(float f);

    public abstract void start();

    public abstract void stop();

    public abstract StreamType switchStream(int i);
}
