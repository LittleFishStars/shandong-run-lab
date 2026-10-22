package com.kc.openset.oaid.repackage.qiku;

import android.os.IBinder;
import com.acse.ottn.p3;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.LogUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class QikuIdmanager {
    public static int CODE_GET_AAID = 6;
    public static int CODE_GET_OAID = 4;
    public static int CODE_GET_UDID = 3;
    public static int CODE_GET_VAID = 5;
    public static int CODE_IS_SUPPORTED = 2;
    public static final int CODE_LIMIT_READ_OAID = 9;
    public static final int CODE_RESET_OAID = 8;
    public static int CODE_SHUTDOWN = 7;
    static final String TAG = OSETSDKProtected.getString2(1996);
    private IBinder mIBinder;

    static {
        OSETSDKProtected.interface11(4551);
    }

    public QikuIdmanager() {
        Method declaredMethod;
        this.mIBinder = null;
        try {
            Class<?> cls = Class.forName(OSETSDKProtected.getString2("1692"));
            if (!((String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, OSETSDKProtected.getString2("1837"), "")).contains(OSETSDKProtected.getString2("1997")) || (declaredMethod = Class.forName(OSETSDKProtected.getString2("1998")).getDeclaredMethod("getService", String.class)) == null) {
                return;
            }
            this.mIBinder = (IBinder) declaredMethod.invoke(null, OSETSDKProtected.getString2("1999"));
        } catch (Throwable th) {
            String string2 = OSETSDKProtected.getString2(2000);
            String string3 = OSETSDKProtected.getString2(1996);
            LogUtils.writeE(string3, string2);
            LogUtils.writeE(string3, th);
        }
    }

    public native String getAAID();

    public native String getOAID();

    public native String getUDID();

    public native String getVAID();

    public native boolean isLimited();

    public native boolean isSupported();

    public native void shutDown();
}
