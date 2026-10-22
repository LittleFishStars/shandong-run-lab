package com.kc.openset.ad_embed.wm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.bw.appsdkdex.WMCustomPrivateController;
import com.kc.bw.common.bean.WMLocation;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMCustomController extends WMCustomPrivateController {
    private static final String TAG = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE);

    static {
        OSETSDKProtected.interface11(4184);
    }

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native String getDevImei();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native String getDevMacAddress();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native String getDevOaid();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native WMLocation getLocation();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUseAppList();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUseBootId();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUseInstallPackages();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUseLocation();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUseNetworkState();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUseOaid();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUsePermissionRecordAudio();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUsePhoneState();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUseWifiState();

    @Override // com.kc.bw.appsdkdex.WMCustomPrivateController
    public native boolean isCanUseWriteExternal();
}
