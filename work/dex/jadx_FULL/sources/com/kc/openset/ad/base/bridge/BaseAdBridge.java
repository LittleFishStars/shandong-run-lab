package com.kc.openset.ad.base.bridge;

import android.app.Activity;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.DummyBtnConfig;
import com.kc.openset.bean.Orientation;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseAdBridge implements AdBridge {
    protected static final int DEFAULT_AD_CACHE_TIME = 3000000;
    private static final int DEFAULT_REQUEST_TIMEOUT = 5000;
    private BridgeInterface bridgeInterface;

    static {
        OSETSDKProtected.interface11(3773);
    }

    public native void bindBridgeInterface(BridgeInterface bridgeInterface);

    public native void doAdLoadFailed(int i, String str);

    public native void doAdLoadFailed(String str);

    public native void doAdLoadFailed(String str, String str2);

    public native void doAdLoadFailed(String str, Throwable th);

    public native void doAdLoadSuccess();

    public native void doAdShowFail(int i, String str);

    public native void doAdShowFail(String str);

    public native void doAdShowFail(String str, String str2);

    public native void doAdSkip();

    public native void doBidFail();

    public native void doBidFail(String str);

    public native void doBidSuccess();

    public native void doBidSuccess(String str);

    public native Activity getActivity();

    public native int getAdObjIsNullBidDefaultPrice();

    public native double getAdWhRatio();

    public native int[] getAdWhSize();

    public native BridgeInterface getBridgeInterface();

    public native double getCommissionPrice();

    public native Context getContext();

    public native int getDefaultCacheTime();

    public native int getDefaultLoadTimeout();

    public native double getDiscount();

    public native DummyBtnConfig getDummyBtnConfig();

    public native String getErrorTypeLoad();

    public native String getErrorTypeOther();

    public native String getErrorTypePlay();

    public native int getExceptionBidDefaultPrice();

    public native String getMediaUid();

    public native Orientation getOrientation();

    public native String getPosId();

    public native int getPrice();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native OSETQDNativeViewAd getQDNativeViewAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getRawEcpm();

    public native String getReplaceMaxNetwork();

    public native double getReplaceMaxPrice();

    public native double getReplacePrice();

    public native String getRequestId();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getS2SInfo();

    public native String getSsAdId();

    public native long getStartCacheTime();

    public native double getSubsidyRatio();

    public native int[] getTiltSensorSen();

    public native String getToken();

    public native int getUpr();

    public native String getUserId();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isBindActivityLifeCycle();

    public native boolean isChangePrice();

    public native boolean isClickCallback();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isDealWithByAdvertisers();

    public native boolean isFilter();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isInitBeforeLoad();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    public native boolean isLoadSuccess();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityDestroyed();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityPaused();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityResumed();

    public native void requestErrorLogUpLoad(String str, String str2);

    public native void requestErrorLogUpLoad(String str, String str2, String str3);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    public native void updateParentAdKey(String str);

    public native void updateSonPlat(String str);
}
