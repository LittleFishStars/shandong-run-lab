package com.kc.openset.ad.base.bridge.video;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface VideoContentBridge {
    void destroy();

    String getAdFront();

    String getAdvertisers();

    String getLogTag();

    String getParentAdId();

    int getPrice();

    String getRawPrice();

    void loadVideoContent();

    boolean onBackPress();

    void onHiddenChanged(boolean z);

    void onPause();

    void onResume();

    void onTaskError(String str);

    void onTaskFinish();

    void setUserVisibleHint(boolean z);
}
