package com.kc.openset.ad.base;

import com.kc.openset.ad.bid.BidAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface BaseOSETAd {
    void bidFail(BidAdInfo bidAdInfo);

    void bidSuccess(BidAdInfo bidAdInfo);

    void destroy();

    int getECPM();

    String getRequestId();

    boolean isUsable();

    void setUserId(String str);
}
