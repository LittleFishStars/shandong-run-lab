package com.kc.openset.ad_embed.ms;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.dw.core.SsdAdConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class MSController extends SsdAdConfig.CustomController {
    static {
        OSETSDKProtected.interface11(4156);
    }

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native boolean canReadInstalledPackages();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native boolean canUseMacAddress();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native boolean canUseNetworkState();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native boolean canUseStoragePermission();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native String getAndroidId();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native String getDevImei();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native String getMacAddress();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native String getOaid();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native boolean isCanUseAndroidId();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native boolean isCanUseImsi();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native boolean isCanUseLocation();

    @Override // com.kc.dw.core.SsdAdConfig.CustomController
    public native boolean isCanUsePhoneState();
}
