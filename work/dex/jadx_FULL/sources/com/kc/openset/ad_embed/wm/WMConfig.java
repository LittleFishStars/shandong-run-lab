package com.kc.openset.ad_embed.wm;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMConfig extends BaseConfig {
    public static final String ADVERTISERS = OSETSDKProtected.getString2(873);
    public static final String ADVERTISERS_NAME = OSETSDKProtected.getString2(878);
    private static final String CHECK_PACKAGE = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE);
    public static final String FRONT = OSETSDKProtected.getString2(872);
    private static final String MINI_SUPPORT_KS_VERSION = OSETSDKProtected.getString2(879);
    private static final String TAG = OSETSDKProtected.getString2(875);

    static {
        OSETSDKProtected.interface11(4183);
    }

    @Override // com.kc.openset.advertisers.bash.BaseConfig
    public native void addAdapter();

    @Override // com.kc.openset.advertisers.bash.BaseConfig
    public native String getCurrentVersion();

    @Override // com.kc.openset.advertisers.bash.BaseConfig
    public native void init(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseConfig
    public native void initialize();

    @Override // com.kc.openset.advertisers.bash.BaseConfig
    public native void start(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseConfig
    public native void startTestTool(Activity activity);
}
