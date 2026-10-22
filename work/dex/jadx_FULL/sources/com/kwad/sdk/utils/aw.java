package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.provider.Settings;
import com.alibaba.android.arouter.utils.Consts;
import com.hjq.permissions.Permission;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class aw {
    private static Map<String, Integer> bpQ;
    private static Set<String> bpR;
    private static Method bpS;

    static {
        HashSet hashSet = new HashSet();
        bpR = hashSet;
        hashSet.add(Permission.REQUEST_INSTALL_PACKAGES);
        bpR.add(Permission.WRITE_SETTINGS);
        bpR.add(Permission.SYSTEM_ALERT_WINDOW);
    }

    public static int aA(Context context, String str) {
        int iAB;
        if (bpQ == null) {
            h(aa.di(context));
        }
        if (bpR.contains(str) && (iAB = aB(context, str)) != -2) {
            return iAB;
        }
        int iAC = aC(context, str);
        if (iAC != -2) {
            return iAC;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return iAC;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int aB(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "android.permission.WRITE_SETTINGS":
                try {
                    if (Settings.System.canWrite(context)) {
                        return 0;
                    }
                    return -1;
                } catch (Throwable unused) {
                    break;
                }
                break;
            case "android.permission.SYSTEM_ALERT_WINDOW":
                try {
                    if (Settings.canDrawOverlays(context)) {
                        return 0;
                    }
                    return -1;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    break;
                }
                break;
            case "android.permission.REQUEST_INSTALL_PACKAGES":
                if (aa.dh(context)) {
                    return 0;
                }
                return -1;
            default:
                return -2;
        }
    }

    private static int aC(Context context, String str) {
        if (bpQ == null || str == null || !bpQ.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = bpQ.get(str);
            if (num == null) {
                return -2;
            }
            if (bpS == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                bpS = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) bpS.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }

    public static boolean dK(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 1;
    }

    private static void h(String[] strArr) {
        if (strArr == null) {
            return;
        }
        bpQ = new HashMap();
        for (String str : strArr) {
            try {
                int iIntValue = ((Integer) ab.c(AppOpsManager.class, AssistPushConsts.OPPO_PREFIX + hX(str))).intValue();
                if (iIntValue >= 0) {
                    bpQ.put(str, Integer.valueOf(iIntValue));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String hX(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        if (iLastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(iLastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }
}
