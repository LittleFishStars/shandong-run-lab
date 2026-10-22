package com.kc.openset.hook.hapi;

import android.os.Build;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.utils.LogUtilsBridge;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class BootstrapClass {
    private static final String TAG = OSETSDKProtected.getString2(1806);
    private static Object sVmRuntime;
    private static Method setHiddenApiExemptions;

    static {
        OSETSDKProtected.interface11(4458);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, OSETSDKProtected.getString2("1803"));
                Method method = (Method) declaredMethod2.invoke(cls, OSETSDKProtected.getString2("1804"), null);
                setHiddenApiExemptions = (Method) declaredMethod2.invoke(cls, OSETSDKProtected.getString2("1805"), new Class[]{String[].class});
                sVmRuntime = method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                LogUtilsBridge.writeW(OSETSDKProtected.getString2(1806), OSETSDKProtected.getString2(1807), th);
            }
        }
    }

    public static native boolean exempt(String str);

    public static native boolean exempt(String... strArr);

    public static native boolean exemptAll();
}
