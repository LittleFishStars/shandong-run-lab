package com.alibaba.ariver.commonability.core.b;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23939a = "CommonAbility#SystemUtils";
    private static final String b = "checkOpNoThrow";
    private static final String c = "OP_POST_NOTIFICATION";

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return d(context);
    }

    public static boolean b(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0;
        } catch (Throwable th) {
            RVLogger.d(f23939a, "isGpsSwitchOPen, error,msg=" + th);
            return true;
        }
    }

    public static boolean c(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    @TargetApi(24)
    private static boolean d(Context context) {
        try {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        } catch (Throwable th) {
            RVLogger.e(f23939a, "getNotificationsStateCompatApi24", th);
            return false;
        }
    }

    @TargetApi(19)
    private static boolean e(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod(b, cls2, cls2, String.class);
            method.setAccessible(true);
            Field declaredField = cls.getDeclaredField(c);
            declaredField.setAccessible(true);
            int iIntValue = ((Integer) method.invoke(appOpsManager, Integer.valueOf(((Integer) declaredField.get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue();
            if (iIntValue == 0) {
                return true;
            }
            if (1 == iIntValue) {
                return false;
            }
            RVLogger.d(f23939a, "getNotificationsEnabledCompatKitkat, result code is " + iIntValue);
            return false;
        } catch (Throwable th) {
            RVLogger.e(f23939a, "getNotificationsEnabledCompatKitkat", th);
            return false;
        }
    }

    public static boolean a() {
        return BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (Throwable unused) {
            RVLogger.e(f23939a, "os rejected this operation");
            return false;
        }
    }
}
