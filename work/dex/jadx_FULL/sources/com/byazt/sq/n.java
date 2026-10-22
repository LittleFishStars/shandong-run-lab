package com.byazt.sq;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 900, 46})
public class n {
    public static Boolean c;

    private static boolean c() {
        if (c == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant$RitScenes");
                c = Boolean.TRUE;
            } catch (Throwable unused) {
                c = Boolean.FALSE;
            }
        }
        return c.booleanValue();
    }

    public static String c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return "game_more_kllkrtunities".equalsIgnoreCase(str) ? c(str) : str;
        }
        if (c()) {
            try {
                if (obj instanceof TTAdConstant.RitScenes) {
                    return ((TTAdConstant.RitScenes) obj).getScenesName();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }
}
