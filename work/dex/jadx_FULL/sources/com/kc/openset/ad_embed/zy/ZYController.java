package com.kc.openset.ad_embed.zy;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.cw.ad.SSAdSdkController;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYController extends SSAdSdkController {
    static {
        OSETSDKProtected.interface11(4212);
    }

    @Override // com.kc.cw.ad.SSAdSdkController
    public native String getImei();

    @Override // com.kc.cw.ad.SSAdSdkController
    public native String getOaid();

    @Override // com.kc.cw.ad.SSAdSdkController
    public native boolean isCanUsePhoneState();
}
