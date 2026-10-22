package com.aliyun.player;

import com.aliyun.player.nativeclass.PreloadConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface UrlListPlayer extends IListPlayer, UrlPlayer {
    void addUrl(String str, String str2);

    void addUrl(String str, String str2, PreloadConfig preloadConfig);

    IPlayer getPreRenderPlayer();

    boolean moveTo(String str);

    boolean moveToNext();

    boolean moveToNextWithPrerendered();

    boolean moveToPrev();

    void updatePreloadConfig(PreloadConfig preloadConfig);

    void updatePreloadConfig(String str, PreloadConfig preloadConfig);
}
