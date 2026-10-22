package com.kc.openset.advertisers.adv;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseInit;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b extends BaseInit {
    static {
        OSETSDKProtected.interface11(4232);
    }

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native String getCurrentVersion();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void init(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void start(String str, String str2);
}
