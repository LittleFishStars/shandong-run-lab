package com.kc.openset.ad_embed.zy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYConfig extends BaseConfig {
    public static final String ADVERTISERS = OSETSDKProtected.getString2(904);
    public static final String ADVERTISERS_NAME = OSETSDKProtected.getString2(925);
    public static final String CHECK_PACKAGE = OSETSDKProtected.getString2(927);
    public static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE);
    private static final String MINI_SUPPORT_BZ_VERSION = OSETSDKProtected.getString2(926);
    private static final String TAG = OSETSDKProtected.getString2(922);

    static {
        OSETSDKProtected.interface11(4211);
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
