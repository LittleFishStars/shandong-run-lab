package com.kwad.sdk.core.video.videoview;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface c {
    boolean OO();

    int getBufferPercentage();

    long getCurrentPosition();

    long getDuration();

    int getMediaPlayerType();

    boolean isIdle();

    boolean isPaused();

    void pause();

    void release();

    void restart();

    void setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a aVar);

    void start();
}
