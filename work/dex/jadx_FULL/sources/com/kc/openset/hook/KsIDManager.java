package com.kc.openset.hook;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KsIDManager {
    private static volatile KsIDManager INSTANCE;
    private static final String TAG = OSETSDKProtected.getString2(1760);
    private final Map<String, KsIDInfoBean> ksIDInfoBeanMap = new HashMap();

    static {
        OSETSDKProtected.interface11(4445);
    }

    private KsIDManager() {
    }

    public static native KsIDManager getInstance();

    public native String getAppId(long j);

    public native void initKsSDK(String str);

    public native boolean isSS(long j);

    public native void putAppId(String str, boolean z);

    public native void putPosId(String str);

    public native void putPosId(String str, boolean z);
}
