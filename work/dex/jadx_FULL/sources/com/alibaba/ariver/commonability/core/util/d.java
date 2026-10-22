package com.alibaba.ariver.commonability.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.acse.ottn.p3;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.igexin.assist.util.AssistUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23953a = "CommonAbility#NavigationBarCompat";
    private static boolean b = false;

    public static boolean a(Context context) {
        boolean zHasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        boolean zDeviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (!zHasPermanentMenuKey || !zDeviceHasKey) {
            return false;
        }
        RVLogger.d(f23953a, "has physical navigation bar");
        return true;
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(com.gyf.immersionbar.b.f6803b, "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        RVLogger.d(f23953a, "navigationBar height：" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0026  */
    public static boolean c(Context context) {
        boolean z = false;
        if (!d(context) || TextUtils.isEmpty(Build.BRAND)) {
            return false;
        }
        if (a(AssistUtils.BRAND_HW)) {
            if (Settings.Global.getInt(context.getContentResolver(), com.gyf.immersionbar.b.f6808g, 0) == 0) {
                z = true;
            }
        } else if (a("xiaomi")) {
            if (Settings.Global.getInt(context.getContentResolver(), com.gyf.immersionbar.b.f6806e, 0) == 0) {
                z = true;
            }
        } else if (a("vivo")) {
            if (Settings.Global.getInt(context.getContentResolver(), com.gyf.immersionbar.b.f6809h, 0) == 0) {
                z = true;
            }
        } else if (!a("oppo")) {
            z = b;
        } else if (Settings.Secure.getInt(context.getContentResolver(), "manual_hide_navigationbar", 0) == 0) {
            z = true;
        }
        RVLogger.d(f23953a, "navigationBar isShown:" + z);
        return z;
    }

    private static boolean d(Context context) {
        if (e(context)) {
            RVLogger.d(f23953a, "has navigation bar by ResourcesId");
            return true;
        }
        if (a()) {
            RVLogger.d(f23953a, "has navigation bar by SystemProperties");
            return true;
        }
        boolean zB = b();
        if (!zB) {
            return zB;
        }
        RVLogger.d(f23953a, "has navigation bar by windowManagerService");
        return true;
    }

    private static boolean e(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier > 0) {
            return resources.getBoolean(identifier);
        }
        return false;
    }

    public static void a(boolean z) {
        b = z;
    }

    private static boolean b() {
        try {
            Method declaredMethod = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("hasNavigationBar", new Class[0]);
            declaredMethod2.setAccessible(true);
            return ((Boolean) declaredMethod2.invoke(objInvoke, new Object[0])).booleanValue();
        } catch (Exception e) {
            RVLogger.e(f23953a, e);
            return false;
        }
    }

    private static boolean a(String str) {
        String str2 = Build.BRAND;
        String str3 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(p3.f, String.class).invoke(cls, "qemu.hw.mainkeys");
            return !"1".equals(str) && "0".equals(str);
        } catch (Exception e) {
            RVLogger.e(f23953a, e);
        }
    }

    private static boolean a(Activity activity) {
        try {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            if (viewGroup == null) {
                return false;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                int id = viewGroup.getChildAt(i).getId();
                if (id != -1 && "navigationBarBackground".equals(activity.getResources().getResourceEntryName(id))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            RVLogger.e(f23953a, th);
            return false;
        }
    }
}
