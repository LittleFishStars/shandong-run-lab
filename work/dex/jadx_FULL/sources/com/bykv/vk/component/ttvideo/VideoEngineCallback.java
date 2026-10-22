package com.bykv.vk.component.ttvideo;

import com.bykv.vk.component.ttvideo.utils.Error;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface VideoEngineCallback {
    public static final int AFTER_FIRST_FRAME = 1;
    public static final int BEFORE_FIRST_FRAME = 0;
    public static final int BUFFERING_TYPE_DECODER = 1;
    public static final int BUFFERING_TYPE_NET = 0;

    void onBufferEnd(int i);

    void onBufferStart(int i, int i2, int i3);

    void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i);

    void onCompletion(TTVideoEngine tTVideoEngine);

    void onError(Error error);

    void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i);

    void onMDLHitCache(String str, long j);

    void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i);

    void onPrepare(TTVideoEngine tTVideoEngine);

    void onPrepared(TTVideoEngine tTVideoEngine);

    void onRenderSeekComplete(int i);

    void onRenderStart(TTVideoEngine tTVideoEngine);

    void onRetry(int i);

    void onUseMDLCacheEnd();

    void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2);
}
