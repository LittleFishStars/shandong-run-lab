package com.kc.openset.ad_embed.fw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.aw.lib.interf.PtgCustomController;
import com.kc.aw.lib.model.AdLocation;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FWCustomController extends PtgCustomController {
    private static final String TAG = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_SPILT_VOICE_WRITE);

    static {
        OSETSDKProtected.interface11(3908);
    }

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native String getAliBoot();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native String getAliUpdate();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native String getMediaAndroidId();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native String getMediaDeviceImei();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native String getMediaDeviceOaId();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native List<String> getMediaInstalledPackages();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native AdLocation getMediaLocation();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native String getMediaMacAddress();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native boolean isAllowSDKInstallList();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native boolean isAllowSDKObtainAndroidId();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native boolean isAllowSDKObtainLocation();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native boolean isAllowSDKObtainMacAddress();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native boolean isAllowSDKObtainOaId();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native boolean isAllowSDKObtainPhoneInfo();

    @Override // com.kc.aw.lib.interf.PtgCustomController
    public native boolean isAllowSDKObtainWriteExternal();
}
