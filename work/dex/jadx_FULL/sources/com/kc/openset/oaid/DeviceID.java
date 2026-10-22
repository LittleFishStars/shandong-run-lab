package com.kc.openset.oaid;

import android.app.Application;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class DeviceID {
    private static final String TAG = OSETSDKProtected.getString2(1821);
    private Application application;
    private String clientId;
    private String oaid;
    private boolean tryWidevine;

    @Keep
    public static /* synthetic */ class a {
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final DeviceID f39766a;

        static {
            OSETSDKProtected.interface11(4465);
            f39766a = new DeviceID(null);
        }
    }

    static {
        OSETSDKProtected.interface11(4466);
    }

    private DeviceID() {
    }

    public /* synthetic */ DeviceID(a aVar) {
        this();
    }

    public static native String getAndroidID(Context context);

    public static native void getByGms(Context context, IGetter iGetter);

    public static native void getByMsa(Context context, IGetter iGetter);

    private static native String getIMEI(Context context);

    public static native String getOAID();

    public static native void getOAID(Context context, IGetter iGetter);

    @Deprecated
    public static native String getUniqueID(Context context);

    private static native String getUuidFromSystemSettings(Context context);

    private static native void saveUuidToSystemSettings(Context context, String str);

    public static native boolean supportedOAID(Context context);
}
