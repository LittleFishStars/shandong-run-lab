package com.alibaba.ariver.v8worker;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24496a = "AriverEngine:JSApiCacheUtils";

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                for (String str3 : str2.split(",")) {
                    String[] strArrSplit = str3.split(u15.f19942b);
                    if (strArrSplit != null && strArrSplit.length > 0 && str.equals(strArrSplit[0].trim())) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                RVLogger.e(f24496a, th);
            }
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                for (String str3 : str2.split(",")) {
                    if (str.equals(str3.trim())) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                RVLogger.e(f24496a, th);
            }
        }
        return false;
    }
}
