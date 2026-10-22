package com.kc.openset.ad_embed.ms;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class MSConfig extends BaseConfig {
    public static final int ADN_MEI_SHU_BIDDING = 4;
    public static final int ADN_MEI_SHU_DATA = 1;
    public static final int ADN_MINE = 3;
    public static final int ADN_OTHER = 2;
    private static final String[] CHECK_PACKAGE;
    public static final String ADVERTISERS = OSETSDKProtected.getString2(AVMDLDataLoader.KeyIsGetVersionInfo);
    public static final String ADVERTISERS_NAME = OSETSDKProtected.getString2(839);
    public static final String FRONT = OSETSDKProtected.getString2(831);
    private static final String MINI_SUPPORT_KS_VERSION = OSETSDKProtected.getString2(840);
    private static final String TAG = OSETSDKProtected.getString2(841);

    static {
        OSETSDKProtected.interface11(4155);
        CHECK_PACKAGE = new String[]{OSETSDKProtected.getString2(838), OSETSDKProtected.getString2(836), OSETSDKProtected.getString2(837)};
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
