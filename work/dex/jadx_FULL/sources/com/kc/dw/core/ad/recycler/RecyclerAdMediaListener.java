package com.kc.dw.core.ad.recycler;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface RecyclerAdMediaListener {
    default void onProgressUpdate(long j, long j2) {
    }

    void onVideoCompleted();

    void onVideoError();

    default void onVideoLoaded() {
    }

    void onVideoPause();

    void onVideoResume();

    void onVideoStart();
}
