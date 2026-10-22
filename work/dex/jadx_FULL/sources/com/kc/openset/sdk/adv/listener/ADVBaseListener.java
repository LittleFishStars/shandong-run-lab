package com.kc.openset.sdk.adv.listener;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface ADVBaseListener {
    String getUserId();

    void onAdLoadFailure(String str, String str2);

    void onAdLoadSuccess();
}
