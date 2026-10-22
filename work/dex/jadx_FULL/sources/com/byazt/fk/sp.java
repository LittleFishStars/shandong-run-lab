package com.byazt.fk;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface sp {

    public interface c {
        void onBufferEnd(sp spVar, int i);

        void onBufferStart(sp spVar, int i, int i2, int i3);

        void onBufferingUpdate(sp spVar, int i);

        void onCompletion(sp spVar);

        void onError(sp spVar, ve veVar);

        void onMonitorLog(sp spVar, JSONObject jSONObject, String str);

        void onPause(sp spVar);

        void onPlayPositionUpdate(sp spVar, long j, long j2);

        void onPrepared(sp spVar);

        void onRelease(sp spVar);

        void onRenderStart(sp spVar, long j);

        void onResume(sp spVar);

        void onSeekCompletion(sp spVar, boolean z);

        void onStart(sp spVar);

        void onVideoSizeChanged(sp spVar, int i, int i2);
    }

    void addIVideoPlayerCallback(c cVar);

    int getBufferCount();

    String getCodec();

    long getCurrentPosition();

    SurfaceHolder getSurfaceHolder();

    SurfaceTexture getSurfaceTexture();

    long getTotalBufferTime();

    int getUpdateProgressInterval();

    long getVideoDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isCompleted();

    boolean isFirstFrameSuccess();

    boolean isLooping();

    boolean isPaused();

    boolean isPlaying();

    boolean isPrepared();

    boolean isReleased();

    boolean isStarted();

    void pause();

    void play();

    void release();

    void removeIVideoPlayerCallback(c cVar);

    void reset();

    void restart();

    void seekTo(long j);

    void setDataSource(u uVar);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLoop(boolean z);

    void setPlaySpeedRatio(float f);

    void setQuietPlay(boolean z);

    void setSeekMode(int i);

    void setSurface(SurfaceTexture surfaceTexture);

    void setSurfaceValid(boolean z);

    void setUpdateProgressInterval(int i);

    void start(boolean z, long j, boolean z2);

    void stop();
}
