package com.kc.dw.core.ad.recycler;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface ExpressMediaListener {
    void onVideoCompleted();

    void onVideoError(int i, String str);

    void onVideoLoaded();

    void onVideoPause();

    void onVideoResume();

    void onVideoStart();
}
