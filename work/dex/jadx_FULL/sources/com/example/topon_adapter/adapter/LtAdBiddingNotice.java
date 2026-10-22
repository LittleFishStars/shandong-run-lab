package com.example.topon_adapter.adapter;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LtAdBiddingNotice implements ATBiddingNotice {
    private final Object mAdObject;
    private Map<String, Object> mCustomData;

    public LtAdBiddingNotice(Object obj) {
        this.mAdObject = obj;
    }

    public Map<String, Object> getCustomData() {
        return this.mCustomData;
    }

    public Object getNativeAd() {
        return this.mAdObject;
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    public void notifyBidDisplay(boolean z, double d) {
    }

    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
    }

    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
    }

    public void setCustomData(Map<String, Object> map) {
        this.mCustomData = map;
    }
}
