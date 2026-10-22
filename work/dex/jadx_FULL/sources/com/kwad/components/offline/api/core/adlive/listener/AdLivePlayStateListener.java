package com.kwad.components.offline.api.core.adlive.listener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
