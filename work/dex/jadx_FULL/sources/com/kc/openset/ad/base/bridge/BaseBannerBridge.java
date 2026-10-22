package com.kc.openset.ad.base.bridge;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.ViewHolderManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseBannerBridge extends BaseViewBridge {
    static {
        OSETSDKProtected.interface11(3774);
    }

    public native void bannerLoadToShow(View view);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native Object getAdObj();

    public native int getBannerImgRadius();

    public native String getDefaultBg();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewGroup viewGroup);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);
}
