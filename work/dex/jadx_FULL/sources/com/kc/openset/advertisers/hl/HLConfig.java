package com.kc.openset.advertisers.hl;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLConfig extends BaseConfig {
    public static final String ADVERTISERS = OSETSDKProtected.getString2(401);
    public static final String ADVERTISERS_NAME = OSETSDKProtected.getString2(1046);
    public static final String FRONT = OSETSDKProtected.getString2(1041);
    private static final String MINI_SUPPORT_BZ_VERSION = OSETSDKProtected.getString2(1047);
    private static final String TAG = OSETSDKProtected.getString2(1043);

    static {
        OSETSDKProtected.interface11(4263);
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
