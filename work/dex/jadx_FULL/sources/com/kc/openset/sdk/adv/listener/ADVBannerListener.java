package com.kc.openset.sdk.adv.listener;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface ADVBannerListener extends ADVBaseListener {
    void onAdClick(View view);

    void onAdClosed(View view);

    void onAdShow(View view);

    void onAdShowFailure(String str, String str2);
}
