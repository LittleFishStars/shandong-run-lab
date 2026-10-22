package com.kc.openset.common.okhttp;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.utils.LogUtilsBridge;
import com.kc.openset.bridge.common.BaseHttpClientBridge;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OkHttpBridge implements BaseHttpClientBridge {
    private static final String TAG = OSETSDKProtected.getString2(1491);
    private boolean isAvailable;
    private OkHttpScheduler mOkHttpScheduler;

    static {
        OSETSDKProtected.interface11(4380);
    }

    public OkHttpBridge() {
        String string2 = OSETSDKProtected.getString2(1491);
        try {
            Class.forName(OSETSDKProtected.getString2("837"));
            this.isAvailable = true;
            this.mOkHttpScheduler = OkHttpScheduler.getInstance();
            LogUtilsBridge.writeD(string2, OSETSDKProtected.getString2("1492"));
        } catch (ClassNotFoundException unused) {
            this.isAvailable = false;
            LogUtilsBridge.writeD(string2, OSETSDKProtected.getString2(1493));
        }
    }

    @Override // com.kc.openset.bridge.common.BaseHttpClientBridge
    public native void get(String str, Map<String, String> map, OSETHttpCallback oSETHttpCallback);

    @Override // com.kc.openset.bridge.common.BaseCommonBridge
    public native boolean isAvailable();

    @Override // com.kc.openset.bridge.common.BaseHttpClientBridge
    public native void post(String str, Map<String, String> map, String str2, OSETHttpCallback oSETHttpCallback);
}
