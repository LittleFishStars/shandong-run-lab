package com.kc.openset.oaid;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class DeviceIdentifier {
    private static volatile String androidId;
    private static volatile String clientId;
    private static volatile String guid;
    private static volatile String imei;
    private static volatile String oaid;
    private static volatile String pseudoId;
    private static volatile boolean registered;
    private static volatile String widevineId;

    static {
        OSETSDKProtected.interface11(4467);
    }

    private DeviceIdentifier() {
    }

    public static native String getAndroidID(Context context);

    public static native String getIMEI(Context context);

    public static native String getOAID(Context context, IGetter iGetter);
}
