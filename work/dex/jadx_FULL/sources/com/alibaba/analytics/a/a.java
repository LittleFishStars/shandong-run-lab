package com.alibaba.analytics.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Process;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.byazt.hv.TTDownloadField;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private static String bc = "";
    static Map<String, String> y;

    public static String a(Context context, String str) {
        int identifier;
        if (context == null) {
            return null;
        }
        try {
            Resources resources = context.getResources();
            if (resources != null && (identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName())) != 0) {
                return context.getString(identifier);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean b(Context context) {
        return true;
    }

    public static String c(Context context) {
        Map<String, String> mapA = a(context);
        if (mapA != null) {
            return mapA.get("preLoad_Channel2");
        }
        return null;
    }

    public static String getAppkey() {
        return com.alibaba.analytics.core.d.a().getAppkey();
    }

    public static String getCurProcessName(Context context) {
        if (context == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean isMainProcess(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
            String curProcessName = getCurProcessName(context);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(curProcessName)) {
                return true;
            }
            return curProcessName.equalsIgnoreCase(str);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String j() {
        return com.alibaba.analytics.core.d.a().j();
    }

    public static Map<String, String> a(Context context) {
        Map<String, String> map = y;
        if (map != null) {
            return map;
        }
        if (context == null) {
            return null;
        }
        y = new HashMap();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("manufacture_config", 0);
            boolean z = sharedPreferences.getBoolean("preLoad", false);
            String string = sharedPreferences.getString("preLoad_VersionName", "");
            String string2 = sharedPreferences.getString("preLoad_Channel1", "");
            String string3 = sharedPreferences.getString("preLoad_Channel2", "");
            if (z) {
                y.put("preLoad", "true");
                y.put("preLoad_VersionName", string);
                y.put("preLoad_Channel1", string2);
                y.put("preLoad_Channel2", string3);
            }
        } catch (Exception unused) {
        }
        return y;
    }
}
