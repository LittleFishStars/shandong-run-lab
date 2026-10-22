package com.igexin.assist.control.xiaomi;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.igexin.push.core.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class Utils {
    public static String getAppIdByBuildConfig(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(b.f37950a);
            if (TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(string + ".BuildConfig");
            return (String) cls.getField("XIAOMI_APP_ID").get(cls);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAppKeyByBuildConfig(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(b.f37950a);
            if (TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(string + ".BuildConfig");
            return (String) cls.getField("XIAOMI_APP_KEY").get(cls);
        } catch (Throwable unused) {
            return "";
        }
    }
}
