package com.kc.openset.ad_embed.ks_ad.ks_3_3_72;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kwad.sdk.api.KsCustomController;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KsController extends KsCustomController {
    private static final String TAG = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD);

    static {
        OSETSDKProtected.interface11(4098);
    }

    @Override // com.kwad.sdk.api.KsCustomController
    public native boolean canReadInstalledPackages();

    @Override // com.kwad.sdk.api.KsCustomController
    public native boolean canReadLocation();

    @Override // com.kwad.sdk.api.KsCustomController
    public native boolean canUseMacAddress();

    @Override // com.kwad.sdk.api.KsCustomController
    public native boolean canUseNetworkState();

    @Override // com.kwad.sdk.api.KsCustomController
    public native boolean canUseOaid();

    @Override // com.kwad.sdk.api.KsCustomController
    public native boolean canUsePhoneState();

    @Override // com.kwad.sdk.api.KsCustomController
    public native boolean canUseStoragePermission();

    @Override // com.kwad.sdk.api.KsCustomController
    public native String getAndroidId();

    @Override // com.kwad.sdk.api.KsCustomController
    public native String getImei();

    @Override // com.kwad.sdk.api.KsCustomController
    public native List<String> getInstalledPackages();

    @Override // com.kwad.sdk.api.KsCustomController
    public native String getMacAddress();

    @Override // com.kwad.sdk.api.KsCustomController
    public native String getOaid();
}
