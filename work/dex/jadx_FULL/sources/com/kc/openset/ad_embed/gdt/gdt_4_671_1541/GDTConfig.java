package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class GDTConfig extends BaseConfig {
    public static final String ADVERTISERS = OSETSDKProtected.getString2(615);
    public static final String ADVERTISERS_NAME = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB);
    private static final String CHECK_PACKAGE = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME);
    public static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME);
    private static final String MINI_SUPPORT_GDT_VERSION = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID);
    private static final String TAG = OSETSDKProtected.getString2(613);

    static {
        OSETSDKProtected.interface11(3928);
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
