package com.kc.dw.core.ad.fullscreenvideo;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IFullScreenMediaListener {
    void onSkippedVideo();

    void onVideoCompleted();

    void onVideoError();

    void onVideoLoaded();

    void onVideoPause();

    void onVideoResume();

    void onVideoStart();
}
