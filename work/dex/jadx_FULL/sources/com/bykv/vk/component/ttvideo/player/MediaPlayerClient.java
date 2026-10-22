package com.bykv.vk.component.ttvideo.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.byazt.nr.m;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public abstract class MediaPlayerClient {
    public static final int IsAudioVoiceWaitTimeout = 1;
    public static final int IsBuffering = 0;
    public static final int MAX_LOG_LINES = 40;

    public abstract void deselectTrack(int i);

    public abstract int getCurrentPosition();

    public String getDataSource() {
        return null;
    }

    public double getDoubleOption(int i, double d) {
        return d;
    }

    public abstract int getDuration();

    public float getFloatOption(int i, float f) {
        return f;
    }

    public int getIntOption(int i, int i2) {
        return i2;
    }

    public long getLongOption(int i, long j) {
        return j;
    }

    public abstract int getSelectedTrack(int i);

    public String getStringOption(int i) {
        return null;
    }

    public abstract MediaPlayer.TrackInfo[] getTrackInfo();

    public abstract int getType();

    public abstract int getVideoHeight();

    public int getVideoType() {
        return 0;
    }

    public abstract int getVideoWidth();

    public abstract boolean isLooping();

    public boolean isMute() {
        return false;
    }

    public abstract boolean isPlaying();

    public void mouseEvent(int i, int i2, int i3) {
    }

    public abstract void pause();

    public abstract void prepare();

    public abstract void prepareAsync();

    @Deprecated
    public abstract void prevClose();

    public abstract void release();

    public abstract void releaseAsync();

    public abstract void reset();

    public void rotateCamera(float f, float f2) {
        m.c(TTPlayerConfiger.TAG, "<MediaPlayerClient.java,rotateCamera,55>rotateCamera is not implemented");
    }

    public abstract void seekTo(int i);

    public abstract void selectTrack(int i);

    public void setCacheFile(String str, int i) {
    }

    public abstract void setDataSource(Context context, Uri uri) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    public abstract void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    public abstract void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException;

    public abstract void setDataSource(String str) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    public abstract void setDisplay(SurfaceHolder surfaceHolder);

    public int setDoubleOption(int i, double d) {
        return -1;
    }

    public int setFloatOption(int i, float f) {
        return -1;
    }

    public abstract void setFrameMetadataListener(FrameMetadataListener frameMetadataListener);

    public int setIntOption(int i, int i2) {
        m.c(TTPlayerConfiger.TAG, "<MediaPlayerClient.java,setIntOption,65>set os player is not inval");
        return -1;
    }

    public void setIsMute(boolean z) {
    }

    public int setLongOption(int i, long j) {
        return -1;
    }

    public abstract void setLooping(boolean z);

    public abstract void setMediaTransport(MediaTransport mediaTransport);

    public abstract void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    public abstract void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener);

    public abstract void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener);

    public abstract void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener);

    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
    }

    public abstract void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener);

    public abstract void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener);

    public abstract void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    public abstract void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    public void setPanoVideoControlModel(int i) {
    }

    public abstract void setPlaybackParams(PlaybackParams playbackParams);

    public abstract void setScreenOnWhilePlaying(boolean z);

    public int setStringOption(int i, String str) {
        return -1;
    }

    public abstract void setSurface(Surface surface);

    public abstract void setVolume(float f, float f2);

    public abstract void setWakeMode(Context context, int i);

    public abstract void start();

    public abstract void stop();

    public abstract void switchStream(int i, int i2);

    public abstract void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener);
}
