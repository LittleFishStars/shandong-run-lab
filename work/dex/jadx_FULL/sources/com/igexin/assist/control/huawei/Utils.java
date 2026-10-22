package com.igexin.assist.control.huawei;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.p3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class Utils {
    public static final String TAG = "Assist_HW";

    public static String getBuildVersion(String str) {
        String str2;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getDeclaredMethod(p3.f, String.class).invoke(cls, str);
        } catch (Throwable th) {
            Log.d("Assist_HW", "getBuildVersion error : " + th.getMessage());
            str2 = "";
        }
        Log.d("Assist_HW", "getBuildVersion: " + str2);
        return str2;
    }

    private static boolean isHonorDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean isHonorNewDevice() {
        return isHonorDevice() && !isHonorOldDevice();
    }

    public static boolean isHonorOldDevice() {
        String buildVersion = getBuildVersion("ro.build.version.emui");
        if (TextUtils.isEmpty(buildVersion)) {
            return false;
        }
        return buildVersion.contains("MagicUI") || buildVersion.contains("MagicOS");
    }
}
