package com.kc.openset.ad.base.bridge;

import android.app.Activity;
import android.view.ViewGroup;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface AdBridge {
    void bidFail(WinAdData winAdData, boolean z);

    void bidSuccess(LossAdData lossAdData);

    void destroyAd();

    String getAdFront();

    Object getAdObj();

    String getAdTitle();

    String getAdUserName();

    String getAdvertisers();

    int getEcpm();

    String getLogTag();

    String getParentAdId();

    OSETQDNativeViewAd getQDNativeViewAd();

    String getRawEcpm();

    String getS2SInfo();

    boolean isBindActivityLifeCycle();

    boolean isDealWithByAdvertisers();

    boolean isInitBeforeLoad();

    boolean isLoadByActivity();

    boolean isUsable();

    void onShowActivityDestroyed();

    void onShowActivityPaused();

    void onShowActivityResumed();

    void toLoadAd();

    void toLoadS2SAd(String str);

    void toShowAd(Activity activity);

    void toShowAd(Activity activity, ViewGroup viewGroup);

    void toShowAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);
}
