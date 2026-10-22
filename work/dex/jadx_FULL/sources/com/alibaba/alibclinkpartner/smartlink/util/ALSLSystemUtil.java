package com.alibaba.alibclinkpartner.smartlink.util;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALSLSystemUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f23579a;
    private static String b;

    public static String getAppName(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
            } catch (Exception e) {
                ALSLLogUtil.d("ALSLSystemUtil", "getAppName", e.toString());
            }
        }
        return b;
    }

    public static String getPackageName(Context context) {
        if (TextUtils.isEmpty(f23579a)) {
            f23579a = context.getPackageName();
        }
        return f23579a;
    }
}
