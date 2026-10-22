package com.kc.openset.ad.base;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.bid.BidAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseOSETAdImp implements BaseOSETAd {
    protected static final String SHOWED_ERROR_MESSAGE = OSETSDKProtected.getString2(332);
    protected boolean isReportBidSuccess = false;
    protected boolean isShowed = false;
    protected final com.kc.openset.ad.d mBidFailCacheData;
    protected final com.kc.openset.ad.d mCacheData;

    static {
        OSETSDKProtected.interface11(3755);
    }

    public BaseOSETAdImp(com.kc.openset.ad.d dVar, com.kc.openset.ad.d dVar2) {
        this.mCacheData = dVar;
        this.mBidFailCacheData = dVar2;
    }

    @Override // com.kc.openset.ad.base.BaseOSETAd
    public native void bidFail(BidAdInfo bidAdInfo);

    @Override // com.kc.openset.ad.base.BaseOSETAd
    public native void bidSuccess(BidAdInfo bidAdInfo);

    @Override // com.kc.openset.ad.base.BaseOSETAd
    public native void destroy();

    @Override // com.kc.openset.ad.base.BaseOSETAd
    public native int getECPM();

    @Override // com.kc.openset.ad.base.BaseOSETAd
    public native String getRequestId();

    @Override // com.kc.openset.ad.base.BaseOSETAd
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.BaseOSETAd
    public native void setUserId(String str);
}
