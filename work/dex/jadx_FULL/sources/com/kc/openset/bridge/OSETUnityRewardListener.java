package com.kc.openset.bridge;

import com.kc.openset.ad.listener.OSETBaseListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface OSETUnityRewardListener extends OSETBaseListener {
    void onClick();

    void onClose(String str);

    void onReward(String str, int i);

    void onServiceResponse(int i);

    void onShow(String str);

    void onVideoEnd(String str);

    void onVideoStart();
}
