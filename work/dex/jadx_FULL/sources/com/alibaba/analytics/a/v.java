package com.alibaba.analytics.a;

import android.util.Log;
import com.acse.ottn.p3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class v {
    public static String get(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class).invoke(cls, str);
        } catch (Exception e) {
            Log.e("SystemProperties", "get() ERROR!!! Exception!", e);
            return "";
        }
    }
}
