package com.kc.openset.advertisers.adv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ADVConfig extends BaseConfig {
    private static final String[] CHECK_PACKAGE_ARR;
    public static final String ADVERTISERS = OSETSDKProtected.getString2(141);
    public static final String ADVERTISERS_NAME = OSETSDKProtected.getString2(962);
    public static final String ADV_SUFFIX = OSETSDKProtected.getString2(963);
    public static final String FRONT = OSETSDKProtected.getString2(964);
    private static final String MINI_SUPPORT_BZ_VERSION = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION);
    private static final String TAG = OSETSDKProtected.getString2(965);

    static {
        OSETSDKProtected.interface11(4229);
        CHECK_PACKAGE_ARR = new String[]{OSETSDKProtected.getString2(961)};
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
}
