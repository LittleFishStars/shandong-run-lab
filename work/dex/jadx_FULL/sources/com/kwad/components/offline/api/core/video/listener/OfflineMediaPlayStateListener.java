package com.kwad.components.offline.api.core.video.listener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface OfflineMediaPlayStateListener {
    void onMediaPlayCompleted();

    void onMediaPlayError(int i, int i2);

    void onMediaPlayPaused();

    void onMediaPlayProgress(long j, long j2);

    void onMediaPlayStart();

    void onMediaPlaying();

    void onMediaPrepared();

    void onMediaPreparing();
}
