package com.kc.aw.lib.interf;

import com.kc.aw._l;
import com.kc.aw.lib.model.AdBidLossReason;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PtgAd {
    void destroy();

    _l getAdFilterAdapter();

    String getAdId();

    String getConsumer();

    long getEcpm();

    int getInteractionType();

    boolean isReady();

    boolean isResourceLoaded();

    void notifyBidLoss(AdBidLossReason adBidLossReason);

    void notifyBidWin(double d, double d2);

    void setAdFilterAdapter(_l _lVar);
}
