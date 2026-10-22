package com.kc.openset.ad_embed.zy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseInit;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYInitAdapter extends BaseInit {
    private static final String TAG = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST);

    static {
        OSETSDKProtected.interface11(4213);
    }

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native String getCurrentVersion();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void init(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void start(String str, String str2);
}
