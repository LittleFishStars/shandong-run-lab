package com.byazt.wg;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.gyf.immersionbar.b;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1071, 20})
public class c {
    private static boolean a(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), b.f6808g, 0) != 0;
    }

    public static boolean c(Context context) {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains(AssistUtils.BRAND_HW) && !lowerCase.contains(AssistUtils.BRAND_HON)) {
                if (lowerCase.contains("vivo")) {
                    return uj(context);
                }
                if (lowerCase.contains("oppo")) {
                    return n(context);
                }
                if (!lowerCase.contains("xiaomi") && !lowerCase.contains("redmi")) {
                    if (lowerCase.contains("samsung")) {
                        return false;
                    }
                    return a(context);
                }
                return ve(context);
            }
            return tt(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean n(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), b.i, 0) != 0;
    }

    private static boolean tt(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), b.f6808g, 0) != 0;
    }

    private static boolean uj(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), b.f6809h, 0) != 0;
    }

    private static boolean ve(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), b.f6806e, 0) != 0;
    }

    public static boolean c() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return lowerCase.contains(AssistUtils.BRAND_HW) || lowerCase.contains(AssistUtils.BRAND_HON) || lowerCase.contains("vivo") || lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase.contains("oppo");
    }
}
