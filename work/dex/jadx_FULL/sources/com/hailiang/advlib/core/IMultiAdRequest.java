package com.hailiang.advlib.core;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface IMultiAdRequest {
    String getBiddingToken(AdRequestParam adRequestParam);

    void invokeADV(AdRequestParam adRequestParam);
}
