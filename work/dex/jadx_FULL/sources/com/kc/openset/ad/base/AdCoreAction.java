package com.kc.openset.ad.base;

import android.app.Activity;
import android.view.ViewGroup;
import com.kc.openset.ad.NativeViewConfig;
import com.kc.openset.ad.bid.BidAdInfo;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface AdCoreAction {
    void biddingFail(BidAdInfo bidAdInfo, boolean z);

    void biddingFail(com.kc.openset.ad.d dVar, boolean z);

    void biddingSuccess(BidAdInfo bidAdInfo);

    void biddingSuccess(com.kc.openset.ad.d dVar);

    void destroy();

    int getEcpm();

    String getS2SInfo();

    boolean isUsable();

    void loadAd();

    boolean showAd(Activity activity, ViewGroup viewGroup, OSETBaseListener oSETBaseListener);

    boolean showAd(Activity activity, NativeViewConfig nativeViewConfig, OSETBaseListener oSETBaseListener);
}
