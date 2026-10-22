package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class bt {
    public static String a(Context context) {
        int intExtra;
        try {
            Intent intentD = d(context);
            if (intentD != null) {
                intExtra = (int) ((intentD.getIntExtra(com.alibaba.ariver.permission.b.b, -1) / intentD.getIntExtra("scale", -1)) * 100.0f);
            } else {
                intExtra = 0;
            }
            return intExtra + "%";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            int intExtra = d(context).getIntExtra("plugged", -1);
            if (intExtra == 1) {
                return "AC charger";
            }
            if (intExtra != 2) {
                return intExtra != 4 ? "" : "Wireless charger";
            }
            return "USB charger";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int c(Context context) {
        int i = -1;
        try {
            int intExtra = d(context).getIntExtra("health", -1);
            i = 3;
            if (intExtra != 2) {
                if (intExtra == 3) {
                    return 4;
                }
                if (intExtra == 4) {
                    return 2;
                }
                if (intExtra != 5) {
                    return intExtra != 7 ? 6 : 1;
                }
                return 5;
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    private static Intent d(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
